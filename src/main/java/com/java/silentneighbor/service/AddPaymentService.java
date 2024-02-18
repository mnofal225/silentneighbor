package com.java.silentneighbor.service;

import com.java.silentneighbor.model.AddPaymentRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AddPaymentService {

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