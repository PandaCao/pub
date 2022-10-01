package com.example.demo.application.assembler;

import com.example.demo.domain.dto.UserListDto;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAssembler {
    private final UserRepository userRepository;
    public List<UserListDto> assemble1(){
        return userRepository.findAll().stream().map(user->{
            UserListDto userListDto = new UserListDto();
            userListDto.setId(user.getId());
            userListDto.setName(user.getName());
            userListDto.setIsActive(user.getIsActive());
            userListDto.setBirthDate(user.getBirthDate());
            userListDto.setPocket(user.getPocket());
            return userListDto;
        }).collect(Collectors.toList());
    }


}
