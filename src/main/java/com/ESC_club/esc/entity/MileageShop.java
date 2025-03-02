package com.ESC_club.esc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mileage_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MileageShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int productCount;

    private String productDescription;

    private String productPhoto;

    private int productPrice;



}
