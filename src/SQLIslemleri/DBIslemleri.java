/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLIslemleri;


import OgrenciKursSinavSonucu.Kurs;
import OgrenciKursSinavSonucu.Ogrenci;
import OgrenciKursSinavSonucu.SinavSonucu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ocak
 */
public class DBIslemleri extends DBBaglanti{
    
   
    private final String ogrenciEkleSQL = "INSERT INTO student VALUES(NULL,?,?,?,?)";
    private final String kursEkleSQL = "INSERT INTO course VALUES(NULL,?)";
    private final String ogrenciOkuSQL = "SELECT * FROM student";
    private final String kursOkuSQL = "SELECT * FROM course";
   
    private final String ogrenciIdBul = "SELECT * FROM student WHERE number = ?";
    private final String kursIdBul = "SELECT * FROM course WHERE name = ?";
    private final String sonucTablosunaEkle = "INSERT INTO exam_result VALUES(NULL,?,?,?)";
  
    private final String kursSonucuTablosu = "SELECT * FROM exam_result WHERE student_id = ? AND course_id = ?";
    
    private ArrayList<Integer> ogrenciler = new ArrayList<>();
    private ArrayList<String> kurslar = new ArrayList<>();
  
    
    public DBIslemleri(String DBIsmi) {
        super(DBIsmi);
    }

    public boolean kullaniciOlustur(Ogrenci ogrenci) {
        
        boolean kullaniciOlustuMu = false; 
        
        try {
    
            baglanti.setAutoCommit(false);
            
            komutTamamlayici = baglanti.prepareStatement(ogrenciEkleSQL);
            komutTamamlayici.setString(1,ogrenci.getTamAd());
            komutTamamlayici.setInt(2,ogrenci.getNumber());
            komutTamamlayici.setString(3,ogrenci.getEmail());
            komutTamamlayici.setString(4,ogrenci.getTelefonNumarasi());
            
            komutTamamlayici.executeUpdate();
            baglanti.commit();
            
            kullaniciOlustuMu = true;

            
        } catch (SQLException ex) {
            
            try {
                baglanti.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
 

        return kullaniciOlustuMu;
    }
    
    
    
    public boolean kursOlusturSQL(Kurs kurs){
        
        boolean kursOlustuMu = false;
        
        try {
            
            baglanti.setAutoCommit(false);
            
            komutTamamlayici = baglanti.prepareStatement(kursEkleSQL);
            komutTamamlayici.setString(1,kurs.getKursAdi());
            komutTamamlayici.executeUpdate();
            
            baglanti.commit();
            
            kursOlustuMu = true;
            
        } catch (SQLException ex) {
            
            try {
                baglanti.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return kursOlustuMu;
    }
    
 
    public ArrayList<Integer> ogrenciGetir(){
        
       ResultSet resultSet;
        
       ogrenciler.add(0);
       
        try {
            
            komutTamamlayici = baglanti.prepareStatement(ogrenciOkuSQL);
            resultSet = komutTamamlayici.executeQuery();
 
            while(resultSet.next()){
                
              ogrenciler.add(resultSet.getInt("number"));
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        return ogrenciler;
    }
    
    public ArrayList<String> kursGetir(){
        
      ResultSet resultSet;
      
      kurslar.add(" ");
        
        try {
            
            komutTamamlayici = baglanti.prepareStatement(kursOkuSQL);
            resultSet = komutTamamlayici.executeQuery();
 
            while(resultSet.next()){
                
                kurslar.add(resultSet.getString("name"));
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
       return kurslar; 
    }
    
    public Integer kullaniciIdBul(Integer numara){
        
       ResultSet resultSet; 
       
       int kullaniciId = 0;
        
        try {
            komutTamamlayici = baglanti.prepareStatement(ogrenciIdBul);
            komutTamamlayici.setInt(1, numara);
            
            resultSet = komutTamamlayici.executeQuery();
            
            if(resultSet.next()){
                
               kullaniciId = resultSet.getInt("id");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return kullaniciId;
        
    }
    
    
    public Integer kursIdBul(String ad){
        
      ResultSet resultSet;
      
      int kursId = 0;
        
     try{
         
       komutTamamlayici = baglanti.prepareStatement(kursIdBul);
       komutTamamlayici.setString(1, ad);
       resultSet = komutTamamlayici.executeQuery();
       
       if(resultSet.next()){
           
           
          kursId = resultSet.getInt("id");
           
           
       }
       
     }catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return kursId;
        
    }
    
    
    public boolean sonucEkleSQL(SinavSonucu sinavSonucu){
        
        boolean sonucOlustuMu = false;
        
        try {
            
            baglanti.setAutoCommit(false);
            komutTamamlayici = baglanti.prepareStatement(sonucTablosunaEkle);
            komutTamamlayici.setInt(1,sinavSonucu.getOgrenciId());
            komutTamamlayici.setInt(2, sinavSonucu.getKursId());
            komutTamamlayici.setInt(3,sinavSonucu.getSkor());
            komutTamamlayici.executeUpdate();
            baglanti.commit();
            sonucOlustuMu = true;
            
        } catch (SQLException ex) {
            try {
                baglanti.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return sonucOlustuMu;
       
    }
    
    public double ortalamaSonucGoster(Integer ogrenciId,Integer kursId){
   
        
        double ortalamaSkor = 0;
        
        int sayac = 0;
        
        ResultSet resultSet;
        
        try {
            
            komutTamamlayici = baglanti.prepareStatement(kursSonucuTablosu);
            komutTamamlayici.setInt(1,ogrenciId);
            komutTamamlayici.setInt(2,kursId);
            resultSet = komutTamamlayici.executeQuery();
            
            while(resultSet.next()){
                
              ortalamaSkor += resultSet.getInt("score");
                
              sayac++;  
               
            }
            
           if(sayac == 3){
               
              ortalamaSkor = ortalamaSkor/3;
               
           }else{
               
               ortalamaSkor = 0;
               
           } 
            
        } catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return ortalamaSkor;
    }
    
    public boolean kursBittiMi(Integer ogrenciId,Integer kursId){
        
        boolean kursBittiMi = false;
        
        int sayac = 0;
        
        ResultSet resultSet;
        
        try {
            
            komutTamamlayici = baglanti.prepareStatement(kursSonucuTablosu);
            komutTamamlayici.setInt(1,ogrenciId);
            komutTamamlayici.setInt(2,kursId);
            resultSet = komutTamamlayici.executeQuery();
            
            while(resultSet.next()){
       
              sayac++;  
              
              if(sayac == 3){
                  
                  kursBittiMi = true;
                  
                  break;
                  
              }
               
            }
            
       
            
        } catch (SQLException ex) {
            Logger.getLogger(DBIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return kursBittiMi;
        
    }
    
}
