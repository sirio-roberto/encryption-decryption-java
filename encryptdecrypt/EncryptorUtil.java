package encryptdecrypt;

public class EncryptorUtil {
    public static String getEncryptedString(String plainString, int key) {
        StringBuilder result = new StringBuilder();
        for (char c: plainString.toCharArray()) {
            int newUnicodeIndex = c + key;
            result.append((char) newUnicodeIndex);
        }
        return result.toString();
    }

    public static String getDecryptedString(String encryptedString, int key) {
        StringBuilder result = new StringBuilder();
        for (char c: encryptedString.toCharArray()) {
            int newUnicodeIndex = c - key;
            result.append((char) newUnicodeIndex);
        }
        return result.toString();
    }
}
