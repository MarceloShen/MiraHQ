import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class ST_7_InheritancePractice_Caogang_Shen {
    public class MinMaxAccount extends BankingAccount {
        // setting up min max variables
        private int min;
        private int max;

        public MinMaxAccount(Startup s) {
            super(s);
            min = getBalance();
            max = min;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        // update min balance and max balance everytime
        // the balance is updated for both methods
        @Override
        public void debit(Debit d) {
            super.debit(d);
            checkMinMax();
        }

        @Override
        public void credit(Credit c) {
            super.credit(c);
            checkMinMax();
        }

        public void checkMinMax() {
            int balance = getBalance();
            if (balance < min) {
                min = balance;
            } else if (balance > max) {
                max = balance;
            }
        }
    }

    public class MemoCalculator extends Calculator {

        private HashMap<Integer, Integer> memoPrimes; // hashmap to remember primes
        private int computeCount; // count the amount of actual computations
        private int memoCount; // count the amount of memo usage

        public MemoCalculator(int seed) {
            super(seed);
            memoPrimes = new HashMap<Integer, Integer>();
            computeCount = 0;
            memoCount = 0;
        }

        public int getComputeCount() {
            return computeCount;
        }

        public int getMemoCount() {
            return memoCount;
        }

        @Override
        public int prime(int n) {
            if (memoPrimes.containsKey(n)) { // check if hashmap has the key
                // if has key then use value
                memoCount++;
                return memoPrimes.get(n);
            } else {
                // if not has key then calculate
                computeCount++;
                int value = super.prime(n);
                memoPrimes.put(n, value);
                return value;
            }
        }

    }

    public class UndoStack extends StringStack {

        private int numAct; // count the number of actions because I don't have access to call variable

        public UndoStack() {
            super();
            numAct = 0;
        }

        // increment numAct for each action
        @Override
        public void push(String s) {
            numAct++;
            super.push(s);
        }

        @Override
        public String pop() {
            numAct++;
            return super.pop();
        }

        //  undo if possible, decrement numAct for each undo
        public void undo() {
            if (canUndo()) {
                super.secret_undo();
                numAct--;
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean canUndo() {
            return numAct > 0;
        }
    }

    public class DiscountBill extends GroceryBill {
        private boolean thisPreferred; // stored whether the customers is preferred
        private int discountNum; // count the total # of discount
        private double discountSum; // count the total discount

        public DiscountBill(Employee clerk, boolean preferred) {
            super(clerk);
            discountNum = 0;
            discountSum = 0;
            thisPreferred = preferred;
        }

        // using my own method to save lines
        @Override
        public double getTotal() {
            return super.getTotal() - getDiscountAmount();
        }

        // increment discountNum by 1 and discountSum by the discount of item
        @Override
        public void add(Item i) {
            if (i.getDiscount() > 0) {
                discountNum++;
                discountSum += i.getDiscount();
            }
            super.add(i);
        }

        public int getDiscountCount() {
            return thisPreferred ? discountNum : 0;
        }

        
        public double getDiscountAmount() {
            return thisPreferred ? discountSum : 0;
        }

        // return the ratio of percent by dividing discount amount by total
        public double getDiscountPercent() {
            return thisPreferred ? getDiscountAmount() / super.getTotal() * 100 : 0;
        }
    }

    public class FilteredAccount extends Account {
        private int numFiltered; // count the number of filtered processes
        private int numTotal; // count the total number of processes

        public FilteredAccount(Client c) {
            super(c);
            numFiltered = 0;
            numTotal = 0;
        }

        @Override
        public boolean process(Transaction t) {
            numTotal++;
            if (t.value() == 0) { // if filtered a $0 transaction
                numFiltered++;
                return true;
            } else {
                return super.process(t); // else hand the process to the super class
            }
        }

        public double percentFiltered() {
            return (numTotal == 0) ? 0.0 : 100.0 * numFiltered / numTotal; 
            // calculate via dividing numFiltered by numTotal to get their ratio 
        }
    }

    // ------------------------------- The base classes --------------------------------
    public class BankingAccount {
        private int balance;

        private List<String> historyTransaction;
        private List<String> historyBalance;

        public BankingAccount() {
            historyTransaction = new LinkedList<String>();
            historyBalance = new LinkedList<String>();
        }

        public BankingAccount(Startup s) {
            this.balance = s.startup_getBalance();
            historyTransaction = new LinkedList<String>();
            historyBalance = new LinkedList<String>();

            historyTransaction.add(valueToHistory(s.startup_getBalance()));
            historyBalance.add(toString());
        }

        public void debit(Debit d) {
            balance += d.debit_getBalance();

            historyTransaction.add(valueToHistory(d.debit_getBalance()));
            historyBalance.add(toString());
        }

        public void credit(Credit c) {
            balance += c.credit_getBalance();

            historyTransaction.add(valueToHistory(c.credit_getBalance()));
            historyBalance.add(toString());
        }

        public int getBalance() {
            return balance;
        }

        public boolean equals(Object o) {
            if (o instanceof BankingAccount) {
                return (this.getBalance() == ((BankingAccount) o).getBalance());
            }
            return false;
        }

        private String valueToHistory(int value) {
            int absValue = Math.abs(value);
            return (value < 0 ? "(-" : "") + (absValue / 100) + "." + (absValue % 100 / 10) + (absValue % 100 % 10)
                    + (value < 0 ? ")" : " ");
        }

        public String toString() {
            int absBalance = Math.abs(balance);
            return (balance < 0 ? "-" : "") + "$" + (absBalance / 100) + "." + (absBalance % 100 / 10)
                    + (absBalance % 100 % 10);
        }

        public String historyBalanceToString() {
            /*int maxLength = 0;
            for(String piece : historyBalance) {
                maxLength = Math.max(maxLength, piece.length());
            }*/
            int maxLength = 8;

            String build = "";
            for (int i = 0; i < historyBalance.size(); i++) {
                for (int j = 0; j < maxLength - historyBalance.get(i).length(); j++) {
                    build += " ";
                }
                build += historyBalance.get(i);
                if (i != historyBalance.size() - 1) {
                    build += "\n";
                }
            }

            return build;
        }

        public String historyTransactionToString() {
            String total = toString() + " ";

            int maxLength = 0;
            for (String piece : historyTransaction) {
                maxLength = Math.max(maxLength, piece.length() + 2);
            }
            maxLength = Math.max(maxLength, total.length() + 2);

            String build = "";
            for (int i = 0; i < historyTransaction.size() - 1; i++) {
                for (int j = 0; j < maxLength - historyTransaction.get(i).length(); j++) {
                    build += " ";
                }
                build += historyTransaction.get(i);
                build += "\n";
            }

            build += "+";
            for (int i = 0; i < maxLength - (historyTransaction.get(historyTransaction.size() - 1).length() + 1); i++) {
                build += " ";
            }
            build += historyTransaction.get(historyTransaction.size() - 1);
            build += "\n";

            for (int i = 0; i < maxLength; i++) {
                build += "-";
            }
            build += "\n";

            for (int i = 0; i < maxLength - total.length(); i++) {
                build += " ";
            }
            build += total;

            return build;
        }

        public static class Startup {
            private int balance;

            public Startup(int balance) {
                this.balance = balance;
            }

            public int startup_getBalance() {
                return balance;
            }
        }

        public static class Debit {
            private int balance;

            public Debit(int balance) {
                this.balance = balance;
            }

            public int debit_getBalance() {
                return balance;
            }
        }

        public static class Credit {
            private int balance;

            public Credit(int balance) {
                this.balance = balance;
            }

            public int credit_getBalance() {
                return balance;
            }
        }

        //  REPLACEME

    }

    public class Calculator {
        private int seed;
        private Random rand;

        private int primeCallCount;
        private int isPrimeCallCount;

        public Calculator(int seed) {
            this.seed = seed;
            rand = new Random(seed);
        }

        public boolean isPrime(int n) {
            isPrimeCallCount++;
            if (n == 0) {
                return false;
            }
            int prime = 0;
            int index = 0;
            while (prime < n) {
                index++;
                prime = prime(index);
            }
            return (prime == n);
        }

        public int prime(int n) {
            primeCallCount++;
            if (n < 1) {
                throw new IllegalArgumentException();
            }
            Set<Integer> primeSet = new HashSet<Integer>();
            int number = 2;
            while (true) {
                boolean result = true;
                for (int prime : primeSet) {
                    if (number % prime == 0) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    primeSet.add(number);
                    if (primeSet.size() == n) {
                        return number;
                    }
                }
                number++;
            }
        }

        public int fib(int n) {
            if (n < 1) {
                throw new IllegalArgumentException();
            }
            Set<Integer> primeSet = new HashSet<Integer>();
            int past = 0;
            int current = 1;
            int index = 1;
            while (index < n) {
                int temp = current;
                current += past;
                past = temp;
                index++;
            }
            return current;
        }

        public int rand(int max) {
            if (max < 1) {
                throw new IllegalArgumentException();
            }
            return rand.nextInt(max);
        }

        public int getSeed() {
            return seed;
        }

        public int getPrimeCallCount() {
            return primeCallCount;
        }

        public int getIsPrimeCallCount() {
            return isPrimeCallCount;
        }

        //  REPLACEME

    }

    public class StringStack {
        private Stack<String> element;

        private Stack<Boolean> call;
        private Stack<String> recall;

        public StringStack() {
            element = new Stack<String>();
            call = new Stack<Boolean>();
            recall = new Stack<String>();
        }

        public void push(String s) {
            element.push(s);
            call.push(true);
        }

        public String pop() {
            String result = element.pop();
            call.push(false);
            recall.push(result);
            return result;
        }

        public boolean isEmpty() {
            return element.isEmpty();
        }

        public int size() {
            return element.size();
        }

        public void secret_undo() {
            if (call.size() > 0) {
                if (call.pop()) {
                    element.pop();
                } else {
                    element.push(recall.pop());
                }
            }
        }

        public String toString() {
            return "bottom " + element.toString() + " top";
        }

        public boolean equals(Object o) {
            if (o instanceof StringStack) {
                return this.toString().equals(o.toString());
            }
            return false;
        }

        //  REPLACEME

    }

    public class GroceryBill {
        private Employee clerk;
        private List<Item> receipt;
        private double total;
        private double internalDiscount;

        public GroceryBill(Employee clerk) {
            this.clerk = clerk;
            receipt = new ArrayList<Item>();
            total = 0.0;
            internalDiscount = 0.0;
        }

        public void add(Item i) {
            receipt.add(i);
            total += i.getPrice();
            internalDiscount += i.getDiscount();
        }

        public double getTotal() {
            return Math.rint(total * 100) / 100.0;
        }

        public Employee getClerk() {
            return clerk;
        }

        public void printReceipt() {
            System.out.println(this);
        }

        private String valueToString(double value) {
            value = Math.rint(value * 100) / 100.0;
            String result = "" + Math.abs(value);
            if (result.indexOf(".") == result.length() - 2) {
                result += "0";
            }
            result = "$" + result;
            return result;
        }

        public String receiptToString() {
            String build = "items:\n";
            for (int i = 0; i < receipt.size(); i++) {
                build += "   " + receipt.get(i);
                if (i != receipt.size() - 1) {
                    build += "\n";
                }
            }
            return build;
        }

        public String toString() {
            return receiptToString() + "\ntotal: " + valueToString(total);
        }

        public String discountToString() {
            return receiptToString() + "\nsub-total: " + valueToString(total) + "\ndiscount: "
                    + valueToString(internalDiscount) + "\ntotal: " + valueToString(total - internalDiscount);
        }

        public static class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        public static class Item {
            private String name;
            private double price;
            private double discount;

            public Item(String name, double price, double discount) {
                this.name = name;
                this.price = price;
                this.discount = discount;
            }

            public double getPrice() {
                return price;
            }

            public double getDiscount() {
                return discount;
            }

            private String valueToString(double value) {
                String result = "" + Math.abs(value);
                if (result.indexOf(".") == result.length() - 2) {
                    result += "0";
                }
                result = "$" + result;
                return result;
            }

            public String toString() {
                return name + " " + valueToString(price) + " (-" + valueToString(discount) + ")";
            }
        }

        //	REPLACEME

    }

    public class Account {
        public boolean __processCalled;

        public Account(Client c) {
            __processCalled = false;
        }

        public boolean process(Transaction t) {
            __processCalled = true;
            return t.value() > -100 && t.value() < 1000000;
        }

        public class Client {
        }

        public class Transaction {
            private int value;

            public Transaction(int v) {
                value = v;
            }

            public int value() {
                return value;
            }
        }
    }
}
