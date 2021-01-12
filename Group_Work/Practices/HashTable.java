import java.util.*;

/**
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 */
public class HashTable {

    /**
     * we created a hashmap that counts the apparence of each number 
     * and check in the end which number only appeared once.
     * 
     * @param nums the list numbers which the single number is in
     * @return the number that only appeared once
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // the map that track the apparence
    
        for(int num : nums) { // loop through the array and track the apparence of each number
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // second loop that returns the single number
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // error checking
        return 0;
    } 

    /**
     * we created a hashmap that counts the apparence of each number 
     * and check in the end which number only appeared once.
     * 
     * So we copypasted from our last method.
     * 
     * @param nums the list numbers which the single number is in
     * @return the number that only appeared once
     */
    public int singleNumberII(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // the map that track the apparence
    
        for(int num : nums) { // loop through the array and track the apparence of each number
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // second loop that returns the single number
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // error checking
        return 0;
    } 

    /**
     * we add all the ASCII code of chars in t to an integer
     * and remove all the ASCII code of chars in s to it; 
     * then we return the letter corresponding to that integer with ASCII.
     * 
     * 
     * @param s the original string
     * @param t the mixed string.
     * @return the extra letter in t that is not in s
     */
    // Eashver did this and he is a genius
    public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length()); // the tracking integer
        for(int i=0;i < s.length();++i){ 
            charCode -= (int)s.charAt(i);
            charCode += (int)t.charAt(i);
        }
        return (char)charCode;
    }

    class MyHashSet {

        private final double RATIO = 0.75;
        private HashEntry[] elementData;
        private int size;
        /** Initialize your data structure here. */
        public MyHashSet() {
            elementData = new HashEntry[10];
            size = 0;
        }
        
        public void add(int key) {

            if (!contains(key)) {
                if ((1.0 * size / elementData.length) >= RATIO) {
                    rehash();
                }
                // insert new value at front of list
                int bucket = hashFunction(key);
                elementData[bucket] = new HashEntry(key, elementData[bucket]);
                size++;
            }

        }
        
        public void remove(int key) {
            int hashedVal = hashFunction(key);
            if (elementData[hashedVal] != null) {
                HashEntry pre = elementData[hashedVal];
                if (pre.val == key) {
                    elementData[hashedVal] = elementData[hashedVal].next;
                    size--;
                }
                while (pre.next != null) {
                    if (pre.next.val == key) {
                        pre.next = pre.next.next;
                        size--;
                        return;
                    }
                    pre = pre.next;
                }
            }
        }
        
        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = hashFunction(key);
            
            HashEntry current = elementData[index];
            while(current != null) {
                if(current.val == key) {
                    return true;
                }
                current = current.next;
            }
            
            return false;
            
        }

        private void rehash() {
            HashEntry[] oldElementData = elementData;
            elementData = new HashEntry[oldElementData.length*2];
            size=0;
            for (int i = 0; i < oldElementData.length; i++){
                HashEntry current = oldElementData[i];
                while (current != null){
                    add(current.val);
                    current=current.next;
                }
            }
        }
        
        private int hashFunction(int value) {
            return Math.abs(value) % elementData.length;
        }

        class HashEntry {
            public int val;
            public HashEntry next;
            public HashEntry(int value) {
                val = value;
            }
            public HashEntry(int value, HashEntry nextEntry) {
                val = value;
                next = nextEntry;
            }
        }
    }
}
