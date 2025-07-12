/* LOTTERY GAME PROGRAM
* Implement a java program for lottery game that allows the user to enter a 8-digit guess.
* The user has up to a maximum of 5 attempts.
* For every wrong attempt, a message is displayed showing number of attempts remaining
* e.g. "Wrong guess. You have X trials remaining".
* If the user exhausts all the attempts, system displays "Maximum trials reached. Try again tomorrow".
* If the user makes the correct guess (86439812),
* the program displays "You are the lucky winner of Ksh.1 Million. We will contact you shortly".
* Use appropriate control structures.
*/
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.*;
class Player{
    protected String playerName;
    protected String phoneNumber;
    protected String playerGuess;
    protected int tickets = 0;
    protected int attempts = 5;
    Player(){
        Scanner get = new Scanner(System.in);
        System.out.println("--- PLAYER REGISTRATION ---");
        System.out.print("PLAYER NAME:");
        playerName = get.nextLine();
        System.out.print("PHONE NUMBER: +254 ");
        phoneNumber = get.nextLine();
        validatePhoneNumber();
    }
    void validatePhoneNumber(){
        if(phoneNumber.startsWith("0") ||phoneNumber.startsWith("1") || phoneNumber.startsWith("2") || phoneNumber.startsWith("3") || phoneNumber.startsWith("4") || phoneNumber.startsWith("5") ||phoneNumber.startsWith("6") || phoneNumber.startsWith("7") || phoneNumber.startsWith("8") || phoneNumber.startsWith("9") && phoneNumber.length() == 9){
            System.out.println("VALID PHONE NUMBER");
            bannerMessage();
        }else{
            System.out.println("INVALID PHONE NUMBER");
            Player retry = new Player();
        }
    }

    void payment(){
        System.out.print("PROCESSING PAYMENT...");
    }

    void checkout(){
        System.out.println("""
                =================================================================
                |                 ** START OF RECEIPT **                        |
                |                                                               |
                | [*] TICKET BOUGHT SUCCESSFULLY!                               |
                | [*] ENTER TICKET NUMBER TO PROCEED                            |
                |                                                               |
                =================================================================
                """);
    }
    void winnerMessage(){
        System.out.printf("""
                =================================================================
                |                 YOU ARE THE LUCKY WINNER !                    |
                =================================================================
                |                                                               |
                |       [*] YOU HAVE WON THE JACKPOT!                           |
                |       [*] PLAYER NAME: %s                                     |
                |       [*] PHONE NUMBER: %s                                    |
                |       [*] AMOUNT: Ksh.10,000,000                              |
                |       [*] TICKETS LEFT: %d                                    |
                |                                                               |
                =================================================================
                |                  BET RESPONSIBLY!                             |
                |                  * CASH PAYOUTS SUBJECT TO TAX                |
                |                  * TRY YOUR LUCK AGAIN TOMORROW!              |
                | CONGRATULATIONS!!!  CONGRATULATIONS!!!   CONGRATULATIONS!!!   |
                =================================================================
                \n
                """, playerName,phoneNumber,(tickets-1));
    }

    void buyTicket(){
        Scanner getChoice = new Scanner(System.in);
        int choice;
        String confirm;
        String pass;
        final int price = 50;
        System.out.println("""
                =================================================================
                |                            BUY TICKET                         |
                |     TICKETS @Ksh.50 EACH                                      |
                |       [*] ENTER NUMBER OF TICKETS TO BUY                      |
                |                                                               |
                |     BEST OF LUCK!!!                                           |
                =================================================================
                """);
        System.out.print(">> ");
        choice = getChoice.nextInt();
        System.out.println("CONFIRM TO BUY " + choice +" TICKETS (Y/N)");
        System.out.print(">> ");
        confirm = getChoice.next();
        switch(confirm){
            case "Y":
                System.out.println("AMOUNT: Ksh." + choice * price);
                break;
            case "N":
                bannerMessage();
                break;
            default:
                buyTicket();
                break;
        }

    }
    void playGame(){

    }

    void bannerMessage(){
        Scanner getChoice = new Scanner(System.in);
        String choice;
        System.out.println("""
                  =================================================================
                  |                      L O T T E R Y   G A M E                  |
                  |                                                               |
                  |  [*] Jackpot: Ksh.10,000,000                                  |
                  |  [*] Tickets: Only Ksh.50 each                                |
                  |  [*] Draws everyday at 8PM EST                                |
                  |                                                               |
                  |  >> Type 'play' to try your luck!                             |
                  |  >> Type 'help' for game rules                                |
                  |                                                               |
                  =================================================================
                  """);
        System.out.print(">> ");
        choice = getChoice.nextLine();
        switch(choice){
            case "play":
                buyTicket();
                break;
            case "help":
                gameRules();
                break;
            default:
                System.out.println("INVALID CHOICE");
                bannerMessage();
                break;
        }
    }
    void gameRules() {
        Scanner get = new Scanner(System.in);
        String choice;
        System.out.println("""
                =================================================================
                |                        GAME RULES                             |
                |                                                               |
                |  [*] BUY TICKET FIRST                                         |
                |  [*] ENTER 8-DIGIT GUESS                                      |
                |  [*] YOU HAVE 5 ATTEMPTS TO GET IT RIGHT                      |
                |                                                               |
                |  >> HOW TO BUY TICKET?                                        |
                |     -- ENTER NUMBER OF TICKETS YOU WANT TO BUY                |
                |     -- ENTER YOUR PASSWORD TO PURCHASE TICKET                 |
                |                                                               |
                |  >> Type 'play' to try your luck!                             |
                |                                                               |
                =================================================================               
                """);
        System.out.print(">> ");
        choice = get.nextLine();
        switch (choice){
            case "play":
                buyTicket();
                break;
            default:
                gameRules();
                break;
        }
    }

}

public class LotteryGame {
    public static void main(String[] args){
        Player p1 = new Player();

    }
}
