/*
package demo.config1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config3.annotation.web.builders.HttpSecurity;
import org.springframework.security.config3.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config3.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

*/
/**
 * configure(HttpSecurity http) httpSecurity中配置所有请求的安全验证
 * 注入Bean UserDetailsService 管理用户信息
 * 注入Bean AuthenticationManager 用来做验证
 * 注入Bean PasswordEncoder
 *//*


//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    // 手动注入用户数据
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
//        String finalPassword = "123456";

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());

        return manager;
    }


    @Bean
    PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();
    }


}
*/
