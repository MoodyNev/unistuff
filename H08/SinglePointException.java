public class SinglePointException extends Exception {
    private final Punkt exceptionPunkt;

    public SinglePointException(Punkt punkt){
        this.exceptionPunkt = punkt;
    }

    @Override
    public String toString(){
        return "Der Punkt" + exceptionPunkt + "wurde zweimal benutzt.";
    }
    
}
