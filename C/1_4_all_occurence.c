#include<stdio.h>

int search_all_occurence(int ar[], int size, int item) {

    int count = 0;
    printf("\nPositions : ");
    for(int i=0; i < size; i++) {
        if(ar[i] == item) {
            printf("%d, ", i+1);
            count++;
        }
    }

    return count;
}
int main() {

    int ar[40], size, i, item;
    char opt;

    printf("Enter size of array (less than 40) : ");
    scanf("%d", &size);

    for (i = 0; i<size; i++)
    {
        printf("Enter element %d : ", i+1);
        scanf("%d", &ar[i]);
    }

    printf("==========SEARCH OCCURENCE========\n\n");

    do {
        int count;
        printf("Enter seach element : ");
        scanf("%d", &item);

        count = search_all_occurence(ar, size, item);
        printf("\n\n %d occurences detected.\n\n", count);

        printf("Do you want to continue (y/*) : ");
        scanf(" %c", &opt);
    }while (opt=='y');
}