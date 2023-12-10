/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.models;

/**
 *
 * @author admin
 */
public class Mahasiswa {
    private Integer id;
    private String nim, nama, alamat;
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public String getNim() {
        return nim;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
}
