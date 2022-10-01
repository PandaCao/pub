package com.example.demo.application.assembler;

import com.example.demo.domain.dto.DrinkMenuListDto;
import com.example.demo.domain.repository.DrinkMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkMenuAssembler {
    private final DrinkMenuRepository drinkMenuRepository;

    public List<DrinkMenuListDto> assemble2() {

        return drinkMenuRepository.findAll().stream()
                .map(drinkMenu -> {
                    DrinkMenuListDto drinkMenuListDto = new DrinkMenuListDto();
                    drinkMenuListDto.setId(drinkMenu.getId());
                    drinkMenuListDto.setProductName(drinkMenu.getProductName());
                    drinkMenuListDto.setUnitPrice(drinkMenu.getUnitPrice());
                    drinkMenuListDto.setIsForAdult(drinkMenu.getIsForAdult());
                    return drinkMenuListDto;
                }).collect(Collectors.toList());
    }
}
