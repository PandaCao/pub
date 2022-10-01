package com.example.demo.application.handler;

import com.example.demo.domain.dto.DrinkMenuDto;
import com.example.demo.domain.entity.DrinkMenu;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.DrinkMenuRepository;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkMenuHandler {
    private final DrinkMenuRepository drinkMenuRepository;

    public void handle2(DrinkMenuDto drinkMenuDto){
        DrinkMenu drinkMenu = new DrinkMenu();
        drinkMenu.setProductName(drinkMenuDto.getProductName());
        drinkMenu.setUnitPrice(drinkMenuDto.getUnitPrice());
        drinkMenu.setProductName(drinkMenuDto.getProductName());
        drinkMenu.setIsForAdult(drinkMenuDto.getIsForAdult());
        drinkMenuRepository.save(drinkMenu);
    }
}
