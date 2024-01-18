//package jpa.privatestay.api;
//
//import jakarta.servlet.http.HttpSession;
//import jpa.privatestay.domain.entity.Reservation;
//import jpa.privatestay.domain.entity.ReservationStatus;
//import jpa.privatestay.domain.entity.Stock;
//import jpa.privatestay.domain.entity.User;
//import jpa.privatestay.domain.exception.NotEnoughStockException;
//import jpa.privatestay.domain.repository.StockRepository;
//import jpa.privatestay.domain.repository.UserRepository;
//import jpa.privatestay.domain.service.ReservationSearch;
//import jpa.privatestay.domain.service.ReservationService;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ReservationApiController {
//
//    private final ReservationService reservationService;
//    private final UserRepository userRepository;  // Make sure this line is present
//    private final StockRepository stockRepository;
//
//
//    @PostMapping("/api/reservation")
//    public CreateReservationResponse saveReservation(@RequestBody CreateReservationRequest request) throws NotEnoughStockException {
//        User user = new User();
//        user.setId(request.getUserId());
//        userRepository.save(user);
//
//        Stock stock = new Stock();
//        stock.setSCode(request.getSCode());
//        stock.setQuantity(true);
//        stockRepository.save(stock);
//        Integer id = reservationService.reservation(request.getUserId(), request.getHeadCount(), request.getStatus(), request.getSCode());
//        return new CreateReservationResponse(id);
//    }
//    @Data
//    static class CreateReservationRequest {
//        private String userId;
//        private String sCode;
//        private Integer headCount;
//        private ReservationStatus status;
//
//    }
//    @Data
//    static class CreateReservationResponse {
//        private Integer id;
//        public CreateReservationResponse(Integer id) {
//            this.id = id;
//        }
//    }
//
//
//}
