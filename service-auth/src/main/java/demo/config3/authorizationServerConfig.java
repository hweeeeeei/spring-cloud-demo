package demo.config3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
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
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * 用来作为请求者获得授权的服务,默认的URL是/oauth/authorize.
 * 用来作为请求者获得令牌（Token）的服务，默认的URL是/oauth/token.
 * 开启权限认证服务
 */
@Configuration
@EnableAuthorizationServer
public class authorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    static final Logger logger = LoggerFactory.getLogger(authorizationServerConfig.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    @Qualifier("authenticationManagerBean") //指定authenticationManagerBean
            AuthenticationManager authenticationManager;


    @Autowired
    private ClientDetailsService clientDetailsService;

    /**
     * token管理
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * token加密解密
     * test-jwt.jks是一个私钥文件
     * 要在pom.xml中增加不编译过滤（cert文件也一样）
     * test-jwt.jks的生成,test123为密码，test-jwt.jks放在认证服务器
     * keytool -genkeypair -alias test-jwt -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CH" -keypass test123 -keystore test-jwt.jks -storepass test123
     * JWT的解密需要公钥
     * keytool -list -rfc --keystore test-jwt.jks | openssl x509 -inform pem -pubkey
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("test-jwt.jks"), "test123".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("test-jwt"));
        return converter;
    }

    /**
     * 数据源
     *
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService() {

        return new JdbcClientDetailsService(dataSource);
    }


    /**
     * 配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 配置服务端 访问端点和token服务服务
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).tokenEnhancer(jwtAccessTokenConverter()).authenticationManager(authenticationManager);

        // 配置tokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());

        // token过期时间30天
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        endpoints.tokenServices(tokenServices);
    }

    /**
     * 配置令牌端点(Token Endpoint)的安全约束
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

}
