package jpa.privatestay.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "userId")
    private String id;
    @OneToMany(mappedBy = "user", cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();


}
