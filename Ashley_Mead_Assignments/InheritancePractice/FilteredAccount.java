// package InheritancePractice;

// // This class can access the super class and other objects in practice-it
// public class FilteredAccount extends Account {
    
//     int filtered;
//     int transactions;
    
//     public FilteredAccount(Client c) {
//         super(c);
//         this.filtered = 0;
//         this.transactions = 0;
//     }
    
//     public boolean process(Transaction t) {
//         this.transactions++;
//         // Filter transactions with value 0
//         if(t.value() == 0) {
//             this.filtered++;
//             return true;
//         }

//         return super.process(t);
//     }
    
//     public double percentFiltered() {
//         // If there are no transactions, there are no filtered transactions. Otherwise, calculate the percent filtered 
//         return this.transactions == 0 ? 0.0 : (double) this.filtered / this.transactions * 100;
//     }

// }
