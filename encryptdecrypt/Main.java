package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        String stringToEncrypt = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());

        if ("enc".equals(action)) {
            System.out.println(EncryptorUtil.getEncryptedString(stringToEncrypt, key));
        } else {
            System.out.println(EncryptorUtil.getDecryptedString(stringToEncrypt, key));
        }
    }
}
