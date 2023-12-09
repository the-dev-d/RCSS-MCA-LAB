import java.io.DataInputStream;

class Sort {
    
    public static void main(String[] args) {
        
        int arr[];
        DataInputStream in = new DataInputStream(System.in);

        try {

            int size;
            System.out.print("Enter array size : ");
            size = Integer.parseInt(in.readLine());

            arr = new int[size];

            System.out.println("Populate the array :");
            for(int i=0; i<size ; i++) {
                System.out.print("["+(i+1)+"] : ");
                arr[i] = Integer.parseInt(in.readLine());
            }

            for(int i=1; i<arr.length; i++) {

                int key = arr[i];
                int j = i-1;

                while(j>=0 && arr[j]>key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j+1] = key;
            }

            System.out.println("Sorted :");
            for(int i=0; i<size ; i++) {
                System.out.print(arr[i] + ", ");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
