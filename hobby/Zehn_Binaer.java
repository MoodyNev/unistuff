public non-sealed class Zehn_Binaer extends Zahlensystemeumwandlung{
    int[] binaer_value;
    int zehner_value;

    //creates a usable int array to calculate the value
    public Zehn_Binaer(String input){
       String[] array = input.split("");
       int len = input.length();
       int[] result = new int[len];
       for(String x : array){
            int value = Integer.parseInt(x);
            len -= 1;
            result[len] = value;
       }
       binaer_value = result;
       IO.println("hello i have the input" + binaer_value);
    }

    //calculates the value
    public int zuDecimal(){
        int result = 0;
        int len = binaer_value.length -1;
        for(int x : binaer_value){
            result += x * Math.pow(2, len);
            len -= 1;
        }
        zehner_value = result;
        return result;
    }
}