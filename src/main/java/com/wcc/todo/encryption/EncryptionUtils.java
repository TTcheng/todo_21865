package com.wcc.todo.encryption;

public class EncryptionUtils {
    private static final int cipherlen = 30;//密文长度
    private static final char increasingVal = 57;
    private static final int offset = 19;
    public static String encrypt(String plaintext) {
        char[] sourceChars = plaintext.toCharArray();
        char[] targetChars = new char[30];
        int len = sourceChars.length;
        int displacement = (len + offset)%len;
        for (int i = 0; i < len; i ++) {
            char c = sourceChars[i];
            targetChars[(i+displacement)%len] = (char) ((c + increasingVal)%(128));
        }
        /* todo fill to cipherlen
        for (int i = len; i < cipherlen; i++) {
            targetChars[i] = (char) ((i * increasingVal + )%128);
        }*/
        return new String(targetChars);
    }

    public static boolean validate(String plaintext,String ciphertext) {
        String encrypted = encrypt(plaintext);
        return encrypted.equals(ciphertext);
    }
}
