/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControl;

import Frame.formchinh;
import Frame.loginForm;
import Util.ketnoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author truon
 */
public class Autoload extends Thread {
    private String sql,user,friend, content;
    private int idu, idf;
    private loginForm lg;
    private formchinh mainf;
    private ResultSet rs;
    ketnoi kn= new ketnoi();
    @Override
    public void run() {
      try{ 
        while(true){
        Loaddata();
       }}catch(Exception e){
          System.out.print(e);     
               }
    }
   public void Loaddata(){
      
       user= formchinh.userName;
       friend= formchinh.CurrentFriend;
       //lay idu cua user trong bang taikhoan s e noi ko dk
       sql="select idu  from username where taikhoan='"+user+"'";
       rs= kn.TruyVan(sql);
        try {
            while(rs.next()){
                idu=rs.getInt("idu");
            } } catch (SQLException ex) {
            Logger.getLogger(Autoload.class.getName()).log(Level.SEVERE, null, ex);
        }
        // lay idu cua friend trong bang taikhoan
       sql="select idu from username where taikhoan='"+friend+"'";
       kn.TruyVan(sql);
       try {
            while(rs.next()){
                idf=rs.getInt("idu");
            } } catch (SQLException ex) {
            Logger.getLogger(Autoload.class.getName()).log(Level.SEVERE, null, ex);
        }
       // su dung 2 idu de lay ra content tai bang connectuf
       sql="select contentchat from connectuf where idu="+idu+" and idf="+idf+"";
       rs= kn.TruyVan(sql);
       // lay content va load len o noi dung chat chinh 
       try {
            while(rs.next()){
                content=rs.getString("contentchat");
                mainf.txttext.setText(content);
            }} catch (SQLException ex) {
            Logger.getLogger(Autoload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }
