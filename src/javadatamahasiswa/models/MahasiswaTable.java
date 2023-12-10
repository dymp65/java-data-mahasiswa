/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatamahasiswa.models;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class MahasiswaTable extends AbstractTableModel {
    
    List<Mahasiswa> listMahasiswa;
    
    public MahasiswaTable (List<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    @Override
    public int getRowCount() {
        return listMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> listMahasiswa.get(rowIndex).getNim();
            case 2 -> listMahasiswa.get(rowIndex).getNama();
            case 3 -> listMahasiswa.get(rowIndex).getAlamat();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "No";
            case 1 -> "NIM";
            case 2 -> "Nama";
            case 3 -> "Alamat";
            default -> null;  
        };
    }
    
}
