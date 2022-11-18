package com.payments.service;

import com.payments.exceptions.NotFoundException;
import com.payments.model.Water;

public interface WaterService {

    Water getWaterCustomerBySocialNumber(long socialNumber) throws NotFoundException;

    boolean pay(long socialNumber, int paymentAmount) throws NotFoundException;

}
