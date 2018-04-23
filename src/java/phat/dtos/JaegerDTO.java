/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dtos;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class JaegerDTO implements Serializable{
    private String jaegername ;
    private int Speed;
    private int Strength;
    private int Armor;
    private String Type;
    private String image;

    public JaegerDTO(String jaegername, int Speed, int Strength, int Armor, String Type, String image) {
        this.jaegername = jaegername;
        this.Speed = Speed;
        this.Strength = Strength;
        this.Armor = Armor;
        this.Type = Type;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public String getJaegername() {
        return jaegername;
    }

    public void setJaegername(String jaegername) {
        this.jaegername = jaegername;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int Strength) {
        this.Strength = Strength;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int Armor) {
        this.Armor = Armor;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
}
