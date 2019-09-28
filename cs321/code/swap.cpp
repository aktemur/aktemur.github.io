#include <iostream>

void swapV(int x, int y) {
  int tmp = x;
  x = y;
  y = tmp;
}

void swapR(int &x, int &y) {
  int tmp = x;
  x = y;
  y = tmp;
}

void swapP(int *x, int *y) {
  int tmp = *x;
  *x = *y;
  *y = tmp;
}

int main() {
  int a = 11;
  int b = 22;
  std::cout << "a: " << a << " b: " << b << "\n";
  swapV(a, b);
  std::cout << "a: " << a << " b: " << b << "\n";
  swapR(a, b);
  std::cout << "a: " << a << " b: " << b << "\n";
  swapP(&a, &b);
  std::cout << "a: " << a << " b: " << b << "\n";
  return 0;
}
