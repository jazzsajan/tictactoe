package game;

public class Game {
    Box b;
    char marker;
    char player;

    public Game() {

    }

    public Game(Box b, char marker, char player) { //b - choice, marker - square, char - x/o
        this.b = b;
        this.marker = marker;
        this.player = player;
    }

// if the box is won by any player, the remaining block is changed to *
    public void change(char box[][]) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (box[i][j] == 'X' || box[i][j] == 'O') {

                } else {
                    box[i][j] = '*';
                }
            }
        }
    }

//replaces x/o with the input selected
    public void bT() {
        char a = marker;
        int row = 0, col = 0;

        int temp = Integer.parseInt(String.valueOf(a));

        char arr [][] = {{0, 1, 2},
                        {3, 4, 5},
                        {6, 7, 8}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == temp){
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        b.box[row][col] = player;
    }

// checks for winner of the board
    public boolean checks(char letter, char box[][]) {
        Move move = new Move();
        if (move.checkRow(letter, box)) {
            return true;
        }

        if (move.checkcolumn(letter, box)) {
            return true;
        }

        if (move.checkDiagnol(letter, box)) {
            return true;
        }
        return false;
    }

}
