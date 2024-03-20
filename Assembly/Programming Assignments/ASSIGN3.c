/* This code is intented to be psuedocode 
for an assembly language program */

/* Program Description: This program will calculate
the factorial of N, an unsigned 1 byte number utilizing
the algorithm from lab 2. */
#include <stdio.h>

void main() {
    unsigned int N = 0; //number to take factorial of
    unsigned int NFAC;
    unsigned int M = N;
    unsigned int i;
    unsigned int sum;


    M--;
    sum = 0;
    i = 0;

    if (N == 0) {
        N = 1;
    }
    else {
        while (M > 1) {
            while (i < N) {
                sum = (M) + sum;
                i++;
            }
            i=0;
            N = sum;
            sum = 0;
            M--;
        }
    }

    NFAC = N;

    printf("The factorial is %d\n", NFAC);
}