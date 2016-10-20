/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.eapo.stal.codingtasks.collections;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alexandr Stal astal@eapo.org; al_stal@mail.ru
 */
public class StackPrimary {
    
    public LinkedList<Integer> orderList(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        
        while (!s1.isEmpty()) {
            Integer tmp = s1.pop();            
            if (!s2.isEmpty()) {
                if (s2.peek() < tmp) {
                    s1.push(s2.pop());
                }
                            
            } 
              s2.push(tmp);  
        }
        
        System.out.println("s2" + s2);
        
        return s2;
    }
    
}
