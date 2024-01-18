package jpa.privatestay.domain.service;

import jpa.privatestay.domain.entity.ReservationStatus;
import jpa.privatestay.domain.exception.NotEnoughStockException;
import jpa.privatestay.domain.entity.Reservation;
import jpa.privatestay.domain.entity.Stock;
import jpa.privatestay.domain.entity.User;
import jpa.privatestay.domain.repository.ReservationRepository;
import jpa.privatestay.domain.repository.StockRepository;
import jpa.privatestay.domain.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private  final UserRepository userRepository;
    private final StockRepository stockRepository;

//    public List<Reservation> findReservationBySCode(String pCode) {
//        return reservationRepository.findByStock_sCodeContaining(pCode);
//    }
    //new order
    @Transactional
    public Integer reservation(String userId, Integer headCount, ReservationStatus status, String sCode) throws NotEnoughStockException {
         User user = userRepository.findById(userId).get();
         Stock stock = stockRepository.findById(sCode).get();

        Reservation reservation = Reservation.createReservation(user, headCount, status, stock);
        reservationRepository.save(reservation);
        return reservation.getId();
    }
    //cancel
    @Transactional
    public void cancelReservation(Integer reservationId)  {
        Reservation reservation = findReservationById(reservationId);
        reservation.cancelReservation();
    }
    @Transactional
    public void updateReservation(Integer reservationId, Reservation param) {
        Reservation findedReservation = reservationRepository.findById(reservationId).get();
        findedReservation.setStatus(param.getStatus());
        findedReservation.setHeadcount(param.getHeadcount());
        findedReservation.setCurrTimeStamp(LocalDateTime.now());
    }

    public List<Reservation> findReservationsByUserIdandStatus(ReservationSearch reservationSearch) {
        return reservationRepository.findByUserIdAndStatus(reservationSearch.getUserId(), reservationSearch.getStatus());
    }
    public Reservation findReservationById(Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        return reservation;
    }


//    public List<Reservation> findByUserId(String userId) {
//        return reservationRepository.findByUserId(userId);
//    }

}
