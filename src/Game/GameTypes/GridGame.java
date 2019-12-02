package Game.GameTypes;

import Game.Enums.Direction;
import Game.Interfaces.Checks;
import Game.Point;

import java.util.Random;

public class GridGame implements Checks {

    private String[][] board;
    private final int MAX_BOARD_SIZE = 15;

    public GridGame() {
        this.board = new String[6][6];
        for(int i = 0; i < board.length;i++) {
            for(int j = 0; j < board[i].length;j++) {
                board[i][j] = "-";
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < board.length;i++) {
            for(int j = 0; j < board[i].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void generateBoard() {
        Random rand = new Random();
        int y = 0;
        int randomX = rand.nextInt(board.length);
        int prevX = randomX;
        int tileCount = 1;

        board[y][randomX] = "0";

        Direction[] choices = {  Direction.DOWN, Direction.LEFT, Direction.RIGHT };
        Direction prevDirection = Direction.NONE;

        while(y < board.length) {
            printBoard();
            System.out.println(tileCount);
            Direction randomChoice = choices[rand.nextInt(choices.length)];
            System.out.println("Random Choice: " + randomChoice);

            // If the random choice is going left
            if (randomChoice == Direction.LEFT) {

                //Check if the piece will be inside the board
                if (prevX - 1 < 0) {
                    
                    if(board[y][prevX+1].equals("-")) {
                        prevDirection = Direction.RIGHT;
                        board[y][prevX + 1] = tileCount + "";
                        prevX += 1;
                    } else {
                        if(y + 1 >= board.length) break;
                        prevDirection = Direction.DOWN;
                        board[++y][prevX] = tileCount + "";
                    }
                } else {
                    if(!board[y][prevX-1].equals("-")) {
                        if(y+1 >= board.length) break;
                        prevDirection = Direction.DOWN;
                        board[++y][prevX] = tileCount + "";
                    } else {
                        prevDirection = Direction.LEFT;
                        board[y][prevX - 1] = tileCount + "";
                        prevX -= 1;
                    }
                }
            } else if (randomChoice == Direction.RIGHT) {
                if(prevX + 1 >= board.length) {
                    if(!board[y][prevX-1].equals("-")) {
                        if(y+1 >= board.length) break;
                        prevDirection = Direction.DOWN;
                        board[++y][prevX] = tileCount + "";
                    } else {
                        prevDirection = Direction.LEFT;
                        board[y][prevX - 1] = tileCount + "";
                        prevX -= 1;
                    }
                } else {
                    if(!board[y][prevX+1].equals("-")) {
                        if(y+1 >= board.length) break;
                        prevDirection = Direction.DOWN;
                        board[++y][prevX] = tileCount + "";
                    } else {
                        prevDirection = Direction.RIGHT;
                        board[y][prevX + 1] = tileCount + "";
                        prevX += 1;
                    }
                }
            } else if (randomChoice == Direction.DOWN) {
                if(y+1 >= board.length) break;
                prevDirection = Direction.DOWN;
                board[++y][prevX] = tileCount + "";
            }
            System.out.println("Final Direction Choice: " + prevDirection);
            tileCount++;
            if(y+1 >= board.length) break;
        }
    }

    @Override
    public boolean isValidMovement(Point givenPoint) {
        int x = givenPoint.getX();
        int y = givenPoint.getY();
        return y < 0 || y > board.length-1 || x < 0 || x > board.length-1;
    }

    @Override
    public boolean isWinner() {
        return false;
    }
}