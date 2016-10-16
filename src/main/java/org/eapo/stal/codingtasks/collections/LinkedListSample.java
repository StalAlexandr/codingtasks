

package org.eapo.stal.codingtasks.collections;

import java.util.List;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */

class A {};

public class LinkedListSample {

    public static void main(String... args){
    
        A a = new A();
        List list = new java.util.LinkedList();
        
        list.add(null);
        list.add(null);
        list.add(a);
        list.add(a);
        
        
        System.err.println(list.size());
        System.err.println(list.contains(null));
         System.err.println(list.lastIndexOf(null));
        System.out.println(list.size());
       
         list.remove(a);
        System.out.println(list.size());
          System.out.println(list.remove(a));
        System.out.println(list.size());
         list.remove(a);
          System.out.println(list.remove(a));
         
      //    System.out.println(list.get(100));
          
    }
    
}
