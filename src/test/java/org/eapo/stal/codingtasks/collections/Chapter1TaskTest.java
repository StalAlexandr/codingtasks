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
public class Chapter1TaskTest {

    @Test
    public void checkTest() {
        Chapter1Tasks rc = new Chapter1Tasks();
        assertFalse(rc.checkString("asdfgh"));
        assertTrue(rc.checkString("asdafgh"));
    }

    @Test
    public void checkWOBufferTest() {
        Chapter1Tasks rc = new Chapter1Tasks();
        assertFalse(rc.checkStringWOBuffer("asdfgh"));
        assertTrue(rc.checkStringWOBuffer("asdafgh"));
    }

    @Test
    public void checkRecombinarionTest() {
        Chapter1Tasks rc = new Chapter1Tasks();
        assertFalse(rc.isRecombination("asdfgh", "assdff"));
        assertFalse(rc.isRecombination("asdfgh", "asdasd"));
        assertTrue(rc.isRecombination("asdfgh", "fghasd"));

    }

    @Test
    public void spaceRemoverTest() {
        Chapter1Tasks rc = new Chapter1Tasks();
        assertTrue(rc.spaceRemover("asd dfg").equals("asd%20dfg"));
        assertTrue(rc.spaceRemover("asddfg ").equals("asddfg%20"));
        assertTrue(rc.spaceRemover(" asddfg ").equals("%20asddfg%20"));

    }

    @Test
    public void isOneStepTest() {
        Chapter1Tasks rc = new Chapter1Tasks();

        assertTrue(rc.isOneStep("a", "a"));
        assertTrue(rc.isOneStep("a", "b"));
        assertTrue(rc.isOneStep("ab", "b"));
        assertFalse(rc.isOneStep("abc", "cba"));
        assertFalse(rc.isOneStep("abc", "cba"));
        assertTrue(rc.isOneStep("abcaabc", "abcdabc"));
        assertFalse(rc.isOneStep("abcaabc", "abcdabca"));
        assertTrue(rc.isOneStep("", ""));

    }

    @Test
    public void isPalTest() {
        Chapter1Tasks rc = new Chapter1Tasks();
        assertTrue(rc.isPalyndromeRepl("AAA"));
        assertTrue(rc.isPalyndromeRepl("B"));
        assertTrue(rc.isPalyndromeRepl("AB AB ")); 
        assertTrue(rc.isPalyndromeRepl("ABC AB ")); 
        assertFalse(rc.isPalyndromeRepl("ABC ABD ")); 

    }

      @Test
    public void zipperTest() {
    Chapter1Tasks rc = new Chapter1Tasks();
    assertTrue(rc.zipper("A").equals("A"));
    assertTrue(rc.zipper("AA").equals("A2"));
    assertTrue(rc.zipper("ABBBCDDDDDE").equals("AB3CD4E"));
    
    
    
    
    
      
    }
}
