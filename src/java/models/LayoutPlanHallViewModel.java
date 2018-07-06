
package models;

import dao.ClassDb;


public class LayoutPlanHallViewModel 
{
    ClassDb ob=new ClassDb();
    
    public String getGridByPlanAndHallForBooking(int hallcode, String plandate, double starttime, String chkname)
    {
        String res="";
        String query="SELECt * from layoutplanhallview "+
                " where hallcode="+hallcode+
        " and plandate='"+plandate+"' "+
                " and starttime="+starttime;
        
        boolean check=ob.checkRecordExists(query);
        if(check==false)
        {
            res="NO plan created for the hall!!!";
            return(res);
        }
        
        //query="select * from layoutplanhallview " +
        //"where hallcode="+hallcode +
        //" and groupplancode=(select max(groupplancode) from " +
        //" layoutplanhallview where hallcode="+hallcode+") ";
        
        res=ob.generateGridForSeatBooking(query, "uniquelayoutplancode",
                "seatname", "status", "bookingstatus", chkname);
        return res;
    }
    
    public int getSeatPriceByUniqueLayoutPlanCode(int ucode)
    {
        int res=0;
        String query="select * from layoutplanhallview "+
                " where uniquelayoutplancode="+ucode;
        Object oprice=ob.getOneColumnValue(query, "price");
        if(oprice!=null)
            res=Integer.parseInt(oprice.toString());
        
        return res;
    }
    
    public boolean checkPlanExistsOnDateAndStartTimeForAHall(int hallcode, 
            String plandate, double starttime)
    {
        boolean check=false;
        String query="select * from layoutplanhallview "+
                " where hallcode="+hallcode+
                " and plandate='"+plandate+"' "+
                " and starttime="+starttime;
        check=ob.checkRecordExists(query);
        return check;
    }
    
    public boolean checkPlanExistsOnDateAndMovie(int moviecode, String plandate)
    {
        boolean check=false;
        String query="select * from layoutplanhallview "+
                " where moviecode="+moviecode+
                " and plandate='"+plandate+"' ";
        check=ob.checkRecordExists(query);
        return check;
    }
    
    public  int getHallcodeByMovieAndPlandate(int moviecode, String plandate)
    {
        int res=0;
        String query="select * from layoutplanhallview "+
                " where moviecode="+moviecode+
                " and plandate='"+plandate+"' ";
                
        Object ores=ob.getOneColumnValue(query, "hallcode");
        if(ores!=null)
            res=Integer.parseInt(ores.toString());
        
        
        return res;
    }
    
    public String getComboMultiple(int moviecode, String plandate, String cmbName)
    {
        String res="";
        String[] colids={"hallcode", "plandate", "starttime"};
        String[] collabels={"name" , "hallname", "plandate", "starttime" };
        
        String query="select distinct hallcode, name, hallname, plandate, starttime " +
            "from " +
            "layoutplanhallview " +
            "where plandate='"+plandate+"'" +
            "and moviecode="+moviecode;
        res=ob.getComboMultiple(query, colids, collabels, cmbName);
        return res;
    }
    
    public String getRecordsByBookingCode(int bcode)
    {
        String res="";
        String query="SELECT * FROM TP.LAYOUTPLANHALLVIEW "+
            " where uniquelayoutplancode in("+
            " select uniquelayoutplancode from bookingseatdetail "+
            " where bookingcode="+bcode+")";
        res=ob.getRecords(query);
        return res;
    }
    public String getSeatNamebyBookingCode(int bcode)
    {
        String res="";
        String query="select seatname from layoutplanhallview " +
            " where uniquelayoutplancode in ("+
            " select uniquelayoutplancode from bookingseatdetail" +
            " where bookingcode="+bcode+")";
      res=ob.getRecordsWithoutHeading(query);
        return res;
    }
    
    public String getBookingDateByBookingCode(int bcode)
    {
        String res="";
        String query="select plandate from layoutplanhallview " +
            " where uniquelayoutplancode in ("+
            " select uniquelayoutplancode from bookingseatdetail" +
            " where bookingcode="+bcode+")";
        Object oplandate = ob.getOneColumnValue(query, "plandate");
        if(oplandate!=null)
            res=oplandate.toString();
        else
            res="";
        return res;
    }
    public double getStartTimebyBookingCode(int bcode)
    {
        double res=0.0;
        String query="select starttime from layoutplanhallview " +
            " where uniquelayoutplancode in ("+
            " select uniquelayoutplancode from bookingseatdetail" +
            " where bookingcode="+bcode+")";
        Object ost = ob.getOneColumnValue(query, "starttime");
        if(ost!=null)
            res = Double.parseDouble(ost.toString());
        else
            res=0;
        return res;
        
    }
    
    public String getHallNameByBookingCode(int bcode)
    {
        String res="";
        String query="select hallname from layoutplanhallview " +
            " where uniquelayoutplancode in ("+
            " select uniquelayoutplancode from bookingseatdetail" +
            " where bookingcode="+bcode+")";
        Object oplandate = ob.getOneColumnValue(query, "hallname");
        if(oplandate!=null)
            res=oplandate.toString();
        else
            res="";
        
        return res;
    }
    public String getTheaterNameByBookingCode(int bcode)
    {
        String res="";
        String query="select name from layoutplanhallview " +
            " where uniquelayoutplancode in ("+
            " select uniquelayoutplancode from bookingseatdetail" +
            " where bookingcode="+bcode+")";
        Object oplandate = ob.getOneColumnValue(query, "name");
        if(oplandate!=null)
            res=oplandate.toString();
        else
            res="";
        return res;
    }
    
}
