package encryptdecrypt;

public class EncryptorUtil {
    public static String getEncryptedString(String plainString, int key, String algorithm) {
        StringBuilder result = new StringBuilder();

        if ("shift".equals(algorithm)) {
            final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

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
        } else {
            for (char c : plainString.toCharArray()) {
                int newUnicodeIndex = c + key;
                result.append((char) newUnicodeIndex);
            }
        }

        return result.toString();
    }

    public static String getDecryptedString(String encryptedString, int key, String algorithm) {
        StringBuilder result = new StringBuilder();

        if ("shift".equals(algorithm)) {
            final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

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
        } else {
            for (char c : encryptedString.toCharArray()) {
                int newUnicodeIndex = c - key;
                result.append((char) newUnicodeIndex);
            }
        }
        return result.toString();
    }
}
