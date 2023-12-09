#include <stdio.h>

int insert(int ar[], int index, int size) {
    if (index == size) {
        printf("Insufficient space ..");
        return;
    }

    printf("Enter the element : ");
    scanf("%d", &ar[index++]);
    
    return index;
}

void sort(int ar[], int index) {
    int i, j;
    for (i = 0; i < index - 1; i++) {
        for (j = 0; j < index - 1 - i; j++) {

            if (ar[j] > ar[j + 1]) {
                int temp;
                temp = ar[j];
                ar[j] = ar[j + 1];
                ar[j + 1] = temp;
            }
        }
    }
}

void display(int ar[], int index) {
    int i;
    printf(" | ");
    for (i = 0; i < index; i++) {
        printf("%d | ", ar[i]);
    }
}

int main() {
    int size;
    printf("Enter size of array (less than 50) : ");
    scanf("%d", &size);

    int ar[50];
    int index = 0;

    int opt;

    do {
        printf("\n\n1.Insert \n2.Sort \n3.Display \n4.Quit \nEnter your choice : ");
        scanf("%d", &opt);

        switch (opt) {
        case 1:
            index = insert(ar, index, size);
            break;

        case 2:
            sort(ar, index);
            break;

        case 3:
            display(ar, index);
            break;

        case 4:
            return 0;

        default:
            printf("Wrong choice !!\n\n");
        }
    } while (1);
}
