package com.ESC_club.esc.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="mileage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mileage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mileage_count;


    @Column(nullable = false)
    private LocalDateTime accual_date;

    private String accrual_place;
    private LocalDateTime usage_date;
    private int validity_period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member student;


 }
