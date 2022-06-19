package com.auction.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.auction.portal.util.BidDetailsMapper;

@Configuration
@EnableScheduling
public class BidServiceConfig {
	
	@Bean
	public BidDetailsMapper bidDetailsMapper() {
		return new BidDetailsMapper();
	}
}
