package com.timlai.stockapp.repository;

import com.timlai.stockapp.entity.StockAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockAppUserRepository extends JpaRepository<StockAppUser, Long> {
}
