package com.example.demo.application.handler;

import com.example.demo.domain.dto.ObjednavkaDto;
import com.example.demo.domain.dto.UserValidationDto;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.repository.DrinkMenuRepository;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserValidation {
    private final UserRepository userRepository;
    private final DrinkMenuRepository drinkMenuRepository;
    private final OrderRepository orderRepository;

    private Boolean checkYears(LocalDate birthDate) {
        LocalDate bd = birthDate;
        LocalDate now = LocalDate.now();
        Period p = Period.between(bd, now);
        if (p.getYears() >= 18) {
            return true;
        } else {
            return false;
        }
    }
    public String validateUser(UserValidationDto userValidationDto) {
        var user = userRepository.findById(userValidationDto.getUserId()).get();
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < userValidationDto.getObjednavkaList().size(); i++) {
            ObjednavkaDto objednavkaDto = userValidationDto.getObjednavkaList().get(i);
            var product = drinkMenuRepository.findById(objednavkaDto.getProductId()).get();
            Integer pocket = user.getPocket();

            if (product.getIsForAdult() && !checkYears(user.getBirthDate())) {
                return "Nejsi dospělý.";
            }

            if (pocket <= product.getUnitPrice() * objednavkaDto.getQuantity()) {
                return "Nemáš dostatek financí v produktu: " + product.getProductName();
            }

            Order order = new Order();
            user.setPocket(pocket - product.getUnitPrice() * objednavkaDto.getQuantity());
            order.setAmount(objednavkaDto.getQuantity());
            order.setIsPayed(true);
            order.setProduct(product);
            order.setSummaryPrice(product.getUnitPrice() * objednavkaDto.getQuantity());
            order.setUser(user);
            orderList.add(order);
        }
        orderRepository.saveAll(orderList);
        return"Objednávka byla přijata";
}
}
