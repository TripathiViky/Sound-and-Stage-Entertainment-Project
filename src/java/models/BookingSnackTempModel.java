
package models;

import java.util.Map;
import dao.ClassDb;


public class BookingSnackTempModel {
    int tempid,bookingcode,snackcode,quantity,price,totalprice;
    ClassDb obj = new ClassDb();
    public int getTempid() {
        return tempid;
    }

    public void setTempid(int tempid) {
        this.tempid = tempid;
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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public String insert()
    {
        String res="";
        tempid = obj.getMaxCode("booksnacktemp", "tempid");
        String query= "insert into booksnacktemp values("+tempid+","+bookingcode+","+snackcode+""
                +","+quantity+","+price+","+totalprice+" )";
        res=obj.updateRecords(query)+"Record inserted";
        
        return res;
    }
    public String getRecordsByBookingCode(int bcode)
    {
        String res="";
        String query="select booksnacktemp.*, name  "+
                " from booksnacktemp, snack "+
                " where booksnacktemp.snackcode=snack.snackcode "+
                " and bookingcode="+bcode;
        res=obj.getRecords(query);
        return res;
    }
    
    public int getTotalPriceByBookingCode(int bcode)
    {
        int res=0;
        String query="select sum(totalprice) \"sumamount\" "+
                " from booksnacktemp "+
                " where bookingcode="+bcode;
        Object o=obj.getOneColumnValue(query, "sumamount");
        if(o!=null)
            res=Integer.parseInt(o.toString());
        
        return res;
    }
    public String getRecordsWithDeleteAndEditButton(String actionName)
    {
        String query="select * from booksnacktemp";
        String res=obj.getRecordsWithDeleteAndEditButton(query, "tempid", actionName);
        return res;
    }
    public String getRecordsWithDeleteAndEditButtonByBookingcode(int bcode ,String actionName)
    {
        String query="select booksnacktemp.*, name  "+
                " from booksnacktemp, snack "+
                " where booksnacktemp.snackcode=snack.snackcode "+
                " and bookingcode="+bcode;
        String res=obj.getRecordsWithDeleteAndEditButton(query, "tempid", actionName);
        return res;
    }
    public String deleteRecordsByTempId(int tid)
    {
        String res="";
        String query="delete from booksnacktemp where tempid="+tid;
        res=obj.updateRecords(query)+" Records removed from booksnacktemp table";
        return res;
    }
    public Map <String, String> getOneRecordsByTempId(int tid)
    {
        Map<String, String> map=null;
        String query="select * from booksnacktemp where tempid="+tid;
        System.out.println("bookingsnacktempmodel: getOneRecordsByTempId: "+query);
        map=obj.getOneRecordValue(query);
        return map;
    }
    
    public String getComboWithOneItemSelected(int bcode, int selectedtempid, String cmbName)
    {
        String res="";
        String query="select * from   "+
                      " from booksnacktemp, snack "+
                      " where booksnacktemp.snackcode=snack.snackcode "+
                      " and bookingcode="+bcode;
        String[] collabels={"name", "price"};
        String colidName="tempid";
        res=obj.getComboWithOneItemSelected(query, collabels,
                colidName, selectedtempid, cmbName);
        return res;
    }
    public String  modifyQuantityByTempId(int tcode)
    {
        String res="";
        String query = "update booksnacktemp set "+
                        " quantity= "+quantity +", "+
                        " totalprice = "+ totalprice +
                        " where tempid="+tcode;
        res=obj.updateRecords(query)+" edit records in snacktemp table";
        return res;
    }
    
  }
