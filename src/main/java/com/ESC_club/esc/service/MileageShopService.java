package com.ESC_club.esc.service;

import com.ESC_club.esc.dto.MileageShopDTO;
import com.ESC_club.esc.entity.MileageShop;
import com.ESC_club.esc.repository.MileageShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MileageShopService {
    private final MileageShopRepository mileageShopRepository;

    public MileageShopService(MileageShopRepository mileageShopRepository) {
        this.mileageShopRepository = mileageShopRepository;
    }

    @Transactional
    public void addProduct(MileageShopDTO productDTO) {
        MileageShop product = new MileageShop(null, productDTO.getProductName(), productDTO.getProductCount(), productDTO.getProductDescription(), productDTO.getProductPhoto(), productDTO.getProductPrice());
        mileageShopRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        mileageShopRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, MileageShopDTO productDTO) {
        MileageShop product = mileageShopRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(productDTO.getProductName());
        product.setProductCount(productDTO.getProductCount());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPhoto(productDTO.getProductPhoto());
        product.setProductPrice(productDTO.getProductPrice());
        mileageShopRepository.save(product);
    }

    public List<MileageShop> listProducts() {
        return mileageShopRepository.findAll();
    }
}
