public final class Waschbaer extends Tier {
    Waschbaer(String name, int alter){
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
        return "Waschbaer " + name + " (Alter: " + alter + ")";
    }
}
