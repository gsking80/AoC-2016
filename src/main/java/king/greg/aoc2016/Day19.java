package king.greg.aoc2016;

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

    public static int winnerV2(final int players) {
        int winner = 1;
        for (int i = 1; i < players; i++) {
            winner = winner % i + 1;
            if (winner > (i + 1)/2) {
                winner++;
            }
        }
        return winner;
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
