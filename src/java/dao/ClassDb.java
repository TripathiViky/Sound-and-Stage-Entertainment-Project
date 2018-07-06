
package dao;

import static java.lang.System.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import models.BookingSnackModel;

public class ClassDb 
{
    private String driver="org.apache.derby.jdbc.ClientDriver";
    private String url="jdbc:derby://localhost:1527/SSEDAO";
    private String user="test", password="test123";
    Connection con=null;
    String ds="jdbc/SSEDAODatasource";
    
    public void openConnection()
    {
        try
        {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
            Context ctx=new InitialContext();
            Object o=ctx.lookup(ds);
            DataSource ds=(DataSource)o;
            con=ds.getConnection();
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
    
    public void closeConnection()
    {
        try
        {
            if(con!=null)
            {
                con.close();
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
    
    public boolean checkRecordExists(String selectquery)
    {
        boolean check=false;
        
        try
        {
            openConnection();
            ResultSet rs=con.createStatement()
                    .executeQuery(selectquery);
            if(rs.next()==true)
            {
                check=true;
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public int getMaxCode(String tablename, String colcodename)
    {
        int res=0;
        try
        {
            openConnection();
            String query="select max("+colcodename+")+1 \"maxcode\" "+
                    " from "+tablename;
            out.println(query);
            ResultSet rs=con.createStatement()
                    .executeQuery(query);
            if(rs.next())
            {
                Object o=rs.getObject("maxcode");
                if(o!=null)
                {
                    res=Integer.parseInt(o.toString());
                }
                else
                    res=1;
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        finally
        {
            closeConnection();
        }
        return res;
    }
    
   public int updateRecords(String dmlquery)
   {
       int res=0;
       try
       {
           openConnection();
           res=con.createStatement().executeUpdate(dmlquery);
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getRecords(String selectquery)
   {
       String res=null;
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           ResultSetMetaData rsmd=rs.getMetaData();
           res="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1'>";
           res+="<tr>";
           for(int i=1;i<=rsmd.getColumnCount();i++)
           {
               res+="<th>";
               res+=rsmd.getColumnName(i);
               res+="</th>";
           }
           res+="</tr>";
           boolean check=false;
           while(rs.next())
           {
               check=true;
               res+="<tr>";
               for(int i=1;i<=rsmd.getColumnCount();i++)
                   res+="<td>"+rs.getString(i)+"</td>";
               
               res+="</tr>";
           }
           res+="</table>";
           
           if(check==false) res=null;
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getCombo(String selectquery, String colcodename, String colabelname, String cmbname)
   {
       String res="";
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           res="<select name='"+cmbname+"'>" ;
           while(rs.next())
           {
               String code=rs.getString(colcodename); //rs.getInt(colcodename);
               String label="";
               if(!colcodename.equals(colabelname)) 
                   label=rs.getString(colabelname);
               else
                   label=code;
               res+="<option value='"+code+"'>"+label+"</option>";
           }
           res+="</select>";
           
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String generateGridForSeat(String selectquery, String seatidcolname, 
           String seatnameColumn,
           String statuscolumnName, String checkboxName)
   {
       String res="";
       try
       {
           //out.println(selectquery);
           
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           int i=1;
           res="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1' align='center' table-layout:'auto' >";
           while(rs.next())
           {
               String seatid=rs.getString(seatidcolname);
               String seatname=rs.getString(seatnameColumn);
               String status=rs.getString(statuscolumnName);
               String statuscheck=null;
               if(status.equals("1"))
                   statuscheck="checked";
               else
                   statuscheck="";
               if(i==1)
                   res+="<tr>";
               
               res+="<td>"+seatname+" "+"<input type='checkbox' name='"+checkboxName+
                       "' value='"+seatid+"' "+statuscheck+"/></td>";
               if(i==2)
               {
                   i=1;
                   res+="</tr>";
               }
               else
                   i++;
           }
           res+="</table>";
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String generateGridForSeatBooking(String selectquery, String seatidcolname, 
           String seatnameColumn,
           String statuscolumnName, String bookingstatusColumnName,
           String checkboxName)
   {
       String res="";
       try
       {
           //out.println(selectquery);
           
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           int i=1;
           res="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1'>";
           while(rs.next())
           {
               String seatid=rs.getString(seatidcolname);
               String seatname=rs.getString(seatnameColumn);
               String status=rs.getString(statuscolumnName);
               int bookingstatus=rs.getInt(bookingstatusColumnName);
               
               if(i==1)
                   res+="<tr>";
               
               if(bookingstatus==0)
                    res+="<td>"+seatname+" "+"<input type='checkbox' name='"+checkboxName+
                       "' value='"+seatid+"' /></td>";
               else if(bookingstatus==1)
                   res+="<td>"+seatname+" Booked</td>";
                   
               
               if(i==7)
               {
                   i=1;
                   res+="</tr>";
               }
               else
                   i++;
           }
           res+="</table>";
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public Object getOneColumnValue(String selectquery, String colname)
   {
       Object res=null;
       try
       {
           openConnection();
           ResultSet rs=con.createStatement()
                   .executeQuery(selectquery);
           if(rs.next())
           {
               res=rs.getObject(colname);
           }
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getComboMultiple(String selectquery, String[] colids, String[] collabels, String cmbName)
   {
       String res="";
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           
            res+="<select name='"+cmbName+"'>";
           while(rs.next())
           {
               String colids1="";
               for(int i=0;i<colids.length;i++)
               {
                   colids1+=rs.getString(colids[i]);
                   if(i<colids.length-1) colids1+=",";
               }
               
               String collabels1="";
               for(int i=0;i<collabels.length;i++)
               {
                   collabels1+=collabels[i]+"="+rs.getString(collabels[i]);
                   if(i<collabels.length-1)
                       collabels1+=",";
               }
                   
              
               res+="<option value='"+colids1+"'>"+collabels1+"</option>";
               
           }
           res+="</select>";
           
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getComboWithOneItemSelected(String selectQuery, String[] colLabels, 
           String colidName, int selectedColId, String cmbName)
   {
       String res="";
       try
       {
           openConnection();
           res+="<select name='"+cmbName+"'>";
           ResultSet rs=con.createStatement().executeQuery(selectQuery);
           
           String str="", str1="";
           while(rs.next())
           {
               int colidvalue=rs.getInt(colidName);
               for(int i=0;i<colLabels.length;i++)
               {
                   str+=colLabels[i]+"="+rs.getString(colLabels[i]);
                   if(i<colLabels.length)
                       str+=",";
               }
               if(colidvalue==selectedColId && !str.equals(str1))
                res+="<option value='"+colidvalue+"' selected='true'>"+str+"</option>";
               else
                   res+="<option value='"+colidvalue+"'>"+str+"</option>";
               str1=str;
               str="";
               
           }
           res+="</select>";
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getRecordsWithoutHeading(String selectquery)
   {
       String res=null;
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           ResultSetMetaData rsmd=rs.getMetaData();
           res="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1'>";
           /*
           res+="<tr>";
           for(int i=1;i<=rsmd.getColumnCount();i++)
           {
               res+="<th>";
               res+=rsmd.getColumnName(i);
               res+="</th>";
           }
           res+="</tr>";
            */
           boolean check=false;
           while(rs.next())
           {
               check=true;
               res+="<tr>";
               for(int i=1;i<=rsmd.getColumnCount();i++)
                   res+="<td>"+rs.getString(i)+"</td>";
               
               res+="</tr>";
           }
           res+="</table>";
           
           if(check==false) res=null;
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getRecordsWithCheckBox(String selectquery, String chkboxName, String chkboxIdColumnName)
   {
       String res="";
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           ResultSetMetaData rsmd=rs.getMetaData();
           int colcount=rsmd.getColumnCount();
           res+="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1'>";
           res+="<tr>";
           res+="<td>select checkbox</td>";
           for(int i=1;i<=colcount;i++)
           {
               res+="<td>"+rsmd.getColumnName(i)+"</td>";
           }
           res+="</tr>";
           
           while(rs.next())
           {
               res+="<tr>";
               String colid=rs.getString(chkboxIdColumnName);
               res+="<td><input type='checkbox' name='"+chkboxName+"' value='"+colid+"'/></td>";
               for(int i=1;i<=colcount;i++)
                   res+="<td>"+rs.getString(i)+"</td>";
               res+="</tr>";
           }
           res+="</table>";
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   public String transferSnackRecordsFromTempToOriginalTableByBookingCode(int bcode)
   {
       String res="";
       try
       {
           openConnection();
           String query="select * from booksnacktemp "+
                   " where bookingcode="+bcode;
           
           ResultSet rs=con.createStatement().executeQuery(query);
           
           BookingSnackModel obsnack=new BookingSnackModel();
           
           while(rs.next())
           {
               int tempid=rs.getInt("tempid");
               int bookingcode=rs.getInt("bookingcode");
               int snackcode=rs.getInt("snackcode");
               int quantity=rs.getInt("quantity");
               int price=rs.getInt("price");
               int totalprice=rs.getInt("totalprice");
           
               obsnack.setBookingcode(bookingcode);
               obsnack.setSnackcode(snackcode);
               obsnack.setQuantity(quantity);
               obsnack.setPrice(price);
               obsnack.setTotalprice(totalprice);
               String res1=obsnack.insert();
               out.println(res1);
           }
           rs.close();
           
           query="delete from booksnacktemp "+
                   " where bookingcode="+bcode;
           String res2=updateRecords(query)+" record/s removed in booksnacktemp table";
           out.println(res2);
           
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public String getRecordsWithDeleteAndEditButton(String selectquery,
           String btnIdColumnName, String actionName)
   {
       String res=null;
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectquery);
           ResultSetMetaData rsmd=rs.getMetaData();
           res="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1'>";
           res+="<tr>";
           for(int i=1;i<=rsmd.getColumnCount();i++)
           {
               res+="<th>";
               res+=rsmd.getColumnName(i);
               res+="</th>";
           }
           res+="</tr>";
           boolean check=false;
           while(rs.next())
           {
               check=true;
               res+="<tr>";
               for(int i=1;i<=rsmd.getColumnCount();i++)
                   res+="<td>"+rs.getString(i)+"</td>";
               
               int btncolidvalue=rs.getInt(btnIdColumnName);
               res+="<form name='formdelete"+btncolidvalue+"' method='post' action='"+actionName+"'>";
               res+="<input type='hidden' name='operation' value='delete'/>";
               res+="<input type='hidden' name='id' value='"+btncolidvalue+"'/>";
               res+="<td><input type='submit' name='btndelete' value='Delete'/></td>";
               res+="</form>";
               
               res+="<form name='formedit"+btncolidvalue+"' method='post' action='"+actionName+"'>";
               res+="<input type='hidden' name='operation' value='edit'/>";
               res+="<input type='hidden' name='id' value='"+btncolidvalue+"'/>";
               res+="<td><input type='submit' name='btnedit' value='Edit'/></td>";
               res+="</form>";
               res+="</tr>";
           }
           res+="</table>";
           
           if(check==false) res=null;
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return res;
   }
   
   public Map<String, String> getOneRecordValue(String selectQuery)
   {
       Map<String, String> map=new HashMap<String,String>();
       try
       {
           openConnection();
           ResultSet rs=con.createStatement().executeQuery(selectQuery);
           ResultSetMetaData rsmd=rs.getMetaData();
           if(rs.next()==true)
           {
               for(int i=1;i<=rsmd.getColumnCount();i++)
               {
                   String key=rsmd.getColumnName(i);
                   String value=rs.getString(i);
                   map.put(key,value);
                   //out.println("key="+key+", value="+value);
               }
           }
       }
       catch(Exception e)
       {
           out.println(e);
       }
       finally
       {
           closeConnection();
       }
       return map;
   }
}
