
package models;

import dao.ClassDb;


public class SnackPaymentModel {
    int paymentcode,bookingcode,amount;
    String cardholder,ccno,cvno,validupto;

    public int getPaymentcode() {
        return paymentcode;
    }

    public void setPaymentcode(int paymentcode) {
        this.paymentcode = paymentcode;
    }

    public int getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(int bookingcode) {
        this.bookingcode = bookingcode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
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
    
    
    ClassDb obj = new ClassDb();
    public String insert()
    {
        String res="";
        paymentcode = obj.getMaxCode("snackpayment", "paymentcode");
        String query="insert into snackpayment values("+paymentcode+","+
                bookingcode+",'"+cardholder+"','"+ccno+"','"+cvno+"','"+validupto+"', "+
                amount+")"; 
        res=obj.updateRecords(query)+"inserted record in snackpayment";
               
        return res;
    }
    public String getRecordsByBookingCode(int bcode)
    {
        String res="";
        String query="select * from snackpayment where bookingcode="+bcode;
        res=obj.getRecords(query);
        return res;
    }
    public boolean CheckRecordsExistByBookingCode(int bcode)
    {
        boolean check=false;
        String query = "Select * from snackpayment "+
                " where bookingcode="+bcode
                ;
        check=obj.checkRecordExists(query);
        return check;
        
    }
    
        
}
