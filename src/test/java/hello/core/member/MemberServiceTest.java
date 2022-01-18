package hello.core.member;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(MemberService memberService) {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
