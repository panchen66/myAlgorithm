package com.panchen.myAlgorithm.bigData;


/**
 * hashMap hash()
 *
 * @author pc
 *
 */
public class Hash {
    
    
    
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
