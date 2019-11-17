/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.google.gson.Gson;



/**
 *
 * @author truon
 */
public class covertJson  {
    public static contentchats parseJsonToObject(String content){
        Gson g= new Gson();
        contentchats cc= g.fromJson(content, contentchats.class);
        return cc;
    }
    public static String parseJsonString(contentchats cc){
        Gson g= new Gson();
        return g.toJson(cc);    

    }
}
