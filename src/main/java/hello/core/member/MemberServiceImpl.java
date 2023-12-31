package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    //현재 추상화에도 의존하고 구체화에도 의존하고 있음
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //AppConfig 생성하면서 아래와 같이 생성자를 호출 -> @RequiredArgsConstructor 애노테이션으로 대체

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
