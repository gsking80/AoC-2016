import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Day19 {

    LinkedList<Player> players = new LinkedList<>();

    public Day19(final int numPlayers) {
        for(int i = 1; i <= numPlayers; i++) {
            players.addLast(new Player(i));
        }
    }

    public int winner() {
        Iterator<Player> turn = players.iterator();
        while(players.size() > 1) {
            if(!turn.hasNext()) {
                turn = players.iterator();
            }
            turn.next();
            if(!turn.hasNext()) {
                turn = players.iterator();
            }
            turn.next();

            turn.remove();
        }
        return players.peek().getPlayerNumber();
    }

    private class Player {
        public int getPlayerNumber() {
            return playerNumber;
        }

        final int playerNumber;
        public Player(int playerNumber) {
            this.playerNumber = playerNumber;
        }
    }
}
