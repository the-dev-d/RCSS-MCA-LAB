#include<stdio.h>
int num=7;
void fnWithLocal() {
	int num = 0;
	
	printf("My num is %d, I'm incrementing it as %d. I wont remember it next time \n", num, ++num);
	
}

void fnWithStatic() {
	
	static int num = 0;
	
	printf("My num is %d, I'm incrementing it as %d. I will remember it next time \n", num, ++num);
}

void fnWithGlobal() {
	
	printf("Global num from function is also %d \n", num);
}

int main() {
	
	register int r = 0;
	
	printf("R register now has %d \n", r);
	while(r != 30000) {
		r++;
	}
	printf("Now register is %d, Register is fast\n", r);
	
	printf("\n\n");
	
	printf("Global num from main is %d \n", num);
	fnWithGlobal();
	
	printf("\n\n");
	fnWithLocal();
	fnWithLocal();
	
	printf("\n\n");
	fnWithStatic();
	fnWithStatic();
	
	return 0;
}
