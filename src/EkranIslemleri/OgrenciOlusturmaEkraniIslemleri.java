/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EkranIslemleri;

import OgrenciKursSinavSonucu.Ogrenci;
import javax.swing.JTextField;

/**
 *
 * @author ocak
 */
public class OgrenciOlusturmaEkraniIslemleri {
    
    private JTextField jTextFieldOgrenciNumarasi;
    private JTextField jTextFieldOgrenciTamAd;   
    private JTextField jTextFieldOgrenciEmail;
    private JTextField jTextFieldOgrenciTelefon;
    
    private String mesaj;

    public OgrenciOlusturmaEkraniIslemleri(JTextField jTextFieldOgrenciNumarasi, JTextField jTextFieldOgrenciTamAd, JTextField jTextFieldOgrenciEmail, JTextField jTextFieldOgrenciTelefon) {
        this.jTextFieldOgrenciNumarasi = jTextFieldOgrenciNumarasi;
        this.jTextFieldOgrenciTamAd = jTextFieldOgrenciTamAd;
        this.jTextFieldOgrenciEmail = jTextFieldOgrenciEmail;
        this.jTextFieldOgrenciTelefon = jTextFieldOgrenciTelefon;
    }
    
    
    public Ogrenci ogrenciOlustur(){
 
     Ogrenci ogrenci = null;   

     ogrenci = new Ogrenci(0,
                           jTextFieldOgrenciTamAd.getText().toString(),
                           Integer.valueOf(jTextFieldOgrenciNumarasi.getText().toString()),
                           jTextFieldOgrenciEmail.getText().toString(),
                           jTextFieldOgrenciTelefon.getText().toString()); 

     return ogrenci;
     
    }
   
    protected boolean ogrenciNumarasiKontrol(){
     
      boolean ogrenciNumarasiUygunMu = true;
 
      int ogrenciNumarasi = 0;
      
  
        try{
            
         ogrenciNumarasi = Integer.valueOf(jTextFieldOgrenciNumarasi.getText().toString());
            
        }catch(NumberFormatException e){
            
            e.getLocalizedMessage();
            
            ogrenciNumarasiUygunMu = false;
   
        }
        
        
        if(ogrenciNumarasi == 0){
            
            ogrenciNumarasiUygunMu = false;
               
        }
        
     return ogrenciNumarasiUygunMu; 
   }
      

    
    
 protected boolean bosAlanKontrol(){

   String adSoyad = jTextFieldOgrenciTamAd.getText().toString().trim();
   String eMail = jTextFieldOgrenciEmail.getText().toString().replaceAll(" ", "");
   String telefonNumarasi = jTextFieldOgrenciTelefon.getText().toString().replaceAll(" ", "");
   
   if(adSoyad.equals("") || eMail.equals("") || telefonNumarasi.equals("")){
       
       return false;
       
       
   }else{
       
       jTextFieldOgrenciEmail.setText(eMail);
       jTextFieldOgrenciTamAd.setText(adSoyad);
       jTextFieldOgrenciTelefon.setText(telefonNumarasi);
       
       return true;
       
   }
   

     
 }   
    
    
 public boolean uyariMesajiOlustur(){
     
    boolean uyariEkraniGerekliMi = false;
    
    boolean numaraKontrol  = ogrenciNumarasiKontrol();
     
    boolean boslukKontrol = bosAlanKontrol();
    
    this.mesaj ="";
    
   
    if(numaraKontrol == false){
        
        this.mesaj = "Öğrenci numaranız rakamlardan oluşmalı ve 0 olmamalıdır!!!";
        uyariEkraniGerekliMi = true;
        
    }
    
    else if(boslukKontrol == false){
        
        this.mesaj = "Boş bıraktığınız alanlar mevcut!!!";
        uyariEkraniGerekliMi = true;
    }
  
    
    return uyariEkraniGerekliMi;
    
} 

    public String getMesaj() {
        return this.mesaj;
    }
 
 
 
 
    
}
