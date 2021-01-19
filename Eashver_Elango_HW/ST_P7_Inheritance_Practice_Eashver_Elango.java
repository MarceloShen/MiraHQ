import java.util.*;

// This may not run because I didn't include the requiste parent classes
// I didn't want to bloat this file.

public class ST_P7_Inheritance_Practice_Eashver_Elango {
    class MinMaxAccount extends BankingAccount{
        private int min;
        private int max;
        
        public MinMaxAccount(Startup s){
            super(s);
            min = super.getBalance();
            max = super.getBalance();
        }

        //Simple getter function
        public int getMin(){
            return min;
        }
        public int getMax(){
            return max;
        }
        
        //Override these two functions to add the functionality for Min and Max Checking
        @Override
        public void debit(Debit d){
            super.debit(d);
            checkMinMaxValue();
        }
        
        @Override
        public void credit(Credit c){
            super.credit(c);
            checkMinMaxValue();
        }
        
        //In the MinMax check, we need to replace the max and min of each value based on current balance
        private void checkMinMaxValue(){
            int balance = getBalance();
            max = Math.max(balance, max);
            min = Math.min(balance, min);
        }
    }

    class MemoCalculator extends Calculator{
    
        private int computeCount = 0;
        private int memoCount = 0;
        // A Hashmap that contains the primes we've memoized along with values of the prime() function
        private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        
        public MemoCalculator(int seed){
            super(seed);
        }
        
        //Simple getter function
        public int getComputeCount(){
            return computeCount;
        }
        public int getMemoCount(){
            return memoCount;
        }
        
        //Override the prime function
        @Override
        public int prime(int n){
            //Check if we already memoized the prime
            if(memo.containsKey(n)){
                // if we did, add to memoCount and return the value
                memoCount++;
                return memo.get(n);
            } else {
                // if we didn't, add to compute, and memoize the prime
                computeCount++;
                int value = super.prime(n);
                memo.put(n, value);
                return value;
            }
        }
    }

    class UndoStack extends StringStack{
        
        //contains our history of either pushs or pops in True vs False format
        private Stack<Boolean> call = new Stack<Boolean>(); 
        
        // Contains our history of pops saved for undos
        private Stack<String> history = new Stack<String>();
        
        public UndoStack(){
            super();
        }
        
        //Simple override of the push functio adding the call Stack
        @Override
        public void push(String s){
            super.push(s);
            call.push(true);
        }
        
        //Simple override of the pop function adding the call and history Stack
        @Override
        public String pop(){
            String result = super.pop();
            call.push(false);
            history.push(result);
            return result;
        }
        
        //Undoing a value
        public void undo(){
            //Check if we can undo
            if(canUndo()){
                //If there was a push
                if(call.pop()){
                    // we pop the value to undo
                    super.pop();
                } else { //or if there was a pop
                    // push back a value from history
                    super.push(history.pop());
                }
            }
        }
        
        //Check if the call stack is empty
        public boolean canUndo(){
            return !call.isEmpty();
        }
    }

    public class DiscountBill extends GroceryBill {
        private boolean preferred; // whether customers preferred
        private int discountNum; // total number of discount
        private double discountSum; // total discount

        public DiscountBill(Employee clerk, boolean _preferred) {
            super(clerk);
            discountNum = 0;
            discountSum = 0;
            preferred = _preferred;
        }

        //saving lines
        @Override
        public double getTotal() {
            return super.getTotal() - getDiscountAmount();
        }

        // increment discountNum by 1 and discountSum by the discount of item
        @Override
        public void add(Item item) {
            // add the discount portion to the add function
            if (item.getDiscount() > 0) {
                discountNum++;
                discountSum += item.getDiscount();
            }
            super.add(item);
        }

        //simple getter functions
        public int getDiscountCount() {
            return preferred ? discountNum : 0;
        }

        
        public double getDiscountAmount() {
            return preferred ? discountSum : 0;
        }

        // return the ratio of percent by dividing discount amount by total
        public double getDiscountPercent() {
            return preferred ? getDiscountAmount() / super.getTotal() * 100 : 0;
        }
    }
}
