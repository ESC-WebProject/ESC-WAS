package com.ESC_club.esc.entity;

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
    private Long mileageCount;


    @Column(nullable = false)
    private LocalDateTime accualDate;

    private String accrualPlace;
    private LocalDateTime usageDate;
    private int validityPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member student;


 }
