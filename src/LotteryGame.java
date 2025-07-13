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
    protected double amount;
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
            phoneNumber = "+254" + phoneNumber;
            bannerMessage();
        }else{
            System.out.println("INVALID PHONE NUMBER");
            Player retry = new Player();
        }
    }

    void payment(){
        System.out.println("PROCESSING PAYMENT...");
    }

    void checkout(){
        System.out.printf("""
                =================================================================
                |                 ** START OF RECEIPT **                        |
                |                                                               |
                | [*] TICKET BOUGHT SUCCESSFULLY!                               |
                |                                                               |
                |   PLAYER: %s   AMOUNT : Ksh. %.2f                             
                =================================================================\
                \n
                """,playerName,amount);
    }
    void winnerMessage(){
        System.out.printf("""
                =================================================================
                |                 YOU ARE THE LUCKY WINNER !                    |
                =================================================================
                |                                                               
                |       [*] YOU HAVE WON THE JACKPOT!                           
                |       [*] PLAYER NAME: %s                                
                |       [*] PHONE NUMBER: %s                               
                |       [*] AMOUNT: Ksh.10,000,000                           
                |       [*] TICKETS LEFT: %d                                    
                |                                                               
                =================================================================
                |                  BET RESPONSIBLY!                             |
                |                  * CASH PAYOUTS SUBJECT TO TAX                |
                |                  * TRY YOUR LUCK AGAIN TOMORROW!              |
                | CONGRATULATIONS!!!  CONGRATULATIONS!!!   CONGRATULATIONS!!!   |
                =================================================================
                \n
                """, playerName,phoneNumber,(tickets-1));
        playAgain();
    }

    void playAgain(){
        String choice;
        Scanner get = new Scanner(System.in);
        System.out.println("WOULD YOU WISH TO PLAY AGAIN? (Y/N)");
        System.out.print(">> ");
        choice = get.next();
        switch (choice){
            case "Y":
                if(attempts > 0){
                    System.out.println("YOU HAVE " + (attempts) + " ATTEMPTS REMAINING");
                    playGame();
                }
                break;
            case "N":
                System.out.println("THANK YOU FOR PLAYING!!!");
                System.out.println("BUY MORE TICKETS? (Y/N)");
                System.out.print(">> ");
                String buy  = get.next();
                switch (buy){
                    case "Y":
                        buyTicket();
                        break;
                    case "N":
                        System.out.println("COME BACK TOMORROW FOR NEXT JACKPOT!!");
                        break;
                    default:
                        Player retry = new Player();
                }
                break;
            default:

        }
    }

    void loserMessage(){
        if(attempts==0){
            System.out.printf("""
                =================================================================
                |                         YOU LOST !                            |
                =================================================================
                   ATTEMPTS LEFT: %d      TRY AGAIN TOMORROW
                \n
                """,attempts);
        }else{
            System.out.printf("""
                =================================================================
                |                         YOU LOST !                            |
                =================================================================
                   ATTEMPTS LEFT: %d      TRY AGAIN
                \n
                """,attempts);
            playAgain();
        }
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
        choice = getChoice.nextInt(); tickets = choice;
        System.out.println("CONFIRM TO BUY " + choice +" TICKETS (Y/N)");
        System.out.print(">> ");
        confirm = getChoice.next();
        switch(confirm){
            case "Y":
                System.out.printf("AMOUNT: Ksh. %d\n", (choice * price));
                Scanner pay = new Scanner(System.in);
                System.out.println("ENTER AMOUNT PAID");
                System.out.print(">> ");
                amount = pay.nextDouble();
                payment();
                if(amount > (choice*price)) {
                    double rem = amount - (choice * price);
                    if(rem > 0){
                        System.out.printf("BALANCE: %.2f\n", rem);
                        System.out.println("BALANCE SETTLED? (Y/N)");
                        System.out.print(">> ");
                        String bal_choice = pay.next();
                        switch (bal_choice){
                            case "Y":
                                checkout();
                                playGame();
                                break;
                            case "N":
                                System.out.println("GIVE BALANCE");
                                break;
                        }
                    }else{
                        System.out.println("NO BALANCE!");
                        checkout();
                        playGame();
                    }
                }else{
                    System.out.println("NOT ENOUGH TO PAY FOR TICKET(S)!!");
                }
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
        do{
            System.out.printf("""
                     =================================================================
                     |       HELLO, %s                                            
                     |       [*] THIS IS THE GUESSING GAME, GUESS ANY NUMBER BETWEEN |
                     |           0-9 IN ANY ORDER                                    |
                     |       [*] GOOD LUCK!!                                         |
                     |                                                               |
                     |                                                               |
                     =================================================================
                     \n
                     """,playerName);
            System.out.print(">> ");
            Scanner get = new Scanner(System.in);
            playerGuess = get.nextLine();
            if(playerGuess.contains("86439812")){
                winnerMessage();
                break;
            }else{
                loserMessage();
            }
            attempts--;
        }while(attempts > 0);
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
