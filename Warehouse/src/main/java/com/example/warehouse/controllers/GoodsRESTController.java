package com.example.warehouse.controllers;


import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.services.GoodsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
public class GoodsRESTController {

    public final GoodsServices goodsServices;

    public GoodsRESTController(GoodsServices goodsServices) {
        this.goodsServices = goodsServices;
    }

    @PostMapping("/add-new-goods")
    ResponseEntity<?> addNewGood(@RequestBody  GoodsRequestDTO goodsRequestDTO){
        return ResponseEntity.ok().body(goodsServices.addGoods(goodsRequestDTO));
    }

    @DeleteMapping("/remove-goods/{id}")
    ResponseEntity<?> removeGoods(@PathVariable Long id){
        return ResponseEntity.ok().body(goodsServices.removeGoodsById(id));
    }

    @PatchMapping("/modify-goods/{id}")
    ResponseEntity<?> modifyGoods(@PathVariable Long id, @RequestBody  GoodsRequestDTO goodsRequestDTO){
        return ResponseEntity.ok().body(goodsServices.modifyGoodsById(id, goodsRequestDTO));
    }

    @PatchMapping("/modify-amount-of-goods/{id}/{amount}")
    ResponseEntity<?> modifyAmountOfGoods(@PathVariable Long id, @PathVariable int amount){
        return ResponseEntity.ok().body(goodsServices.modifyAmountOfGoodsById(id, amount));
    }
}
