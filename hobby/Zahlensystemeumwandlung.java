/** This is a program that helps you calculate between different number systems
 * So you give a number the system and which system you would like to have your number
 * we learned how this works in our lectures in the module so called "Technische Informatik"
 */

public sealed  class Zahlensystemeumwandlung permits Zehn_Binaer, Jeder_Zehner {
    public static void main(String[] args) {
        Zehn_Binaer r = new Zehn_Binaer("1111");
        IO.println(r.zuDecimal());

    }
    
}
