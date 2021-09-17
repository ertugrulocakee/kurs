/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EkranIslemleri;

import javax.swing.JTextField;

/**
 *
 * @author ocak
 */
public class SonuclarUIEkranIslemleri {
    
    private JTextField jTextField_OgrenciNo;
    private JTextField jTextField_KursIsmi;
    
    private String mesaj;

    public SonuclarUIEkranIslemleri(JTextField jTextField_OgrenciNo, JTextField jTextField_KursIsmi) {
        this.jTextField_OgrenciNo = jTextField_OgrenciNo;
        this.jTextField_KursIsmi = jTextField_KursIsmi;
    }
    
    
            
    public boolean kontrol(){
      
       int sayi; 
       
       boolean hata = false;
       
       String kursAdi = jTextField_KursIsmi.getText().toString().trim();
        
       try{
           
         sayi =  Integer.valueOf(jTextField_OgrenciNo.getText().toString());
           
           
       }catch(NumberFormatException exception){
           
           System.out.println(exception.getLocalizedMessage());
           
           hata = true;
           
           this.mesaj = "Öğrenci numarası rakamlardan oluşmaktadır!!!"; 
                   
           return hata;
       } 
        
       if(kursAdi.equals("")){
           
           hata = true;
           
           this.mesaj = "Kurs adı boş bırakılamaz!!!";  
    
           return hata;
           
       }else{
           
           jTextField_KursIsmi.setText(kursAdi);
           
       }
       
       
      return hata;  
      
    }

    public String getMesaj() {
        return mesaj;
    }
    
    
    
}
