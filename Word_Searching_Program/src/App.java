import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        FileRead a = new FileRead();
        long endTime = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime);
        ;
        System.out.println(totalTime + " secons");
        Scanner scan = new Scanner(System.in);
        boolean end = false;
        while (end == false) {
            System.out.println("1 - Search word:");
            System.out.println("2 - Print wordlist:");
            System.out.println("3- Exit:");
            int choice = 0;
            boolean noerror = false;
            while(noerror==false){
            try {
                choice = Integer.parseInt(scan.nextLine());
                noerror = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter a number:");
            }
        }
            if (choice == 1) {
                System.out.print("Enter the word:");
                String word = scan.nextLine().toLowerCase().trim();
                if (!word.matches("[a-zA-Z]+")) {
                    while (!word.matches("[a-zA-Z]+")) {
                        System.out.print("Enter only alphabetic letters (no numbers etc...):");
                        word = scan.nextLine().toLowerCase().trim();
                    }
                }
                a.search(word);
            } else if (choice == 2) {
                System.out.print("Enter the letters to search max 3 letters min 1 letter Ex:(a, b, c or a or a,b):");
                String word[] = scan.nextLine().toLowerCase().trim().split("[\\s,]+");
                System.out.println(word[0]);
                if (!String.join("", word).matches("[a-zA-Z]+")) {
                    while (!String.join("", word).matches("[a-zA-Z]+")) {
                        System.out.print("Enter at leas 1 letter:");
                        word = scan.nextLine().toLowerCase().trim().split("[\\s,]+");
                    }
                }
                Character fL = 'a';
                Character sL = 'a';
                Character tL = 'a';
                if (word.length > 2) {
                    fL = word[0].charAt(0);
                    sL = word[1].charAt(0);
                    tL = word[2].charAt(0);
                    a.print(fL, sL, tL);
                } else if (word.length > 1) {
                    fL = word[0].charAt(0);
                    sL = word[1].charAt(0);
                    for (int i = 0; i < 26; i++) {
                        tL = (char) (97 + i);
                        a.print(fL, sL, tL);
                    }
                } else {
                    fL = word[0].charAt(0);
                    for (int i = 0; i < 26; i++) {
                        tL = (char) (97 + i);
                        for (int j = 0; j < 26; j++) {
                            sL = (char) (97 + j);
                            a.print(fL, sL, tL);
                        }

                    }

                }

            } else if(choice==3){
                end = true;
                System.out.println("Terminated.");
            }
            else 
            {
                System.out.println("Enter 1, 2, or 3");
            }
        }
        scan.close();
    }
}
