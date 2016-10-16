package org.eapo.stal.codingtasks.collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class TLinkedListTest {
    
    public TLinkedListTest() {
    }
   
     @Test
     public void addTest() {
     
         List list = new TLinkedList();
         assertTrue(list.size()==0);
         assertTrue(list.isEmpty()); 
         list.add("1");
         list.add("2");
         assertTrue(list.size()==2);
         assertTrue(list.contains("2"));
         assertFalse(list.contains("3"));
         assertFalse(list.contains(null));
         list.add(null);
         assertTrue(list.contains(null));
     }
     
     @Test
     public void removeTest() {
     
     class A {};
         List<A> list = new TLinkedList<>();
         A a = new A();
         list.add(a);
         assertTrue(list.remove(a));
         assertTrue(list.isEmpty() );
         assertFalse(list.remove(a));
         assertTrue(list.isEmpty() );
     
     }
     
     public void indexTest() {
        List<Integer> list = new TLinkedList<>();
        list.add(1);
        list.add(5);
        
         assertTrue(list.indexOf(5)==1);
         assertFalse(list.indexOf(1)==0);
         assertFalse(list.indexOf(7)==-1);
         
     }
     
      public void arrayTest() {
        List<Integer> list = new TLinkedList<>();
    
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(5);
       
        Integer[] expected = {1,5,5,7};
          assertTrue(list.toArray().equals(expected));
      }
     
     public static void  main(String... args){
         List<String> list = new TLinkedList<>();
         list.add("A");
         list.add("B");
         list.add("B");
         list.add("D");
         for (String s:list){
             System.out.println(s);
         }
         
         
     }
}
