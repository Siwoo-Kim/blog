package com.siwoo.blog;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.siwoo.blog.repository")
@EntityScan("com.siwoo.blog.domain")
@Configuration
public class RootConfig {


}
