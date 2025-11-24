public class UE_01_rechner{
    void main(String[] args){
        String numQuestion = "Bitte geben Sie eine Zahl ein: ";
        String opQuestion = "Bitte geben Sie eine Rechenoperation (ADD oder SUB) oder STOP ein: ";
        int currVal = Integer.parseInt(IO.readln(numQuestion));
        String op = IO.readln(opQuestion);
        
        while (!op.equals("STOP")) { 
            switch(op){
                case "ADD" -> {
                    int num = Integer.parseInt(IO.readln(numQuestion));
                    currVal += num;
                }
                case "SUB" -> {
                    int num = Integer.parseInt(IO.readln(numQuestion));
                    currVal -= num;
                }
                default ->{
                    IO.println("Fehlerhafte Eingabe");
                    System.exit(0);
                }
            }
            IO.println("Aktuelles Ergebnis: " + currVal);
            op = IO.readln(opQuestion);
            }
        IO.println("Endergebnis: " + currVal);
        }
}