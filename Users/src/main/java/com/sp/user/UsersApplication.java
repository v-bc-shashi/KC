package com.sp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@CrossOrigin(origins = "*")
@EnableJpaRepositories(
		excludeFilters = @ComponentScan.Filter(
				type= FilterType.REGEX,
				pattern = {
						"com.sp.user.base.repository.BaseRepository"
				}
		)
)

@EnableTransactionManagement
@EnableScheduling
@EnableCaching
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}


	@RequestMapping(value="/")
	public String startBaseBopok(){
		return "Hello Users";
	}

}
