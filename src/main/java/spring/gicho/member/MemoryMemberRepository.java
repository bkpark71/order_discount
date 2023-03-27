package spring.gicho.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
 /* 실무가 아니고 예제니까 concurrent 사용안함 */
  private static Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(),member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}
