package com.bmarques.springkafkaavrossl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    private String customerId;
    private String initialDate;
    private String finalDate;
    private String totalGrossRevenueWeek;
    private String totalGrossRevenueLastWeek;
    private String salesCountWeek;
    private String salesCountLastWeek;
    private String totalCanceledWeek;
    private String totalCanceledLastWeek;
    private String canceledSalesCountWeek;
    private String canceledSalesCountLastWeek;
    private String salesPerDay;
    private String salesPaymentMethod;
    private String salesPaymentType;
    private String salesPerCardBrandCredit;
    private String salesPerCardBrandDebit;
    private String salesPerCardBrandVoucher;

}
