
package models;

import java.util.Map;
import dao.ClassDb;


public class HallModel {
    
    int hallcode, theatercode;

    String hallname;
    
    
    ClassDb obj=new ClassDb();

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }
    
    
    
    public int getHallcode() {
        return hallcode;
    }

    public void setHallcode(int hallcode) {
        this.hallcode = hallcode;
    }

    public int getTheatercode() {
        return theatercode;
    }

    public void setTheatercode(int theatercode) {
        this.theatercode = theatercode;
    }
    
    public String insert()
    {
        String res=null;
        hallcode=obj.getMaxCode("hall", "hallcode");
        
        String query="insert into hall values("+
                hallcode+", "+theatercode+", '"+hallname+"') ";
        res=obj.updateRecords(query)+" record/s inserted in hall table";
        
        return res;
    }
    
    public String getRecords()
    {
        String query="select hall.hallcode, hall.hallname, hall.theatercode, "+
                " name "+
                " from hall "+
                " inner join "+
                " theater "+
                " on "+
                " hall.theatercode=theater.theatercode";
        
                
        String res=obj.getRecords(query);
        return(res);
    }
    
    public String getComboByTheaterCode(String cmbname, int tcode)
    {
        String res=null;
        String query="select * from hall "+
                " where theatercode="+tcode;
        res=obj.getCombo(query, "hallcode", "hallname", cmbname);
        return(res);
        
    }
    public String getRecordsWithEditAndDeleteButtonByTheaterCode(int tcode, String actionName)
    {
        String query="select * from hall where theatercode = "+tcode;
        String res=obj.getRecordsWithDeleteAndEditButton(query, "hallcode", actionName);
        return res;
    }
    public boolean checkRecordsExistsInSeatByHallCode(int hcode)
    {
        boolean check = false;
        String query="select * from seat where hallcode="+hcode;
        check=obj.checkRecordExists(query);
        
        return check;
    }
    public String deleteHallByHallCode(int hcode)
    {
        String res="";
        String query = "delete from hall where hallcode="+hcode;
        res=obj.updateRecords(query)+" Removed records by hall table";
        
        return res;
    }
    public Map <String, String> getOneRecordsByHallCode(int hcode)
    {
        Map<String, String> map=null;
        String query="select * from hall where hallcode="+hcode;
        map=obj.getOneRecordValue(query);
        
        return map;
    }
    public String  modifyHallNameByHallCode(int hcode)
    {
        String res="";
        String query = "update hall set "+
                        " hallname= '"+hallname+"'"+
                        " where hallcode="+hcode;
        res=obj.updateRecords(query)+" edit records in hall table";
        return res;
    }
}
