/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AttentionMouse;
import Model.Keyboard;
import Model.Mouse;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Catarina
 */
public class AttentionMouseController {

    private AttentionMouse mouse;

    public AttentionMouseController() {
    }

    public AttentionMouseController(AttentionMouse mouse) {
        this.mouse = mouse;
    }

    public AttentionMouse createMouseResult(ArrayList<Mouse> p, double[] major) {
        mouse = new AttentionMouse();
        double[] m = media(p);
        mouse.setMediaMA(m[0]);
        if (m[0] >= major[0]) {
            mouse.setpMA(100);
        } else {
            mouse.setpMA((m[0] * 100) / major[0]);
        }
        mouse.setMediaMV(m[1]);
        if (m[1] >= major[1]) {
            mouse.setpMV(100);
        } else {
            mouse.setpMV((m[1] * 100) / major[1]);
        }
        mouse.setListMouse(p);
        mouse.setMediaCD(m[2]);
        if (m[2] >= major[2]) {
            mouse.setpCD(100);
        } else {
            mouse.setpCD((m[2] * 100) / major[2]);
        }
        mouse.setMediaDBC(m[3]);
        if (m[3] >= major[3]) {
            mouse.setpDBC(100);
        } else {
            mouse.setpDBC((m[3] * 100) / major[3]);
        }
        mouse.setMediaDDC(m[4]);
        if (m[4] >= major[4]) {
            mouse.setpDDC(100);
        } else {
            mouse.setpDDC((m[4] * 100) / major[4]);
        }
        mouse.setMediaDPLBC(m[5]);
        if (m[5] >= major[5]) {
            mouse.setpDPLBC(100);
        } else {
            mouse.setpDPLBC((m[5] * 100) / major[5]);
        }
        mouse.setMediaTBC(m[6]);
        if (m[6] >= major[6]) {
            mouse.setpTBC(100);
        } else {
            mouse.setpTBC((m[6] * 100) / major[6]);
        }
        mouse.setMediaTDC(m[7]);
        if (m[7] >= major[7]) {
            mouse.setpTDC(100);
        } else {
            mouse.setpTDC((m[7] * 100) / major[7]);
        }
        return mouse;
    }

    public double[] media(ArrayList<Mouse> p) {
        double[] media = new double[8];
        for (int i = 0; i < p.size(); i++) {
            media[0] = media[0] + p.get(i).getMa();
            media[1] = media[1] + p.get(i).getMv();
            media[2] = media[2] + p.get(i).getCd();
            media[3] = media[3] + p.get(i).getDbc();
            media[4] = media[4] + p.get(i).getDdc();
            media[5] = media[5] + p.get(i).getDplbc();
            media[6] = media[6] + p.get(i).getTbc();
            media[7] = media[7] + p.get(i).getTdc();
        }
        int i;
        for (i = 0; i < media.length; i++) {
            media[i] = media[i] / p.size();
        }
        return media;

    }

}
