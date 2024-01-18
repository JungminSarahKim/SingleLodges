package jpa.privatestay.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Stock")
@Getter
@Setter
public class Stock {

    @Id
    @Column(name = "sCode")
    private String sCode;



    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
    private Boolean quantity;

}
