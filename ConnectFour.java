
import java.util.*;
public class ConnectFour {
public static void main(String[] args) {
//create a 2D array that will contain the letters R and Y
char[][] array = new char[6][7];
char player1 = 'R';
char player2 = 'Y';
//calling the functions Initialize and Printlines to display the board
Initialize(array);
Printlines(array);
//ask the user to input a value
Scanner input = new Scanner(System.in);
char start_player = player1;
//establish the condition
while (true) {
// prompt the Red or yellow user to enter a value
if (start_player == player1) {
System.out.println("Drop a red disk at column between 0 and 6: ");
} else {
System.out.println("Drop a yellow disk at column between 0 and 6: ");
}
//ask the user where they want to drop the disk( index of the disk)
int column = input.nextInt();

// Drop disk into the column and print the board again
dropDisk(array, column, start_player);
Printlines(array);

// Check for win conditions and display who is the winner
if (HorizontalWin(array, column, start_player)) {
System.out.println("The player " + start_player + " won");
break;
}
if (VerticalWin(array, column, start_player)){
System.out.println("The player  " + start_player + " won");
break;
}

            // Switch players so that they can alternatively play
if (start_player == player1) {
start_player = player2;
} else {
start_player = player1;
}
}


}
//creates a method to have spaces where R and Y are going to be stored
public static void Initialize(char[][] array) {
        //for each loop
for (char[] i : array) {
for (int j = 0; j < i.length; j++) {
i[j] = ' ';
}
}
}
// creates a method that print the vertical bar that shows the game board
public static void Printlines(char[][] array) {
for (char[] k : array) {
for (char elt : k) {
System.out.print("|" + elt);
}
System.out.println("|");
}
System.out.println("---------------");
}
//creates a method that drop the disk at the specified place 
public static void dropDisk(char[][] array, int column, char start_player) {
for (int i = array.length - 1; i >= 0; i--) {
if (array[i][column] == ' ') {
array[i][column] = start_player;
break;
}
}
}
// creates a method that check the horizontal win and takes the array, column, and the player
public static boolean HorizontalWin(char[][] array, int column, char start_player) {

for (int i = 0; i < array.length; i++) {
int count = 0;
for (int j = 0; j < array[0].length; j++) {
if (array[i][j] == start_player) {
count++;  // Increment count when the disk matches the player's disk
if (count >= 4) {  // Check for win condition after incrementing count
return true;
}
} else {
count = 0;  // Reset count if the current disk does not match the player's disk
}
}
}
return false;
}

// creates a method that check the vertical win and takes the array, column, player
public static boolean VerticalWin(char[][] array, int column, char start_player) {
//initialize the count 
int count = 0;

for (int i = 0; i < array.length; i++) {
if (array[i][column] == start_player) {
count++;
if (count >= 4) {
return true;
}
} else {
count = 0;
}
}
return false;
}

}



