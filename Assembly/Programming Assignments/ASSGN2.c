#include <stdio.h>

void main() {
    unsigned int NUM1 = 255;
    unsigned int NUM2 = 255;
    unsigned int RESULT;
    unsigned int i;

    RESULT = 0;
    i = 0;

    while (i < NUM2) {
        RESULT = NUM1 + RESULT;
        i++;
    }
    
    printf("%d * %d = %d, or %x in hex.\n", NUM1, NUM2, RESULT, RESULT);
}