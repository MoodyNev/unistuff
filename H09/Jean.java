public class Jean {
    public static void main(String[] args) {

        IO.println("Dann schauen wir doch mal nach was wir alles gefangen haben.\nBei 100 Bibern erhalte ich endlich meinen Hauptgewinn! \n");

        Tier h = new Hase("Fluffy", 5);
        Tier b = new Biber("Sherlock Holmes", 14);
        Tier w = new Waschbaer("Raccoonster", 4);

        // Baerenfalle test
        Baerenfalle<Tier> trap = new Baerenfalle<>();
        trap.fange(h);
        trap.fange(b);  // ignoriert
        try{
            IO.println("Baerenfalle: \n" + trap.abholen() + "\n");
        } catch(LeereFalleException e){
            IO.println("Leider ist die Falle Nummer 1 Leer...\n");
        }

        // GefrorenerSee test
        GefrorenerSee lake = new GefrorenerSee();
        lake.fange(h);
        lake.fange(b);
        lake.fange(w);
        try{
            IO.println("GefrorenerSee: \n" + lake.abholen() + "\n");
        } catch(LeereFalleException e){
            IO.println("Leider ist die Falle Nummer 2 Leer...\n");
        }

        // Kaefig test
        Kaefig cage = new Kaefig();
        cage.fange(h);
        cage.fange(b);
        cage.fange(w); // Waschbär frisst Hasen
        try{
            IO.println("Kaefig: \n" + cage.abholen() + "\n");
        } catch(LeereFalleException e){
            IO.println("Leider ist die Falle Nummer 3 Leer...\n");
        }

        // Leere Falle Test
        Kaefig cage2 = new Kaefig();
        try{
            IO.println("Kaefig: \n" + cage2.abholen() + "\n");
        } catch(LeereFalleException e){
            IO.println("Leider ist die Falle Nummer 4 Leer...\n");
        }
    }
}