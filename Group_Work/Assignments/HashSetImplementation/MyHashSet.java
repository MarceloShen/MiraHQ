package HashSetImplementation;

// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
/**
 * @author Marcelo Shen, Ashley Mead, Brandon Yi, Eashver Elango
 */
public class MyHashSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    
    // Constructs an empty set.
    public MyHashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Adds the given element to this set
    public void add(int value) {
        int hashedVal = hashFunction(value);
        HashEntry hs;
        if (elementData[hashedVal] != null) {
            HashEntry pre = elementData[hashedVal];
            do {
                if (pre.data == value) {
                    return;
                }
                pre = pre.next;
            } while (pre != null);
            hs = new HashEntry(value, elementData[hashedVal]);
        } else {
            hs = new HashEntry(value);
        }

        elementData[hashedVal] = hs;
        size++;

        if (loadFactor() >= MAX_LOAD_FACTOR) {
            rehash();
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int hashedVal = hashFunction(value);
        if (elementData[hashedVal] != null) {
            HashEntry s = elementData[hashedVal];
            while (s != null) {
                if (s.data == value) {
                    return true;
                }
                s = s.next;
            }
        }
        return false;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int hashedVal = hashFunction(value);
        if (elementData[hashedVal] != null) {
            HashEntry pre = elementData[hashedVal];
            if (pre.data == value) {
                elementData[hashedVal] = null;
                size--;
            }
            while (pre.next != null) {
                if (pre.next.data == value) {
                    pre.next = pre.next.next;
                    size--;
                    return;
                }
                pre = pre.next;
            }
        }
    }
    
    // Returns the number of elements in the queue.
    public int size() {
    	return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        /*int index = value;
        if(index < 0) { index = -index; }
        return index % elementData.length;*/
        return Math.abs(Integer.hashCode(value)) % elementData.length;
    }
    
    private double loadFactor() {
    	return ((double) size)/elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    private void rehash() {
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry element = oldElementData[i];
            while (element != null) {
                // basically add(element.data)
                int hashedVal = hashFunction(element.data);
                HashEntry hs;
                if (elementData[hashedVal] != null) {
                    hs = new HashEntry(element.data, elementData[hashedVal]);
                } else {
                    hs = new HashEntry(element.data);
                }
                elementData[hashedVal] = hs;
                element = element.next;
            }
        }
    }

    
    
    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }
}
