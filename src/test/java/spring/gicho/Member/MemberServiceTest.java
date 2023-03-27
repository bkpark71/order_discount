package spring.gicho.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spring.gicho.AppConfig;
import spring.gicho.member.Grade;
import spring.gicho.member.Member;
import spring.gicho.member.MemberServiceImpl;
import spring.gicho.member.MemberService;

public class MemberServiceTest {

  MemberService memberService ;

  @BeforeEach
  public void beforeEach(){
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }

  @Test
  void save(){
    //givem
    Member member = new Member(1L, "test", Grade.VIP);
    //Member member2 = new Member(1L, "test", Grade.VIP);
    //when
    Member findMember = memberService.save(member);
    //then
    Assertions.assertThat(member).isEqualTo(findMember);
  }
}
