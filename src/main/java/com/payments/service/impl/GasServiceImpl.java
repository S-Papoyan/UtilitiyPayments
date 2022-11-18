package com.payments.service.impl;

import com.payments.exceptions.ErrorMessages;
import com.payments.exceptions.NotFoundException;
import com.payments.model.Gas;
import com.payments.repository.GasRepository;
import com.payments.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasServiceImpl implements GasService {

    @Autowired
    private GasRepository gasRepository;

    @Override
    public Gas getGasCustomerBySocialNumber(long socialNumber) throws NotFoundException {
        Gas gasCustomer = gasRepository.getGasCustomerBySocialNumber(socialNumber);
        if (gasCustomer == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_CUSTOMER);
        }
        return gasCustomer;
    }

    @Override
    public boolean pay(long socialNumber, int paymentAmount) throws NotFoundException {
        Gas gasCustomer = gasRepository.getGasCustomerBySocialNumber(socialNumber);
        if (gasCustomer == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_CUSTOMER);
        }
        gasCustomer.setAmountForConsumption(gasCustomer.getAmountForConsumption() - paymentAmount);
        gasRepository.save(gasCustomer);
        return true;
    }
}
