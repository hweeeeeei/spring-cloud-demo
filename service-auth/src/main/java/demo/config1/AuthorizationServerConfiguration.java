/*
package demo.config1;


import demo.utils.MyRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

//https://www.jianshu.com/p/3427549a148a

*/
/**
 * 认证授权服务器 redis
 *//*

//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    */
/**
     * 配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，
     * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息；
     *//*

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");

        //手动配置客户端数据 写死在代码里面 后续配置mysql保存

        // 配置两个客户端，一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
                .resourceIds("order")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("oauth2")
                .secret(finalSecret)

                .and().withClient("client_2")
                .resourceIds("order")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("server")
                .authorities("oauth2")
                .secret(finalSecret);
    }


    */
/**
     * endpoints)
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)，
     *//*

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // token的存储方式(tokenStore)；
        endpoints.tokenStore(new MyRedisTokenStore(redisConnectionFactory))

                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }


    */
/** configure(AuthorizationServerSecurityConfigurer security)
        用来配置令牌端点(Token Endpoint)的安全约束；
     *//*

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients();
    }

}
*/
