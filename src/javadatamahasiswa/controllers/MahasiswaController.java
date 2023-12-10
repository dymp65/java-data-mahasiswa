/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.controllers;

import java.util.List;
import javadatamahasiswa.dao.MahasiswaDao;
import javadatamahasiswa.models.Mahasiswa;
import javadatamahasiswa.models.MahasiswaTable;
import javadatamahasiswa.views.MahasiswaView;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MahasiswaController {
    MahasiswaView view;
    MahasiswaDao dao;
    List<Mahasiswa> listMahasiswa;
    
    public MahasiswaController (MahasiswaView view) {
        this.view = view;
        dao = new MahasiswaDao();
        listMahasiswa = dao.all();
    }
    
    public void reset() {
        view.getTxtNim().setText("");
        view.getTxtNama().setText("");
        view.getTxtAlamat().setText("");
        view.getTxtId().setText("");
        view.getTxtCariData().setText("");
    }
    
    public void setTable () {
        listMahasiswa = dao.all();
        MahasiswaTable mt = new MahasiswaTable(listMahasiswa);
        view.tabelMahasiswa().setModel(mt);
    }
    
    public void insert() {
        if (!view.getTxtNim().getText().trim().isEmpty() && !view.getTxtNama().getText().trim().isEmpty()) {
            Mahasiswa m = new Mahasiswa();
            m.setNim(view.getTxtNim().getText());
            m.setNama(view.getTxtNama().getText());
            m.setAlamat(view.getTxtAlamat().getText());
            
            dao.insert(m);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            
        } else {
            JOptionPane.showMessageDialog(null, "Data NIM atau Nama tidak boleh kosong!");
        }
    }
}
