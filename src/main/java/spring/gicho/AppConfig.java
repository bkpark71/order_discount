package spring.gicho;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.gicho.discount.DiscountPolicy;
import spring.gicho.discount.FixDiscountPolicy;
import spring.gicho.discount.RateDiscountPolicy;
import spring.gicho.member.MemberRepository;
import spring.gicho.member.MemberService;
import spring.gicho.member.MemberServiceImpl;
import spring.gicho.member.MemoryMemberRepository;
import spring.gicho.order.OrderService;
import spring.gicho.order.OrderServiceImpl;


public class AppConfig {

  public MemberService memberService() {

    return new MemberServiceImpl(memberRepository());
  }

  private static MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(
        memberRepository(),
        discountPolicy()
    );
  }

  private static DiscountPolicy discountPolicy() {
    //return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
