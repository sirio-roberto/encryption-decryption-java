package encryptdecrypt;

public class EncryptorUtil {
    private static final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String getEncryptedString(String plainString, int key, String algorithm) {
        if ("shift".equals(algorithm)) {
            return shiftEncryption(plainString, key);

        } else {
            return unicodeEncryption(plainString, key);
        }
    }

    private static String unicodeEncryption(String plainString, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : plainString.toCharArray()) {
            int newUnicodeIndex = c + key;
            result.append((char) newUnicodeIndex);
        }
        return result.toString();
    }

    private static String shiftEncryption(String plainString, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : plainString.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    int newIndex = (LOWER_ALPHABET.indexOf(c) + key) % LOWER_ALPHABET.length();
                    result.append(LOWER_ALPHABET.charAt(newIndex));
                } else {
                    int newIndex = (UPPER_ALPHABET.indexOf(c) + key) % UPPER_ALPHABET.length();
                    result.append(UPPER_ALPHABET.charAt(newIndex));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String getDecryptedString(String encryptedString, int key, String algorithm) {
        if ("shift".equals(algorithm)) {
            return shiftDecryption(encryptedString, key);
        } else {
            return unicodeDecryption(encryptedString, key);
        }
    }

    private static String unicodeDecryption(String encryptedString, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : encryptedString.toCharArray()) {
            int newUnicodeIndex = c - key;
            result.append((char) newUnicodeIndex);
        }
        return result.toString();
    }

    private static String shiftDecryption(String encryptedString, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : encryptedString.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    int newIndex = LOWER_ALPHABET.indexOf(c) - key;
                    if (newIndex < 0) {
                        newIndex += LOWER_ALPHABET.length();
                    }
                    result.append(LOWER_ALPHABET.charAt(newIndex));
                } else {
                    int newIndex = UPPER_ALPHABET.indexOf(c) - key;
                    if (newIndex < 0) {
                        newIndex += UPPER_ALPHABET.length();
                    }
                    result.append(UPPER_ALPHABET.charAt(newIndex));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
