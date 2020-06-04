/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokens;


/**
 *
 * @author andre
 */
public class DameToken {
    public void Token(String[] s){
        AFN afn = new AFN();
        Token aux = null;
        int c = 0;
        
        for (int i = 0; i < s.length; i++) {
            while(aux == null){
                if(afn.afnToken(s[i], c) == null);
            }
        }
    }
}
