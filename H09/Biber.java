public non-sealed class Biber extends Tier{
    Biber(String name, int alter){
        super(name,alter); //ok... i have no idea why java tries super() instead of the actual constructor
        this.name = name;
        this.alter = alter;
    }

    int getAlter(){
        return alter;
    }

    String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " ist " + alter + " Jahre alt.";
    }
}
