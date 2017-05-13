/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Catarina
 */
import Controller.AttentionResultController;
import Controller.DataController;
import Model.AttentionResult;
import Model.Data;
import Model.Keyboard;
import Model.Mouse;
import Model.Rule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/classifier")
public class Teste extends HttpServlet{
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String dados() throws IOException {
        DataController controller = new DataController();
        Date i = new Date(63615324300000l);
        Date f = new Date(63615329418696l);
        f.setYear(f.getYear()-1969);
        i.setYear(i.getYear()-1969);
        controller.createData(i, f);
        ArrayList<Data> d = controller.getData();
        AttentionResultController t = new AttentionResultController();
        ArrayList<AttentionResult> allResults = new ArrayList<AttentionResult>();

        HashMap<String, ArrayList<Mouse>> m = new HashMap<String, ArrayList<Mouse>>();
        HashMap<String, ArrayList<Keyboard>> k = new HashMap<String, ArrayList<Keyboard>>();
        for (Data e : d) {
            m.put(e.getUser(), e.getListMouse());
            k.put(e.getUser(), e.getListKeyboard());
        }
        ArrayList<Rule> rule = new ArrayList<Rule>();
        JSONParser parser = new JSONParser();
        JSONObject r=new JSONObject();
//        try {
//            r=(JSONObject)parser.parse(rules);
//  
//        } catch (ParseException ex) {
//            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //JSONArray arr=(JSONArray) r.get("Rules");
        for(int j=0;j<1;j++){
            rule.add(new Rule("YouTube",3));
       }
        double[] mKey = majorValueKeyboard(k);
        double[] mMouse = majorValueMouse(m);
        
        for (Data e : d) {
            AttentionResult results = t.createAttentionResult(e, rule, mMouse, mKey);
            allResults.add(results);
        }
        System.out.println("Resposta");
        return createResponse(i, f, allResults).toJSONString();
       
    }
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String dados(@FormParam("DataInicial") String di, @FormParam("DataFinal") String df, @FormParam("Json") String rules, @Context HttpServletResponse servletResponse) throws IOException {
        DataController controller = new DataController();
        Date i = new Date(Long.parseLong(di));
        Date f = new Date(Long.parseLong(df));
        controller.createData(i, f);
        ArrayList<Data> d = controller.getData();
        AttentionResultController t = new AttentionResultController();
        ArrayList<AttentionResult> allResults = new ArrayList<AttentionResult>();

        HashMap<String, ArrayList<Mouse>> m = new HashMap<String, ArrayList<Mouse>>();
        HashMap<String, ArrayList<Keyboard>> k = new HashMap<String, ArrayList<Keyboard>>();
        for (Data e : d) {
            m.put(e.getUser(), e.getListMouse());
            k.put(e.getUser(), e.getListKeyboard());
        }
        ArrayList<Rule> rule = new ArrayList<Rule>();
        JSONParser parser = new JSONParser();
        JSONObject r=new JSONObject();
        try {
            r=(JSONObject)parser.parse(rules);
  
        } catch (ParseException ex) {
            System.out.println("ERROOOOOOOOOOOOOOOO");
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONArray arr=(JSONArray) r.get("Rules");
            for(int j=0;j<arr.size();j++){
            Object fd=arr.get(j);
            JSONObject v=(JSONObject) fd;
            String nome=(String) v.get("Nome");System.out.println("nome: "+nome);
            long tipo=(Long)v.get("Tipo");System.out.println("tipo: "+tipo);
            rule.add(new Rule(nome,(int)tipo));
            
       }
        
        System.out.println("SOUT "+rule.size());
        double[] mKey = majorValueKeyboard(k);
        double[] mMouse = majorValueMouse(m);
        
        for (Data e : d) {
            System.out.println(e.getUser());
            
            AttentionResult results = t.createAttentionResult(e, rule, mMouse, mKey);
            
            allResults.add(results);
        }
        System.out.println("dddddddddddd");
        return createResponse(i, f, allResults).toJSONString();
    }

    
    public double[] majorValueMouse(HashMap<String, ArrayList<Mouse>> list) {
        double[] major = new double[8];
        for (int i = 0; i < 8; i++) {
            major[i] = 0.0;
        }
        for (String key : list.keySet()) {
            double[] major1 = gMouse(list.get(key));
            if (major[0] < major1[0]) {
                major[0] = major1[0];
            }
            if (major[1] < major1[1]) {
                major[1] = major1[1];
            }
            if (major[2] < major1[2]) {
                major[2] = major1[2];
            }
            if (major[3] < major1[3]) {
                major[3] = major1[3];
            }
            if (major[4] < major1[4]) {
                major[4] = major1[4];
            }
            if (major[5] < major1[5]) {
                major[5] = major1[5];
            }
            if (major[6] < major1[6]) {
                major[6] = major1[6];
            }
            if (major[7] < major1[7]) {
                major[7] = major1[7];
            }

        }

        return major;
    }

    public double[] majorValueKeyboard(HashMap<String, ArrayList<Keyboard>> list) {
        double[] major = new double[2];
        major[0] = 0.0;
        major[1] = 0.0;

        for (String key : list.keySet()) {
            double[] major1 = gkeyboard(list.get(key));
            if (major[0] < major1[0]) {
                major[0] = major1[1];
            }
            if (major[1] < major1[1]) {
                major[1] = major1[1];
            }
        }

        return major;
    }

    public double[] gMouse(ArrayList<Mouse> a) {

        double[] major = new double[8];

        for (int i = 0; i < a.size(); i++) {
            major[0] += a.get(i).getMa();
            major[1] += a.get(i).getMv();
            major[2] += a.get(i).getCd();
            major[3] += a.get(i).getDbc();
            major[4] += a.get(i).getDdc();
            major[5] += a.get(i).getDplbc();
            major[6] += a.get(i).getTbc();
            major[7] += a.get(i).getTdc();
        }
        major[0] = major[0] / a.size();
        major[1] = major[1] / a.size();
        major[2] = major[2] / a.size();
        major[3] = major[3] / a.size();
        major[4] = major[4] / a.size();
        major[5] = major[5] / a.size();
        major[6] = major[6] / a.size();
        major[7] = major[7] / a.size();
        return major;
    }

    public double[] gkeyboard(ArrayList<Keyboard> a) {
        double[] major = new double[2];

        for (int i = 0; i < a.size(); i++) {
            major[0] += a.get(i).getKdt();
            major[1] += a.get(i).getTbk();

        }
        major[0] = major[0] / a.size();
        major[1] = major[1] / a.size();

        return major;
    }
    
    public JSONObject createResponse(Date i, Date f, ArrayList<AttentionResult> allResults) {

        JSONObject object = new JSONObject();
        object.put("datai", i.getTime());
        object.put("dataf", f.getTime());
        
        JSONObject turma= new JSONObject();
        double ativity=0.0;
        double other=0.0;
        double utilizacao=0.0;
        JSONArray alunos = new JSONArray();
        for (AttentionResult r : allResults) {
            JSONObject aluno = new JSONObject();
            aluno.put("user", r.getUser());
            //JSONObject objectd = new JSONObject();
            aluno.put("mCount", r.getMouseCount());
            aluno.put("kCount", r.getKeyCount());
            
            JSONObject objectTask = new JSONObject();
            
            //int mouseCount = (int)aux.get("mCount");
           // int mouseKey= (int)aux.get("kCount");
            objectTask.put("AllTime", r.getResultTask().getTimeActivity());
           
            objectTask.put("TimeApp", r.getResultTask().getTimeAplication());
            objectTask.put("PercenApp", r.getResultTask().getPercentagemAplication());
            objectTask.put("TimeOther", r.getResultTask().getTimeOther());
            objectTask.put("PercenOther", r.getResultTask().getPercentagemOther());
            aluno.put("task", objectTask);

            JSONObject objectMouse = new JSONObject();
            objectMouse.put("cd", r.getResultMouse().getMediaCD());
            objectMouse.put("PercenCd", r.getResultMouse().getpCD());
            objectMouse.put("dbc", r.getResultMouse().getMediaDBC());
            objectMouse.put("PercenDbc", r.getResultMouse().getpDBC());
            objectMouse.put("ddc", r.getResultMouse().getMediaDDC());
            objectMouse.put("PercenDdc", r.getResultMouse().getpDDC());
            objectMouse.put("dplbc", r.getResultMouse().getMediaDPLBC());
            objectMouse.put("PercenDplbc", r.getResultMouse().getpDPLBC());
            objectMouse.put("ma", r.getResultMouse().getMediaMA());
            objectMouse.put("PercenMA", r.getResultMouse().getpMA());
            objectMouse.put("mv", r.getResultMouse().getMediaMV());
            objectMouse.put("PercenMv", r.getResultMouse().getpMV());
            objectMouse.put("tbc", r.getResultMouse().getMediaTBC());
            objectMouse.put("PercenTbc", r.getResultMouse().getpTBC());
            objectMouse.put("tdc", r.getResultMouse().getMediaTDC());
            objectMouse.put("PercenTdc", r.getResultMouse().getpTDC());
            aluno.put("mouse", objectMouse);

            JSONObject objectKey = new JSONObject();
            objectKey.put("kdt", r.getResultKeyboard().getMediaKDT());
            objectKey.put("PercenKdt", r.getResultKeyboard().getpKDT());
            objectKey.put("tbk", r.getResultKeyboard().getMediaTBK());
            objectKey.put("PercenTbk", r.getResultKeyboard().getpTBK());
            aluno.put("key", objectKey);
            alunos.add(aluno);
            
            ativity+=r.getResultTask().getPercentagemAplication();
            other+=r.getResultTask().getPercentagemOther();
            utilizacao+=r.getResultTask().getTimeActivity();
           
        }
        turma.put("percentagemApp",ativity/allResults.size());
        turma.put("percentagemOther",other/allResults.size());
        turma.put("time",utilizacao/allResults.size());
        
        object.put("Turma",turma);
        object.put("results", alunos);
        return object;
    }
}
