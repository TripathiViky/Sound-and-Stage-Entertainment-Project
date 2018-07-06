
package models;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import dao.ClassDb;


public class LoggerModel {

private String username;
private int usertype;
private String recorddate;
private String action;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(String recorddate) {
        this.recorddate = recorddate;
    }

   
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    ClassDb obj = new ClassDb();
    public String insert()
    {
        String res="";
        String query = "insert into logger "+
                        " values ('"+username+"',"+usertype+",'"+recorddate+"','"+action+"')";
        res= obj.updateRecords(query)+" record inserted into logger table";
        
        return res;
    }
    public String getRecords()
    {
        String res="";
        String query = "select * from logger";
        res = obj.getRecords(query);
        return res;
    }
    public String getRecordsByUserName(String uname)
    {
        String res="";
        String query = "select * from logger "
                + " where username = '"+uname+"' ";
        res = obj.getRecords(query);
        return res;
    }
    
    public String insertFromWebpage(HttpSession session,
            String actionName)
    {
        String res="";
        java.util.Map<String,String> map=(java.util.Map<String,String>)session.getAttribute("user");
        
        String username=map.get("USERNAME");
        int usertype=Integer.parseInt(map.get("USERTYPE").toString());
        java.sql.Date sysdate=new java.sql.Date(new java.util.Date().getTime());
        //DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String recorddate=sdf.format(sysdate);
        
        String query="insert into logger values("+
                " '"+username+"', "+usertype+", "+
                " '"+recorddate+"', '"+actionName+"') ";
        res=obj.updateRecords(query)+" inserted in logger table";
        
        return res;
    }
    
    public String deleteAllLogs()
    {
        String res="";
        String query="delete from logger";
        res=obj.updateRecords(query)+" all record/s removed from logger table";
        return res;
    }
}
