public non-sealed class Hase extends Tier {
    Hase(String name, int alter){
        super(name,alter);
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
