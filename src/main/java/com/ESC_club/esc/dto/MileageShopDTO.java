package com.ESC_club.esc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MileageShopDTO {
    private String productName;
    private int productCount;
    private String productDescription;
    private String productPhoto;
    private int productPrice;
    private int studentId; // 관리 권한 확인용
}
