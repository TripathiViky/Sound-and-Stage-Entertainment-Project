
package models;

import dao.ClassDb;


public class PaymentDetailModel {
    int paymentcode,bookingCode, amount;
    String cHolder,ccNo,cvno,validupto;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
    
    public int getPaymentcode() {
        return paymentcode;
    }

    public void setPaymentcode(int paymentcode) {
        this.paymentcode = paymentcode;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getcHolder() {
        return cHolder;
    }

    public void setcHolder(String cHolder) {
        this.cHolder = cHolder;
    }

    public String getCcNo() {
        return ccNo;
    }

    public void setCcNo(String ccNo) {
        this.ccNo = ccNo;
    }

    public String getCvno() {
        return cvno;
    }

    public void setCvno(String cvno) {
        this.cvno = cvno;
    }

    public String getValidupto() {
        return validupto;
    }

    public void setValidupto(String validupto) {
        this.validupto = validupto;
    }
    
    ClassDb obj=new ClassDb();
    
    public String insert()
    {
        String res="";
        paymentcode = obj.getMaxCode("paymentdetail", "paymentcode");
        String query="insert into paymentdetail values("+paymentcode+","+
                bookingCode+",'"+cHolder+"','"+ccNo+"','"+cvno+"','"+validupto+"', "+
                amount+")";
        res=obj.updateRecords(query)+"Your Seat Confirmed /n Bring Booking code and"
                + "Id Proof as you have given in form";
        return res;
    }
    
}
