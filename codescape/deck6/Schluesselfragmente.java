package deck6;

import java.util.Arrays;

public class Schluesselfragmente {
    String[] key = new String[6];
    int n = 0;
    public void run() {
		// Vorgehen, um Array an Terminal übergeben:
		// deinString = Arrays.toString(deinArray); - konvertiert deinArray in den String deinString
		// write(deinString); - übergibt den Arraystring an ein Eingabeterminal

    	// Dein Code hier:
        
        for(int i = 0; i < 3; i++){
            catchNext(true);
        }
        move();
        turnRight();
        moveSteps(3);
        turnRight();
        move();
        turnRight();
        String part = read();
        key[n] = part;
        n ++;
        turnLeft();
        for(int i = 0; i < 2; i++){
            catchNext(false);
        }
        move();
        turnRight();
        write(Arrays.toString(key));
        turnLeft();
        move();
    }
    
    public void catchNext(boolean left){
        moveSteps(2);
        if(left) turnLeft();
        else{
            turnRight();
        }
        String part = read();
        key[n] = part;
        n ++;
        if(left) turnRight();
        else{
            turnLeft();
        }
    }
    
    public void moveSteps(int steps){
        for(int i = 0; i < steps; i ++){
            move();
        }
    }
}
