
package models;

import dao.ClassDb;


public class BookingSeatModel {
    int bookingcode;
    String custname,contactno,idprooftype,idproofno;
    int paystatus;
    ClassDb obj= new ClassDb();

    public int getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(int bookingcode) {
        this.bookingcode = bookingcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getIdprooftype() {
        return idprooftype;
    }

    public void setIdprooftype(String idprooftype) {
        this.idprooftype = idprooftype;
    }

    public String getIdproofno() {
        return idproofno;
    }

    public void setIdproofno(String idproofno) {
        this.idproofno = idproofno;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }
    
    public String insert()
    {
       String res="";
       bookingcode = obj.getMaxCode("bookingseat", "bookingcode");
       String query="insert into bookingseat values("+bookingcode+",'"+custname+"'"
               + ",'"+contactno+"','"+idprooftype+"','"+idproofno+"',0)";
       res=obj.updateRecords(query)+"1 Record inserted";
       
       return res;
    }
    public String getRecord()
    {
        String res="";
        String query="Select * from bookingseat";
        res=obj.getRecords(query);
        return res;
    }
    
    public String updatePayStatusByBookingCode(int bcode)
    {
        String res="";
        String query="update bookingseat set "+
                " paystatus=1 "+
                " where bookingcode="+bcode;
        res=obj.updateRecords(query)+" paystatus updated in bookingseat table";
        
        return res;
    }
    
    public boolean checkPaidOrNotByBookingCode(int bcode)
    {
        boolean check=false;
        String query="select * from bookingseat "+
                " where bookingcode="+bcode+
                " and paystatus=1";
        check=obj.checkRecordExists(query);
        return check;
    }
    
    public String deleteBookingByBookingCode(int bcode)
    {
        String res="";
        String query="delete from bookingseat "+
                " where bookingcode="+bcode;
        res=obj.updateRecords(query)+" removed from bookingseat table by bookingcode="+bcode;
        
        return res;
    }
    
    public String getUnpaidBookingRecords(String chkName, String bookingdate, double showtime)
    {
        String res="";
        String query="select * from bookingseat " +
        " where bookingcode in (" +
        " select distinct bookingcode " +
        " from bookingseatdetail, layoutplan " +
        " where bookingseatdetail.uniquelayoutplancode=layoutplan.uniquelayoutplancode " +
        " and layoutplan.PLANDATE='"+bookingdate+"' "
                + " and layoutplan.STARTTIME="+showtime +
        " ) " +
        " and paystatus=0";
        res=obj.getRecordsWithCheckBox(query, chkName, "bookingcode");
        return res;
    }
    
    public boolean checkRecordExistsInLayoutPlanBySeatCode(int scode)
    {
        boolean check=false;
        String query="select * from layoutplan "+
                " where seatcode="+scode;
        check=obj.checkRecordExists(query);
        return check;
    }
}
