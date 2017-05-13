/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Catarina
 */
public class AttentionKeyboard {
    private String User;
    private ArrayList<Keyboard> listKeyboard;
    private double mediaKDT;
    private double pKDT;
    private double mediaTBK;
    private double pTBK;
    
    public AttentionKeyboard() {
    }


    public AttentionKeyboard(String User, ArrayList<Keyboard> listKeyboard, double mediaKDT, double mediaTBK) {
        this.User = User;
        this.listKeyboard = listKeyboard;
        this.mediaKDT = mediaKDT;
        this.mediaTBK = mediaTBK;
    }

    public void setMediaTBK(double mediaTBK) {
        this.mediaTBK = mediaTBK;
    }

    public void setMediaKDT(double mediaKDT) {
        this.mediaKDT = mediaKDT;
    }

    public double getMediaTBK() {
        return mediaTBK;
    }

    public double getMediaKDT() {
        return mediaKDT;
    }

    public ArrayList<Keyboard> getListKeyboard() {
        return listKeyboard;
    }

    public void setListKeyboard(ArrayList<Keyboard> listKeyboard) {
        this.listKeyboard = listKeyboard;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public double getpKDT() {
        return pKDT;
    }

    public void setpKDT(double pKDT) {
        this.pKDT = pKDT;
    }

    public double getpTBK() {
        return pTBK;
    }

    public void setpTBK(double pTBK) {
        this.pTBK = pTBK;
    }
    
    
}
