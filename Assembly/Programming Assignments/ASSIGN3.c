/* This code is intented to be psuedocode 
for an assembly language program */

/* Program Description: This program will calculate
the factorial of N, an unsigned 1 byte number utilizing
the algorithm from lab 2. */
#include <stdio.h>

void main() {
    unsigned int N; //number to take factorial of
    unsigned int RESULT;
    unsigned int i;
    unsigned int j;

    N = 2;
    RESULT = N;
    i = 0;
    j = N-1;
    while (j>0) {
        while (i<j) {
            RESULT = j + RESULT;
        }
    }

    printf("The factorial of %d is %d.\n", N, RESULT);
}