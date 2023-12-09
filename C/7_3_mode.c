#include<stdio.h>
#include<malloc.h>

struct FT {
	
	int term;
	int frequency;
};

int addFrequency(struct FT table[], int size, int term){
	int i;
	for(i=0; i<size; i++) {
		if(term == table[i].term) {
			table[i].frequency++;;
			return size;
		}
	}
	table[size].term = term;
	table[size].frequency = 1;
	return size + 1; 
}


int getMaxFrequency(struct FT table[], int size) {
	
	int i;
	int max = table[0].frequency;
	for(i=1; i<size; i++) {
		
		if(max < table[i].frequency)
			max = table[i].frequency;
	}
	
	return max;
}


int main() {
	
	int *terms, n, i, size = 0, max;
	struct FT *table;
	
	printf("How many terms : ");
	scanf("%d", &n);
	
	terms = (int *)calloc(n,sizeof(int));
	
	for(i =0; i< n; i++) {
		scanf("%d", &terms[i]);
	}
	
	table = malloc(n*sizeof(struct FT));
	
	for(i=0 ; i<n; i++) {
		size = addFrequency(table, size, terms[i]);
	}
	
	if(size == n) {
		printf("No mode exists..");
		return 0;
	}
	
	max = getMaxFrequency(table, size);
	
	printf("Mode is : ");
	for(i=0; i<size; i++) {
		if(max == table[i].frequency) {
			printf("%d, ", table[i].term);
		}
	}
	
}
