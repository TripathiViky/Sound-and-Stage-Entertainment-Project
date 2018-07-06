
package models;

import java.util.Map;
import dao.ClassDb;

public class TheaterModel {
    
    int theatercode;
    String name;
    String location;

    ClassDb obj=new ClassDb();

    public int getTheatercode() {
        return theatercode;
    }

    public void setTheatercode(int theatercode) {
        this.theatercode = theatercode;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    //first set all setr values except code
    public String insert()
    {
        String res=null;
        //fetch code by getmaxcode
        theatercode=obj.getMaxCode("theater", "theatercode");
        String dmlquery="insert into theater values("+
                theatercode+", '"+name+"', '"+location+"') ";
        res=obj.updateRecords(dmlquery)+" record/s inserted in theater table";
        return res;
    }
    
    public String getRecords()
    {
        String res=obj.getRecords("select * from theater");
        return(res);
    }
    
    public String getCombo(String cmbname)
    {
        String res="";
        String selectquery="select * from theater";
        String colcodename="theatercode";
        String colabelname="name";
        res=obj.getCombo(selectquery, colcodename, colabelname, cmbname);
        return res;
    }
    public String getRecordswithEditAndDeleteButton(String actionName)
    {
        String res="";
        String query="select * from theater ";
        res=obj.getRecordsWithDeleteAndEditButton(query, "theatercode", actionName);
        return res;
    }
    public String deleteByTheaterCode(int tcode)
    {
        String query="delete from theater where theatercode="+tcode;
        String res=obj.updateRecords(query)+" Records removed From Theater";
        return res;
        
    }
    
    public boolean checkRecordsExistsInHallByTheaterCode(int tcode)
    {
        String query = "select * from hall where theatercode = "+tcode;
        boolean check=obj.checkRecordExists(query);
        return check;
    }
    public String modifyRecordsByTheaterCode()
    {
        String res="";
        String query="update theater set " + 
                " name = '"+name+"',"+
                " location = '"+location+"' "+
                " where theatercode="+theatercode;
        res=obj.updateRecords(query)+" record/s modified in theater table";
        return res;
    }
    
    public Map<String, String> getOneRecordByTheaterCode(int tcode)
    {
        Map<String, String> map=null;
        String query="select * from theater "+
                " where theatercode="+tcode;
        map=obj.getOneRecordValue(query);
        return map;
    }
}
