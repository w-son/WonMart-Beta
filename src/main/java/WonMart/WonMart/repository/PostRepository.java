package WonMart.WonMart.repository;

import WonMart.WonMart.domain.Member;
import WonMart.WonMart.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public void remove(Post post) { em.remove(post); }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    // 작성자 기준 Post
    public List<Post> findByNickName(String nickName) {
        return em.createQuery("select p from Post p where p.member.nickName = :nickName", Post.class)
                .setParameter("nickName", nickName)
                .getResultList();
    }

}
