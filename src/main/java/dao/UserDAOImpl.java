/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.User;

/**
 *
 * @author Mypc
 */
public class UserDAOImpl extends UserDAO{

    public UserDAOImpl() {
    }

    //kiểm tra sự tồn tại của user
    @Override
    public  boolean isUserExist(User user) {
        System.out.println("...");
        String sql = "SELECT Pass_word FROM [Users] WHERE Username = ?";
        try (Connection connection = util.JDBCUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {

            System.out.println("Thành công");
            ps.setString(1, user.getUsername());
            ResultSet resultSet = ps.executeQuery();
            String password = "";
            if (resultSet.next()) {
                password = resultSet.getString(1);
            }
            resultSet.close();
            return password.equals(user.getPassword());
        } catch (Exception e) {
            return false;
        }
    }

}
