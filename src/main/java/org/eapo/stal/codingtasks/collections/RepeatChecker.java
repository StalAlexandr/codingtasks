package org.eapo.stal.codingtasks.collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */
public class RepeatChecker {

    public boolean checkString(String str) {

        if (str==null) return false;
        if (str.length()>128) return false;
        
        boolean[] b = new boolean[128]; 

        for (int i = 0; i < str.length(); i++) {
            if (b[str.charAt(i)]) {
                return true;
            }
            b[str.charAt(i)]=true;
        }
        return false;
    }
    
     public boolean checkStringWOBuffer(String str) {
        for (int i = 0; i < str.length(); i++) {
          for(int j=i+1; j<str.length(); j++)
              if(str.charAt(i)==str.charAt(j))
                  return true;
        }
        return false;
    }
    
     
     public boolean isRecombination(String a, String b){
     if ((a==null)||(b==null))  return false;
     if (a.length()!=b.length()) return false;
     
     int[] arrA = new int[128]; 
   
     for (int i=0; i<a.length(); i++){
     arrA[a.charAt(i)]++;
     arrA[b.charAt(i)]--;
     }
     
     for (int i=0; i<128; i++){
     if (arrA[i]!=0) return false;
     }
     return true;
     }
     
     
     public String spaceRemover(String str){
     
         char tmp = ' ';
     
         String value = "%20";
     
         
         StringBuilder sb = new StringBuilder();
         int start = 0;
         for (int i = 0; i< str.length();i++){
          if (str.charAt(i)==tmp){
          sb.append(str.substring(start,i)).append(value);
          start = i+1;
          }
         }
         sb.append(str.substring(start,str.length()));
         return sb.toString();
     }
}
