package com.example.warehouse.services;

import com.example.warehouse.DTOs.RequestDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import com.example.warehouse.models.Goods;
import com.example.warehouse.repositories.GoodsRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsServices {

  public final GoodsRepository goodsRepository;

  public GoodsServiceImpl(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }

  @Override
  public ResponseDTO addGoods(RequestDTO requestDTO) {
    goodsRepository.save(new Goods(requestDTO.getName(), requestDTO.getAmount()));
    return new ResponseDTO("Goods was added to warehouse!");
  }

  @Override
  public ResponseDTO modifyGoodsById(Long id, RequestDTO requestDTO) {
    Goods goods = goodsRepository.findById(id).get();
    goods.setName(requestDTO.getName());
    goods.setAmount(requestDTO.getAmount());
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
}
