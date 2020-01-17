package WonMart.WonMart.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LetterForm {

    // 로그인 세션에서 가져올 수 있게끔 처리
    private String sender;

    // 게시글에서 가져올 수 있게끔 처리
    private String receiver;

    private String body;

}
