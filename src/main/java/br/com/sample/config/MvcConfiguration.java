
package br.com.sample.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("br.com.sample")
@EnableJpaRepositories("br.com.sample.repository")
public class MvcConfiguration {




}
