
package models;

import dao.ClassDb;


public class LayoutPlanModel 
{
    
   int uniquelayoutplancode, groupplancode, seatcode, status, bookingstatus;
   String plandate;
   double starttime, endtime;
   int moviecode;
   

    ClassDb obj=new ClassDb();

    public int getMoviecode() {
        return moviecode;
    }

    public void setMoviecode(int moviecode) {
        this.moviecode = moviecode;
    }

    
    public String getPlandate() {
        return plandate;
    }

    public void setPlandate(String plandate) {
        this.plandate = plandate;
    }

    public double getStarttime() {
        return starttime;
    }

    public void setStarttime(double starttime) {
        this.starttime = starttime;
    }

    public double getEndtime() {
        return endtime;
    }

    public void setEndtime(double endtime) {
        this.endtime = endtime;
    }

    
    
    public int getBookingstatus() {
        return bookingstatus;
    }

    public void setBookingstatus(int bookingstatus) {
        this.bookingstatus = bookingstatus;
    }
    
    
    
    public int getUniquelayoutplancode() {
        return uniquelayoutplancode;
    }

    public void setUniquelayoutplancode(int uniquelayoutplancode) {
        this.uniquelayoutplancode = uniquelayoutplancode;
    }

    public int getGroupplancode() {
        return groupplancode;
    }

    public void setGroupplancode(int groupplancode) {
        this.groupplancode = groupplancode;
    }

    public int getSeatcode() {
        return seatcode;
    }

    public void setSeatcode(int seatcode) {
        this.seatcode = seatcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String insert(int hallcode, int[] validseatcode)
    {
        String res="";
        groupplancode=obj.getMaxCode("layoutplan", "groupplancode");
        System.out.println("groupplancode="+groupplancode);
        for(int i=0;i<validseatcode.length;i++)
        {
            uniquelayoutplancode=obj.getMaxCode("layoutplan", "uniquelayoutplancode");
            String query="insert into layoutplan values("+
                    uniquelayoutplancode+", "+groupplancode+", "+
                    validseatcode[i]+", 1, 0, '"+plandate+"', "+
                    starttime+", "+endtime+", "+moviecode+") ";
            System.out.println(query);
            res+="<br/>"+obj.updateRecords(query)+" record/s inserted in layoutplan table";
        }
        return res;
    }
    
    public String getLastPlanByHallCode(int hcode)
    {
        String query="select * from layoutplanhallview "+
                " where hallcode="+hcode+
                " and groupplancode=(select max(groupplancode) "+
                " from layoutplanhallview "+
                " where hallcode="+hcode+") ";
        System.out.println(query);
        String res=obj.getRecords(query);
        return res;
    }
    
    public String updateBookingStatusByUniqueLayoutPlanCode(int ucode, int bookingstatus)
    {
        String res="";
        String query="update layoutplan set "+
                " bookingstatus="+bookingstatus+
                " where uniquelayoutplancode="+ucode;
        res=obj.updateRecords(query)+" bookingstatus updated to "+bookingstatus+" for uniquecode="+ucode;
        
        return res;
    }
   
   
    
}
