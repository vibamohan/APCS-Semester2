# Sorting Algorithm Rankings - Random Data

## Fastest to Slowest (for Random Data)

Based on testing at http://www.sorting-algorithms.com/ with random data:

### 1. Quick Sort (Fastest)
- Average Time Complexity: O(n log n)
- Highly efficient for random data
- Typically the fastest sorting algorithm in practice

### 2. Merge Sort
- Time Complexity: O(n log n) - guaranteed
- Very consistent performance
- Slightly slower than Quick Sort but more predictable

### 3. Insertion Sort
- Time Complexity: O(n²)
- Better performance on small datasets
- Less efficient on larger random datasets

### 4. Selection Sort
- Time Complexity: O(n²)
- Fewer comparisons than bubble sort in some cases
- Still inefficient for large random datasets

### 5. Bubble Sort (Slowest)
- Time Complexity: O(n²)
- Worst performance on random data
- Multiple passes through the entire array

## Summary
For random data, **Quick Sort** provides the best performance due to its efficient divide-and-conquer approach, while **Bubble Sort** is the slowest due to excessive comparisons and swaps.
