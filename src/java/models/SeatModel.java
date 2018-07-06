
package models;

import java.util.HashMap;
import java.util.Map;
import dao.ClassDb;


public class SeatModel {
    
    int seatcode, hallcode;
    String seatname;
    int price, status;

    ClassDb obj=new ClassDb();
    
    public int getSeatcode() {
        return seatcode;
    }

    public void setSeatcode(int seatcode) {
        this.seatcode = seatcode;
    }

    public int getHallcode() {
        return hallcode;
    }

    public void setHallcode(int hallcode) {
        this.hallcode = hallcode;
    }

    public String getSeatname() {
        return seatname;
    }

    public void setSeatname(String seatname) {
        this.seatname = seatname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String insert()
    {
        String res=null;
        seatcode=obj.getMaxCode("seat", "seatcode");
        
        String query="insert into seat values("+
                seatcode+", "+hallcode+", '"+seatname+"', "+
                price+", 1) ";
        res=obj.updateRecords(query)+" record/s inserted in seat table";
        return res;
    }
    
    public String getRecordsByHallCode(int hcode)
    {
        String query="select * from seat "+
                " where hallcode="+hcode+
                " and status=1";
        String res=obj.getRecords(query);
        return res;
    }

    public String getRecordsByHallCodeWithDeleteAndEditButton(int hcode, String actionName)
    {
        String query="select * from seat "+
                " where hallcode="+hcode+
                " and status=1 "+
                " order by seatcode";
        String res=obj.getRecordsWithDeleteAndEditButton(query, "seatcode", actionName);//obj.getRecords(query);
        return res;
    }
    
    public String showSeatsByHallCode(int hcode, String checkname)
    {
        String res=null;
        String query="select * from seat "+
                " where hallcode="+hcode;
        res=obj.generateGridForSeat(query, "seatcode", "seatname", "status", checkname);
        return res;
    }
    
    public String deleteRecordBySeatCode(int scode)
    {
        String res="";
        String query="delete from seat "+
                " where seatcode="+scode;
        res=obj.updateRecords(query)+" record/s removed from seat table";
        return res;
    }
    
    public String modifySeatNameAndPriceBySeatCode()
    {
        String res="";
        String query="update seat set "+
                " seatname='"+seatname+"', "+
                " price="+price+
                " where seatcode="+seatcode;
        res=obj.updateRecords(query)+" record/s editied in seat table";
        return res;
    }
    
    public Map<String, String> getOneRecordBySeatCode(int scode)
    {
        Map<String, String> map=null;
        String query="select * from seat "+
                " where seatcode="+scode;
        map=obj.getOneRecordValue(query);
        return map;
    }
    
}
