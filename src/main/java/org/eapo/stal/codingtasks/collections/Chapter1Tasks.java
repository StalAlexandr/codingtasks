package org.eapo.stal.codingtasks.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */
public class Chapter1Tasks {

    /* 1.1.1*/
    public boolean checkString(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() > 128) {
            return false;
        }

        boolean[] b = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            if (b[str.charAt(i)]) {
                return true;
            }
            b[str.charAt(i)] = true;
        }
        return false;
    }

    /* 1.1.2*/
    public boolean checkStringWOBuffer(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* 1.2*/
    public boolean isRecombination(String a, String b) {
        if ((a == null) || (b == null)) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }

        int[] arrA = new int[128];

        for (int i = 0; i < a.length(); i++) {
            arrA[a.charAt(i)]++;
            arrA[b.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (arrA[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* 1.3*/
    public String spaceRemover(String str) {

        char tmp = ' ';

        String value = "%20";

        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tmp) {
                sb.append(str.substring(start, i)).append(value);
                start = i + 1;
            }
        }
        sb.append(str.substring(start, str.length()));
        return sb.toString();
    }

    /* 1.5*/
    public boolean isOneStep(String strA, String strB) {
        if ((strA == null) || (strB == null)) {
            return false;
        }
        String minStr;
        String maxStr;

        if (strA.length() <= strB.length()) {
            minStr = strA;
            maxStr = strB;
        } else {
            minStr = strB;
            maxStr = strA;
        }

        if (maxStr.length() - minStr.length() > 1) {
            return false;
        }

        int step = 0;

        if (maxStr.length() == minStr.length()) {
            for (int i = 0; i < minStr.length(); i++) {
                if (minStr.charAt(i) != maxStr.charAt(i)) {
                    step++;
                }
                if (step > 1) {
                    return false;
                }
            }
        } else {
            int j = 0;

            for (int i = 0; i < minStr.length(); i++) {
                if (minStr.charAt(i) != maxStr.charAt(j)) {
                    step++;
                    j++;
                }
                if (step > 1) {
                    return false;
                }
                j++;
            }

        }

        return true;
    }

    /* 1.4*/
    public boolean isPalyndromeRepl(String s) {
        String str = s.toLowerCase();
        int[] counter = new int[256];

        int spaceCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCounter++;
            }
            counter[str.charAt(i)]++;
        }

        boolean even = ((str.length() - spaceCounter) % 2 == 0);
        int oddCounter = 0;

        for (char i = 0; i < 256; i++) {
            if (i == ' ') {
                continue;
            }
            if (counter[i] % 2 == 1) {
                oddCounter++;
            }
            //   System.err.println("oddCounter " + oddCounter);
            if (even && oddCounter > 0) {
                return false;
            }
            if (oddCounter > 1) {
                return false;
            }
        }

        return true;
    }

    public String zipper(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() == 0) {
            return "";
        }

        int i = 0;
        char currentChar = str.charAt(i);
        int replCount = 1;

        while (i < str.length()) {

            replCount++;
            if ((currentChar != str.charAt(i)) || (i == str.length() - 1)) {
                sb.append(currentChar);
                if (replCount > 1) {
                    sb.append(replCount);
                }
            }
            i++;
        }
        return sb.length() < str.length() ? sb.toString() : str;
    }

    boolean isListPolynome(TLinkedList list) {
        Node node = list.getHead();
        int length = list.size();

        return recPolynom(node, length).result;
    }

    private Result recPolynom(Node node, int length) {
  
        if (length == 0) {
            return new Result(node, true);
        }
        if (length == 1) {
            return new Result(node.getNode(), true);
        }

        Result res = recPolynom(node.getNode(), length - 2);
        if (res.result == false) {
            return res;
        }

        if (!res.node.getData().equals(node.getData())) {
            return new Result(node, false);
        }
        return new Result(res.node.getNode(), true);
    }

    class Result {

        Node node;
        boolean result;

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }

    }
}
