package WonMart.WonMart;

import WonMart.WonMart.domain.Address;
import WonMart.WonMart.domain.Member;
import WonMart.WonMart.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class SampleData {

    private final InitService initService;

    // 스프링이 제공하는 init Service
    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {

            Member member = createMember("조진웅", "대구광역시", "황금로");
            em.persist(member);

            Post post1 = createPost(member, "아이폰 팝니다", 10000, "사용감 있습니다", "/img/sample/iphone.jpg");
            Post post2 = createPost(member, "아이맥 LATE 2013 21인치", 100, "데탑 새로 맞춰서 싸게 내놓습니다", "/img/sample/imac.jpg");
            Post post3 = createPost(member, "에어팟 프로", 230000, "갤럭시 이용자라 안쓰게 되더라구요 쿨거래 원합니다 쪽지 주세요", "/img/sample/airpods.jpg");

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);

        }

        public void dbInit2() {

            Member member = createMember("인시는 단어 외우는중", "서울시", "와우산로");
            em.persist(member);

            Post post1 = createPost(member, "이케아 책상", 45000, "방이 좁아서 필요 없을거같네요 진촌역 2번출구에서 직거래 원합니다 필요하신분 계시면 연락 고고", "/img/sample/desk.jpg");
            Post post2 = createPost(member, "마이프로틴 초코 카라멜 프로틴 400그람", 19000, "존나 맛있습니다 운동할 맛 나요", "/img/sample/protein.jpg");
            Post post3 = createPost(member, "중국어 기초 회화 1편", 10000, "단어 외우다가 지쳐서 팝니다 필기흔적없고 상태 좋습니다", "/img/sample/chinese.jpg");

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);

        }

        // 생성자들
        private Member createMember(String nickName, String city, String street) {
            Member member = new Member();
            member.setNickName(nickName);
            member.setAddress(new Address(city, street));
            return member;
        }

        private Post createPost(Member member, String title, int price, String body, String image) {
            Post post = Post.createPost(member, title, price, body, image);
            return post;
        }

    }
}
