

package org.eapo.stal.codingtasks.collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */
public class LinkedPolygonTest {

    @Test
    public void linkedPolygonTest(){
        
        TLinkedList list = new TLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        
        Chapter1Tasks rc = new Chapter1Tasks();
        
        assertTrue(rc.isListPolynome(list));
   
             list.add(1);
        assertFalse(rc.isListPolynome(list));
     
        
    }
    
}
