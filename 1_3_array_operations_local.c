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

int removeFrom(int ar[], int index, int size) {
    int pos, i;

    printf("Enter position to remove : ");
    scanf("%d", &pos);

    if (pos >= index) {
        printf("Invalid position \n");
        return;
    }

    for (i = pos - 1; i < index; i++) {
        ar[i] = ar[i + 1];
    }
    return index - 1;
}

void search(int ar[], int index) {
    int item, i;
    printf("Enter item to search : ");
    scanf("%d", &item);

    for (i = 0; i < index; i++) {
        if (ar[i] == item) {
            printf("Item found at position %d", i + 1);
            return;
        }
    }
    printf("Element not found \n");
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
        printf("\n\n1.Insert \n2.Delete \n3.Search \n4.Sort \n5.Display \n6.Exit \nEnter your choice : ");
        scanf("%d", &opt);

        switch (opt) {
        case 1:
            index = insert(ar, index, size);
            break;

        case 2:
            index = removeFrom(ar, index, size);
            break;

        case 3:
            search(ar, index);
            break;

        case 4:
            sort(ar, index);
            break;

        case 5:
            display(ar, index);
            break;

        case 6:
            return 0;

        default:
            printf("Wrong choice !!\n\n");
        }
    } while (1);
}
