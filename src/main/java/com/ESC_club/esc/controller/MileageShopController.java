package com.ESC_club.esc.controller;

import com.ESC_club.esc.dto.MileageShopDTO;
import com.ESC_club.esc.entity.MileageShop;
import com.ESC_club.esc.service.MileageShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mileage-shop")
public class MileageShopController {
    private final MileageShopService mileageShopService;

    public MileageShopController(MileageShopService mileageShopService) {
        this.mileageShopService = mileageShopService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody MileageShopDTO productDTO) {
        mileageShopService.addProduct(productDTO);
        return ResponseEntity.ok("Product added successfully.");
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        mileageShopService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully.");
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody MileageShopDTO productDTO) {
        mileageShopService.updateProduct(productId, productDTO);
        return ResponseEntity.ok("Product updated successfully.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<MileageShop>> listProducts() {
        return ResponseEntity.ok(mileageShopService.listProducts());
    }
}

