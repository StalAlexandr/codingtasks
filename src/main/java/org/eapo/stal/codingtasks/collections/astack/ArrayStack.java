/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eapo.stal.codingtasks.collections.astack;

/**
 *
 * @author Stal
 */
public class ArrayStack<T> {

    T[] memory;
    int hIndex;
    int reverse;
    int size;
    Controller controller;

    ArrayStack(T[] m, int b, boolean r) {
        this.memory = m;
        this.hIndex = b;
        this.reverse = r ? 1 : -1;

        size = 0;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    
    
    
  
  public boolean empty() {
        return (size == 0);
    }

    public T peek() {
      //  System.out.println("getHeadIndex()" + getHeadIndex());
        return memory[getTIndex()-1*reverse];
    }

    public T pop() {
        
        int len = getTIndex()-1*reverse;
        size--;
        System.out.println(len);
        
        if (this.controller!=null)
            this.controller.recalc();
        return memory[len];
        
        
        
    }

    public void push(T t){
     memory[getTIndex()] = t;
     size++; 
     
            if (this.controller!=null)
              this.controller.recalc();
    }
    
    protected int getTIndex() {

        return hIndex + size * reverse;
    }

     protected int getHIndex() {

        return hIndex;
    }
    
    public void moveIndex(int hIndex){
     if (size==0){
       this.hIndex = hIndex; 
       return;
     }
     int delta = hIndex-this.hIndex; 
     if (delta==0)
         return;
     
     int tIndex = getTIndex();
     int minIndex = Math.min(tIndex, this.hIndex);
     int maxIndex = Math.max(tIndex, this.hIndex);
     
        System.out.println("minIndex" + minIndex);
        System.out.println("maxIndex" + maxIndex);
          System.out.println("delta" + delta);
     if (delta > 0){
      //   System.out.println("!!!!" );
     for (int i = maxIndex-1*reverse; i>=minIndex; i--){
          
         memory[i+delta]=memory[i];
     }
     } else {
      for (int i = minIndex; i<=maxIndex; i++){
         memory[i+delta]=memory[i];
     } 
     }
       this.hIndex = hIndex; 
   
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< memory.length; i++) {
            T t = memory[i];
       //     sb.append(i).append("-");
            if (t!=null)
             sb.append(t.toString()).append(";");
            else
                sb.append("NULL").append(";");
        }
        
        sb.append(" head:").append(getHIndex()).append(" tail:").append(getTIndex());
        return sb.toString();
    }
    
    
    
    public static void main(String[] args) {
        
        Object[] mem = new Object[20];
        
        
        ArrayStack stack = new ArrayStack(mem, 5, false);
        System.out.println(stack);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        /*
        System.out.println(stack);
        System.out.println(stack.peek());
         System.out.println(stack.pop());
           System.out.println(stack);
          stack.push("C");
              stack.push("D");
                */
        System.out.println(stack);
        stack.moveIndex(stack.getHIndex()-1);
        //    stack.moveTailIndex(7);
              System.out.println(stack);
        
    }
    
    protected int getSize(){return size;}
    
}
