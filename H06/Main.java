

public class Main {
    boolean min;
    MinMaxTree state;

    public Main(boolean min){
        this.min = min;

        state = new MinMaxTree(
                min,
                new GameState()
        );

        state = state.unfold(9);
    }

    private void makeAIMove(){
        if (!state.isMin())
            throw new AssertionError();
        state = state.makeMove();
    }

    private boolean makePlayerMove(String input){
        if (state.isMin())
            throw new AssertionError();
        GameState next = state.getState().parseAndSetPosition(input, state.isMin());
        if (next == null)
            return false;
        state = new MinMaxTree(!state.isMin(), next);
        state = state.unfold(9);
        return true;
    }

    private boolean isGameOver(){
        MinMaxTree current = state.unfold();
        return current.getSuccessors() == null || current.getSuccessors().length == 0;
    }

    public void main(){
        IO.println("randomly determining who starts...");
        if (min)
            IO.println("the computer makes the first move");
        else
            IO.println("you make the first move");
        IO.println(state.getState().toString());
        while (!isGameOver()){
            if (state.isMin()){
                IO.println("");
                IO.println("the computer is pondering on its next move...");
                makeAIMove();
                IO.println("it has decided to make the following move:");
                IO.println(state.getState().toString());
            } else {
                IO.println("");
                IO.println("make your move by typing row and column, e.g. B3, and then hitting enter.");
                String input = IO.readln();
                while(!makePlayerMove(input)){
                    IO.println("move not recognized.");
                    IO.println("make your move by typing row and column, e.g. B3, and then hitting enter.");
                    input = IO.readln();
                }
                IO.println("your move changed the game to the following state:");
                IO.println(state.getState().toString());
            }
        }
        switch(state.getState().checkWin()){
            case BLANK -> {
                IO.println("it is a draw");
            }
            case MIN -> {
                IO.println("you were defeated by the computer");
            }
            case MAX -> {
                IO.println("you dominated the computer and won the game");
            }
        }
    }

    public static void main(String[] args){
        Main m = new Main(
        //        new Random().nextBoolean()
                false
        );
        m.main();
    }
}
