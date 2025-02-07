package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "ExchangeRecord")
public class ExchangeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private LocalDateTime exchangeRequestDate;
    private LocalDateTime exchangeCompletionDate;
    private boolean exchangeState;
}