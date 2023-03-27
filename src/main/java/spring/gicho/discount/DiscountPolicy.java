package spring.gicho.discount;

import spring.gicho.member.Member;

public interface DiscountPolicy {
  /**
   *
   * @param member
   * @param price
   * @return 할인대상금액 - 얼마나 할인되는지 그 금액
   */
  int discount(Member member, int price);
}
