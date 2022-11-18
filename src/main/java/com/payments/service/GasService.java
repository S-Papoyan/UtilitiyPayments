package com.payments.service;

import com.payments.exceptions.NotFoundException;
import com.payments.model.Gas;

public interface GasService {

    Gas getGasCustomerBySocialNumber(long socialNumber) throws NotFoundException;

    boolean pay(long socialNumber, int paymentAmount) throws NotFoundException;

}
