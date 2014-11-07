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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import jp.classmethod.aws.brian.utils.InitializationUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:/META-INF/spring/quartz-context.xml")
public class BrianApplication {
	
	public static final Collection<String> REQUIRED_SYSTEM_PROPERTIES = Collections.unmodifiableCollection(Arrays.asList(
			"JDBC_CONNECTION_STRING",
			"DB_USERNAME",
			"DB_PASSWORD",
			"BRIAN_TOPIC_ARN"
	));
	
	
	public static void main(String[] args) {
		InitializationUtil.logAllProperties();
		InitializationUtil.validateExistRequiredSystemProperties(REQUIRED_SYSTEM_PROPERTIES);
		SpringApplication.run(BrianApplication.class, args);
	}
}