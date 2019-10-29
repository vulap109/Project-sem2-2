/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Frame.formchinh;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Admin
 */
public class contentchats {
    private List<contenchat> ctc = new ArrayList<contenchat>();
    
    public List<contenchat> getCtc() {
        return ctc;
    }

    public void setCtc(List<contenchat> ctc) {
        this.ctc = ctc;
    }
    
    public void getcontent(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String content, dat;
        
        dat=formatter.format(date);
        content = formchinh.txtsend.getText();
        //id1 = Integer.parseInt(formchinh.)
        
        ctc.add(new contenchat(dat, content));        
    }
}
