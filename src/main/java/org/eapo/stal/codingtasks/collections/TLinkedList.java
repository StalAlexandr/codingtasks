package org.eapo.stal.codingtasks.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */
public class TLinkedList<T> implements List<T> {

    private int size = 0; // cash 
    Node head = null;     

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object n : this) {
            if (isEqWithNulls(n, o)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new NodeIterator(head);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size-1];
        int index=0;
        for (Object n : this) {
          arr[index++]=n;
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        size++;
        Node node = new Node(null, e);
        if (head == null) {
            head = node;
            return true;
        }
        Node tail = getTail();
        tail.setNode(node);
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (head == null) {
            return false;
        }
        Node n = head;
        Node parent = null;
        while (n != null) {

            if (isEqWithNulls(n.getData(), o)) {

                if (parent == null) {
                    head = n.getNode();
                } else {
                    parent.setNode(n.getNode());
                }
                size--;
                return true;
            }
            parent = n;
            n = n.getNode();

        }
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   for (Object o : c){
      if (!contains(o))
          return false;
   }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {

        size = 0;
        head = null;
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int indexOf(Object o) {

        int index = 0;
        for (Object d : this) {
            if (isEqWithNulls(d, o)) {
                return index;
            }
            index++;
        };
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // last Node
    private Node getTail() {
        if (head == null) {
            return null;
        }
        Node n = head;

        while (n.getNode() != null) {
            n = n.getNode();
        }
        return n;
    }

    // Эквивалентность или оба null
    private boolean isEqWithNulls(Object a, Object b) {
        return (((b == null) && (a == null)) || ((a != null) && (a.equals(b))));
    }
}

// Дерево для хранения данных
class Node<T> {

    private Node node;
    private T data;

    public Node(Node node, T data) {
        this.node = node;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

// итератор по списку
class NodeIterator<T> implements Iterator<T> {
    private Node<T> head;
    
    public NodeIterator(Node head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        Node<T> tmp = head;
        head = head.getNode();
        return tmp.getData();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    


