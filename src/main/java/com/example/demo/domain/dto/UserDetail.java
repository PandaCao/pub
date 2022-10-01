package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetail {
    Integer id;
    String name;
    Boolean isActive;
    Boolean isAdult;
    List<OrderDto> orderList;
    Integer pocket;
}
