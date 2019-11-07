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
public class contentchat {
    //public int id1,id2;
    public String content;

    public int id;

    public contentchat() {
    }

//<<<<<<< HEAD:projectsjava/src/Util/contentchat.java
    public contentchat(String content, String date) {}
//=======
    public contentchat(String content, int id) {
//>>>>>>> 9d5887f098cf8bca32268eb3034b20d1d5a409f6:projectsjava/src/Util/contenchat.java
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
