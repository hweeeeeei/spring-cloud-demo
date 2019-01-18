package demo.config2;

import demo.service.UserServiceDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableAuthorizationServer

public class JdbcAuthServerConfig extends AuthorizationServerConfigurerAdapter {

    static final Logger logger = LoggerFactory.getLogger(JdbcAuthServerConfig.class);


    @Autowired
    AuthenticationManager authenticationManager; // 认证服务管理器

    @Autowired
    RedisConnectionFactory redisConnectionFactory; //操作redis

    @Autowired
    private DataSource dataSource;  //数据源


    @Autowired
    private TokenStore tokenStore; //token管理

    @Autowired
    private UserServiceDetail userServiceDetail; // 用户信息管理


    @Autowired
    private ClientDetailsService clientDetailsService; //客户端信息管理


    /**
     * 配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，
     * 把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息；
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetailsService);
    }


    /**
     * endpoints
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)，
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // redisTokenStore 数据存redis 现改为存mysql
//        endpoints.tokenStore(new MyRedisTokenStore(redisConnectionFactory))
//                .authenticationManager(authenticationManager)
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        // 存数据库
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                .userDetailsService(userServiceDetail);

        // 配置tokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)); // 30天
        endpoints.tokenServices(tokenServices);
    }


    /** security
     用来配置令牌端点(Token Endpoint)的安全约束；
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    // 数据库管理token
    @Bean
    public TokenStore tokenStore() {

        return new JdbcTokenStore(dataSource);
    }

    // 数据库管理客户端信息
    @Bean
    public ClientDetailsService clientDetailsService() {

        return new JdbcClientDetailsService(dataSource);
    }

}
