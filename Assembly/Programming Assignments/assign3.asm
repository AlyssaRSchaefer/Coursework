**************************************
*
* Name: Alyssa Schaefer
* ID: 18214196
* Date: 2-24-2024
* Lab3
*
* Program description: This program will calculate the factorial
* of N, an unsigned 1-byte number. The result (N!) is stored as 
* a 2-byte number in Big Endian format. 
*
* Pseudocode:
*
**************************************

* start of data section

	ORG $B000
N	FCB	8		unsigned int N = 8;


	ORG $B010
NFAC	RMB	2	unsigned int NFAC;
M		FCB N	unsigned int M = N;



	ORG $C000
* start of your program

