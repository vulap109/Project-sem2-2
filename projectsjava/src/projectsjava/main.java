/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsjava;

import DataControl.AutoLoadChat;
import DataControl.AutoLoadFriend;
import Frame.formchinh;

/**
 *
 * @author truon
 */
public class main {
    public static void main(String[] args){
        AutoLoadChat c= new AutoLoadChat();
        AutoLoadFriend b= new AutoLoadFriend();
        formchinh a= new formchinh();
        a.setVisible(true);
        b.start();
        c.start();
         
    }
        
}

