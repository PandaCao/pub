package com.example.demo.application.handler;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandler {
    private final UserRepository userRepository;
    public void handle1(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setIsActive(true);
        user.setPocket(100);
        user.setBirthDate(userDto.getBirthDate());
        userRepository.save(user);
    }

}
