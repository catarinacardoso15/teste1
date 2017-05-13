/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplication;
import Model.AttentionKeyboard;
import Model.AttentionMouse;
import Model.AttentionResult;
import Model.AttentionTask;
import Model.Data;
import Model.Keyboard;
import Model.Mouse;
import Model.Rule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Catarina
 */
public class AttentionResultController {

    private AttentionResult result;

    public AttentionResultController() {
    }

    public AttentionResultController(AttentionResult result) {
        this.result = result;
    }

    public AttentionResult createAttentionResult(Data d, ArrayList<Rule> rule, double[] majorMouse, double[] majorKey) {
        result = new AttentionResult();
        result.setUser(d.getUser());
        createResultsKeyboard(d.getListKeyboard(), majorKey);
        createResultsMouse(d.getListMouse(), majorMouse);
        createResultsTask(d.getListAplication(),d.getListMouse(),d.getListKeyboard() ,d.getFinalData(), rule);
        return result;
    }

    public void createResultsTask(ArrayList<Aplication> list, ArrayList<Mouse> m,ArrayList<Keyboard>k,Date finalDate, ArrayList<Rule> rule) {
        list = TaskToAplication(list, "Tarefa", rule);
        AttentionTaskController g = new AttentionTaskController(new AttentionTask());
        ArrayList<AttentionTask> results = new ArrayList<AttentionTask>();
        AttentionTask t = g.createResultTask(list,m, k,finalDate);
        result.setKeyCount(t.getKeyC());
        result.setMouseCount(t.getMouseC());
        result.setResultTask(t);
    }

    public void createResultsMouse(ArrayList<Mouse> list, double[] majorMouse) {
        AttentionMouseController g = new AttentionMouseController(new AttentionMouse());
        AttentionMouse t = g.createMouseResult(list, majorMouse);
        result.setResultMouse(t);
    }

    public void createResultsKeyboard(ArrayList<Keyboard> list, double[] major) {
        AttentionKeyboardController g = new AttentionKeyboardController(new AttentionKeyboard());
        AttentionKeyboard t = g.createResultKeyboard(list, major);
        result.setResultKeyboard(t);
    }

    public ArrayList<Aplication> TaskToAplication(ArrayList<Aplication> list, String tarefa, ArrayList<Rule> rules) {
        int t,g;
        for (int i = 0; i < list.size(); i++) {
            t=0;
            g=0;
            int fu=0;
        
            for (int q=0;q<rules.size();q++) {
                
                switch (rules.get(q).getTipo()) {
                    case 0:
                         System.out.println("tarefa:  "+list.get(i).getName());
                        System.out.println("regra: "+rules.get(q).getNome());
                        if (list.get(i).getName().toUpperCase().contains(rules.get(q).getNome().toUpperCase())) {
                            System.out.println("passou");
                           
                           g=1;
                        }
                        t++;
                        break;
                    case 1:
                        if (list.get(i).getName().toUpperCase().startsWith(rules.get(q).getNome().toUpperCase())) {
                            t++;
                            g=1;
                        }
                        break;
                    case 2:
                        if (list.get(i).getName().toUpperCase().endsWith(rules.get(q).getNome().toUpperCase())) {
                             t++;
                             g=1;
                        }
                        break;
                    case 3:
                       
                        if (list.get(i).getName().toUpperCase().contains(rules.get(q).getNome().toUpperCase())) {
                            t++;
                            fu=1;
                             System.out.println("------------------");
                            System.out.println(list.get(i).getName());
                            System.out.println(rules.get(q).getNome());
                            System.out.println("-------------------");
                            System.out.println("nao tarefa");
                        }else{
                            System.out.println("------------------");
                            System.out.println(list.get(i).getName());
                            System.out.println(rules.get(q).getNome());
                            System.out.println("-------------------");
                          g=1;
                           t++;
                        }
                        
                        break;
                    default:
                        break;
                }

                if(t==rules.size()){
                   
                    if(g==1 && fu==0){
                        ArrayList<String>f=list.get(i).getListT();
                        f.add(tarefa);
                        list.get(i).setListT(f);
                    }
                }
                
            }
        }
        return list;
    }
   
}
