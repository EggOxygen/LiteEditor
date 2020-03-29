package egg.lab.liteeditor.Config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
@Configuration
class CustomWebSecurity : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        if (auth != null) {
            auth.inMemoryAuthentication().passwordEncoder(NonePasswordEcoder())
                    .withUser("0321").password(NonePasswordEcoder().encode("0321")).roles("TEACHER")

        }
    }

    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.authorizeRequests()
                    .antMatchers("/").hasRole("TEACHER")
                    .antMatchers("index").hasRole("TEACHER")
                    .antMatchers("/instance/newInstance").hasRole("TEACHER")
                    .anyRequest().permitAll() // TEACHER permit
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().permitAll() // Logout Permit
                    .and()
                    .csrf().disable() // Disable CSRF

        }

    }

    /*
    * Date: 2020/3/22
    * Author: EggOxygen
    * Desc: 不带任何功能的PasswordEncoder
    */
    inner class NonePasswordEcoder : PasswordEncoder{
        override fun encode(p0: CharSequence?): String {
            return p0.toString()
        }

        override fun matches(p0: CharSequence?, p1: String?): Boolean {
            return p0.toString() == p1
        }

    }
}