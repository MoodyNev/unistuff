public final class Hase extends Tier {
    Hase(String name, int alter){
        super(name,alter);
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
        return "Hase " + name + " (Alter: " + alter + ")";
    }
}
