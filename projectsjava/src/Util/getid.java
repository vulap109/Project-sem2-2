/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class getid {
    public int getid( String sql) throws SQLException{
            Vector data = null;
            ketnoi kn = new ketnoi();
            ResultSet rs = kn.TruyVan(sql);
                data = new Vector();
                int id = rs.getInt("idu");             
        
            
        return id;
        
    }
}
