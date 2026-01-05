package com.trackfin.fintrack.transaction.model;

import com.trackfin.fintrack.transaction.entity.Transactions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTransactions {

    private Long oldId;
    private String billId;
    private String description;
    private Double cost;
    private Date date;

    public static Transactions getNewTransaction(Transactions old, UpdateTransactions update){
        if (update.billId != null) old.setBillId(update.billId);
        if (update.description != null) old.setDescription(update.description);
        if (update.cost != null) old.setCost(update.cost);
        if (update.date != null) old.setDate(update.date);
        return old;
    }

}
