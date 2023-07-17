package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        // default values
        String mode = "enc";
        int key = 0;
        String data = "";

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
            }
        }

        if ("enc".equals(mode)) {
            System.out.println(EncryptorUtil.getEncryptedString(data, key));
        } else {
            System.out.println(EncryptorUtil.getDecryptedString(data, key));
        }
    }
}
