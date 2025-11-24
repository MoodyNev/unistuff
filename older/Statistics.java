import java.util.Random ;
import jdk.dynalink.beans.StaticClass;

//QUESTIONS: CAN I ADD STATIC, WHERE AND WHY? 

public class Statistics {

    int[] array = new int[100];
   
    
    public static void main () {
    Statistics statistics = new Statistics ();
    statistics.addValues (2 ,105 , -366 ,44 ,11);
    IO . println ( " Durchschnitt : " + statistics . getAverage ());
    }

    public void addValues ( int... values ) {
        //add values
        int startValue = array.length;
        for(int i = 0; i > values.length ; i++){
            //checks whether the index is out of range
            if(startValue >= 100){
                IO.println("Index out of range, more Elements are not going to be added.");
                return;
            }
            array[startValue] = values[i];
            startValue ++;
        } 
    }

    //mach das
    public double getAverage () {
        //DONT FORGET TO WARN IF THE INDEX IS EMPTY
        //add all the values
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        IO.println(sum);
        //
        //returns the average
        double average  = sum / (double)array.length;
        return average;

    }

    public Statistics generate ( int min , int max , int size ) {
        Random rand = new Random();
        Statistics newArray= new Statistics();
        
        if(size > 100 || size < 0){
            IO.println("Please select a number between 0 - 100 for index size");
        }
        if(min > max){
            IO.println("The minimum can not be greater than max");
        }
        for(int i = 0; i < size; i++){
            newArray.addValues(rand.nextInt(max- min + 1) + min);
        }
        return newArray;
    }
    
    //enum dekleration
    public enum OurColor { GRUEN, GELB, ROT }
    
    public OurColor interpret ( double ratio , int value ) {
        //gets the double d 
        double d = getAverage();
        double lower = d - ratio * Math.abs(d);
        double upper = d + ratio * Math.abs(d);

        if (value < lower) return OurColor.ROT;
        if (value > upper) return OurColor.GRUEN;
        else return OurColor.GELB;
    }
}
