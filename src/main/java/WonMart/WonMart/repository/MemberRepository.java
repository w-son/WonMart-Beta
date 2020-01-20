package WonMart.WonMart.repository;

import WonMart.WonMart.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// Repository : 영속성 컨텍스트내에서 Entity를 직접 다루는 로직을 구현
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public void remove(Member member) { em.remove(member); }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByKakaoKey(String kakaoKey) {
        return em.createQuery("select m from Member m where m.kakaoKey = :kakaoKey", Member.class)
                .setParameter("kakaoKey", kakaoKey)
                .getResultList();
    }

    public List<Member> findByNickName(String nickName) {
        return em.createQuery("select m from Member m where m.nickName = :nickName", Member.class)
                .setParameter("nickName", nickName)
                .getResultList();
    }

}
