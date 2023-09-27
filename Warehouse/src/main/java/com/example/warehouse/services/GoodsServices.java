package com.example.warehouse.services;

import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.DTOs.GoodsResponseDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import com.example.warehouse.models.Goods;

import java.util.List;


public interface GoodsServices {
  ResponseDTO addGoods(GoodsRequestDTO goodsRequestDTO);

  ResponseDTO modifyGoodsById(Long id, GoodsRequestDTO goodsRequestDTO);

  ResponseDTO modifyAmountOfGoodsById(Long id, int amount);

  ResponseDTO plusOneGoodsById(Long id);

  ResponseDTO minusOneGoodsById(Long id);

  ResponseDTO removeGoodsById(Long id);

  List<GoodsResponseDTO> getAllGoods();
}
