#include<stdio.h>

int ar[50];
int size;
int index = 0;

void insert() {
	
	if(index == size) {
		printf("Insufficient space ..");
		return;
	}
	
	printf("Enter the element : ");
	scanf("%d", &ar[index++]);
}

void removeFrom() {
	
	int pos, i;
	
	printf("Enter position to remove : ");
	scanf("%d", &pos);
	
	if(pos >= size ) {
		printf("Invalid position \n");
		return;
	}
	
	for(i=pos-1; i<index; i++) {
		ar[i] = ar[i+1];
	}
	index--;
}

void search() {
	
	int item, i;
	printf("Enter item to search : ");
	scanf("%d", &item);
	
	for(i=0; i<=index; i++) {
		if(ar[i] == item) {
			printf("Item found at position %d", i+1);
			return;
		}
	}
	printf("Element not found \n");
}

void sort() {
	
	int i,j;
	for(i=0; i<index-1; i++) {
		for(j=0; j<index-1-i; j++) {
			
			if(ar[j] > ar[j+1]) {
				int temp;
				temp = ar[j];
				ar[j] = ar[j+1];
				ar[j+1] = temp;
			}
		}
	}
}
void display() {
	int i;
	printf(" | ");
	for(i=0; i<index; i++) {
		printf("%d | ", ar[i]);
	}
}
int main() {
	
	int opt;
	
	printf("Enter size of array (less than 50) : ");
	scanf("%d", &size);
	
	do {
		
		printf("\n\n1.Insert \n2.Delete \n3.Search \n4.Sort \n5.Display 6.Exit \nEnter your choice : ");
		scanf("%d", &opt);
	
		switch(opt) {
		
			case 1: 
				insert();
				break;
				
			case 2: 
				removeFrom();
				break;
		
			case 3:
				search();
				break;
				
			case 4:
				sort();
				break;
		
			case 5: 
				display();
				break;
				
			case 6:
				return;
				
			default:
				printf("Wrong choice !!\n\n");
		}
	}while(1);
}
