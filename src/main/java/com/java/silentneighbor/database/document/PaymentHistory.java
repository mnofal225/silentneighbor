package com.java.silentneighbor.database.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory {
    @Id
    private ObjectId id;
    private String email;
    private String houseNumber;
    private String feeName;
    private int feeAmount;
    private String date;
    private String feeDescription;
}
