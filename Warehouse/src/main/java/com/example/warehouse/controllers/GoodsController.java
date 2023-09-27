package com.example.warehouse.controllers;

import com.example.warehouse.DTOs.GoodsRequestDTO;
import com.example.warehouse.models.Goods;
import com.example.warehouse.services.GoodsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warehouse")
public class GoodsController {
    private final GoodsServices goodsServices;

    public GoodsController(GoodsServices goodsServices) {
        this.goodsServices = goodsServices;
    }

    @PostMapping ("/add-new-goods")
    public String addNewGoods(@ModelAttribute Goods goods, GoodsRequestDTO goodsRequestDTO){
        model.addAttribute("")
    }
}

