public final class Biber extends Tier{
    Biber(String name, int alter){
        super(name,alter); //ok... i have no idea why java tries super() instead of the actual constructor - auto heißt ohne parameter
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
