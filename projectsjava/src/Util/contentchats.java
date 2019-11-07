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
    private List<contentchat> ctc = new ArrayList<contentchat>();
    
    public List<contentchat> getCtc() {
        return ctc;
    }

    public void setCtc(List<contentchat> ctc) {
        this.ctc = ctc;
    }
    
//<<<<<<< HEAD
    
//=======
    public void getcontent(){
        String content, sql;
        int id = 0;
//        sql="select idu from username where  taikhoan = '"+loginForm.txtuser.getText()+"' ";        
//        getid gid = new getid();        
//        id = gid.getid(sql);
        content = formchinh.txtsend.getText();
        //id1 = Integer.parseInt(formchinh.)
        
        ctc.add(new contentchat(content,id)); 
        //formchinh.txttext.setText(ctc);
        for(contentchat s: ctc)
            System.out.println(s);
        
    }
//>>>>>>> 9d5887f098cf8bca32268eb3034b20d1d5a409f6
}
