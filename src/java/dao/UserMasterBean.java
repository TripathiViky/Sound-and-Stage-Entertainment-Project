
package dao;


public class UserMasterBean {
    private String username, password;
    private int usertype;
    private String name, phone;

    ClassDb obj=new ClassDb();
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    //must set value of username, and password, and usertype
    //before calling this method
    public boolean Authenticate()
    {
        boolean check=false;
        String query="select * from usermaster "+
                " where username='"+username+"' "+
                " and password='"+password+"' "+
                " and usertype="+usertype;
        check=obj.checkRecordExists(query);
        return check;
    }
    public String insert()
    {
     String res="";
     String query="select * from usermaster "+
             " where username='"+username+"' ";
     boolean check=obj.checkRecordExists(query);
     if(check==true)
     {
         res="Username already exists!!!";
     }
     else
     {
      query="insert into usermaster values('"+username+"',"
             + "'"+password+"',"+usertype+",'"+name+"','"+phone+"')";
     res=obj.updateRecords(query)+"record inserted";
         
     }
     return res;
    }
    
    public String getRecords()
    {
        String res="";
        String query="select username,name,usertype from usermaster";
        res=obj.getRecords(query);
        return res;
        
    }
    
    
    
    public java.util.Map<String,String> getOneRecordValue()
    {
        java.util.Map<String,String> map=null;
        String query="select * from usermaster "+
                " where username='"+username+"' "+
                " and password='"+password+"' "+
                " and usertype="+usertype;

                map=obj.getOneRecordValue(query);
                
         return(map);
    }
    
    public String changePasswordByUserName(String user, String newpwd)
    {
        String res="";
        String query="update usermaster set "+
                " password='"+newpwd+"' "+
                " where username='"+user+"' ";
        res=obj.updateRecords(query)+" password changed successfully!";
        return res;
    }
    
    public String getComboByUserType(int usertype, String cmbName)
    {
        String res="";
        String query="select * from usermaster "+
                "where usertype="+usertype;
        res=obj.getCombo(query, "username", "username", cmbName);
        return res;
    }
    
}
