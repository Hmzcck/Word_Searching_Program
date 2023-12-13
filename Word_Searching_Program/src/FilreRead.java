import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class FileRead

{
    wordNode head = new wordNode("");

    FileList lists[][][] = new FileList[26][26][26];

    FileRead() throws IOException {
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists.length; j++) {
                for (int k = 0; k < lists.length; k++) {
                    lists[i][j][k] = new FileList();
                }
            }
        }
        File output = new File("out.txt");
        File input = new File("input.txt");
        Scanner fscan = new Scanner(input);
        BufferedWriter out = new BufferedWriter(new FileWriter(output));

        while (fscan.hasNext()) {

            String a = fscan.nextLine();
            String cc[] = a.split("[^a-zA-Z]+");

            for (String c : cc) {
                if (c != "") {
                    c = c.toLowerCase(Locale.forLanguageTag("en_US"));

                    if (c.length() > 2)
                        lists[c.charAt(0) - 97][c.charAt(1) - 97][c.charAt(2) - 97].add(c);
                    else if (c.length() > 1)
                        lists[c.charAt(0) - 97][c.charAt(1) - 97][0].add(c);
                    else
                        lists[c.charAt(0) - 97][0][0].add(c);
                }
            }

        }
        fscan.close();
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists.length; j++) {
                for (int k = 0; k < lists.length; k++) {
                    wordNode walk = lists[i][j][k].head;
                    while (walk != null) {
                        if (walk.word != "") {
                            out.write(walk.word + ": " + walk.count);
                            out.newLine();
                        }
                        walk = walk.next;
                    }
                }
            }
        }

        out.close();

    }

    public void print(Character a, Character b, Character c) {
        wordNode walk = lists[a - 97][b - 97][c - 97].head;
        while (walk != null) {
            if (walk.word != "")
                System.out.println(walk.word + ": " + walk.count);
            walk = walk.next;
        }
    }

    public void search(String key) {
        if (key.length() > 0) {
            int fIndex = key.charAt(0) - 97;
            int sIndex = 0;
            int tIndex = 0;
            if (key.length() > 2) {
                sIndex = key.charAt(1) - 97;
                tIndex = key.charAt(2) - 97;

            } else if (key.length() > 1) {
                sIndex = key.charAt(1) - 97;
            }

            wordNode walk = lists[fIndex][sIndex][tIndex].head;
            while (walk != null) {
                if (walk.word.equals(key)) {
                    System.out.println(key + ": " + walk.count);
                    return;
                }
                walk = walk.next;
            }

            System.out.println("Cannot found the word.");

        }

    }
}