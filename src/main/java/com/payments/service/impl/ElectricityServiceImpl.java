package com.payments.service.impl;

import com.payments.exceptions.ErrorMessages;
import com.payments.exceptions.NotFoundException;
import com.payments.model.Electricity;
import com.payments.repository.ElectricityRepository;
import com.payments.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElectricityServiceImpl implements ElectricityService {

    @Autowired
    private ElectricityRepository electricityRepository;

    @Override
    public Electricity getById(int id) throws NotFoundException {
        Optional<Electricity> elPayments = electricityRepository.findById(id);
        if (elPayments.isEmpty()) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_ID);
        }
        return elPayments.get();
    }

    @Override
    public Electricity getBySocialNumber(long socialNumber) throws NotFoundException {
        Electricity customerElectricityBySocialNumber = electricityRepository.getElectricityBySocialNumber(socialNumber);
        if (customerElectricityBySocialNumber == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_ID);
        }
        return customerElectricityBySocialNumber;
    }

    @Override
    public boolean pay(long socialNumber, int paymentAmount) throws NotFoundException {
        Electricity customerElBySocNum = getBySocialNumber(socialNumber);
        if (customerElBySocNum == null) {
            throw new NotFoundException(ErrorMessages.NOT_FOUND_ID);
        }
        customerElBySocNum.setTotalSum(customerElBySocNum.getTotalSum() - paymentAmount);
        electricityRepository.save(customerElBySocNum);
        return true;
    }
}
