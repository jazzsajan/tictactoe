package game;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {

    public void printArr(Box[] boxes) {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(Box.display3by3(boxes[i], boxes[i + 1], boxes[i + 2]));
        }
    }

    public void play() {

        //9 objects of class box - makes 9 boxes of ttt in 3x3 format
        Scanner sc = new Scanner(System.in);
        Box b0 = new Box(0);
        Box b1 = new Box(1);
        Box b2 = new Box(2);
        Box b3 = new Box(3);
        Box b4 = new Box(4);
        Box b5 = new Box(5);
        Box b6 = new Box(6);
        Box b7 = new Box(7);
        Box b8 = new Box(8);

        //store box objects in Box array
        Box[] boxes = {b0, b1, b2, b3, b4, b5, b6, b7, b8};

        char p1 = 'X', p2 = 'O', square = 's';

        int count = 0, wins = 0, choice; //count - keep track of each turn

        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");

        while (true) {

            if (count % 2 == 0) {
                System.out.println("Current Player is : " + p1);
            } else {
                System.out.println("Current Player is : " + p2);
            }

            // first turn, the user input the square
            if (count == 0) {

                System.out.print("Please select a valid board: ");
                //System.out.print("Selected Board : ");
                choice = sc.nextInt();

                while(choice == 9){
                    System.out.println("Invalid board!!! Please select again: ");
                    choice = sc.nextInt();
                }

                System.out.print("Please select a valid square on the selected board: ");
                square = sc.next().charAt(0);
                System.out.println("Selected Square : " + square);
                Game g = new Game(boxes[choice], square, p1);
                // calling the function to add choice to the board
                g.bT(); //replace xo where ever selected

                //printing the board
                printArr(boxes);

            }
            //if count -> turns 1 3 5 7 player O will play
            else if (count % 2 != 0) {
                choice = Integer.parseInt(String.valueOf(square));
                System.out.println("Selected Board : " + choice);

                System.out.print("Selected Square : ");
                square = sc.next().charAt(0);
                Game g = new Game(boxes[choice], square, p2);
                g.bT();

                //printing the board
                printArr(boxes);

                if (g.checks(p1, boxes[choice].box)) { //sends array of box objects w box chosen
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p1);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }

                if (g.checks(p2, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p2);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
            }
            // in turns 2 4 6 8, X will play
            else if (count % 2 == 0) {
                choice = Integer.parseInt(String.valueOf(square));
                System.out.println("Selected Board : " + choice);
                //System.out.println("Please select a valid square on the selected board: ");

                System.out.print("Selected Square : ");
                square = sc.next().charAt(0);
                Game g = new Game(boxes[choice], square, p1);
                g.bT();
                //printing the board
                printArr(boxes);

                if (g.checks(p1, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p1);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
                if (g.checks(p2, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p2);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
            }
            // if there are 9 wins then the loop will exit
            if (wins == 9) {
                for (int i = 0; i < 9; i++) {
                    System.out.println("Box #" + boxes[i].getNum() + " Winner is: " + boxes[i].getPlayerWin());
                }
                if(boxes[0].getPlayerWin() == boxes[1].getPlayerWin() && boxes[0].getPlayerWin() == boxes[2].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[0].getPlayerWin() == boxes[4].getPlayerWin() && boxes[0].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[0].getPlayerWin() == boxes[3].getPlayerWin() && boxes[0].getPlayerWin() == boxes[6].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[1].getPlayerWin() == boxes[4].getPlayerWin() && boxes[1].getPlayerWin() == boxes[7].getPlayerWin()){
                    System.out.println(boxes[1].getPlayerWin() + " is the winner!!!");
                } else if(boxes[2].getPlayerWin() == boxes[5].getPlayerWin() && boxes[2].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[2].getPlayerWin() + " is the winner!!!");
                } else if(boxes[3].getPlayerWin() == boxes[4].getPlayerWin() && boxes[3].getPlayerWin() == boxes[5].getPlayerWin()){
                    System.out.println(boxes[3].getPlayerWin() + " is the winner!!!");
                } else if(boxes[6].getPlayerWin() == boxes[7].getPlayerWin() && boxes[6].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[1].getPlayerWin() + " is the winner!!!");
                } else {
                    System.out.println("The game is a tie!!!");
                }
                break;
            }
            count++;
        }
    }

    public void computerPlay() throws ArrayIndexOutOfBoundsException, InputMismatchException{
        //9 objects of class box - makes 9 boxes of ttt in 3x3 format
        Scanner sc = new Scanner(System.in);
        Box b0 = new Box(0);
        Box b1 = new Box(1);
        Box b2 = new Box(2);
        Box b3 = new Box(3);
        Box b4 = new Box(4);
        Box b5 = new Box(5);
        Box b6 = new Box(6);
        Box b7 = new Box(7);
        Box b8 = new Box(8);

        // store objects in array of Box name boxes
        Box[] boxes = {b0, b1, b2, b3, b4, b5, b6, b7, b8};

        char p1 = 'X', p2 = 'O', square = 's';
        int count = 0, wins = 0, choice;

        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");

        while (true) {

            if (count % 2 == 0) {
                System.out.println("Current Player is : " + p1);
            } else {
                System.out.println("Current Player is : " + p2);
            }
            // first time the user will input the square
            if (count == 0) {

                System.out.println("Please select a valid board [0 - 8]: ");

                System.out.print("Selected Board : ");
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please select a valid board [0 - 8]: ");
                    sc.nextLine();
                    choice = sc.nextInt();
                }
                if(choice > 8){
                    System.out.println("Please select a valid board: ");
                    sc.nextInt();
                }
                System.out.print("Please select a valid square on the selected board: ");
                square = sc.next().charAt(0);
                System.out.println("Selected Square : " + square);
                Game g = new Game(boxes[choice], square, p1);
                // calling the function to add
                g.bT();
                //printing the board
                printArr(boxes);

            }

            //count is odd -> all the turns 1 3 5 7, player O will play
            else if (count % 2 != 0) {

                choice = Integer.parseInt(String.valueOf(square));
                System.out.println("Selected Board : " + choice);

                System.out.print("Selected Square : ");
                int a = (int) (0 + (Math.random() * (8 - 0)));
                String b = Integer.toString(a);

                square= b.charAt(0);
                System.out.println(square);
                Game g = new Game(boxes[choice], square, p2);
                g.bT();
                //printing the board
                printArr(boxes);
                if (g.checks(p1, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p1);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
                if (g.checks(p2, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p2);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
            }
            // if count is even  (count%2 is zero) -> all the turns 2 4 6 8, player X will play
            else  {

                choice = Integer.parseInt(String.valueOf(square));
                System.out.println("Selected Board : " + choice);
                //System.out.println("Please select a valid square on the selected board: ");

                System.out.print("Selected Square : ");

                square = sc.next().charAt(0);

                //check for invalid input for square
                if(square > '8'){
                    System.out.println("Please select a valid square [0 - 8]: ");
                    square = sc.next().charAt(0);
                }


                Game g = new Game(boxes[choice], square, p1);
                g.bT();

                //printing the board
                printArr(boxes);


                if (g.checks(p1, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p1);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
                if (g.checks(p2, boxes[choice].box)) {
                    if (!boxes[choice].isFlag()) {
                        wins++;
                        boxes[choice].setPlayerWin(p2);
                        g.change(boxes[choice].box);
                        boxes[choice].setFlag(true);
                    }
                }
            }

            // if there are 9 wins then the loop will exit
            if (wins == 9) {
                for (int i = 0; i < 9; i++) {
                    System.out.println("Box #" + boxes[i].getNum() + " Winner is: " + boxes[i].getPlayerWin());
                }
                if(boxes[0].getPlayerWin() == boxes[1].getPlayerWin() && boxes[0].getPlayerWin() == boxes[2].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[0].getPlayerWin() == boxes[4].getPlayerWin() && boxes[0].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[0].getPlayerWin() == boxes[3].getPlayerWin() && boxes[0].getPlayerWin() == boxes[6].getPlayerWin()){
                    System.out.println(boxes[0].getPlayerWin() + " is the winner!!!");
                } else if(boxes[1].getPlayerWin() == boxes[4].getPlayerWin() && boxes[1].getPlayerWin() == boxes[7].getPlayerWin()){
                    System.out.println(boxes[1].getPlayerWin() + " is the winner!!!");
                } else if(boxes[2].getPlayerWin() == boxes[5].getPlayerWin() && boxes[2].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[2].getPlayerWin() + " is the winner!!!");
                } else if(boxes[3].getPlayerWin() == boxes[4].getPlayerWin() && boxes[3].getPlayerWin() == boxes[5].getPlayerWin()){
                    System.out.println(boxes[3].getPlayerWin() + " is the winner!!!");
                } else if(boxes[6].getPlayerWin() == boxes[7].getPlayerWin() && boxes[6].getPlayerWin() == boxes[8].getPlayerWin()){
                    System.out.println(boxes[1].getPlayerWin() + " is the winner!!!");
                } else {
                    System.out.println("The game is a tie!!!");
                }
                break;
            }
            count++;
        }
    }


}
