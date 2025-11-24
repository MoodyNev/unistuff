public class HA_02_EBNF {
    public static void main(String[] args) {
        //substring gitb den rest aus
        String str = "[]";
        IO.println(str.charAt(0));
        char wert = str.charAt(0);
        char wert2 = str.charAt(1);
        //exit ohne probleme
        if(wert2 == ')') System.exit(0);
        //abnormal termination
        else System.exit(1);
    }
}