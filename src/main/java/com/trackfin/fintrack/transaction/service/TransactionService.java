package com.trackfin.fintrack.transaction.service;

import com.trackfin.fintrack.transaction.entity.Transactions;
import com.trackfin.fintrack.transaction.model.TransactionsDTO;
import com.trackfin.fintrack.transaction.model.UpdateTransactions;
import com.trackfin.fintrack.transaction.repo.TransactionRepo;
import com.trackfin.fintrack.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repo;

    @Autowired
    private UserRepository userRepo;
    public List<Transactions> getAllTransactions(String email) {
        return repo.findAllByUserEmail(email);
    }

    public Transactions addNewTransaction(Transactions transactions, String email){
        transactions.setUser(userRepo.findByEmail(email).get());
        return repo.save(transactions);
    }

    public Transactions updateTransaction(UpdateTransactions update, String email) {
        Optional<Transactions> old = repo.findById(update.getOldId());
        if(old.isPresent() && validateUser(old.get(), email)){
            return repo.save(UpdateTransactions.getNewTransaction(old.get(), update));
        }
        return null;
    }

    public boolean deleteTransaction(Long transactionId, String email) {
        Optional<Transactions> transactions = repo.findById(transactionId);
        if(transactions.isPresent() && validateUser(transactions.get(), email)){
            repo.delete(transactions.get());
            return true;
        }
        return false;
    }

    private boolean validateUser(Transactions transactions, String email){
        return email.equals(transactions.getUser().getEmail());
    }
}
