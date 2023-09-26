package com.example.warehouse.services;

import com.example.warehouse.DTOs.RequestDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface GoodsServices {
    ResponseDTO addGoods(RequestDTO requestDTO);

    ResponseDTO modifyGoodsById(Long id, RequestDTO requestDTO);

    ResponseDTO modifyAmountOfGoodsById(Long id, int amount);

    ResponseDTO removeGoodsById(Long id);
}
