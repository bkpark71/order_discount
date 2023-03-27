package spring.gicho.member;

public interface MemberService {
  Member save(Member member);

  Member findById(Long memberId);

}
