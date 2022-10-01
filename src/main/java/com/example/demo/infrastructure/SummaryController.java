package com.example.demo.infrastructure;

import com.example.demo.application.assembler.SummaryAssembler;
import com.example.demo.domain.dto.SummaryListDto;
import com.example.demo.domain.dto.SummaryProductListDto;
import com.example.demo.domain.dto.SummaryUserListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SummaryController {
    private final SummaryAssembler summaryAssembler;

    @GetMapping(value="/summary/all")
    public List<SummaryListDto> getSummaryList(){
        return summaryAssembler.summaryListDtoList();
    }

    @GetMapping(value = "/summary/product")
    public List<SummaryProductListDto> getSummaryProductList(){
        return summaryAssembler.summaryProductList();
    }

    @GetMapping(value = "/summary/user")
    public List<SummaryUserListDto> getSummaryUserList(){
        return summaryAssembler.summaryUserList();
    }

}
