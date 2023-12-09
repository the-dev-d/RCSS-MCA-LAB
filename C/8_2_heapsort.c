#include<stdio.h>


void insertHeapTree(int heap[], int n, int e) {
    
    heap[n] = e;
    int i = n, t;
    
    while(i != 0) {
        
        if(heap[i] < heap[(i - 1)/2]) {
            return;
        }
        
        t = heap[i];
        heap[i] = heap[(i - 1)/2];
        heap[(i - 1)/2] = t;
        
        i = (i - 1)/2;
        
    }
    
}

void heapSort(int heap[], int n) {
    
    int j=n, t;
    
    while(j > 0) {
        
        int i = 0;
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
        j--;
        
        while(i<= j) {
            
            int lc = (2 * i) + 1;
            int rc = (2 * i) + 2;
            
            if((lc <= j) && (rc <= j)) {
                
                if(heap[i] > heap[lc] && heap[i] > heap[rc]) {
                    break;
                }
                else if(heap[lc] > heap[rc]) {
                    int t = heap[lc];
                    heap[lc] = heap[i];
                    heap[i] = t;
                    i = lc;
                }
                else {
                    
                    int t = heap[rc];
                    heap[rc] = heap[i];
                    heap[i] = t;
                    i = rc;
                }
            }
            else if(lc <= j) {
                
                if(heap[lc] > heap[i]) {
                    
                    int t = heap[lc];
                    heap[lc] = heap[i];
                    heap[i] = t;
                    i = lc;
                }
            }
            else {
                break;
            }
            
        }
    }
    
}

int main() {
    
    int heap[100];
    int size = -1;
    int e;
    int c = 0;

    //just take 6 elements and sort
    while(c != 6) {
        
        printf("\nEnter element : ");
        scanf("%d", &e);
        insertHeapTree(heap, ++size, e);
        
        for(int i=0; i<=size; i++) {
            printf("%d, ", heap[i]);
        }
        
        c++;
        printf("\n");
    }
    heapSort(heap,size);
    for(int i=0; i<=size; i++) {
            printf("%d, ", heap[i]);
    }
}
