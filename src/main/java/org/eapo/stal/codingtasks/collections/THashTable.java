

package org.eapo.stal.codingtasks.collections;

import java.util.List;

/**
 *
 * @author Сталь А.Н. astal@eapo.org
 */
public class THashTable<K> {

    int buckets_num=100;
    int bucket_size = Integer.MAX_VALUE/buckets_num;
    List[] buckets = new TLinkedList[buckets_num];

    public THashTable(){
   
    }
    
    public void put(K key){
        int hash = key!=null?key.hashCode():0;
        int index = hash/bucket_size;
        buckets[index].add(key);

    }
    
}
