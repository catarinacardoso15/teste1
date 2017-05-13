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
public class AttentionResult {

    private AttentionTask ResultTask;
    private AttentionMouse ResultMouse;
    private AttentionKeyboard ResultKeyboard;
    private String user;
    private Date initialDate;
    private Date currentDate;
    private long mouseCount;
    private long keyCount;

    public void setMouseCount(long mouseCount) {
        this.mouseCount = mouseCount;
    }

    public void setKeyCount(long keyCount) {
        this.keyCount = keyCount;
    }

    public long getMouseCount() {
        return mouseCount;
    }

    public long getKeyCount() {
        return keyCount;
    }

    public AttentionResult() {
    }

    public AttentionResult(AttentionTask listResultTask, AttentionMouse listResultMouse,AttentionKeyboard listResultKeyboard, String user, Date initialDate, Date currentDate) {
        this.ResultTask = listResultTask;
        this.ResultMouse = listResultMouse;
        this.ResultKeyboard = listResultKeyboard;
        this.user = user;
        this.initialDate = initialDate;
        this.currentDate = currentDate;
    }

    public AttentionTask getResultTask() {
        return ResultTask;
    }

    public void setResultTask(AttentionTask ResultTask) {
        this.ResultTask = ResultTask;
    }

    public AttentionMouse getResultMouse() {
        return ResultMouse;
    }

    public void setResultMouse(AttentionMouse ResultMouse) {
        this.ResultMouse = ResultMouse;
    }

    public AttentionKeyboard getResultKeyboard() {
        return ResultKeyboard;
    }

    public void setResultKeyboard(AttentionKeyboard ResultKeyboard) {
        this.ResultKeyboard = ResultKeyboard;
    }
  
    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
