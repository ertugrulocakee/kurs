/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLIslemleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ocak
 */
public class DBBaglanti {
    
    
    final String kullaniciAdi = "root";
    final String parola = "";
    final String host = "localhost";
    final String jdbc = "jdbc:mysql://";
    final String driver = "com.mysql.cj.jdbc.Driver";
    final Integer port = 3306;
    
    String DBIsmi;
    String baglantiUrl;
    Connection baglanti;
    PreparedStatement komutTamamlayici;

    public DBBaglanti(String DBIsmi) {
        this.DBIsmi = DBIsmi;
        dbBaglantiKur();
        
    }

    
    public void dbBaglantiKur() {
        
        
        try {
            Class.forName(driver);
            baglantiUrl = jdbc+ host+ ":" + port + "/" + DBIsmi;
            baglanti = (Connection) DriverManager.getConnection(baglantiUrl,kullaniciAdi,parola);
                    
                    } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBBaglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
}
