package spring.gicho;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.gicho.member.Grade;
import spring.gicho.member.Member;
import spring.gicho.member.MemberService;
//import spring.gicho.member.MemberServiceImpl;
import spring.gicho.order.Order;
import spring.gicho.order.OrderService;
//import spring.gicho.order.OrderServiceImpl;

public class OrderApp {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
    //AppConfig appConfig = new AppConfig();
    //MemberService memberService = appConfig.memberService();
    //OrderService orderService = appConfig.orderService();

    long memberId = 1L;
    Member memberA = new Member(memberId, "memberA", Grade.VIP);
    memberService.save(memberA);

    Order itemA = orderService.createOrder(memberId, "ItemA", 10000);
    System.out.println("order = "+itemA);
  }
}
