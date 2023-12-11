import java.util.Scanner;

class Queue {

    private int size;
    private int queueBuffer[];
    private int front, rear;

    Queue(int size) {
        this.size = size;
        this.queueBuffer = new int[size];
        this.front = this.rear = -1;
    }

    boolean enqueue(int elem) {

        if(rear == size - 1)
            return false;

        if(front == -1)
            front = 0;

        rear++;
        queueBuffer[rear] = elem;
        return true;

    }

    Integer dequeue() {

        if(front == -1)
            return null;

        int temp = queueBuffer[front];

        if(front == rear) 
            front = rear = -1;
        else
            front++;
        return temp;
    }
}

class QueueOperation {
    

    public static void main(String[] args) {
        
        Integer number, option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter queue size : ");
        Queue queue = new Queue(scanner.nextInt());


        do {

            System.out.println("\n\n[1] Enqueue \n[2] Dequeue \n[3] Exit \n Enter choice :  ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    number = scanner.nextInt();
                    if(queue.enqueue(number)) {
                        System.out.println("Enqueued");
                    }
                    else {
                        System.out.println("Queue Full");
                    }
                    break;

                case 2:
                    number = queue.dequeue();
                    if(number == null)
                        System.out.println("Queue empty");
                    else 
                        System.out.println("Dequeued : "+number);

                    break;

                case 3:
                    return;

                default:
                    System.out.println("Wrong choice try again \n\n");
            }

        }while(true);

    }

}
