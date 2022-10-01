package com.example.demo.infrastructure;

import com.example.demo.application.assembler.DrinkMenuAssembler;
import com.example.demo.application.handler.DrinkMenuHandler;
import com.example.demo.domain.dto.DrinkMenuDto;
import com.example.demo.domain.dto.DrinkMenuListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrinkMenuController {
    private final DrinkMenuHandler drinkMenuHandler;
    private final DrinkMenuAssembler drinkMenuAssembler;

    @PostMapping(value="/drinks")
    public void createDrink(@RequestBody DrinkMenuDto drinkMenuDto){
        drinkMenuHandler.handle2(drinkMenuDto);
    }
    @GetMapping(value="/drink-menu")
    public List<DrinkMenuListDto> getDrinkMenu(){
        return drinkMenuAssembler.assemble2();
    }
}
