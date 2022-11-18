package com.payments.service.impl;

import com.payments.exceptions.ErrorMessages;
import com.payments.exceptions.NotFoundException;
import com.payments.model.Water;
import com.payments.repository.WaterRepository;
import com.payments.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterServiceImpl implements WaterService {


    @Autowired
    private WaterRepository waterRepository;

    @Override
    public Water getWaterCustomerBySocialNumber(long socialNumber) throws NotFoundException {
        Water waterCustomer = waterRepository.getWaterCustomerBySocialNumber(socialNumber);
        if (waterCustomer == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_CUSTOMER);
        }
        return waterCustomer;
    }

    @Override
    public boolean pay(long socialNumber, int paymentAmount) throws NotFoundException {
        Water waterCustomer = waterRepository.getWaterCustomerBySocialNumber(socialNumber);
        if (waterCustomer == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_CUSTOMER);
        }
        waterCustomer.setAmountToPay(waterCustomer.getAmountToPay() - paymentAmount);
        waterRepository.save(waterCustomer);
        return true;
    }
}
