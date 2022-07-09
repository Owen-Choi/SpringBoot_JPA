package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// @Transactional이 없으면 EntityManager를 통해 데이터를 다룰 수 없다. 따라서 여기에 해당 애노테이션을 붙여도 되고,
// MemberRepository에 애노테이션을 붙여도 된다.
@Transactional
// @Transactional 애노테이션은 테스트에 붙으면 테스트가 종료된 후 DB를 롤백해버린다.
// 데이터를 유지하고 싶다면 @Rollback(false) 를  붙이거나 테스트 코드에 @Commit을 붙인다.
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    // @Commit ==> 마찬가지로 @Commit을 붙이면 테스트가 끝나도 DB에 여전히 데이터가 남아있다.
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}