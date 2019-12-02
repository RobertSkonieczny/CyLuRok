package Game;

import Game.Enums.Difficulty;
import Game.GameTypes.GridGame;

public class MazeGame extends GridGame {

    public MazeGame() {

    }

    private Difficulty difficulty;

    public  void start() {
        super.generateBoard();
        super.printBoard();
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
