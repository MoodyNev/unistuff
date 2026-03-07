package deck6;

public class Sisyphos{
     String key = "";
    public void run() {
    	// Dein Code hier:
        getKey(true);
        move();
        getKey(true);
        turnLeft();
        moveSteps(6);
        turnLeft();
        getKey(false);
        getKey(false);
        move();
        write(key);
        turnRight();
        move();
        
        
    }
    
    public void moveSteps(int steps){
        for(int i = 0; i < steps; i++){
            //there is probs a better solution
            //but we vibing cuz the doggie is cute when he is running around
            while(!isMovePossible()){
                for(int y = 0; y < 2; y++){
                    turnLeft();
                    turnLeft();
                    move();
                }
            }
            move();
        }
    }
    
    public void getKey(boolean right){
        moveSteps(3);
        if(right) turnRight();
        else turnLeft();
        moveSteps(3);
        turnRight();
        key = key + read();
        turnRight();
        moveSteps(3);
        if(right) turnRight();
        else turnLeft();
    }
}