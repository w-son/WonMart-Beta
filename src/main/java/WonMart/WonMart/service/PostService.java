package WonMart.WonMart.service;

import WonMart.WonMart.domain.Member;
import WonMart.WonMart.domain.Post;
import WonMart.WonMart.repository.MemberRepository;
import WonMart.WonMart.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService { // 생성, 삭제, 수정, 조회

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long post(String nickName, String title, int price, String body) {
        List<Member> members = memberRepository.findByNickName(nickName);
        Post post = Post.createPost(members.get(0), title, price, body);
        postRepository.save(post);

        return post.getId();
    }

    @Transactional
    public void delete(Post post) {
        postRepository.remove(post);
    }

    @Transactional
    public void updatePost(Long id, String title, int price, String body) {
        // 변경 감지
        Post post = postRepository.findOne(id);

        post.setTitle(title);
        post.setPostTime(LocalDateTime.now());
        post.setPrice(price);
        post.setBody(body);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public List<Post> findByNickName(String nickName) {
        return postRepository.findByNickName(nickName);
    }

}
