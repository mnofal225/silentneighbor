package com.java.silentneighbor.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.java.silentneighbor.model.AddPaymentRequest;

public interface AddPaymentRepository extends MongoRepository<AddPaymentRequest, String> {
}
