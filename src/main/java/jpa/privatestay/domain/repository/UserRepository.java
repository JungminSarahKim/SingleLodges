package jpa.privatestay.domain.repository;

import jakarta.persistence.EntityManager;
import jpa.privatestay.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, String> {

}
