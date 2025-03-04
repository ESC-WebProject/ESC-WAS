package com.ESC_club.esc.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shop_usage_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopUsageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int history_id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Mileage mileage;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Member student;

    private LocalDateTime exchange_request_date;


}
