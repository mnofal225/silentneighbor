package com.java.silentneighbor.database;

import com.java.silentneighbor.database.document.PaymentHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryRepository extends MongoRepository<PaymentHistory, ObjectId> {
}
