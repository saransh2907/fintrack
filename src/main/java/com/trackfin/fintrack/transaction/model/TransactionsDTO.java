package com.trackfin.fintrack.transaction.model;

import com.trackfin.fintrack.category.entity.Category;
import com.trackfin.fintrack.user.enitity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionsDTO {

    private Long id;
    private String billId;
    private String description;
    private Double cost;
    private Date date;
    private String category;
    private User user;

}
