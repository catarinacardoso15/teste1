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
public class AttentionMouse {
     private String User;
    private ArrayList<Mouse> listMouse;
    private double mediaMA;
    private double pMA;
    private double mediaMV;
    private double pMV;
    private double mediaCD;
    private double pCD;
    private double mediaDBC;
    private double pDBC;
    private double mediaDDC;
    private double pDDC;
    private double mediaDPLBC;
    private double pDPLBC;
    private double mediaTBC;
    private double pTBC;
    private double mediaTDC;
    private double pTDC;

    public double getpMA() {
        return pMA;
    }

    public void setpMA(double pMA) {
        this.pMA = pMA;
    }

    public double getpMV() {
        return pMV;
    }

    public void setpMV(double pMV) {
        this.pMV = pMV;
    }

    public double getpCD() {
        return pCD;
    }

    public void setpCD(double pCD) {
        this.pCD = pCD;
    }

    public double getpDBC() {
        return pDBC;
    }

    public void setpDBC(double pDBC) {
        this.pDBC = pDBC;
    }

    public double getpDDC() {
        return pDDC;
    }

    public void setpDDC(double pDDC) {
        this.pDDC = pDDC;
    }

    public double getpDPLBC() {
        return pDPLBC;
    }

    public void setpDPLBC(double pDPLBC) {
        this.pDPLBC = pDPLBC;
    }

    public double getpTBC() {
        return pTBC;
    }

    public void setpTBC(double pTBC) {
        this.pTBC = pTBC;
    }

    public double getpTDC() {
        return pTDC;
    }

    public void setpTDC(double pTDC) {
        this.pTDC = pTDC;
    }
    
    public AttentionMouse() {
    }

    public AttentionMouse(String User, ArrayList<Mouse> listMouse) {
        this.User = User;
        this.listMouse = listMouse;
    }

    public ArrayList<Mouse> getListMouse() {
        return listMouse;
    }

    public AttentionMouse(String User, ArrayList<Mouse> listMouse, double mediaMA, double mediaMV, double mediaCD, double mediaDBC, double mediaDDC, double mediaDPLBC, double mediaTBC, double mediaTDC) {
        this.User = User;
        this.listMouse = listMouse;
        this.mediaMA = mediaMA;
        this.mediaMV = mediaMV;
        this.mediaCD = mediaCD;
        this.mediaDBC = mediaDBC;
        this.mediaDDC = mediaDDC;
        this.mediaDPLBC = mediaDPLBC;
        this.mediaTBC = mediaTBC;
        this.mediaTDC = mediaTDC;
    }

    public double getMediaMA() {
        return mediaMA;
    }

    public void setMediaMA(double mediaMA) {
        this.mediaMA = mediaMA;
    }

    public double getMediaMV() {
        return mediaMV;
    }

    public void setMediaMV(double mediaMV) {
        this.mediaMV = mediaMV;
    }

    public double getMediaCD() {
        return mediaCD;
    }

    public void setMediaCD(double mediaCD) {
        this.mediaCD = mediaCD;
    }

    public double getMediaDBC() {
        return mediaDBC;
    }

    public void setMediaDBC(double mediaDBC) {
        this.mediaDBC = mediaDBC;
    }

    public double getMediaDDC() {
        return mediaDDC;
    }

    public void setMediaDDC(double mediaDDC) {
        this.mediaDDC = mediaDDC;
    }

    public double getMediaDPLBC() {
        return mediaDPLBC;
    }

    public void setMediaDPLBC(double mediaDPLBC) {
        this.mediaDPLBC = mediaDPLBC;
    }

    public double getMediaTBC() {
        return mediaTBC;
    }

    public void setMediaTBC(double mediaTBC) {
        this.mediaTBC = mediaTBC;
    }

    public double getMediaTDC() {
        return mediaTDC;
    }

    public void setMediaTDC(double mediaTDC) {
        this.mediaTDC = mediaTDC;
    }

    public String getUser() {
        return User;
    }

    public void setListMouse(ArrayList<Mouse> listMouse) {
        this.listMouse = listMouse;
    }

    public void setUser(String User) {
        this.User = User;
    }

   
    
}
