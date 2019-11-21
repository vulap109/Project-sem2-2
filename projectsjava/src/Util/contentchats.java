/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Frame.formchinh;
import static Frame.formcontacts.tblmkb;
import Frame.formtimkiem;
import static Frame.loginForm.txtuser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;


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
        String cc ="", sql;
        int id = 0;
//        sql="select idu from username where  taikhoan = '"+loginForm.txtuser.getText()+"' ";        
//        getid gid = new getid();        
//        id = gid.getid(sql);
        cc = formchinh.txtsend.getText();
        
        covertJson cj= new covertJson();
  //      cj.parseJsonToObject(cc);
        //id1 = Integer.parseInt(formchinh.)
        
        
        //formchinh.txttext.setText(ctc);
//        for(contentchat s: ctc)
//            System.out.println(s);

        
        
        String friend, user;
        int idf = 0,idu = 0;
        ketnoi kn = new ketnoi();
        friend = formchinh.txtnamefriend.getText();
        sql = "select idu from username where taikhoan  = '"+friend+"'";
        ResultSet rs = kn.TruyVan(sql);
        try {
            while (rs.next())
            {
                idf = rs.getInt("idu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formtimkiem.class.getName()).log(Level.SEVERE, null, ex);
        }
   //     ctc.add(new contentchat(cc,idu)); 
        user  = txtuser.getText();
        sql = "select idu from username where taikhoan  = '"+user+"'";
        rs = kn.TruyVan(sql);
        try {
            while (rs.next())
            {
                idu = rs.getInt("idu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formtimkiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "update connectuf set contentchat = '"+user+":"+" "+cc+"' where idu = "+idu+" and idf = "+idf+" or idu="+idf+" and idf="+idu+"";;;;
        kn.CapNhat(sql);
        
        
        
    }
//>>>>>>> 9d5887f098cf8bca32268eb3034b20d1d5a409f6
}
