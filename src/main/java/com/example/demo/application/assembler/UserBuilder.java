package com.example.demo.application.assembler;

import com.example.demo.domain.dto.OrderDto;
import com.example.demo.domain.dto.UserDetail;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserBuilder {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private Boolean checkYears(LocalDate birthDate) {
        LocalDate bd = birthDate;
        LocalDate now = LocalDate.now();
        Period p = Period.between(bd, now);
        if(p.getYears()>=18){
            return true;
        }
        else{
            return false;
        }
    }
    public UserDetail assembleById(Integer id){
        var user = userRepository.findById(id).get();
        return UserDetail.builder()
                .id(user.getId())
                .name(user.getName())
                .isActive(user.getIsActive())
                .isAdult(checkYears(user.getBirthDate()))
                .pocket(user.getPocket())
                .orderList(user.getOrderList().stream().map(order->{
                    OrderDto orderDto = new OrderDto();
                    orderDto.setProductName(order.getProduct().getProductName());
                    orderDto.setAmount(order.getAmount());
                    orderDto.setSummaryPrice(order.getSummaryPrice());
                    orderDto.setIsPayed(order.getIsPayed());
                    return orderDto;
                }).collect(Collectors.toList()))
                .build();
    }
    /*
    public UserDetail assembleById(Integer id){
        var user = userRepository.findById(id).get();

        List<OrderDto> list = new ArrayList<>();

        for (var order: user.getOrderList()){
            OrderDto orderDto = new OrderDto();
            orderDto.setProductName(order.getProductName());
            orderDto.setAmount(order.getAmount());
            orderDto.setSummaryPrice(order.getSummaryPrice());
            orderDto.setIsPayed(order.getIsPayed());
            list.add(orderDto);
        }
        return UserDetail.builder()
                .id(user.getId())
                .name(user.getName())
                .isActive(user.getIsActive())
                .isAdult(checkYears(user.getBirthDate()))
                .pocket(user.getPocket())
                .orderList(list)
                .build();
    }
    */
    public boolean checkMoney(Integer pocket, Integer price){
        Integer i = pocket;
        return false;
    }
    /*public List<UserValidation> validationById(Integer id){
        var order = orderRepository.findAll();
        return userRepository.findById(id).stream().map(user->{
            UserValidation userValidation = new UserValidation();
            userValidation.setUserId(user.getId());
            userValidation.setIsAdult(checkYears(user.getBirthDate()));
            userValidation.setHasEnoughPocket.(checkMoney(user.getPocket(), ));
            return userValidation;
        }).collect(Collectors.toList());
    }*/
}
