package com.java.silentneighbor.controller;

import com.java.silentneighbor.model.AddPaymentRequest;
import com.java.silentneighbor.service.AddPaymentService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/silentneighbor")
@CrossOrigin(origins = "http://localhost:8080")
public class SilentNeighborController {

    @Autowired
    private AddPaymentService addPaymentService;

    @PostMapping("/add-payment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Payment added successfully"),
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<String> addPayment(@Valid @RequestBody AddPaymentRequest addPaymentRequest) {
        return new ResponseEntity<>(addPaymentService.addPayment(addPaymentRequest), HttpStatus.CREATED);
    }
}