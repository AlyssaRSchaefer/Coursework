#include <stdio.h>

void main() {
    unsigned int array[] = {1, 5, 10, 20, 34, 50};
    #define N 2 
    unsigned int result[N];

    unsigned int * X = &array[0];
    unsigned int * Y = &result[0];
    unsigned int b = 0;

    do {
        *Y = *X+*(X+1)+*(X+2);
        X = X + 3;
        Y++;
        b++;
    } 
    while (b < N);

    printf("Element One: %d, element two: %d\n", result[0], result[1]);
}