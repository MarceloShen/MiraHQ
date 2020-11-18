package InheritancePractice;

import java.util.HashMap;

// This class can access the super class and other objects in practice-it
public class MemoCalculator extends Calculator {

    int computeCount;
    int memoCount;
    
    // Prime values already calculated (key: input, value: output)
    HashMap<Integer, Integer> primeValues;
    
    public MemoCalculator(int seed) {
        super(seed);
        this.computeCount = 0;
        this.memoCount = 0;
        this.primeValues = new HashMap<Integer, Integer>();
    }
    
    public int getComputeCount() {
        return this.computeCount;
    }
    
    public int getMemoCount() {
        return this.memoCount;
    }
    
    public int prime(int n) {
        // Memoize if possible
        if(computeCount >= 1 && primeValues.containsKey(n)) {
            this.memoCount++;
            return this.primeValues.get(n);
        }
        
        int num = super.prime(n);
        this.computeCount++;
        // Add this calculated value to the stored prime values
        this.primeValues.put(n, num);
        return num;
    }
    
}