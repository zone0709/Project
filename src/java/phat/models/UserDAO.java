/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.models;

import com.opensymphony.xwork2.ActionContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import phat.utils.MyConnection;

/**
 *
 * @author user
 */
public class UserDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkLogin(String username, String password) {
        String role = "fail";
        try {
            Map session = ActionContext.getContext().getSession();
            String sql = "Select U.Role , P.Name , P.Ability ,P.Idjaeger "
                    + "from Usertbl U LEFT JOIN pilots P ON U.Id = P.Id "
                    + "where U.Id = ? and U.Password = ?";
            con = MyConnection.getMyConnection();
            st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
                String fullname = rs.getString("Name");
                String Ability = rs.getString("Ability");
                String JaegerId = rs.getString("Idjaeger");
                System.out.println(JaegerId);
                session.put("NAME", fullname);
                session.put("ABI", Ability);
                if (JaegerId == null) {
                    session.remove("JaegerId");
                } else {
                    session.put("JaegerId", JaegerId);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

}
