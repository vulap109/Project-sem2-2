/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DataControl.AutoLoadChat;
import DataControl.AutoLoadFriend;

/**
 *
 * @author truon
 */
public class projectsJava {
    public static void main(String[] args){
        AutoLoadChat c= new AutoLoadChat();
        AutoLoadFriend b= new AutoLoadFriend();
        formchinh a= new formchinh();
        a.setVisible(true);
       while(true){ 
        b.start();
       if(formchinh.txtnamefriend!=null){
           break;
       }
       }
        c.start();
         
    }
        
}

