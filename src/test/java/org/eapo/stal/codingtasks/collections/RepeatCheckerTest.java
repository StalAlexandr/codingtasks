package org.eapo.stal.codingtasks.collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RepeatCheckerTest {
    
     @Test
     public void checkTest() {
         RepeatChecker rc = new RepeatChecker();
         assertFalse(rc.checkString("asdfgh"));
         assertTrue(rc.checkString("asdafgh"));
     }
     
     @Test
     public void checkWOBufferTest() {
         RepeatChecker rc = new RepeatChecker();
         assertFalse(rc.checkStringWOBuffer("asdfgh"));
         assertTrue(rc.checkStringWOBuffer("asdafgh"));
     }
     
     @Test
     public void checkRecombinarionTest() {
         RepeatChecker rc = new RepeatChecker();
         assertFalse(rc.isRecombination("asdfgh", "assdff"));
         assertFalse(rc.isRecombination("asdfgh", "asdasd"));
         assertTrue(rc.isRecombination("asdfgh", "fghasd"));
        
     }
     
     
     @Test
     public void spaceRemoverTest() {
         RepeatChecker rc = new RepeatChecker();
         assertTrue(rc.spaceRemover("asd dfg").equals("asd%20dfg"));
         assertTrue(rc.spaceRemover("asddfg ").equals("asddfg%20"));
         assertTrue(rc.spaceRemover(" asddfg ").equals("%20asddfg%20"));
         
         
     }
        @Test
     public void isOneStepTest() {
      RepeatChecker rc = new RepeatChecker();
  
         assertTrue(rc.isOneStep("a", "a"));
     assertTrue(rc.isOneStep("a", "b"));
     assertTrue(rc.isOneStep("ab", "b"));     
    assertFalse(rc.isOneStep("abc", "cba"));     
     assertFalse(rc.isOneStep("abc", "cba"));     
     
     }
     
}
