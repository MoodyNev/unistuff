public final class Biber extends Tier{
    Biber(String name, int alter){
        super(name,alter); //ok... i have no idea why java tries super() instead of the actual constructor
        this.name = name;
        this.alter = alter;
    }

    @Override
    int getAlter(){
        return alter;
    }

    @Override
    String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Biber " + name + " (Alter: " + alter + ")";
    }
}
