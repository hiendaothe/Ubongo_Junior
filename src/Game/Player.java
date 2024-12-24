
package Game;

public class Player {
    private int score;

    public Player() {
        this.score = 0;
    }

    public void addScore(int point) {
        this.score += point;
    }

    public int getScore() {
        return score;
    }

    // Reset score for a new game
    public void resetScore() {
        this.score = 0;
    }
    
    public void saveScore(int player){
        switch(player){
            case 1 -> {
                
            }
        }
    }

}

