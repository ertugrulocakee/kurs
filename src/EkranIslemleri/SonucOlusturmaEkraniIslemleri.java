/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EkranIslemleri;

import OgrenciKursSinavSonucu.SinavSonucu;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

/**
 *
 * @author ocak
 */
public class SonucOlusturmaEkraniIslemleri {
    
    private JComboBox jComboBoxOgrenci;
    private JComboBox jComboBoxKurs;
    private JSpinner jSpinnerSinavSonucu;
    
    private String mesaj;
    
    

    public SonucOlusturmaEkraniIslemleri(JComboBox jComboBoxOgrenci, JComboBox jComboBoxKurs, JSpinner jSpinnerSinavSonucu) {
        this.jComboBoxOgrenci = jComboBoxOgrenci;
        this.jComboBoxKurs = jComboBoxKurs;
        this.jSpinnerSinavSonucu = jSpinnerSinavSonucu;
    }
    
    
    public boolean hataMesajiOlustur(){
        
        mesaj = "";
        
        int minDeger = 1;
        int maxDeger = 100; 
                
        int secilenDeger = (Integer) jSpinnerSinavSonucu.getValue() ;       
        
        if(Integer.valueOf(jComboBoxOgrenci.getSelectedItem().toString()) == 0){
            
            mesaj = "Öğrenci seçmedin!!!";
            
            return false;
            
        }
        
        if(jComboBoxKurs.getSelectedItem().toString().equals(" ")){
            
            mesaj = "Kurs seçmedin!!!";
            
            return false;
            
        }
        
        if(!(secilenDeger >= minDeger && secilenDeger <= maxDeger)){
            
            
           mesaj = "1-100 arasında bir sınav sonucu girmedin!!!"; 
            
           return false; 
        }
        
        return true;
        
    }
    
    public SinavSonucu sinavSonucuOlustur(Integer id,Integer ogrenciId, Integer kursId,Integer skor){
        
       SinavSonucu sinavSonucu; 
        
       sinavSonucu = new  SinavSonucu(0,ogrenciId,kursId,skor);
       
       return sinavSonucu;
       
    } 
   

    public String getMesaj() {
        return mesaj;
    }


    

}
