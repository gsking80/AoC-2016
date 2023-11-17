package king.greg.aoc2016;

public class Day21 {

    private char[] password;

    public Day21(String password) {
        this.password = password.toCharArray();
    }

    public String getPassword() {
        return String.valueOf(password);
    }

    public void transform(String transform) {
        final String[] words = transform.split(" ");
        switch(words[0]) {
            case "swap":
                switch(words[1]){
                    case "position":
                        swap(Integer.valueOf(words[2]), Integer.valueOf(words[5]));
                        break;
                    case "letter":
                        swap(words[2].charAt(0), words[5].charAt(0));
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                break;
            case "reverse":
                reverse(Integer.valueOf(words[2]), Integer.valueOf(words[4]));
                break;
            case "rotate":
                switch(words[1]) {
                    case "left":
                        rotateLeft(Integer.valueOf(words[2]));
                        break;
                    case "right":
                        rotateRight(Integer.valueOf(words[2]));
                        break;
                    case "based":
                        final int index = String.valueOf(password).indexOf(words[6].charAt(0));
                        rotateRight( (1 + (index >= 4 ? index + 1 : index)) % password.length);
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                break;
            case "move":
                move(Integer.valueOf(words[2]),Integer.valueOf(words[5]));
                break;
            default:
                System.out.println(transform);
                throw new UnsupportedOperationException();
        }
    }

    public void reverse(String transform) {
        final String[] words = transform.split(" ");
        switch(words[0]) {
            case "swap":
                switch(words[1]){
                    case "position":
                        swap(Integer.valueOf(words[2]), Integer.valueOf(words[5]));
                        break;
                    case "letter":
                        swap(words[2].charAt(0), words[5].charAt(0));
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                break;
            case "reverse":
                reverse(Integer.valueOf(words[2]), Integer.valueOf(words[4]));
                break;
            case "rotate":
                switch(words[1]) {
                    case "left":
                        rotateRight(Integer.valueOf(words[2]));
                        break;
                    case "right":
                        rotateLeft(Integer.valueOf(words[2]));
                        break;
                    case "based":
                        final int index = String.valueOf(password).indexOf(words[6].charAt(0));
                        rotateLeft( index / 2 + (index % 2 == 1 || index == 0 ? 1 : 5));
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                break;
            case "move":
                move(Integer.valueOf(words[5]),Integer.valueOf(words[2]));
                break;
            default:
                System.out.println(transform);
                throw new UnsupportedOperationException();
        }
    }

    private void move(Integer x, Integer y) {
        char[] moved = new char[password.length];
        int source = 0;
        for (int i = 0; i < password.length; i++) {
            if (i == y) {
                source = x;
            } else if (i < x) {
                if (i < y) {
                    source = i;
                } else {
                    source = i - 1;
                }
            } else if (i == x){
                if (i < y) {
                    source = i + 1;
                } else {
                    source = i - 1;
                }
            } else {
                if (i < y) {
                    source = i + 1;
                } else {
                    source = i;
                }
            }
            moved[i] = password[source];
        }
        password = moved;
    }

    private void rotateRight(Integer x) {
        rotateLeft(password.length - x);
    }

    private void rotateLeft(Integer x) {
        int rotation = x % password.length;
        char[] rotated = new char[password.length];
        for (int i = 0; i < password.length; i++) {
            rotated[i] = password[(i + rotation) % password.length];
        }
        password = rotated;
    }

    private void reverse(Integer x, Integer y) {
        if (y < x) {
            Integer temp = x;
            x = y;
            y = temp;
        }
        while (x < y) {
            swap(x, y);
            x++;
            y--;
        }
    }

    private void swap(char x, char y) {
        swap(String.valueOf(password).indexOf(x),String.valueOf(password).indexOf(y));
    }

    private void swap(final Integer x, final Integer y) {
        char temp = password[x];
        password[x] = password[y];
        password[y] = temp;
    }

}
