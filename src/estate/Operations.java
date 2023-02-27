/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estate;

import assets.User;
import assets.Advert;
import assets.RealEstate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammed Ali
 */
public class Operations {
    
    private ResultSet rs=null;
    private static Connector db = DatabaseInstance.getDb();
    
    
    //Return All Users in arraylist
    public ArrayList<User> getUserList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String query= "SELECT * FROM kullanici";
            db.preState=db.con.prepareStatement(query);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                list.add(new User(rs.getString("kullaniciadi"),rs.getString("isim"),rs.getString("soyisim"),rs.getString("telefonno"),rs.getInt("cuzdan")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
        }
        return list;
    }
    
    //Return All Estates in arraylist
    public ArrayList<RealEstate> getEstateList() {
        ArrayList<RealEstate> list = new ArrayList<>();
        try {
            String query= "SELECT * FROM tasinmaz";
            db.preState=db.con.prepareStatement(query);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                list.add(new RealEstate(rs.getInt("tid"),rs.getInt("tur"),rs.getInt("fiyat"),rs.getInt("metrekare"),rs.getString("adres")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
        }
        return list;
    }
    
    //Return All Adverts in arraylist
    public ArrayList<Advert> getAdvertList() {
        ArrayList<Advert> list = new ArrayList<>();
        try {
            String query="SELECT * FROM tüm_ilan_listesi";
            db.preState=db.con.prepareStatement(query);
         
            rs=db.preState.executeQuery();
            while(rs.next()){
                list.add(new Advert(rs.getInt("tid"),rs.getString("baslik"),rs.getDate("tarih")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
        }
        return list;
    }
    
    // Delete user from the database
    public boolean deleteUser(String userName){
        try {
           String query = "DELETE FROM kullanici WHERE kullaniciadi=?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, userName);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Delete estate from the database
    public boolean deleteEstate(int id){
        try {
           String query = "DELETE FROM tasinmaz WHERE tid=?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, id);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Delete advert from the database
    public boolean deleteAdvert(int id){
        try {
           String query = "DELETE FROM ilan WHERE  tid=?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, id);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Update user in database with given parameters
    public boolean updateUser(String userName, String firstName, String lastName, String tel, int salary){
        try {
            String query = "UPDATE kullanici SET isim = ?, soyisim = ?, telefonno= ?, cuzdan = ? WHERE kullaniciadi = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, firstName);
            db.preState.setString(2, lastName);
            db.preState.setString(3, tel);
            db.preState.setInt(4, salary);
            db.preState.setString(5, userName);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Update advert in database with given parameters
    public boolean updateAdvert(int estateID, String description, int oldestateID){
        try {
            String query = "UPDATE ilan SET tid = ?, baslik = ? WHERE tid = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, estateID);
            db.preState.setString(2, description);
            db.preState.setInt(3, oldestateID);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Update estate in database with given parameters
    public boolean updateEstate(int estateID, int type, int price, int area, String address){
        try {
            String query = "UPDATE tasinmaz SET tur = ?, fiyat = ?, metrekare = ?, adres = ? WHERE tid = ?";
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, type);
            db.preState.setInt(2, price);
            db.preState.setInt(3, area);
            db.preState.setString(4, address);
            db.preState.setInt(5, estateID);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // Insert user to database with given parameters
    public boolean addUser(String userName, String firstName, String lastName, String tel, int salary){
        try {
            String query = "INSERT INTO kullanici VALUES(?,?,?,?,?)";
            db.preState = db.con.prepareStatement(query);
            db.preState.setString(1, firstName);
            db.preState.setString(2, lastName);
            db.preState.setString(3, tel);
            db.preState.setInt(4, salary);
            db.preState.setString(5, userName);
            
            return db.preState.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    // Add advert in database with given parameters and returns the advert date (current date)
    public Date addAdvert(String userName, int estateID, String title){
        Date date= new Date();
        try {
            String query="SELECT ilan_ver(?,?,?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, userName);
            db.preState.setInt(2, estateID);
            db.preState.setString(3, title);
            rs=db.preState.executeQuery();
            
              if(rs.next()){
                    return rs.getDate("ilan_ver");
              }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (null);
    }
    
    // Add estate 'daire' in database with given parameters
    public boolean addEstate(int price, int area, String address, int floor){
        try {
            String query="SELECT tasinmaz_ekle(?,?,?,?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, price);
            db.preState.setInt(2, area);
            db.preState.setString(3, address);
            db.preState.setInt(4, floor);
            rs=db.preState.executeQuery();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
        }
        return false;
    }
    
    // Add estate 'arazi' in database with given parameters
    public boolean addEstate(int price, int area, String address, boolean imar){
        try {
            String query="SELECT tasinmaz_ekle(?,?,?,?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, price);
            db.preState.setInt(2, area);
            db.preState.setString(3, address);
            db.preState.setBoolean(4, imar);
            rs=db.preState.executeQuery();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    //Sale operation with satin_ali() function 
    public Double sale(String userName, int estateID){
        try {
            String query="SELECT satin_al(?,?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, userName);
            db.preState.setInt(2, estateID);
            
            System.out.println(db.preState);
            rs=db.preState.executeQuery();
            
            if(rs.next())
                return rs.getDouble("satin_al");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return -1.0;
    }
    
    //select and return floor number and owner of the apartment
    public String getApartmentInfo(int estateID){
        try {
            String query="SELECT katno, kadi FROM daire d, sahip s WHERE d.tid=? AND s.tid=?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, estateID);
            db.preState.setInt(2, estateID);
            
            rs=db.preState.executeQuery();
            
            while(rs.next())
                return "Kat numarası: "+rs.getInt("katno") + "  Ev sahibi: "+ rs.getString("kadi");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (null);
    }
    
    //select and return reconstruction state and the owner
    public String getInfo(int estateID){
        try {
            String query="SELECT imardurumu, kadi FROM arazi a, sahip s WHERE s.tid=? AND a.tid=?";
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, estateID);
            db.preState.setInt(2, estateID);
            
            rs=db.preState.executeQuery();
            
            String string=(null);
            if(rs.next()){
                if(rs.getBoolean("imardurumu"))
                    string=" İmara Uygun";
                else
                    string = "İmara Uygun Değil";
             return string + "  Arazi sahibi: "+ rs.getString("kadi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (null);
    }
    
    //Donation Operations  Returns the current date
    public Date donate(String newUser, int estateID){
        Date date= new Date();
        try {
            String query="SELECT emlak_bagis(?,?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, newUser);
            db.preState.setInt(2, estateID);
            rs=db.preState.executeQuery();
            System.out.println(db.preState);
              if(rs.next()){
                    return rs.getDate("emlak_bagis");
              }
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (null);
    }
    
    //Selects the total salary of the given user if it has more than one estate
    public int getMoreThenOne(String userName){
        try {
            String query="SELECT birden_fazla_mal_varligi(?)";
            db.preState=db.con.prepareStatement(query);
            db.preState.setString(1, userName);
            rs=db.preState.executeQuery();
           
            if(rs.next())
                return rs.getInt("birden_fazla_mal_varligi");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return -1;
    }
    
    //returns the totalbudget of admin
    public int getBudget(){
        try {
            String query="SELECT toplambutce FROM sistemadmini";
            db.preState=db.con.prepareStatement(query);
            rs=db.preState.executeQuery();
           
            if(rs.next())
                return rs.getInt("toplambutce");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return -1;
    }
}
