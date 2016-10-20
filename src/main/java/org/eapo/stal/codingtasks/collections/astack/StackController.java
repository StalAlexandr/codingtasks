/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eapo.stal.codingtasks.collections.astack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stal
 */
public class StackController<T> implements Controller {

    int ARRAYSIZE = 20;
    List<ArrayStack> stacks;

    Object[] mem = new Object[20];
    ArrayStack stack = new ArrayStack(mem, 5, false);

    public StackController() {

        Object[] memory = new Object[ARRAYSIZE];
        ArrayStack s1 = new ArrayStack(memory, 0, true);
        ArrayStack s2 = new ArrayStack(memory, 7, true);
        ArrayStack s3 = new ArrayStack(memory, 19, false);

        this.stacks = new ArrayList<>(3);

        this.stacks.add(s1);
        this.stacks.add(s2);
        this.stacks.add(s3);
        for (ArrayStack s : stacks) {
            s.setController(this);
        }

    }

    @Override
    public void recalc() {

        if (this.stacks.get(0).getSize() + this.stacks.get(1).getSize() + this.stacks.get(2).getSize() > ARRAYSIZE-1) return;
     //   System.out.println("!"+ (this.stacks.get(1).getHIndex() - this.stacks.get(0).getTIndex()));
        if (this.stacks.get(1).getHIndex() - this.stacks.get(0).getTIndex() == 1) {
                this.stacks.get(1).moveIndex(this.stacks.get(1).getHIndex() + 1);
            }
        

        if (this.stacks.get(1).getTIndex() - this.stacks.get(2).getTIndex() == 1) {
            this.stacks.get(1).moveIndex(this.stacks.get(1).getHIndex() - 1);
        }

    }

    public List<ArrayStack> getStacks() {
        return stacks;
    }

    public static void main(String[] args) {

        //    StackController sc = new StackController();
        List<ArrayStack> stacks = new StackController().getStacks();
        ArrayStack s1 = stacks.get(0);
        ArrayStack s2 = stacks.get(1);
        ArrayStack s3 = stacks.get(2);

        
        s1.push("A1");      
        s1.push("A1");
        s1.push("A1");
        s1.push("A1");
        s1.push("A1");
      s1.push("A1");
         s1.push("A1");
                s1.push("A1");
                         
        s2.push("BBB");
         s2.push("CCC");
          s1.push("A1");
           s1.push("A1");
           s1.push("A1");
           s1.push("A1");
           s1.push("A1");
             s1.push("A1");
                 s1.push("A1");
    //    s1.push("A1");
    //    s1.push("A1");

        System.out.println(s1);
     System.out.println(s2);

    }

}
