package com.example.warehouse.controllers;

import com.example.warehouse.services.GoodsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warehouse")
public class GoodsController {
  private final GoodsServices goodsServices;

  public GoodsController(GoodsServices goodsServices) {
    this.goodsServices = goodsServices;
  }

  @GetMapping("/all-items")
  public String addNewGoods(Model model) {
    model.addAttribute("allGoods", goodsServices.getAllGoods());
    return "main";
  }
}
