# Quick Start
```
git clone https://github.com/AlexIvchenko/Algorithms.git
cd Algorithms
mvn clean install
```
To try this in maven project just insert this into your pom.xml
```
  <groupId>com.shurikat</groupId>
  <artifactId>Algorithms</artifactId>
  <version>1.0-SNAPSHOT</version>
```
# Algorithms
- Sorting algorithms (available in package "sort")
  - InsertionSort
  - SelectionSort
  - QuickSort (two options)
  - MergeSort
- Algorithms with sorted arrays (available in package "sorted")
  - BinarySearch
    - left
    - right
    - ceiling
    - floor
# Data Structures
  - SumSQRTDecomposition which provide the following operations with int array
    - computing sum on segment in O(sqrt(n))
    - change value by index in O(1)
    - increase all values on segment in O(sqrt(n))
# Types
  - Measurable - it's comparable type which provide positive and negative infinity
