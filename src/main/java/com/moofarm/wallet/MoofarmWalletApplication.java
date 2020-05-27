package com.moofarm.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.moofarm.wallet.*")
@EntityScan("com.moofarm.wallet.*")
public class MoofarmWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoofarmWalletApplication.class, args);
	}

}
