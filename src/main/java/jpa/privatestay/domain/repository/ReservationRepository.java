package jpa.privatestay.domain.repository;

import jpa.privatestay.domain.entity.Reservation;
import jpa.privatestay.domain.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(String userId);

    //findByProjectIdAndYears
    List<Reservation> findByUserIdAndStatus(String userId, ReservationStatus status);

}

