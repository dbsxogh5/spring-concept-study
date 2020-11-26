package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args){
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        // 스프링 컨테이너에 있는 @Bean 되있는걸 다 등록해서 객체를 관리해 준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("new  : " + member.getName());
        System.out.println("find  : " + findMember.getName());
    }
}
