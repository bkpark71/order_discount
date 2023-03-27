package spring.gicho.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.gicho.member.Grade;
import spring.gicho.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
  @Test
  @DisplayName("VIP는 10% 할인이 적용됩니다.")
  void vip_o(){
    Member member = new Member(1L, "memberVip", Grade.VIP);
    int discount = discountPolicy.discount(member, 10000);

    Assertions.assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP가 아니면 10% 할인이 적용안됩니다.")
  void vip_x(){
    Member member = new Member(2L, "memberVip", Grade.BASIC);
    int discount = discountPolicy.discount(member, 10000);

    Assertions.assertThat(discount).isEqualTo(0);
  }
}