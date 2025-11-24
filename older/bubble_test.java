public class bubble_test {
    public static void main(String[] args) {
        int timesRepeated = 0;
        int[] sort = new int[args.length];
        for(int i = 0; i < args.length; i++){
            sort[i] = Integer.parseInt(args[i]);
        }
        boolean test;
        if(sort.length > 0){
            int count = 0;
            do 
            { 
                test = true;
                count ++;
                
                for(int i = 0; i < sort.length - count; i ++){
                    timesRepeated ++;
                    int j = i;
                    if(sort[j] > sort[j+1]){
                        int t = sort[j];
                        sort[j] = sort[j+1];
                        sort[j+1] = t;
                        test = false;
                    }
                }
                
            } while (!test);

            for (int x : sort){
                IO.print ( x +  " ");
            }
            IO.println();
            IO.println("i have repeated " + timesRepeated + " times");
        }
    }
}
