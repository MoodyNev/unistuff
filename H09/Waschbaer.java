public final class Waschbaer extends Tier {
    Waschbaer(String name, int alter){
        super(name,alter);
        //this.name = name; hier ist doppelt gemoppelt!!! du brauchst nicht zweimal zu speichern
        //this.alter = alter;
    }

    @Override
    int getAlter(){
        return super.getAlter();
    }

    @Override
    String getName(){
        return super.getName();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
