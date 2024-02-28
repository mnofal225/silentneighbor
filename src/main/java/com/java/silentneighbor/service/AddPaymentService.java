package com.java.silentneighbor.service;

import com.java.silentneighbor.database.document.PaymentHistory;
import com.java.silentneighbor.database.PaymentHistoryRepository;
import com.java.silentneighbor.model.AddPaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class AddPaymentService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    public List<PaymentHistory> allPayments() {

        return paymentHistoryRepository.findAll();
    }

    public String addPayment(AddPaymentRequest addPaymentRequest) {
        validateEmail(addPaymentRequest.getEmail());
        validateHouseNumber(addPaymentRequest.getHouseNumber());
        validateFeeName(addPaymentRequest.getFeeName());
        validateFeeAmount(addPaymentRequest.getFeeAmount());

        return "Payment added successfully for " + addPaymentRequest.getEmail();
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is missing");
        }
    }

    private void validateHouseNumber(String houseNumber) {
        if (houseNumber == null || houseNumber.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "House number is missing");
        }
    }

    private void validateFeeName(String feeName) {
        if (feeName == null || feeName.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fee name is missing");
        }
    }

    private void validateFeeAmount(int feeAmount) {
        if (feeAmount == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fee amount is missing");
        }
    }
}