/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DataControl.autoLoadFriendList;

/**
 *
 * @author truon
 */
public class main {
    public static void main(String[] args){
       
        formchinh b= new formchinh();
        b.setVisible(true);
         autoLoadFriendList a= new autoLoadFriendList();
        a.start();
    }
}
