package spring.gicho.discount;

import spring.gicho.member.Grade;
import spring.gicho.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
  private int discountFixAmount = 1000; // 무조건 1000원 할인
  @Override
  public int discount(Member member, int price) {
    // enum은 == 으로 비교하는 것이 맞음
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }
}
