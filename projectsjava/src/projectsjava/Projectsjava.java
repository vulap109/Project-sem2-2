/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsjava;

import DataControl.AutoLoadChat;
import Frame.loginForm;

/**
 *
 * @author Admin
 */
public class Projectsjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        loginForm flogin = new loginForm();
        flogin.setVisible(true);
        AutoLoadChat au = new AutoLoadChat();
        au.run();
    }
    
}
