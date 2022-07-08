package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// repository는 entity를 찾아주는 것이라고 한다.
@Repository
public class MemberRepository {

    // JPA를 쓰기 때문에 EntityManager가 있어야 한다.
    // @PersistenceContext 애노테이션을 달아놓으면 Spring boot가 엔티티 메니저를 주입을 해준다고 한다.
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        // 멤버를 반화하지 않고 Id를 반환하는 이유는 개인의 스타일로, 커맨드랑 쿼리를 분리하라는 원칙에 의해서
        // 저장을 하고 나면 sideEffect를 만들 수 있는 return값을 대체로 만들지 않지만
        // 강의자는 Id 정도는 있으면 다음에 조회에도 좋고 해서 return 하는걸로 설계한다고 한다.
        return member.getId();
    }

    public Member find(Long id) {
        // pk로 조회하기 때문에 JPQL을 사용하지 않아도 된다.
        return em.find(Member.class, id);
    }
}
