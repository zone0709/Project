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
public class JaegerdetailDTO implements Serializable{
    private String jaegername ;
    private String type;
    private int speed;
    private int strength;
    private int armor;
    private String weapon;
    private float height;
    private float weight;
    private String image;

    public JaegerdetailDTO(String jaegername, String type, int speed, int strength, int armor, String weapon, float height, float weight, String image) {
        this.jaegername = jaegername;
        this.type = type;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
        this.weapon = weapon;
        this.height = height;
        this.weight = weight;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
}
