import jdk.nashorn.internal.objects.NativeString;
import org.apache.commons.codec.digest.DigestUtils;

import java.awt.*;
import java.util.*;

public class Day17 {

    final int x;
    final int y;

    public Day17(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static String doorCheck(final String passcode) {
        final String md5 = DigestUtils.md5Hex(passcode);
        return md5.substring(0,4);
    }

    public String shortestPath(final String passcode) {

        final Queue<State> priorityQueue = initQueue();

        priorityQueue.add(new State(1,1,0, passcode));

        State current;

        while(!priorityQueue.isEmpty()) {
            current = priorityQueue.remove();

            if(current.getEstimatedMovesRemaining() == 0){
                return current.passcode.substring(passcode.length());
            }

            final String doors = doorCheck(current.passcode);
            for (int i = 0; i < 4; i++) {
                switch(doors.charAt(i)){
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                        switch(i){
                            case 0: //up
                                if (current.location.y > 1) {
                                    priorityQueue.add(new State(current.location.x, current.location.y -1, current.moves + 1, current.passcode + 'U'));
                                }
                                break;
                            case 1:
                                if (current.location.y < 4) {
                                    priorityQueue.add(new State(current.location.x, current.location.y +1, current.moves + 1, current.passcode + 'D'));
                                }
                                break;
                            case 2:
                                if (current.location.x > 1) {
                                    priorityQueue.add(new State(current.location.x -1, current.location.y, current.moves + 1, current.passcode + 'L'));
                                }
                                break;
                            case 3:
                                if (current.location.x < 4) {
                                    priorityQueue.add(new State(current.location.x +1, current.location.y, current.moves + 1, current.passcode + 'R'));
                                }
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return null;
    }

    private PriorityQueue<State> initQueue() {
        return new PriorityQueue<>(10, new Comparator<State>() {

            @Override
            public int compare(State arg0, State arg1) {
                return Comparator.comparing(State::getEstimatedTotalMoves).thenComparing(State::getMoves).compare(arg0, arg1);
            }

        });
    }

    public String longestPath(final String passcode) {


        final Queue<State> priorityQueue = initQueue();

        priorityQueue.add(new State(1,1,0, passcode));

        State current;
        String longest = "";

        while(!priorityQueue.isEmpty()) {
            current = priorityQueue.remove();

            if(current.getEstimatedMovesRemaining() == 0){
                String path =  current.passcode.substring(passcode.length());
                if (path.length() > longest.length()) {
                    longest = path;
                }
                continue;
            }

            final String doors = doorCheck(current.passcode);
            for (int i = 0; i < 4; i++) {
                switch(doors.charAt(i)){
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                        switch(i){
                            case 0: //up
                                if (current.location.y > 1) {
                                    priorityQueue.add(new State(current.location.x, current.location.y -1, current.moves + 1, current.passcode + 'U'));
                                }
                                break;
                            case 1:
                                if (current.location.y < 4) {
                                    priorityQueue.add(new State(current.location.x, current.location.y +1, current.moves + 1, current.passcode + 'D'));
                                }
                                break;
                            case 2:
                                if (current.location.x > 1) {
                                    priorityQueue.add(new State(current.location.x -1, current.location.y, current.moves + 1, current.passcode + 'L'));
                                }
                                break;
                            case 3:
                                if (current.location.x < 4) {
                                    priorityQueue.add(new State(current.location.x +1, current.location.y, current.moves + 1, current.passcode + 'R'));
                                }
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return longest;

    }

    private class State {
        final int moves;
        final Point location;
        final String passcode;

        public State(final int x, final int y, final int moves, final String passcode) {
            location = new Point(x, y);
            this.moves = moves;
            this.passcode = passcode;
        }

        public int getEstimatedTotalMoves() {
            return moves + (x - location.x) + (y - location.y);
        }

        public int getMoves() {
            return moves;
        }

        public int getEstimatedMovesRemaining() {
            return (x - location.x) + (y - location.y);
        }
    }

}
