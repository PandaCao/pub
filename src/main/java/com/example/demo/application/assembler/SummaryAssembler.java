package com.example.demo.application.assembler;

import com.example.demo.domain.dto.*;
import com.example.demo.domain.repository.DrinkMenuRepository;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SummaryAssembler {
    private final OrderRepository orderRepository;
    private final DrinkMenuRepository drinkMenuRepository;
    private final UserRepository userRepository;

    public List<SummaryListDto> summaryListDtoList(){
        return drinkMenuRepository.findAll().stream().map(product -> {
            SummaryListDto summaryDto = new SummaryListDto();
            summaryDto.setProductName(product.getProductName());
            product.getOrderList().forEach(order -> {
                summaryDto.setQuantity(summaryDto.getQuantity()+order.getAmount());
                summaryDto.setSummaryPrice(summaryDto.getUnityPrice()*summaryDto.getQuantity());
            });
            summaryDto.setUnityPrice(product.getUnitPrice());
            return summaryDto;
        }).collect(Collectors.toList());
    }

    public List<SummaryProductListDto> summaryProductList(){
        return drinkMenuRepository.findAll().stream().map(drinkMenu -> {
            SummaryProductListDto summaryProductListDto = new SummaryProductListDto();
            summaryProductListDto.setProductName(drinkMenu.getProductName());
            summaryProductListDto.setProductList(drinkMenu.getOrderList().stream().map(order -> {
                ProductList productList = new ProductList();
                productList.setUserId(order.getUser().getId());
                productList.setQuantity(order.getAmount());
                productList.setSummaryPrice(order.getSummaryPrice());
                return productList;
            }).collect(Collectors.toList()));
            return  summaryProductListDto;
        }).collect(Collectors.toList());
    }

    public List<SummaryUserListDto> summaryUserList(){
        return userRepository.findAll().stream().map(user -> {
            SummaryUserListDto summaryUserListDto = new SummaryUserListDto();
            summaryUserListDto.setUserName(user.getName());
            summaryUserListDto.setUserList(user.getOrderList().stream().map(order -> {
                UserList userList = new UserList();
                userList.setUserId(order.getUser().getId());
                userList.setProductName(order.getProduct().getProductName());
                userList.setSummaryPrice(order.getSummaryPrice());
                return userList;
            }).collect(Collectors.toList()));
            return summaryUserListDto;
        }).collect(Collectors.toList());
    }
 }
