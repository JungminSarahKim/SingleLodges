package jpa.privatestay.domain.service;

import jpa.privatestay.domain.entity.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationSearch {
    ReservationStatus status;
    String userId;
}
