package com.ESC_club.esc.Entity;

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
    private Long product_id;

    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private String product_count;

    private String product_description;

    private String product_photo;

    private int product_price;



}
