package spring.gicho.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.gicho.AppConfig;
import spring.gicho.member.Grade;
import spring.gicho.member.Member;
import spring.gicho.member.MemberService;
import spring.gicho.member.MemberServiceImpl;
import spring.gicho.order.Order;
import spring.gicho.order.OrderService;
import spring.gicho.order.OrderServiceImpl;

public class OrderServiceTest {
    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach() {
      AppConfig appConfig = new AppConfig();
      memberService = appConfig.memberService();
      orderService = appConfig.orderService();
    }

    @Test
    void orderCreate(){
      long memberId = 1L;
      Member memberA = new Member(memberId, "memberA", Grade.VIP);
      memberService.save(memberA);

      Order itemA = orderService.createOrder(memberId, "ItemA", 10000);
      Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}

