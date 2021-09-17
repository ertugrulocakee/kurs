/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EkranIslemleri;

import OgrenciKursSinavSonucu.Kurs;
import javax.swing.JTextField;

/**
 *
 * @author ocak
 */
public class KursOlusturmaEkraniIslemleri {
    
    private JTextField jTextFieldKursAdi;

    public KursOlusturmaEkraniIslemleri(JTextField jTextFieldKursAdi) {
        this.jTextFieldKursAdi = jTextFieldKursAdi;
    }
    
    
    public Kurs kursOlustur(){
       
      Kurs kurs;  
       
      
      kurs = new Kurs(0,jTextFieldKursAdi.getText().toString());
        
      
       return kurs;
       
    }
    
    public boolean kursAdiKontrol(){
        
     String kursAdi = jTextFieldKursAdi.getText().toString().trim();
     
     if(kursAdi.equals("")){
         
       
         return true;
         
     }else{
        
         jTextFieldKursAdi.setText(kursAdi);
         
         return false;
        
     }
     
        
    }
    
    
}
