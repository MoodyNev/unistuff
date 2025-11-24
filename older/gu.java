public class gu {
    void main(){
        int size = 0;
        do 
            size = Integer.parseInt(IO.readln("Grosse eingeben: "));
        while(size < 0);

        String[] queue = new String[size];
        int currentSize = 0;

        String operation;

        do{
            operation = IO.readln("Bitte geben Sie eine Operation (ENQUEUE,DEQUEUE,CLEAR,SETSIZE,PRINT,STOP) ein: ");
            switch(operation){
                case "ENDQUEUE" ->{
                    if(currentSize < size){
                        for(int i = currentSize - 1; i >= 0; i--){
                            queue[i+1] = queue[i];
                        }
                        queue[0] = IO.readln("Neues Element");
                    }
                    currentSize++;
                }
                case "DEQUEUE" -> {
                    currentSize = Math.max(0,currentSize - 1);

                }
                case "CLEAR" -> {
                    currentSize = 0;
                }
                case "SETSIZE" -> {
                    do
                        size = Integer.parseInt(IO.readln("Grosse eingeben: "));
                    while(size < 0);
                    String[] new_queue = new String[size];
                    int tmp = 0;
                    for(int i = 0; i < Math.min(currentSize,size); i++){
                        new_queue[i] = queue[i];
                    }
                }
                case "PRINT", "STOP" -> {
                    for(int i = 0; i < currentSize; i++){
                        IO.println(queue[i]);
                    }  
                }
                default -> IO.println("Fehlerhafte Eingabe!");
            }
        }
        while(!operation.equals("STOP"));

    }
    
    
}
