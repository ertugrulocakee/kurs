/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OgrenciKursSinavSonucu;

/**
 *
 * @author ocak
 */
public class Kurs {
    
    private Integer id;
    private String kursAdi;

    public Kurs(Integer id, String kursAdi) {
        this.id = id;
        this.kursAdi = kursAdi;
    }

    public Integer getId() {
        return id;
    }

    public String getKursAdi() {
        return kursAdi;
    }
    
    
    
}
