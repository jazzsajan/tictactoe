# tictactoe
The Ultimate Tic-Tac-Toe Game

This program creates a simulation for Ultimate Tic-Tac-Toe. The user can play with another player
or an AI. The game consists of 9 normal TTT boards in a 3x3 format. The board that is played on is
determined by the previous opponents square choice. The game is won when a player wins 3 entire boards
in a row.

I have created 4 classes in addition to main. The Play class consists of running the main game with loops
until there is a winner or tie. The Game class replaces a board with astricks if the board is won, replaces an X
or an O for the number on a board, and checks for a winner of a single board by utilizing the Move class.
The Move class consists of the functions to check the row, column, and diagonal. The Box class creates the
single box, and also contains a print method.

If I had to implement this game from the start again, I would break up the Play class into two different
classes, a Player class, and ComputerPlayer class. I feel this would allow for better code readability. The
Play class is fairly large, so splitting these options would make this class less overwhelming with code.
