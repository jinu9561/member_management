package practice.hellospring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.hellospring.repository.MemberRepository;
import practice.hellospring.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository() );
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
