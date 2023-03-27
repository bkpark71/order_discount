package spring.gicho.member;

public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository){

    this.memberRepository = memberRepository;
  }
  @Override
  public Member save(Member member) {
    memberRepository.save(member);
    return member;
  }

  @Override
  public Member findById(Long memberId) {

    return memberRepository.findById(memberId);
  }
}
