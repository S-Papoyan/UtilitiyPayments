package com.payments.controller;

import com.payments.exceptions.NotFoundException;
import com.payments.model.Electricity;
import com.payments.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/electricity")
public class ElectricityController {

    @Autowired
    private ElectricityService electricityService;


    @GetMapping("/get-by-id")
    public ResponseEntity<?> getElPaymentsById(@RequestParam int id) throws NotFoundException {
        Electricity electricity = electricityService.getById(id);
        return ResponseEntity.ok(electricity);

    }

    @GetMapping("/get-by-social-number")
    public ResponseEntity<?> getBySocialNumber(@RequestParam long socialNumber) throws NotFoundException {
        return ResponseEntity.ok(electricityService.getBySocialNumber(socialNumber));
    }

    @PatchMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody Request request) throws NotFoundException {
        //boolean pay = electricityService.pay(socialNumber, paymentAmount);
        return ResponseEntity.ok(request);
    }
}
