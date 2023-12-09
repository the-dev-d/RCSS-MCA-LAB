#include<stdio.h>
#define SIZE 4
int queue[SIZE];
int front = -1;
int rear = -1;

void enqueue() {
	
	if(rear + 1 == SIZE) {
		printf("Queue is full\n");
		return;
	}
	if(rear == -1) {
		front = rear = 0;
	}
	else {
		rear++;
	}
	printf("Enter element : ");
	scanf("%d", &queue[rear]);
}

void dequeue() {
	
	if(front == -1) {
		printf("Queue is empty\n");
		return;
	}

	printf("\n\n%d Dequeued\n", queue[front]);
	
	if(front == rear) {
		front = rear = -1;
	}else {
		front++;
	}
}
int main() {
	
	int opt;
	do {
		
		printf("\n\n1. Enqueue \n2. Dequeue \n3. Exit \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1 : 
				enqueue();
				break;
				
			case 2:
				dequeue();
				break;
				
			case 3:
				return 0;
		}
	}while(1);
	
	return 0;
}
