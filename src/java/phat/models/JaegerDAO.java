/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phat.dtos.JaegerDTO;
import phat.dtos.JaegerdetailDTO;
import phat.utils.MyConnection;

/**
 *
 * @author user
 */
public class JaegerDAO implements Serializable{
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
    
    private List<JaegerDTO> listjaeger;

    public List<JaegerDTO> getListjaeger() {
        return listjaeger;
    }
    public void ChooseJaeger(String Ability){
        try {
            String typeJaeger;
            if(Ability.equals("Skillful")){
                typeJaeger = "Fighter";
            }else if(Ability.equals("Focus")){
                typeJaeger = "Gunslinger";
            }else if(Ability.equals("Agility")){
                typeJaeger = "Fury";
            }else{
                typeJaeger = "Defender";
            }
                    
            String sql ="Select Ji.Name,Ji.Image,Jd.Speed,Jd.Armor,Jd.Strength,Jd.WeaponId , Ji.Type "
                    + "from  JaegerDetail Jd , JaegerInfo Ji where Jd.Id =Ji.Id "
                    + "and Jd.isEmpty = 'true' and Ji.Type= ? ";
            con = MyConnection.getMyConnection();
            st = con.prepareStatement(sql);
            st.setString(1, typeJaeger);
            rs = st.executeQuery();
            while(rs.next()){
                String jaegername = rs.getString("Name");
                int Speed = rs.getInt("Speed");
                int Armor = rs.getInt("Armor");
                int Strength = rs.getInt("Strength");
                String Type = rs.getString("Type");
                String image = rs.getString("Image");
                JaegerDTO dto = new JaegerDTO(jaegername, Speed, Strength, Armor, Type, image);
                System.out.println(dto.getJaegername());
                if(this.listjaeger == null){
                    listjaeger = new ArrayList<JaegerDTO>();
                }
                listjaeger.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }
    private List<JaegerdetailDTO> jagerdetail;

    public List<JaegerdetailDTO> getJagerdetail() {
        return jagerdetail;
    }
    
    public void LoadJaeger(String Id){
        try {
            String sql = "Select Ji.Name,Ji.Type,Ji.Image,Ji.Height,Ji.Weight,Jd.Speed,Jd.Armor,Jd.Strength,Jd.WeaponId  "
                    + "from  pilots P LEFT JOIN JaegerDetail Jd ON P.Idjaeger = Jd.Id LEFT JOIN JaegerInfo Ji ON Jd.Id = Ji.Id "
                    + "where  P.Idjaeger = ? ";
            con = MyConnection.getMyConnection();
            st = con.prepareStatement(sql);
            st.setString(1, Id);
            rs = st.executeQuery();
            if(rs.next()){
                String JaegerName = rs.getString("Name");
                String Type = rs.getString("Type");
                String Image = rs.getString("Image");
                Float Height = rs.getFloat("Height");
                Float Weight = rs.getFloat("Weight");
                int Speed = rs.getInt("Speed");
                int Strength = rs.getInt("Strength");
                int Armor = rs.getInt("Armor");
                String Weapon = rs.getString("WeaponId");
                JaegerdetailDTO dto = new JaegerdetailDTO(JaegerName, Type, Speed, Strength, Armor, Weapon, Height, Weight, Image);
                if(this.jagerdetail == null){
                    jagerdetail = new ArrayList<JaegerdetailDTO>();
                }
                jagerdetail.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }
}
