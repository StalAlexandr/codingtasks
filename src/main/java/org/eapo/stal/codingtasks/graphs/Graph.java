/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eapo.stal.codingtasks.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Alexandr Stal astal@eapo.org; al_stal@mail.ru
 */
public class Graph {

    private final String name;
    private final Set<Graph> childs;

    public Graph(String name) {
        this.name = name;
        this.childs = new HashSet<>();
    }

    public Set<Graph> getChilds() {
        return this.childs;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Graph other = (Graph) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isLinkWidth(Graph a, Graph b) {
        Queue<Graph> list = new LinkedList<>();
        list.add(a);

        HashSet<Graph> set = new HashSet<>();
      
        while (!list.isEmpty()) {
            Graph g = list.poll();
            if (!set.contains(g)) {
                set.add(g);
                if (g.getName().equals(b.getName())) {
                    return true;
                }
                list.addAll(g.getChilds()); 
            }
        }
        return false;
    }

    public static boolean isLinkHeight(Graph a, Graph b, Set visited) {
       
        if (visited.contains(a))
            return false;

       visited.add(a);
        
        if (a.equals(b))
            return true;
        
        for (Graph g: a.getChilds()){
            if (isLinkHeight(g,b,visited))
                return true;    
        }
        return false;
    }

    
    
    public static void main(String[] args) {

        Graph a = new Graph("a");
        Graph b = new Graph("b");
        Graph c = new Graph("c");
        Graph d = new Graph("d");

        Graph e = new Graph("e");
        Graph f = new Graph("f");
        Graph g = new Graph("j");
        Graph h = new Graph("h");

        a.getChilds().add(b);
        b.getChilds().add(c);
        b.getChilds().add(a);
        b.getChilds().add(d);
        
        d.getChilds().add(e);
        e.getChilds().add(g);
  
        System.out.println(isLinkWidth(a, h));    
        System.out.println(isLinkHeight(a, h, new HashSet()));

        e.getChilds().add(h);

        System.out.println(isLinkWidth(a, h));    
        System.out.println(isLinkHeight(a, h, new HashSet()));


    }

}
