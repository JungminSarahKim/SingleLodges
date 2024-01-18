package jpa.privatestay.domain.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "필수입력사항입니다")
    private String userId;
    @NotEmpty(message = "필수입력사항입니다")
    private String sCode;

}
