package com.example.warehouse.repositories;

import com.example.warehouse.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Long, Goods> {

}
