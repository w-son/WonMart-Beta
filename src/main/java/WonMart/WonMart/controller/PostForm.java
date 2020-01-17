package WonMart.WonMart.controller;

import WonMart.WonMart.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter @Setter
public class PostForm {

    private String title;

    // 이 부분 로그인 세션에서 가져오게끔 처리
    private String nickName;

    private int price;

    private String body;

}
