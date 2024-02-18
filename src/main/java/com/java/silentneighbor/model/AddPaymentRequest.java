package com.java.silentneighbor.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddPaymentRequest {
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String houseNumber;
    @NotNull
    @NotBlank
    private String feeName;
    @NotNull
    private int feeAmount;
    private String feeDescription;

    public AddPaymentRequest() {
    }

    public AddPaymentRequest(String email , String houseNumber, String feeName, int feeAmount, String feeDescription) {
        this.email = email;
        this.houseNumber = houseNumber;
        this.feeName = feeName;
        this.feeAmount = feeAmount;
        this.feeDescription = feeDescription;
    }

    public AddPaymentRequest(String email , String houseNumber, String feeName, int feeAmount) {
        this.email = email;
        this.houseNumber = houseNumber;
        this.feeName = feeName;
        this.feeAmount = feeAmount;
        this.feeDescription = "";
    }


}
