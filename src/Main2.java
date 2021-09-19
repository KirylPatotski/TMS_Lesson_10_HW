import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Analyses all files you enter and creates analys files.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {

        String path;
        ArrayList<String> myArrayList = new ArrayList<>();
        int limit = 0;
        searchForPaths(myArrayList, limit);
        analyseDocument(myArrayList);

    }

    private static void analyseDocument(ArrayList<String> myArrayList) throws IOException {
        for (int loop = 0; loop < myArrayList.size(); loop++) {
            String filePathName = myArrayList.get(loop);


            File newFile = new File(filePathName);
            if (!newFile.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader1 = new FileReader(filePathName);
            FileReader fileReader2 = new FileReader(filePathName);
            char[] test = new char[65536];
            int i = 0;
            int newCharLength = 0;
            while ((i = fileReader1.read(test)) >= 0) {
                newCharLength = i;
            }
            i = 0;
            int q = 0;
            char[] c = new char[newCharLength];
            char[] c2 = new char[newCharLength];
            while ((i = fileReader2.read(c)) >= 0) {

                c2 = c;
            }
            String str;
            str = String.valueOf(c2);

            /**Analyzes*/
            long long1 = ThreadLocalRandom.current().nextLong(100000000, 999999999);
            String fileName = "C:\\Users\\Tatjana\\Lesson10HW\\validity" + (long1) + ".txt";
            String[] wordsO = str.split(",");
            File myFile = new File(fileName);
            List<String> list = Arrays.asList(wordsO);
            List<String> listCopy = list;
            int notToControlWord = 0;
            int check = 0;
            for (int asd = 0; asd < wordsO.length; asd++) {
                for (int yxcvb = 0; yxcvb < wordsO.length; yxcvb++) {
                    if (wordsO[asd].equals(wordsO[yxcvb])) {
                        if (yxcvb != asd) {
                            notToControlWord = asd;
                            check = 1;
                        }
                    }
                }
            }
            if (check == 0){
                notToControlWord = listCopy.size()+10;
            }
            System.out.println(notToControlWord);
            String[] words = new String[listCopy.size()];
            for (int bnm = 0; bnm < listCopy.size(); bnm++) {
                words[bnm] = listCopy.get(bnm);
            }
            try {
                myFile.createNewFile();
            } catch (FileAlreadyExistsException e) {
                System.out.println("Failed to create file because file already exists.");
                System.out.println(e.getMessage());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            String qwertz;
            writeFile(myFile, notToControlWord, words);

        }
    }


    static void searchForPaths(ArrayList<String> myArrayList, int limit) {
        String path;
        while (limit == 0) {
            System.out.print("Enter path to file: ");
            path = new Scanner(System.in).nextLine();
            myArrayList.add(path);
            if (!path.contains("C:") || path == "0" || path == null) {
                int var = myArrayList.size() - 1;
                myArrayList.remove(var);
                break;
            }
        }
    }

    static void writeFile(File myFile, int notToControlWord, String[] words) {
        String qwertz;
        for (int j = 0; j < words.length - 1; j++) {
            if (j != notToControlWord) {

                if (words[j].length() < 21) {
                    qwertz = ("Invalid: " + words[j] + "  is too short(" + words[j].length() + "). Found at position: " + j + "\n");
                    try (FileWriter fw = new FileWriter(myFile, true)) {
                        fw.write(qwertz);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (words[j].length() > 21) {
                    qwertz = ("Invalid: " + words[j] + "  is too long(" + words[j].length() + "). Found at position: " + j + "\n");
                    try (FileWriter fw = new FileWriter(myFile, true)) {
                        fw.write(qwertz);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (!words[j].contains("docnum") && !words[j].contains("contra")) {
                    qwertz = ("Invalid: " + words[j] + " does not have a specification. " + words[j].length() + " pos: " + j + "\n");
                    try (FileWriter fw = new FileWriter(myFile, true)) {
                        fw.write(qwertz);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (!words[j].matches(".*[0-9].*")) {
                    qwertz = ("Invalid: " + words[j] + "  does not contain numbers " + words[j].length() + " pos: " + j + "\n");
                    try (FileWriter fw = new FileWriter(myFile, true)) {
                        fw.write(qwertz);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        }
    }

}
