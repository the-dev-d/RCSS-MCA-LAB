import java.io.DataInputStream;

class SearchInArray {
    
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

            System.out.print("\n\n===Enter element to search : ");
            int search = Integer.parseInt(in.readLine());

            for(int i=0; i<size ; i++) {

                if(arr[i] == search) {
                    System.out.print("Found at position ["+(i+1)+"]");
                    return;
                }
            }

            System.out.println("Not found!!");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
