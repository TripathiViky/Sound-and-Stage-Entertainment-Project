
package models;

import java.util.Map;
import dao.ClassDb;


public class SnackModel     
    {
    ClassDb obj = new ClassDb();
    int snackcode;
    String name;
    int price;

    public int getSnackcode() {
        return snackcode;
    }

    public void setSnackcode(int snackcode) {
        this.snackcode = snackcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
        
    public String insert()
        {
            String res="";
            snackcode= obj.getMaxCode("snack", "snackcode");
            String query = "insert into snack values("+snackcode+",'"+name+"',"+price+")";
            res=obj.updateRecords(query)+"record insert in snack table ";
            
            return res;
        
        }
        public String getRecords()
            {
            String res="";
            String query="select * from snack";
            res=obj.getRecords(query);
            return res;
    
            }
        
        public String getCombo(String cmbName)
        {
            String res="";
            String query="select * from snack";
            res=obj.getComboMultiple(query, new String[]{"snackcode"},
                    new String[]{"name", "price"}, cmbName);
            return res;
        }
        public int getPriceBySnackCode(int scode)
        {
            int res=0;
            String query="select * from snack "+
                    " where snackcode="+scode;
            Object oprice=obj.getOneColumnValue(query, "price");
            if(oprice!=null)
                res=Integer.parseInt(oprice.toString());
            else
                res=0;
            
            return res;
        }
        public String getRecordsWithDeleteAndEditButton(String actionName)
        {
            String res="";
            String query = "Select * from snack ";
            res=obj.getRecordsWithDeleteAndEditButton(query, "snackcode", actionName);
            return res;
        }
        public String deleteRecordsBySnackCode(int scode)
        {
            String res="";
            String query="delete from snack where snackcode="+scode;
            res=obj.updateRecords(query)+" Removed records from snack table";
            return res;
        }
        public Map<String, String> getOneRecordsBySnackCode(int scode)
        {
            Map<String, String> map=null;
            String query="select * from snack where snackcode="+scode;
            map=obj.getOneRecordValue(query);
            return map;
        }
        public String modifyNameAndPriceBySnackCode()
        {
            String res="";
        String query = "update snack set "+
                        " name= '"+name+"', "+
                        " price = "+price+
                        " where snackcode = "+snackcode;
        res=obj.updateRecords(query)+" edit records in snack table";
        return res;
        }
        public boolean checkExistsRecordsInBookingSnackBySnackCode(int scode)
        {
            boolean check= false;
            String query="select * from bookingsnack where snackcode=  "+ scode;
            check=obj.checkRecordExists(query);
            return check;
        }
    }
