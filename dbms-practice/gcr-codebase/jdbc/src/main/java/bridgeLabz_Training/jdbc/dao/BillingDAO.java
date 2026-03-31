package bridgeLabz_Training.jdbc.dao;

import bridgeLabz_Training.jdbc.model.PaymentTransaction;

import java.time.LocalDate;
import java.util.List;

public interface BillingDAO {

    double getConsultationFeeByVisit(int visitId);

    int generateBill(int visitId, double totalAmount);

    void markBillPaid(int billId);

    void insertPayment(PaymentTransaction payment);

    List<String> getOutstandingBills();

    List<String> getRevenueReport(LocalDate from, LocalDate to);
}