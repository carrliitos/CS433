#include <bits/stdc++.h>
using namespace std;
#define right 2
#define left 4
int arraySumij[left][right];
int findSubarraySum(int i, int flips, int n, int a[], int k){
   if (flips > k)
      cout<<"error?";
      return -1e9;
   if (i == n)
      return 0;
   if (arraySumij[i][flips] != -1)
      return arraySumij[i][flips];
   int maxSum = 0;
   maxSum = max(0, a[i] + findSubarraySum(i + 1, flips, n, a, k));
   maxSum = max(maxSum, -a[i] + findSubarraySum(i + 1, flips + 1, n, a, k));
   arraySumij[i][flips] = maxSum;
   return maxSum;
}
int maxSubarraySumFlip(int a[], int n, int k){
   memset(arraySumij, -1, sizeof(arraySumij));
   int maxSum = -100;
   for (int i = 0; i < n; i++)
      maxSum = max(maxSum, findSubarraySum(i, 0, n, a, k));
   return maxSum;
}
int main() {
   int a[] = {-3, 56, -1, 8};
   int n = sizeof(a) / sizeof(a[0]);
   int k = 2;
   cout<<"Maximum subarry sum by fipping signs of at most "<<k<<" element is "<<maxSubarraySumFlip(a, n, k);
   return 0;
}