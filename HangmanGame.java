import java.util.*;

public class HangmanGame {
public static void main(String[] args) {
String[] words = {"elephant", "cow", "horse", "carriage", "mouse", "executioner", "caravane", "octopus"};

Scanner scanner = new Scanner(System.in);
boolean play = true;

while (play) {
Random random = new Random();
int randomIndex = random.nextInt(words.length);
String randomWord = words[randomIndex];
int count = 0;
char[] letters = new char[randomWord.length()];
for (int i = 0; i < letters.length; i++) {
letters[i] = '*';
}
// Flag to check if the word has been completed
boolean wordComplet = false;
// Loop for guessing letters
while (!wordComplet) {

//ask the user input
System.out.print("(Guess) Enter a letter in a word " +   String.valueOf(letters) + " > ");
String input = scanner.nextLine().toLowerCase();
//character at the first index
char guessed = input.charAt(0);
boolean found = false;
//loop through the random word and check if each character is equal to the word guessed
for (int i = 0; i < randomWord.length(); i++) {
if (randomWord.charAt(i) == guessed) {
//check if the input letter has not been guessed already
if (letters[i] != '*') {
System.out.println("You have already guessed '" + guessed + "'.");
found = true;
break;
}
letters[i] = guessed;
found = true;
}
}
// If the guessed letter is not found in the word, increment the count
if (!found) {
count++;
}
// Check if the word has been completed
wordComplet = true;
for (char i : letters) {
if (i == '*') {
wordComplet= false;
break;
}
}
// If the word has been completed, display the word and the number of misses

if (wordComplet) {
System.out.println("The word is " + randomWord + ". You missed " + count + " times.");
}
}
//ask the user if they want to play agian
System.out.print("Do you want to guess another word? Enter y or n: ");
//convert the input into lowercase
String newInput = scanner.nextLine().toLowerCase();
play = newInput.contains("y");
}

}
}
