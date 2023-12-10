/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.dao;

import java.util.List;
import javadatamahasiswa.models.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import javadatamahasiswa.connection.DbConnection;

/**
 *
 * @author admin
 */
public class MahasiswaDao implements MahasiswaDaoInterface {
    
    Connection cn;
    final String insert = "INSERT INTO mahasiswa (nim, name, address) values (?,?,?);";
    final String update = "UPDATE mahasiswa SET nim=?, name=?, address=? WHERE id=?;";
    final String delete = "DELETE from mahasiswa WHERE id=?;";
    final String select = "SELECT * FROM mahasiswa;";
    final String search = "SELECT * FROM mahasiswa WHERE (nim LIKE ? OR name LIKE ? OR address LIKE ?);";
    
    public MahasiswaDao() {
        cn = new DbConnection().getConnection();
    }

    @Override
    public void insert(Mahasiswa m) {
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(insert);
            ps.setString(1, m.getNim());
            ps.setString(2,m.getNama());
            ps.setString(3, m.getAlamat());
            ps.executeUpdate();
        } catch (SQLException er){
            er.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }
    }

    @Override
    public void update(Mahasiswa m) {
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(update);
            ps.setString(1, m.getNim());
            ps.setString(2,m.getNama());
            ps.setString(3, m.getAlamat());
            ps.setInt(4, m.getId());
            ps.executeUpdate();
        } catch (SQLException er){
            er.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException er){
            er.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }
    }

    @Override
    public List<Mahasiswa> all() {
        List<Mahasiswa> listMahasiswa = null;
        
        try {
            listMahasiswa = new ArrayList<Mahasiswa>();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while(rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setId(rs.getInt("id"));
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("name"));
                m.setAlamat(rs.getString("address"));
                listMahasiswa.add(m);
            }
            
        } catch (SQLException er) {
            er.printStackTrace();
        }
        
        return listMahasiswa;
    }

    @Override
    public List<Mahasiswa> search(String keyword) {
        List<Mahasiswa> listMahasiswa = null;
        
        try {
            listMahasiswa = new ArrayList<Mahasiswa>();
            PreparedStatement ps = cn.prepareStatement(search);
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ps.setString(3, keyword);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setId(rs.getInt("id"));
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("name"));
                m.setAlamat(rs.getString("address"));
                listMahasiswa.add(m);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
        
        return listMahasiswa;
    }
    
}
