package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // default values
        String mode = "enc";
        int key = 0;
        String data = "";
        String filePathIn = null;
        String filePathOut = null;

        // get values from args
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                i++;
                if (i < args.length) {
                    mode = args[i];
                }
            } else if ("-key".equals(args[i])) {
                i++;
                if (i < args.length) {
                    key = Integer.parseInt(args[i]);
                }
            } else if ("-data".equals(args[i])) {
                i++;
                if (i < args.length) {
                    data = args[i];
                }
            } else if ("-in".equals(args[i])) {
                i++;
                if (i < args.length) {
                    filePathIn = args[i];
                }
            } else if ("-out".equals(args[i])) {
                i++;
                if (i < args.length) {
                    filePathOut = args[i];
                }
            }
        }

        if (filePathIn != null && data.isBlank()) {
            data = getDataFromFile(filePathIn);
        }

        String outputString;
        if ("enc".equals(mode)) {
            outputString = EncryptorUtil.getEncryptedString(data, key);
        } else {
            outputString = EncryptorUtil.getDecryptedString(data, key);
        }

        if (filePathOut != null) {
            saveDataToFile(filePathOut, outputString);
        } else {
            System.out.println(outputString);
        }
    }

    private static void saveDataToFile(String filePathOut, String outputString) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOut))) {
            bw.write(outputString);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static String getDataFromFile(String filePathIn) {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePathIn))) {
            while (scanner.hasNext()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return result.toString();
    }
}
