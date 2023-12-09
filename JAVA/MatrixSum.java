import java.io.DataInputStream;

class MatrixSum {
    
    public static void main(String[] args) {
        int arr[][];
        DataInputStream in = new DataInputStream(System.in);

        try {

            System.out.print("Enter size for row and column : ");
            int row = Integer.parseInt(in.readLine());
            int col = Integer.parseInt(in.readLine());

            arr = new int[row][col];

            System.out.println("Populate the array :");
            for(int i=0; i<arr.length ; i++) {
                for(int j=0; j<arr[i].length; j++ ) { 
                    System.out.print("["+(i+1)+"]["+j+"] : ");
                    arr[i][j] = Integer.parseInt(in.readLine());
                }
            }
            int colSums[] = new int[arr[0].length];
            for(int i=0; i<arr.length ; i++) {
                int rowSum = 0;
                for(int j=0; j<arr[i].length; j++ ) {
                    rowSum+= arr[i][j];
                    colSums[j]+=arr[i][j];
                    System.out.print(arr[i][j] + " ");
                }
                System.err.print("\t| "+rowSum);
                System.out.println();
            }
            for(int i=0; i<colSums.length; i++) {
                System.out.print("_");
            }
            System.out.println();
            for(int i=0; i<colSums.length; i++) {
                System.out.print(colSums[i] + " ");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
