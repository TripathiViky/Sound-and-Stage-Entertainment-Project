
package models;

import dao.ClassDb;



public class MovieModel {
    ClassDb obj = new ClassDb();
    int moviecode, status;
    String name,Genere,casts;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    public int getMoviecode() {
        return moviecode;
    }

    public void setMoviecode(int moviecode) {
        this.moviecode = moviecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String Genere) {
        this.Genere = Genere;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }
    
    public String insert()
    {
        String res ="";
        moviecode= obj.getMaxCode("movie", "moviecode");
        String query="insert into movie values("+
                moviecode+", '"+name+"', '"+Genere+"','"+casts+"', 1) ";
        res=obj.updateRecords(query)+" record/s inserted in movie table";
        return res;
    }
    public String getRecords()
    {
        
        String res="";
        String query="select * from movie";
        res=obj.getRecords(query);
        return res;
    }
    
    public String getCombo(String cmbName)
    {
        String res="";
        String query="select * from movie where status=1";
        res=obj.getCombo(query, "moviecode", "name", cmbName);
        return res;
    }
    
    public String closeMovieByMovieCode(int mcode)
    {
        String res="";
        String query="update movie set "+
                " status=0 "+
                " where moviecode="+mcode;
        res=obj.updateRecords(query)+" movie closed for moviecode="+mcode;
        
        return res;
    }
}
