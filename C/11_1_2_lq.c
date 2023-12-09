#include<stdio.h>
#include<malloc.h>
struct node {
	
	int data;
	struct node *next;
};

struct node *front = NULL;
struct node *rear = NULL;

struct node* create_node(int data) {
	
	struct node *newNode = ( struct node* )malloc(sizeof(struct node));
	newNode->data = data;
	newNode->next = NULL;
	
	return newNode;
}

void enqueue(int data) {
	
	struct node *newNode = create_node(data);
	
	if(rear == NULL) {
		
		front=rear=newNode;
		return;
	}
	
	rear->next = newNode;
	rear = rear->next;
	
	return;
}

int dequeue() {
	
	if(front == NULL) {
		printf("Queue empty \n\n");
		return 0;
	}
	
	int data = front->data;
	
	if(front == rear) {
		front=rear=NULL;
	}
	else
		front= front->next;
	
	printf("\nDequeued : %d \n", data);
	return data;
}

int main() {
	
	int opt, data;
	do{
		
		printf("\n\n1.Enqueue \n2.Dequeue \n3.Exit \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1:
				printf("Enter element : ");
				scanf("%d", &data);
				enqueue(data);
				break;
				
			case 2:
				dequeue();
				break;
				
			case 3:
				break;
		}
	}while(opt!=3);
	
	return 0;
	
}
