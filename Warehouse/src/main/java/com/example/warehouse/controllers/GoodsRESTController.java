package com.example.warehouse.controllers;


import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.DTOs.ResponseDTO;
import com.example.warehouse.services.GoodsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("/api/goods")
public class GoodsRESTController {

    public final GoodsServices goodsServices;

    public GoodsRESTController(GoodsServices goodsServices) {
        this.goodsServices = goodsServices;
    }

    @PostMapping("/add-new-goods")
    ResponseEntity<ResponseDTO> addNewGood(GoodsRequestDTO goodsRequestDTO){
        return ResponseEntity.ok().body(goodsServices.addGoods(goodsRequestDTO));
    }

    @DeleteMapping("/remove-goods/{id}")
    ResponseEntity<?> removeGoods(Long id){
        return ResponseEntity.ok().body(goodsServices.removeGoodsById(id));
    }

    @PatchMapping("/modify-goods/{id}")
    ResponseEntity<?> modifyGoods(Long id, GoodsRequestDTO goodsRequestDTO){
        return ResponseEntity.ok().body(goodsServices.modifyGoodsById(id, goodsRequestDTO));
    }

    @PatchMapping("/modify-amount-of-goods/{id}/{amount}")
    ResponseEntity<?> modifyAmountOfGoods(Long id, int amount){
        return ResponseEntity.ok().body(goodsServices.modifyAmountOfGoodsById(id, amount));
    }
}
