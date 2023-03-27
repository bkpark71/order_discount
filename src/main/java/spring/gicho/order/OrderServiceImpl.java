package spring.gicho.order;
;
import spring.gicho.discount.DiscountPolicy;
import spring.gicho.member.Member;
import spring.gicho.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy ;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId,itemName,itemPrice,discountPrice);
  }
}

