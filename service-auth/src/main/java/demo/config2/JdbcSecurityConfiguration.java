//package demo.config2;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config3.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config3.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config3.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
////
////@Configuration
////@EnableWebSecurity
//public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//    // 密码管理
//    @Bean
//    PasswordEncoder passwordEncoder() {
//
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//
//    //注入认证管理器
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        AuthenticationManager manager = super.authenticationManagerBean();
//        return manager;
//    }
//
//
//    // 认证服务器请求过滤url
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**").permitAll();
//    }
//
//
//}
