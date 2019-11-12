/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControl;

import Frame.formchinh;
import Frame.loginForm;
import Util.ConnectionSQL;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truon
 */
public class autoLoadFriendList extends Thread{
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
        user=loginForm.txtuser.getText();
        sql="select idu from username where taikhoan='"+user+"'";
        rs=cnt.Query(sql);
      try{
          while(rs.next()){
              id=rs.getInt("idu");
          }
      }catch(Exception ex){
          System.out.print(ex);
      }
       sql="select taikhoan from connectuf,username where idu="+id+" and connectuf.idf=username.idu"; 
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
            formchinh.friendlist.setModel(tblmodel);
            }catch(Exception ex){
            System.out.print(ex);
        }
    } 
}
