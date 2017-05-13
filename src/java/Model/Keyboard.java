/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Catarina
 */
public class Keyboard {
    private long timestamp;
    private double kdt;
    private double tbk;

    public Keyboard() {
    }

    public Keyboard(long timestamp, double kdt, double tbk) {
        this.timestamp = timestamp;
        this.kdt = kdt;
        this.tbk = tbk;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getKdt() {
        return kdt;
    }

    public void setKdt(double kdt) {
        this.kdt = kdt;
    }

    public double getTbk() {
        return tbk;
    }

    public void setTbk(double tbk) {
        this.tbk = tbk;
    }
    
    
}
