package com.ryan.xunwu.config;

import com.ryan.xunwu.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 16:55
 * @Version 1.0
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/login").permitAll()  //管理员登录入口
                .antMatchers("/static/**").permitAll()  //静态资源
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/user/login").permitAll()  //用户登录入口
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin().loginProcessingUrl("/login")  //配置角色登录处理入口
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and();

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * @Description
     *  自定义认证策略
     * @Param
     * @return
     * @Author linzhenhong
     * @Date 2019/3/12 17:02
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//                .roles("ADMIN").and();

        auth.authenticationProvider(authProvider()).eraseCredentials(true);

    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }

}
