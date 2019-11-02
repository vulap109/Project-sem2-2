/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ketnoi {
    //Noon very super pro vip
    private static Connection conn;
    private static PreparedStatement stmt;
    public void KetNoiCSDL()
    {
        try
        {
            String dbURL = "jdbc:sqlserver://ProjectSem2.mssql.somee.com;packetsize=4096;user=chaunoon_SQLLogin_1;password=yrdjdkvkw8";
            conn = DriverManager.getConnection(dbURL);
            if(conn!=null)
            {
                System.out.println("Ket noi thanh cong");
            }          
        }
        catch(SQLException ex)
        {
            System.out.println("Loi ket noi:" + ex);
        }
    }
    public ResultSet TruyVan(String sql)
    {
        ResultSet rs = null;
        try
        {
            KetNoiCSDL();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println("Loi truy van:" + ex);
        }
        return rs;
    }
    public void CapNhat(String sql)
    {
        try
        {
            KetNoiCSDL();
            stmt = conn.prepareStatement(sql);
            int row = stmt.executeUpdate();
            if(row==1) System.out.println("Thanh cong");
            stmt.close();
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Loi cap nhat:" + ex);
        }
    }
}
