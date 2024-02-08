package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultipleRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    //덧셈계산기

    @GetMapping("/add") //get/add
    public int  addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }


    @PostMapping("/multiply") //POSt/multiply
    public int myltiplyTwoNumbers(@RequestBody CalculatorMultipleRequest request){ //post 는 @RequestBody로 JSON을받아서 객체로 변환한다.
        return request.getNumber1() * request.getNumber2();
    }
}
