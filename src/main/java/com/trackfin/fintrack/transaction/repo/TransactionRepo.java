package com.trackfin.fintrack.transaction.repo;

import com.trackfin.fintrack.transaction.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Long> {

    List<Transactions> findAllByCategoryIdAndUserUserId(Long id, Long userId);

    List<Transactions> findAllByUserEmail(String email);
}
