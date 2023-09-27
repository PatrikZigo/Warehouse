package com.example.warehouse.services;

import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.DTOs.GoodsResponseDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import com.example.warehouse.models.Goods;
import com.example.warehouse.repositories.GoodsRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsServices {

  public final GoodsRepository goodsRepository;

  public GoodsServiceImpl(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }

  @Override
  public ResponseDTO addGoods(GoodsRequestDTO goodsRequestDTO) {
    Goods goods = new Goods(goodsRequestDTO.getName(), goodsRequestDTO.getAmount());
    goodsRepository.save(goods);
    return new ResponseDTO("Goods was added to warehouse!");
  }

  @Override
  public ResponseDTO modifyGoodsById(Long id, GoodsRequestDTO goodsRequestDTO) {
    Goods goods = goodsRepository.findById(id).get();
    goods.setName(goodsRequestDTO.getName());
    goods.setAmount(goodsRequestDTO.getAmount());
    goodsRepository.save(goods);
    return new ResponseDTO("Goods was updated!");
  }

  @Override
  public ResponseDTO modifyAmountOfGoodsById(Long id, int amount) {
    Goods goods = goodsRepository.findById(id).get();
    goods.setAmount(amount);
    goodsRepository.save(goods);
    return new ResponseDTO("Amount was changed!");
  }

  @Override
  public ResponseDTO plusOneGoodsById(Long id) {
    Goods goods = goodsRepository.findById(id).get();
    goods.setAmount(goods.getAmount() + 1);
    goodsRepository.save(goods);
    return new ResponseDTO("Goods was increased by 1");
  }

  @Override
  public ResponseDTO minusOneGoodsById(Long id) {
    Goods goods = goodsRepository.findById(id).get();
    goods.setAmount(goods.getAmount() - 1);
    goodsRepository.save(goods);
    return new ResponseDTO("Goods was decreased by 1");
  }

  @Override
  public ResponseDTO removeGoodsById(Long id) {
    goodsRepository.delete(goodsRepository.findById(id).get());
    return new ResponseDTO("Goods was removed!");
  }

  @Override
  public List<GoodsResponseDTO> getAllGoods() {
    return goodsRepository.findAll().stream()
        .map(
            goods -> {
              GoodsResponseDTO goodsResponseDTO =
                  new GoodsResponseDTO(goods.getId(), goods.getName(), goods.getAmount());
              return goodsResponseDTO;
            })
        .collect(Collectors.toList());
  }
}
