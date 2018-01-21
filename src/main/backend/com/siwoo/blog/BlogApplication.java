package com.siwoo.blog;

import com.siwoo.blog.domain.member.Member;
import com.siwoo.blog.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}


	@Bean
	CommandLineRunner addMember(MemberRepository memberRepository){
		return args -> {
			memberRepository.saveAll(
					Arrays.asList(
							Member.builder().name("김시우").age(29).email("skim327@myseneca.ca").level(Member.Level.GOLD).point(300).build(),
							Member.builder().name("아이유").age(26).email("iuLove@myseneca.ca").level(Member.Level.BRONZE).point(0).build(),
							Member.builder().name("나현").age(23).email("naHyunLove@myseneca.ca").level(Member.Level.BRONZE).point(100).build(),
							Member.builder().name("정연").age(22).email("jungYung@myseneca.ca").level(Member.Level.SILVER).point(220).build(),
							Member.builder().name("나루토").age(24).email("naruto@myseneca.ca").level(Member.Level.GOLD).point(600).build(),
							Member.builder().name("카스케").age(23).email("sasuke@myseneca.ca").level(Member.Level.SILVER).point(50).build(),
							Member.builder().name("모모").age(21).email("momoDes@myseneca.ca").level(Member.Level.BRONZE).point(10).build()
					)
			);
		};
	}


}
