#include <stdio.h>

void swap1(int n, int m) {
  int tmp = n;
  n = m;
  m = tmp;
}

void swap2(int *n, int *m) {
  int tmp = *n;
  *n = *m;
  *m = tmp;
}

int main() {
  int a = 5;
  int b = 3;
  swap1(a, b);
  printf("a: %d, b: %d\n", a, b);
  swap2(&a, &b);
  printf("a: %d, b: %d\n", a, b);
  return 0;
}


