package com.infoPulse.lessons;

import java.io.Serializable;

public class Payment implements Serializable{
    private static final long serialVersionUID = 1;
    String customerNumber;
    String paymentDate;
    String amount;

    public Payment(String customerNumber, String paymentDate, String amount) {
        this.customerNumber = customerNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }
}


