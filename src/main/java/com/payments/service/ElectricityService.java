package com.payments.service;

import com.payments.exceptions.NotFoundException;
import com.payments.model.Electricity;

public interface ElectricityService {

    Electricity getById(int id) throws NotFoundException;

    Electricity getBySocialNumber(long socialNumber) throws NotFoundException;

    boolean pay(long socialNumber, int paymentAmount) throws NotFoundException;

}
