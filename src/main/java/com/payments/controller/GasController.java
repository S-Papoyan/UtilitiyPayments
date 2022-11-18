package com.payments.controller;

import com.payments.exceptions.NotFoundException;
import com.payments.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gas")
public class GasController {

    @Autowired
    private GasService gasService;

    @GetMapping("/payment-by-social-number")
    public ResponseEntity<?> getBySocialNumber(@RequestParam long socialNumber) throws NotFoundException {
        return ResponseEntity.ok(gasService.getGasCustomerBySocialNumber(socialNumber));
    }

    @PatchMapping("/pay")
    public ResponseEntity<?> pay(@RequestParam long socialNumber, @RequestParam int paymentAmount) throws NotFoundException {
        boolean pay = gasService.pay(socialNumber, paymentAmount);
        return pay ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
