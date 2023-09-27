package com.example.warehouse.services;

import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.DTOs.GoodsResponseDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import java.util.List;

public interface GoodsServices {
  ResponseDTO addGoods(GoodsRequestDTO goodsRequestDTO);

  ResponseDTO modifyGoodsById(Long id, GoodsRequestDTO goodsRequestDTO);

  ResponseDTO modifyAmountOfGoodsById(Long id, int amount);

  ResponseDTO removeGoodsById(Long id);

  List<GoodsResponseDTO> getAllGoods();
}
