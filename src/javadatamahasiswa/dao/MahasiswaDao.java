/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.dao;

import java.util.List;
import javadatamahasiswa.models.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javadatamahasiswa.connection.DbConnection;

/**
 *
 * @author admin
 */
public class MahasiswaDao implements MahasiswaDaoInterface {
    
    Connection cn;
    final String insert = "INSERT INTO mahasiswa (nim, name, address) VALUES (?,?,?);";
    final String update = "UPDATE mahasiswa SET nim=?, name=?, address=? WHERE id=?;";
    final String delete = "DELETE mahasiswa WHERE id=?;";
    final String select = "SELECT * FROM mahasiswa;";
    final String search = "SELECT * FROM mahasiswa WHERE (nim LIKE ? OR name LIKE ? OR address LIKE ?)";
    
    public MahasiswaDao() {
        cn = new DbConnection().getConnection();
    }
    
    @Override
    public void insert(Mahasiswa m) {
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(insert);
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getAlamat());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Mahasiswa m) {
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(update);
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getAlamat());
            ps.setInt(4, m.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Mahasiswa> all() {
        List<Mahasiswa> m = null;
        
        try {
            m = new ArrayList<Mahasiswa>();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("name"));
                b.setAlamat(rs.getString("address"));
                b.setId(rs.getInt("id"));
                m.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }

    @Override
    public List<Mahasiswa> search(String q) {
        List<Mahasiswa> m = null;
        
        try {
            m = new ArrayList<Mahasiswa>();
            PreparedStatement st = cn.prepareStatement(search);
            st.setString(1, "%" + q + "%");
            st.setString(2, "%" + q + "%");
            st.setString(3, "%" + q + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("name"));
                b.setAlamat(rs.getString("address"));
                b.setId(rs.getInt("id"));
                m.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
    
}
