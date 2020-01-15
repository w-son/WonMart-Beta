package WonMart.WonMart.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "닉네임 정보는 필수입니다")
    private String nickName;

    @NotEmpty(message = "지역구 정보는 필수입니다")
    private String city;

    @NotEmpty(message = "도로명 정보는 필수입니다")
    private String street;

}
