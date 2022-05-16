package game;

public class Move {

    // checking the rows if they match
    public boolean checkRow(char letter, char box[][]) {
        for (int i = 0; i < box.length; i++) {
            if (box[i][0] == letter && box[i][1] == letter && box[i][2] == letter) {
                return true;
            }
        }
        return false;
    }


    // checking the columns if they match
    public boolean checkcolumn(char letter, char box[][]) {

        for (int i = 0; i < box.length; i++) {
            if (box[0][i] == letter && box[1][i] == letter && box[2][i] == letter) {
                return true;
            }
        }
        return false;
    }

    // checking the diagonals if they match
    public boolean checkDiagnol(char letter, char box[][]) {

        if (box[1][1] != letter) {return false;} // middle

        if (box[0][0] == letter && box[2][2] == letter) {return true;} //top left, bottom right

        if (box[0][2] == letter && box[2][0] == letter) {return true;} //top right, bottom left

        return false;
    }
}
