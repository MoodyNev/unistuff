public class HA_02_bankautomat {
    //4 functions: guthaben, einzahlen, abheben, zinseszins. the programs stops when you type stop
    public static void main(String[] args){
        IO.println("Bitte geben Sie eine Operation (GUTHABEN,EINZAHLEN,ABHEBEN,ZINSESZINS,STOP) ein:");
        String userInput = IO.readln();
        int guthaben = 1000;

        while(!userInput.equals("STOP")){
            switch(userInput){
                //check guthaben
                case "GUTHABEN" -> IO.println(guthaben);
                
                //Geld Einzahlung
                case "EINZAHLEN" -> {
                                    IO.println("Wie viel Geld möchten Sie einzahlen? Es wird eine Gebühr von 5% berechnet.");
                                    int einzahlung = Integer.parseInt(IO.readln());
                                    if(betrag(einzahlung)){
                                        guthaben += (int)Math.ceil((einzahlung * 0.95));
                                        guthabenAngabe(guthaben);
                                    }
                                    }

                //Geld auszahlung
                case "ABHEBEN" -> {
                                    IO.println("Wie viel Geld möchten Sie abheben?");
                                    int abhebung = Integer.parseInt(IO.readln());
                                    if(betrag(abhebung)){
                                        guthaben -= abhebung;
                                        guthabenAngabe(guthaben);
                                    }
                                }

                //zinsen
                case "ZINSESZINS" -> {
                                        IO.println("Wie viele Jahren wollen Sie Ihr Guthaben verzisen?");
                                        int jahren = Integer.parseInt(IO.readln());
                                        guthaben = zinsen(guthaben, jahren);
                                    }

                //the default case no one asked for 
                default ->{
                            IO.println("Fehlerhafte Eingabe");
                            System.exit(0);
                        }
            }

            IO.println("Bitte geben Sie eine Operation (GUTHABEN,EINZAHLEN,ABHEBEN,ZINSESZINS,STOP) ein:");
            userInput = IO.readln();
        }
        //program finished
        IO.println("Ihr Guthaben beträgt " + guthaben + " EURO. Vielen Dank und bis zum nächsten Mal!");
        logo();
    }
    
    //guthaben wird eif. ausgegeben yk
    public static void guthabenAngabe(int guthaben){
        IO.println("Ihr Guthaben beträgt " +  guthaben + " EURO.");
    }
    
    public static boolean betrag(int angabe){
        if(angabe > 0){
            return true;
        }
        else{
            IO.println("Betrag negativ.");
            return false;
        }
    }

    public static int zinsen(int guthaben, int jahren){
        //erst zinsen
        // can also be float but why not double ykyk
        double guthabenDanach = (double)guthaben * Math.pow(1 + 0.04, jahren);
        //aufrunden
        int neueGuthaben = (int)Math.ceil(guthabenDanach);
        neueGuthaben -= 2 * jahren;
        if(!betrag(neueGuthaben)){
            IO.println("Kein Guthaben mehr verfügbar!");
            return 0;
        }
        else{
            return neueGuthaben;
        }    
    }

    public static void logo(){
        IO.println(     "                           .                                     .   .            .                 \n" + //
                        "      .         .   .                                    ..          .                              \n" + //
                        "                                      .        :*%%*:                                 .   .         \n" + //
                        "      .  .                        .         .*%%%%%%%%*.           .                                \n" + //
                        "        .          .                     .+%%%%%%+:@%%%%%+.                                .        \n" + //
                        "                              .       .=%%%%%%%-.  ..+%%%%%%=..            .                        \n" + //
                        "                                 . .-%%%%%%%%%- -%%@..+%%%%%%%%-  .                                 \n" + //
                        "                                 :#%%%%%%%%%%%- .%%%%%%%%%%%%%%%%#:                                 \n" + //
                        "         .               ..   .*%%%%%%%%%%%%%%%=..  .*%%%%%%%%%%%%%%*..                             \n" + //
                        "  .                       ..+%%%%%%%%%%%%%%%%%%#%%%+. -%%%%%%%%%%%%%%%%+..                          \n" + //
                        "                .       .=%%%%%%%%%%%%%%%%%%%%..+%%%-.:%%%%%%%%%%%%%%%%%%%=.                        \n" + //
                        "                     .-%%%%%%%%%%%%%%%%%%%%%%%*..   .-%%%%%%%%%%%%%%%%%%%%%%%-.                     \n" + //
                        ". .                :#%%%%%%%%%%%%%%%%%%%%%%%%%%%%+:@%%%%%%%%%%%%%%%%%%%%%%%%%%%#:              .    \n" + //
                        "                   +%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%+  .      .         \n" + //
                        " .       .       .  ............................................................   .    .     ..    \n" + //
                        "              .          ..................................................                  .      \n" + //
                        " .          .         .  .@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@: .                    .  \n" + //
                        "          .              .@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@:.                        \n" + //
                        " .                       .@%%%%%=.   .-%%%%%%%#..   .#%%%%%%%-.   .=%%%%%@:        .            .   \n" + //
                        "                         .@%%%%=  .    .@%%%%%.      .%%%%%@.       -%%%%@:.                  .     \n" + //
                        "   ..                  . .@%%%%:     . .#%%%%+        +%%%%%.   .   :%%%%@:       .    . .          \n" + //
                        "  .            .   .     .@%%%%:       .#%%%%+        +%%%%%..      :%%%%@:         .               \n" + //
                        "        .             .  .@%%%%:.     ..#%%%%+       .+%%%%%.       :%%%%@:   .                     \n" + //
                        "             .           .@%%%%:       .#%%%%+        +%%%%%.       :%%%%@:               .         \n" + //
                        "               .   .     .@%%%%:  .    .#%%%%+        +%%%%%.       :%%%%@:                         \n" + //
                        "                         .@%%%%: . .  ..#%%%%+        +%%%%%.       :%%%%@:             .     .     \n" + //
                        "             .           .@%%%%: .     .#%%%%+        +%%%%%.       :%%%%@: . .                     \n" + //
                        "     .                   .@%%%%:       .#%%%%+ .      +%%%%%.       :%%%%@:                         \n" + //
                        "                  .      .@%%%%:       .#%%%%+        +%%%%%.       :%%%%@:                         \n" + //
                        "                     .   .@%%%%:       .#%%%%+        +%%%%%.       :%%%%@:.                        \n" + //
                        "                         .-----.       .-----:        :-----.       .-----.    .                    \n" + //
                        "                       .   INFORMATIK 01100010 01100001 01101110 01101011   .              .        \n" + //
                        "       .           +%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%+     .  .          \n" + //
                        "            .      :++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++:            .      \n" + //
                        "     .          :++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++:                \n" + //
                        "     .      .   +%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%+                \n" + //
                        "                    . .                       .                                                     \n");
    }


}
