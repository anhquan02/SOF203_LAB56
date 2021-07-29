/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entity.Lugger;

/**
 *
 * @author Mypc
 */
public class LuggerDAOImpl implements IDAO<Lugger> {

    private ArrayList<Lugger> lst;

    public LuggerDAOImpl() {
        lst = new ArrayList<>();
        read();
    }


    @Override
    // tạo 1 bản ghi mới cho db tham số là 1 Lugger
    public boolean create(Lugger t) {
        String query = "Insert into Lugger values(?,?,?,?,?,?,?)";
        try (Connection conn = util.JDBCUtils.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setInt(1, t.getMaHL());
            st.setString(2, t.getTen());
            st.setFloat(3, t.getTrongLuong());
            st.setInt(4, t.getSoLuong());
            st.setBigDecimal(5, t.getGiaHienTai());
            long ngayTao = t.getNgayTao().getTime();
            st.setDate(6, new Date(ngayTao));
            st.setString(7, t.getColor());
            st.executeUpdate();
            lst.add(t);
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    //Đọc dữ liệu từ db thêm các bản ghi vào ArrayList đã tạo
    public void read() {
        String query = "Select * from Lugger";

        try (Connection conn = util.JDBCUtils.getConnection();
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();) {
            while (rs.next()) {
                lst.add(new Lugger(rs.getInt(1), rs.getString(2),
                        rs.getFloat(3), rs.getInt(4), rs.getBigDecimal(5),
                        rs.getDate(6), rs.getString(7)));
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //Thay đổi thông tin giá trị bên db dựa vào mã của Lugger, tham số Lugger 
    //đã thay đổi và index trỏ tới mã của Lugger dựa vào list 
    public void update(Lugger t, int index) {
        String query = "update Lugger set ten=?,trongLuong=?,soluong=?,"
                + "giaHienTai=?,ngayTao=?,color=? where MaHL = ? ";
        try (Connection conn = util.JDBCUtils.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, t.getTen());
            st.setFloat(2, t.getTrongLuong());
            st.setInt(3, t.getSoLuong());
            st.setBigDecimal(4, t.getGiaHienTai());
            long ngayTao = t.getNgayTao().getTime();
            st.setDate(5, new Date(ngayTao));
            st.setString(6, t.getColor());
            st.setInt(7, getItem(index).getMaHL());
            st.executeUpdate();
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //Xoá bản ghi bên db dựa vào mã Lugger--tham số là Lugger dùng để lấy mã
    public void delete(Lugger t) {
        String query = "Delete Lugger where maHL=?";
        try (Connection conn = util.JDBCUtils.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setInt(1, t.getMaHL());
            st.executeUpdate();
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //Lấy cái danh sách hành lý
    public ArrayList<Lugger> getList() {
        return this.lst;
    }

    @Override
    //Lấy hành lý trong list chứa hành lý 
    // tham số id: vị trí của hành lý trong danh sách    
    public Lugger getItem(int id) {
        return this.lst.get(id);
    }

}
