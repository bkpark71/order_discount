package spring.gicho;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.gicho.member.Grade;
import spring.gicho.member.Member;
import spring.gicho.member.MemberServiceImpl;
import spring.gicho.member.MemberService;

public class MemberApp {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    //AppConfig appConfig = new AppConfig();
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    Member memberA = new Member(1L, "memberA", Grade.VIP);
    memberService.save(memberA);

    Member findMember = memberService.findById(1L);
    System.out.println("new member : " + memberA.getName());
    System.out.println("findMember : " + findMember.getName());

  }
}
