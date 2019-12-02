package Game.Interfaces;

import Game.Point;

public interface Checks {

    boolean isValidMovement(Point givenPoint);

    boolean isWinner();


}
