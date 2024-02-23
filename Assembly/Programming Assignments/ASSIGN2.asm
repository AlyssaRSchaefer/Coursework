**************************************
*
* Name: Alyssa Schaefer
* ID: 18214196
* Date: 2-16-2024
* Lab2
*
* Program description: This program multiplies two 8
* bit numbers (NUM1 & NUM2) by adding NUM1 to itself
* NUM2 times. Both numbers are unsigned. This result
* is stored in a 16-bit RESULT variable in Big-Endian
* format. 
*
* Pseudocode: 
*     unsigned int NUM1 = 255;
*     unsigned int NUM2 = 255;
*     unsigned int RESULT;
*     unsigned int i;
*
*     RESULT = 0;
*     i = 0;
*
*     while (i < NUM2) {
*         RESULT = NUM1 + RESULT;
*         i++;
*     }
*
**************************************

* start of data section

	ORG $B000
NUM1	FCB	255	unsigned int NUM1;
NUM2	FCB	255	unsigned int NUM2;

	ORG $B010
RESULT	RMB	2	unsigned int RESULT;
I	RMB	1	unsigned int I;

* start of program section
	ORG $C000
	CLR	RESULT	RESULT = 0;
	CLR	RESULT+1
	CLR	I	i = 0;
WHILE	LDAA	I	while (i<NUM2) {
	CMPA	NUM2	
	BHS	ENDW	
	LDAB	NUM1	RESULT = NUM1 + RESULT
	CLRA
	ADDD	RESULT
	STD	RESULT
	INC	I	i++;
	BRA	WHILE	}
ENDW	STOP
	
		

