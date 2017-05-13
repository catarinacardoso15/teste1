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
public class Aplication {
    private ArrayList<String>listT;
    private String name;
    private Date time;
    private String user;
    public Aplication() {
    }

    public Aplication(String name, Date time,String user) {
        this.listT = new ArrayList<String>();
        this.name = name;
        this.time = time;
        this.user=user;
    }

    public ArrayList<String> getListT() {
        return listT;
    }

    public void setListT(ArrayList<String> listT) {
        this.listT = listT;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
