package com.hfcsbc;

import com.hfcsbc.repository.support.WiselyRepositoryImpl;
import com.hfcsbc.service.DomainUserDetailsService;
import com.hfcsbc.service.SecurityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
public class AuthServerApplication {

	@Bean(name = "auditorAware")
	public AuditorAware<String> auditorAware() {
		return () -> SecurityUtils.getCurrentUserUsername();
	}

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		return new DomainUserDetailsService();
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
