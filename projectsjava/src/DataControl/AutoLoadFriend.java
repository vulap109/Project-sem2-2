/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControl;

import Frame.formchinh;
import Frame.loginForm;
import Util.ConnectionSQL;
import Util.ketnoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truon
 */
public class AutoLoadFriend extends Thread {

    private int id;
    private String sql, user;
    private ConnectionSQL cnt;
    private ResultSet rs;
 
    @Override
    public void run() {
        while(true){
           autoload();
           try{
               Thread.sleep(5000);
           }catch(Exception ex){
               System.out.print(ex);
           }
        }
    }
    
    public void autoload(){
        
        cnt= new ConnectionSQL();
        user=formchinh.userName;
        sql="select idu from username where taikhoan='"+user+"'";
        rs=cnt.Query(sql);
      try{
          while(rs.next()){
              id=rs.getInt("idu");
          }
      }catch(Exception ex){
          System.out.print(ex);
      }
       sql="select taikhoan from connectuf,username where connectuf.idu="+id+" and connectuf.idf=username.idu and request= 1"; 
//       sql="select username.taikhoan from connectuf inner join username on connectuf.idf = username.idu where connectuf.request = 1 and connectuf.idu = "+id+" or connectuf.request = 1 and connectuf.idf = "+id+" ";
       String header[]={"taikhoan"};
       DefaultTableModel tblmodel= new DefaultTableModel(header,0);
       try{
            Vector data=null;
            tblmodel.setRowCount(0);
            rs=cnt.Query(sql);
            while(rs.next()){
                data= new Vector();
                data.add(rs.getString("taikhoan"));
                tblmodel.addRow(data);
            }
            formchinh.tblfriend.setModel(tblmodel);
            }catch(Exception ex){
            System.out.print(ex);
        }
    } 
}
