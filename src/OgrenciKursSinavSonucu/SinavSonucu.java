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
public class SinavSonucu {
    
    private Integer id;
    private Integer ogrenciId;
    private Integer kursId;
    private Integer skor;

    public SinavSonucu(Integer id, Integer ogrenciId, Integer kursId, Integer skor) {
        this.id = id;
        this.ogrenciId = ogrenciId;
        this.kursId = kursId;
        this.skor = skor;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOgrenciId() {
        return ogrenciId;
    }

    public Integer getKursId() {
        return kursId;
    }

    public Integer getSkor() {
        return skor;
    }
    
    
    
    
}
