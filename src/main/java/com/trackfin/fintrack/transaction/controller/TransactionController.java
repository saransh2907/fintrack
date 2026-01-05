package com.trackfin.fintrack.transaction.controller;

import com.trackfin.fintrack.transaction.entity.Transactions;
import com.trackfin.fintrack.transaction.model.UpdateTransactions;
import com.trackfin.fintrack.transaction.service.TransactionService;
import com.trackfin.fintrack.user.enitity.User;
import com.trackfin.fintrack.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/all")
    public List<Transactions> getAllTransactions(@AuthenticationPrincipal String email){
        return service.getAllTransactions(email);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Transactions> addNewTransaction(@RequestBody Transactions transactions, @AuthenticationPrincipal String email){
        transactions = service.addNewTransaction(transactions, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactions);
    }

    @PutMapping("/update")
    public ResponseEntity<Transactions> addNewCategory(@RequestBody UpdateTransactions update, @AuthenticationPrincipal String email){
        Transactions transactions = service.updateTransaction(update, email);
        if(transactions == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTransaction(@RequestBody Long transactionId, @AuthenticationPrincipal String email){
        boolean deleted = service.deleteTransaction(transactionId, email);
        if(deleted){
            return ResponseEntity.ok("Transaction with id " + transactionId +" is deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
