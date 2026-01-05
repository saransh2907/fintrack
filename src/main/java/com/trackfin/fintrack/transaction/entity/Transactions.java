package com.trackfin.fintrack.transaction.entity;

import com.trackfin.fintrack.category.entity.Category;
import com.trackfin.fintrack.user.enitity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String billId;

    @Column
    private String description;

    @Column
    private Double cost;

    @Column
    private Date date;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
