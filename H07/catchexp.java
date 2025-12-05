public class catchexp {
    public static void main(String[] args) {
        int[] exampleArr = {1,2,3};
        try {
            IO.println(exampleArr[4]);
            IO.println(exampleArr[2]); 
        } catch (Exception another) {
            IO.println("Error :(");
        }
        
    }

    
}
