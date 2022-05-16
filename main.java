//jazz sajan 05/04/22 cs 2336.003
/*
Analysis: This program creates a simulation for Ultimate Tic-Tac-Toe.
Additional and complete analysis is given in the README file.
Design: There are 4 classes with various roles to run the game. Primarily 2D array is used
for the basis of the game. Loops and if statements are utilized throughout.
*/
package game;
import java.util.Scanner;


public class main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Play p = new Play();
        var a = 0;
        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");

        // menu for displaying the choice of user
        while(a!='1' || a!= '2') { //check for invalid input
            System.out.println("1. player vs player\n2. player vs computer");
            char c = sc.next().charAt(0);
            a = (int) c;

            // if the player wants to play with another player, press 1
            if (a == '1') {
                p.play();
            }
            // if the player wants to play with computer, press 2
            else if (a == '2') {
                p.computerPlay();
            }
        }
    }
}
