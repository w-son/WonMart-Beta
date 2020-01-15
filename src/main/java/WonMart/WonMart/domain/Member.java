package WonMart.WonMart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    // PK
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String nickName;

    @Embedded
    private Address address;

    // Post와 OneToMany 연관관계
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    // Letter과 OneToMany 연관관계
    @OneToMany(mappedBy = "member")
    private List<Letter> letters = new ArrayList<>();

    /*
     하나의 객체에 적용되는 비즈니스 로직, 연관관계 메서드, 생성 메서드는 엔티티 클래스 내에 구현한다

     - 연관관계 메서드는 관계도에서 중심이 되는 엔티티에 구현한다
     Post - Member - Letter
     Member가 Post와 Letter의 중심에 존재

     - 생성메서드는 Post, Letter에 각각 구현
     */

    public void addPost(Post post) {
        posts.add(post);
        post.setMember(this);
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
        letter.setMember(this);
    }

}
