package jpa.privatestay.domain.controller;
import jpa.privatestay.domain.entity.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReservationForm {
    @NotEmpty(message = "필수입력사항입니다")
    private ReservationStatus status;
    @NotEmpty(message = "필수입력사항입니다.")
    private Integer headCount;
    //-----------------------여긴 지워라


}
