public class bubblesort {
    //TO RUN THE FILE: java bubblesort.java <insert the rest of the arguments here>
    //make sure you are in the right directory!!!
    public void main(String[] args) {
        int[] array = new int[args.length];
        //convert String to int
        for(int i = 0; i < args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        print(sort(array));
    }
    //this function sorts the array
    public int[] sort(int[] array){
        int timesRepeated = 0;
        int len = array.length;
        for(int n = 0; n < len; n ++){
            for(int i = 0; i < len - 1; i++){
                timesRepeated ++;
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        IO.println(timesRepeated);
        return array;
    }

    //prints the result in the console nothing else lmao
    public void print(int[] array) {
        for(int i = 0; i < array.length; i++){
            IO.print(array[i] + " ");
        }
        IO.println();
    }
    
}
