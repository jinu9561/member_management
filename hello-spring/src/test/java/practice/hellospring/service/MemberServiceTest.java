package practice.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import practice.hellospring.domain.Member;
import practice.hellospring.repository.MemberRepository;
import practice.hellospring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){ // 메서드 실행후에 초기화
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { // Test 코드의 경우에는 한글로 적어도 딱히 상관없음
        //given
        Member member = new Member();
        member.setName("jinwoo");

        //when
        Long saveId = memberService.join(member); // join이 정상작동하는지 테스트

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName())
                .isEqualTo(findMember.getName());
    } // test 는 실제 코드에 포함 안됨

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Minsoo");

        Member member2 = new Member();
        member2.setName("Minsoo"); // 중복된 이름 입력

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


/*        memberService.join(member1);
        try {
            memberService.join(member2); // 중복된 이름 입력
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/      // 좀 애매함

        //then

    }

    @Test
    void 전체_회원_조회() {


    }
}