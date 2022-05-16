package game;

class Box {
    private char playerWin;
    private int num;
    private boolean flag;

    public Box(int num) {
        this.num = num;
        this.flag = false;
    }

    public char[][] box =
            {{'0', '1', '2'},
            {'3', '4', '5'},
            {'6', '7', '8'}};

    public Box() {this.flag = false;}


    // method to print the board
    public static String display3by3(Box a, Box b, Box c) {
        return "BOARD#" + a.num + " | " + a.box[0][0] + " | " + a.box[0][1] + " | " + a.box[0][2] + " |" + "\tBOARD#" + b.num + " | " + b.box[0][0] + " | " + b.box[0][1] + " | " + b.box[0][2] + " |" + "\tBOARD#" + c.num + " | " + c.box[0][0] + " | " + c.box[0][1] + " | " + c.box[0][2] + " |"
                + "\nBOARD#" + a.num + " | " + a.box[1][0] + " | " + a.box[1][1] + " | " + a.box[1][2] + " |" + "\tBOARD#" + b.num + " | " + b.box[1][0] + " | " + b.box[1][1] + " | " + b.box[1][2] + " |" + "\tBOARD#" + c.num + " | " + c.box[1][0] + " | " + c.box[1][1] + " | " + c.box[1][2] + " |"
                + "\nBOARD#" + a.num + " | " + a.box[2][0] + " | " + a.box[2][1] + " | " + a.box[2][2] + " |" + "\tBOARD#" + b.num + " | " + b.box[2][0] + " | " + b.box[2][1] + " | " + b.box[2][2] + " |" + "\tBOARD#" + c.num + " | " + c.box[2][0] + " | " + c.box[2][1] + " | " + c.box[2][2] + " |";


    }


    //getters and setters for private variables

    public char getPlayerWin() {return playerWin;}
    public void setPlayerWin(char playerWin) {this.playerWin = playerWin;}

    public int getNum() {return num;}
    public void setNum(int num) {
        this.num = num;
    }

    public boolean isFlag() {return flag;}
    public void setFlag(boolean flag) {this.flag = flag;}


}
