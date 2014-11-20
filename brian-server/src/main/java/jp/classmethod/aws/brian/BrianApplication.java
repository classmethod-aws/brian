/*
 * Copyright 2013-2014 Classmethod, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.classmethod.aws.brian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * TODO for daisuke
 * 
 * @author daisuke
 * @since 1.0
 */
@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:/applicationContext.xml")
public class BrianApplication {
	
	/**
	 * Main method.
	 * 
	 * @param args ignored
	 * @since 1.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(BrianApplication.class, args);
	}
	
	@Bean
	ServletContextInitializer servletContextInitializer() {
		return servletContext -> BrianSpringInitializer.doStartup(servletContext, false);
	}
}
