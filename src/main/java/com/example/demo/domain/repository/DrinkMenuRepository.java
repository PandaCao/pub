package com.example.demo.domain.repository;

import com.example.demo.domain.entity.DrinkMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrinkMenuRepository extends JpaRepository<DrinkMenu, Integer> {
}
