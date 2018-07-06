
package models;

import dao.ClassDb;


public class BookingSeatDetailModel {
    int bookingseatcode, bookingcode, uniquelayoutplancode, price;

    public int getBookingseatcode() {
        return bookingseatcode;
    }

    public void setBookingseatcode(int bookingseatcode) {
        this.bookingseatcode = bookingseatcode;
    }

    public int getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(int bookingcode) {
        this.bookingcode = bookingcode;
    }

    public int getUniquelayoutplancode() {
        return uniquelayoutplancode;
    }

    public void setUniquelayoutplancode(int uniquelayoutplancode) {
        this.uniquelayoutplancode = uniquelayoutplancode;
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
        bookingseatcode=obj.getMaxCode("bookingseatdetail", "bookingseatcode");
        String query="insert into bookingseatdetail values("+
                bookingseatcode+", "+bookingcode+", "+
                uniquelayoutplancode+", "+price+") ";
        res=obj.updateRecords(query)+" record/s inserted in bookingseatdetail table";
        
                
        return res;
    }
    
    public String getRecordsByBookingCode(int bcode)
    {
        String res="";
        String query="select * from bookingseatdetail "+
                " where bookingcode="+bcode;
        res=obj.getRecords(query);
        return res;
    }
    
    public int getTotalPriceForBookingCode(int bcode)
    {
        int res=0;
        String query="select sum(price) \"sumprice\" "+
                " from bookingseatdetail "+
                " where bookingcode="+bcode;
        System.out.println("BookingSeatDetailModel: "+query);
        
        Object oprice=obj.getOneColumnValue(query, "sumprice");
        if(oprice!=null)
            res=Integer.parseInt(oprice.toString());
        
        return res;
    }
    //1.
    public String updateLayoutPlanBookingStatusCancellationByBookingCode(int bcode)
    {
        String res="";
        String query="update layoutplan set "+
                " bookingstatus=0 "+
                " where uniquelayoutplancode in ("+
                " select uniquelayoutplancode from bookingseatdetail "+
                " where bookingcode="+bcode+") ";
        res=obj.updateRecords(query)+" bookingstatus set to zero in layoutplan table through ref of bookingseatdetail ";
        
        return res;
    }
    
    //2.
    public String deleteBookingDetailsByBookingCode(int bcode)
    {
        String res="";
        String query="delete from bookingseatdetail "+
                " where bookingcode="+bcode;
        res=obj.updateRecords(query)+" record/s removed in bookingseatdetail table by bookingcode="+bcode;
        
        return res;
    }
    
}
