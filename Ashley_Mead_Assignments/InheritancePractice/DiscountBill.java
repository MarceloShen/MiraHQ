// package InheritancePractice;

// // This class can access the super class and other objects in practice-it
// public class DiscountBill extends GroceryBill {
//     boolean preferred;
//     // Total discount amount
//     double discountsSum;
//     // Number of discounts
//     int discountCount;
    
//     public DiscountBill(Employee clerk, boolean preferred) {
//         super(clerk);
//         this.preferred = preferred;
//         this.discountsSum = 0.0;
//         this.discountCount = 0;
//     }
    
//     public int getDiscountCount() {
//         return this.discountCount;
//     }
    
//     public double getDiscountAmount() {
//         return this.discountsSum;
//     }
    
//     public double getDiscountPercent() {
//         return this.getDiscountAmount() / super.getTotal() * 100;
//     }
    
//     public double getTotal() {
//         return super.getTotal() - this.getDiscountAmount();
//     }
    
//     public void add(Item i) {
//         super.add(i);
//         double discount = i.getDiscount();
//         // Add the discount if the customer is preferred and the discount is not 0
//         if(preferred && discount != 0.0) {
//             this.discountsSum += discount;
//             this.discountCount++;
//         }
//     }
// }
