package com.example.demo.infrastructure;

import com.example.demo.application.assembler.UserAssembler;
import com.example.demo.application.assembler.UserBuilder;
import com.example.demo.application.handler.UserHandler;
import com.example.demo.application.handler.UserValidation;
import com.example.demo.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserHandler userHandler;
    private final UserAssembler userAssembler;
    private final UserBuilder userBuilder;
    private final UserValidation userValidation;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        userHandler.handle1(userDto);
    }
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<UserListDto> getUser(){
        return userAssembler.assemble1();
    }

    @GetMapping(value="/users/{id}")
    public UserDetail getUser(@PathVariable Integer id){
        return userBuilder.assembleById(id);
    }

    @PostMapping(value="/buy")
    public String validateUser(@RequestBody UserValidationDto userValidationDto){
        return userValidation.validateUser(userValidationDto);
    }
}
