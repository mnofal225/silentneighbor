package com.java.silentneighbor.controller;

import com.java.silentneighbor.database.document.PaymentHistory;
import com.java.silentneighbor.model.AddPaymentRequest;
import com.java.silentneighbor.service.AddPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loud-neighbor")
@CrossOrigin(origins = "http://localhost:8080")
public class SilentNeighborController {

    @Autowired
    private AddPaymentService addPaymentService;

    @GetMapping("/get-history")
    public ResponseEntity<String> getPaymentHistory() {
        return new ResponseEntity<String>("Hello Payment History", HttpStatus.OK);
    };

//    @GetMapping("/payment-history")
//    public ResponseEntity<List<PaymentHistory>> getAllPayments() {
//        return new ResponseEntity<List<PaymentHistory>>(addPaymentService.allPayments(), HttpStatus.OK);
//    }

    @PostMapping("/add-payment")
    public ResponseEntity<String> addPayment(@Valid @RequestBody AddPaymentRequest addPaymentRequest) {
        return new ResponseEntity<String>(addPaymentService.addPayment(addPaymentRequest), HttpStatus.CREATED);
    };

}