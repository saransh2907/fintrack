package com.trackfin.fintrack.user.repository;

import com.trackfin.fintrack.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
//    boolean existByEmail(String email);

}
