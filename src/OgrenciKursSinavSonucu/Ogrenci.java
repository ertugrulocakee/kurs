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
public class Ogrenci {
    
    private Integer id;
    private String tamAd;
    private Integer number;
    private String email;
    private String telefonNumarasi;

    public Ogrenci(Integer id, String tamAd, Integer number, String email, String telefonNumarasi) {
        this.id = id;
        this.tamAd = tamAd;
        this.number = number;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    public Integer getId() {
        return id;
    }

    public String getTamAd() {
        return tamAd;
    }

    public Integer getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }
    
    
    
    
}
