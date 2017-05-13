/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Catarina
 */
public class Data {
    private Date initialDate;
    private Date finalData;
    private String user;
    private ArrayList<Aplication> listAplication;
    private ArrayList<Mouse>listMouse;
    private ArrayList<Keyboard>listKeyboard;
    

    public Data() {
        this.listAplication=new ArrayList<Aplication>();
        this.listMouse=new ArrayList<Mouse>();
        this.listKeyboard=new ArrayList<Keyboard>();
    }

    public Data(Date initialDate, Date finalData, String user, ArrayList<Aplication> listAplication, ArrayList<Mouse> listMouse, ArrayList<Keyboard> listKeyboard) {
        this.initialDate = initialDate;
        this.finalData = finalData;
        this.user = user;
        this.listAplication = listAplication;
        this.listMouse = listMouse;
        this.listKeyboard = listKeyboard;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalData() {
        return finalData;
    }

    public void setFinalData(Date finalData) {
        this.finalData = finalData;
    }

    public ArrayList<Keyboard> getListKeyboard() {
        return listKeyboard;
    }

    public void setListKeyboard(ArrayList<Keyboard> listKeyboard) {
        this.listKeyboard = listKeyboard;
    }

   
    public ArrayList<Aplication> getListAplication() {
        return listAplication;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Mouse> getListMouse() {
        return listMouse;
    }

    public void setListAplication(ArrayList<Aplication> listAplication) {
        this.listAplication = listAplication;
    }

    public void setListMouse(ArrayList<Mouse> listMouse) {
        this.listMouse = listMouse;
    }
    
    
}
