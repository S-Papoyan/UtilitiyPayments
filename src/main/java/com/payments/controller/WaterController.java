package com.payments.controller;

import com.payments.exceptions.NotFoundException;
import com.payments.model.Water;
import com.payments.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @GetMapping("/get-by-social-number")
    public ResponseEntity<Water> getWaterCustomerBySocialNumber(@RequestParam long socialNumber) throws NotFoundException {
        Water waterCustomer = waterService.getWaterCustomerBySocialNumber(socialNumber);
        return ResponseEntity.ok(waterCustomer);
    }

    @PatchMapping("/pay")
    public ResponseEntity<?> pay(@RequestParam long socialNumber, @RequestParam int paymentAmount) throws NotFoundException {
        boolean pay = waterService.pay(socialNumber, paymentAmount);
        return pay ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
