
package models;

import dao.ClassDb;


public class BookingSnackModel {

    int bookingsnackcode,bookingcode,snackcode,quantity,price,totalprice;

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    
    public int getBookingsnackcode() {
        return bookingsnackcode;
    }

    public void setBookingsnackcode(int bookingsnackcode) {
        this.bookingsnackcode = bookingsnackcode;
    }

    public int getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(int bookingcode) {
        this.bookingcode = bookingcode;
    }

    public int getSnackcode() {
        return snackcode;
    }

    public void setSnackcode(int snackcode) {
        this.snackcode = snackcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    ClassDb obj=new ClassDb();
    
    public String insert()
    {
        String res="";
        bookingsnackcode = obj.getMaxCode("bookingsnack", "bookingsnackcode");
        String query="insert into bookingsnack values("+bookingsnackcode+","+
                bookingcode+","+snackcode+","+quantity+","+price+", "+
                totalprice+")";
        res=obj.updateRecords(query)+"record inserted ";
        return res;
        
    }
    public String getRecordsByBookingCode(int bcode)
    {
         String res="";
         String query = "select * from bookingsnack where bookingcode="+bcode;
         res=obj.getRecords(query);
         return res;
    }
}
