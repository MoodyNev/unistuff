/* minimax
x ist min
o ist max
Nachfolger successors ist erstmal `null`
beachte die kozepte der datenkapselung

 */
public class MinMaxTree {
    //what is the current state
    private GameState state ; //anzahl der leeren spielfelder
    //Whos turn, Zug
    private final boolean min ;
    private MinMaxTree [] successors ;
    public MinMaxTree ( boolean min , GameState state ){
        this . min = min ;
        this . state = state ;
        this . successors = null ;
    }
    public MinMaxTree [] getSuccessors () {
    return successors ;
    }

    public GameState getState () {
    return state ;
    }
    public boolean isMin () {
    return min ;
    }

    //HERE IS THE TASK
    public MinMaxTree unfold(){
        //in der wurzel den gleichen state und den gleichen spieler (min) und das aktuelle mmtree objekt hat
        MinMaxTree u_minmax = new MinMaxTree(min, state); //origin, the current state of the game, min egal
        GameState[] u_state = state.getSuccessors(min);

        //wenn keine weitere Züge gibt:
        if(u_state.length == 0) return u_minmax; 

        //zu minmaxobjekte umawndeln -> jetzt nachfolgern also mehrere objekte
        u_minmax.successors = new MinMaxTree[u_state.length];
        for(int i = 0; i < u_state.length ; i++){
            u_minmax.successors[i] = new MinMaxTree(!min, state);
        }
        return u_minmax;
    }

    public MinMaxTree unfold(int depth){
        MinMaxTree u_minmax = new MinMaxTree(min, state); //origin, the current state of the game, min egal
        //boolean u_min = min;
        GameState[] u_state = state.getSuccessors(min);

        //if depth is 0 it must return
        if(depth == 0) return u_minmax;
        //every array in der list specihert, die ganze Tiefe d,h {{T0}, {T1},{T2},..,{T9}} !!MAYBE I AM WRONG WITH THIS
        u_minmax.successors = new MinMaxTree[depth];
        for(int k = 0; k < u_state.length ; k++){
            //sammelt die ganze Tiefe durch Rekursion
            u_minmax.successors[k] = unfold(depth--);
            //unfold(depth--);
        }
        //u_min = !u_min;
        return u_minmax;
    }

    private score(){
        /* if there are no more moves to make call evaluate to return die bewertung duch game state
        Ansonsten bilde eine Bewertung, erlaubt ist die min max von der math library

        Bewertungsverfahren: using a TRUE minimax algorithm
        jede Knote im Baum wird eine Bewertung abgegeben
        was min gewinnt: -1
        was max gewinnt: 1
        unentschieden: 0
        if das Spiel nocht nicht vorbei ist, wird das Ergebnis einer Nachfolger zugewiesen
         */
    }
}
