/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Admin
 */
public class contenchat {
    //public int id1,id2;
    public String content;

    public int id;

    public contenchat() {
    }

    public contenchat(String content, int id) {
        this.content = content;
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "contenchat{" + "content=" + content + ", id=" + id + '}';
    }
    

    

    
    
}
