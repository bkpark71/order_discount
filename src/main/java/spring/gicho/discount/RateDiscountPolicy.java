package spring.gicho.discount;

import spring.gicho.member.Grade;
import spring.gicho.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
  private int discountRate = 10; // 무조건 10% 할인
  @Override
  public int discount(Member member, int price) {
    // enum은 == 으로 비교하는 것이 맞음
    if (member.getGrade() == Grade.VIP) {
      return price * 10 / 100;
    } else {
      return 0;
    }
  }
}
