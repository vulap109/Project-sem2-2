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
public class AutoLoadFriend extends Thread {

    private String sql,user,friend;
    private int idu, idf;
    private ResultSet rs;
    ketnoi kn= new ketnoi();
    @Override
    public void run() {
      while(true){
          Loaddata();
          try{
              Thread.sleep(5000);
          }catch(Exception e){
              System.out.print(e);
          }
      }
    }
   public void Loaddata(){
      
       //user= formchinh.userName;
       //friend= formchinh.CurrentFriend;
       //lay idu cua user trong bang taikhoan s e noi ko dk
       sql="select idu  from username where taikhoan='"+user+"'";
       rs= kn.TruyVan(sql);
        try {
            while(rs.next()){
                idu=rs.getInt("idu");
            } } catch (SQLException ex) {
            Logger.getLogger(AutoLoadChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        // lay idu cua friend trong bang taikhoan
       sql="select idf from connectuf where idu="+idu+"";
       kn.TruyVan(sql);
       try {
            while(rs.next()){
                idf=rs.getInt("idu");
            } } catch (SQLException ex) {
            Logger.getLogger(AutoLoadChat.class.getName()).log(Level.SEVERE, null, ex);
        }
       // su dung 2 idu de lay ra content tai bang connectuf
       sql="select taikhoan from username where idf="+idf+"";
       rs= kn.TruyVan(sql);
       // lay content va load len o noi dung chat chinh 
       try {
            while(rs.next()){
                friend=rs.getString("contentchat");
                formchinh.txtareboxchat.setText(friend);
                System.out.println("--------------");
            }} catch (SQLException ex) {
            Logger.getLogger(AutoLoadChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
