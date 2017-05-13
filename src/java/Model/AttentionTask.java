/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Catarina
 */
public class AttentionTask {

    private String user;
    private ArrayList<Aplication> listAplication;
    private double timeActivity;
    private double timeAplication;
    private double timeOther;
    private double percentagemAplication;
    private double percentagemOther;
    private long mouseC;
    private long keyC;

    public void setMouseC(int mouseC) {
        this.mouseC = mouseC;
    }

    public void setKeyC(int keyC) {
        this.keyC = keyC;
    }

    public long getMouseC() {
        return mouseC;
    }

    public long getKeyC() {
        return keyC;
    }

    public AttentionTask() {
    }

    public AttentionTask(String user, ArrayList<Aplication> listAplication, double timeActivity, double timeAplication, double timeOther, double percentagemAplication, double percentagemOther) {
        this.user = user;
        this.listAplication = listAplication;
        this.timeActivity = timeActivity;
        this.timeAplication = timeAplication;
        this.timeOther = timeOther;
        this.percentagemAplication = percentagemAplication;
        this.percentagemOther = percentagemOther;
    }

    public void setListAplication(ArrayList<Aplication> listAplication) {
        this.listAplication = listAplication;
    }

    public void setPercentagemAplication(double percentagemAplication) {
        this.percentagemAplication = percentagemAplication;
    }

    public ArrayList<Aplication> getListAplication() {
        return listAplication;
    }

    public double getPercentagemAplication() {
        return percentagemAplication;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getTimeActivity() {
        return timeActivity;
    }

    public void setTimeActivity(double timeActivity) {
        this.timeActivity = timeActivity;
    }

    public double getTimeAplication() {
        return timeAplication;
    }

    public void setTimeAplication(double timeAplication) {
        this.timeAplication = timeAplication;
    }

    public double getTimeOther() {
        return timeOther;
    }

    public void setTimeOther(double timeOther) {
        this.timeOther = timeOther;
    }

    public double getPercentagemOther() {
        return percentagemOther;
    }

    public void setPercentagemOther(double percentagemOther) {
        this.percentagemOther = percentagemOther;
    }

    public void setMouseC(long mouseC) {
        this.mouseC = mouseC;
    }

    public void setKeyC(long keyC) {
        this.keyC = keyC;
    }

}
