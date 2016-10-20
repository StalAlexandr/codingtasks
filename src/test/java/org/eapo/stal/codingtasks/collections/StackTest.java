/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.eapo.stal.codingtasks.collections;

import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alexandr Stal
 * astal@eapo.org; al_stal@mail.ru
 */
public class StackTest {

   
    @Test
    public void testPrimaryStack(){
    
        StackPrimary sp = new StackPrimary();
        
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(7);
        s1.push(5);
        s1.push(0);
        s1.push(9);
        
        assertEquals(sp.orderList(s1).pop(),new Integer(0)) ; 
        
        
    
    };
    
}
