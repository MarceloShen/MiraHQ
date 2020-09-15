# Big O Notation HW Eashver Elango

## Estimating g(x) Given f(x)
---
1. g(x) = n
2. g(x) = n<sup>2</sup>
3. g(x) = n<sup>5</sup>
4. g(x) = n<sup>3</sup>
5. g(x) = n<sup>2</sup>log(n)
5. g(x) = nlog(n)

## Counting Operations to Produce Polynomials
---
1. f(x) = 1
2. f(x) = n<sup>2</sup>
3. f(x) = n + n<sup>2</sup>
4. f(x) = n-2

## More Advanced Practice
---
1. Binary Search g(x) = log(x)
    * In Binary Search, the array is split in half and recursived over multiple times. Take the example of an array with length 32. We would have to split the array 5 times at worst case. In math, 32 * &frac12;<sup>5</sup> = 1 or n * &frac12;<sup>k</sup> which simplifies to n = 2<sup>k</sup>. This creates the worst case O(n) = log<sub>2</sub>(n).
2. Bubble Sort: g(x) = n<sup>2</sup>
    * In Bubble sort, two integers in the array are switched if they are out of order. This iteration uses two nested for loops. Regardless of how long they are, both are related to n and since there are two nested for loops basically of length n, the time complexity at worst would be O(n) = n<sup>2</sup>