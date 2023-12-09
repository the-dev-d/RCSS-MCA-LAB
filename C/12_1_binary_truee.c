#include<stdio.h>
#include<malloc.h>

struct node {
	
	int data;
	struct node *left, *right;
};
typedef struct node node;
node *root = NULL;
node* create_node(int data) {
	
	node* temp = (node*) malloc(sizeof(node));
	temp->data = data;
	temp->left = temp->right = NULL;
	return temp;
}

void insert(int data) {
	
	node* new_node = create_node(data);
	if(root == NULL) {
		root = new_node;
		return;
	}
	node *prev = NULL, *temp = root;
	
	while(temp != NULL ) {
		
		prev = temp;
		if(temp->data > new_node->data)
			temp = temp->left;
		else
			temp = temp->right;
	}
	if(prev->data > new_node->data) {
		prev->left = new_node;
	}else {
		prev->right = new_node;
	}
}

void inorder(node *n) {
	
	if(n == NULL) 
		return;
		
	inorder(n->left);
	printf("%d ", n->data);
	inorder(n->right);
}

int main() {
	
	int opt,item;
    do {

        printf("\n\n1.Insert \n2.Inorder \n3.Exit \nEnter your choice : ");
        scanf("%d", &opt);

        switch (opt)
        {
            case 1:
                printf("Enter data : ");
                scanf("%d", &item);
                insert(item);
                break;

            case 2:
                inorder(root);
                break;

            case 3:
                return 0;

            default:
                printf("Wrong choice!\n\n");
        }

    }while (opt != 4);
}
