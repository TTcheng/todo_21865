package com.wcc.base.utils;

import com.wcc.base.exception.BusinessException;

public class EncryptionUtils {
    private static final int cipherlen = 30;//密文长度
    private static final char increasingVal = 57;
    private static final int offset = 19;

    public static String encrypt(String plaintext) throws BusinessException {
        if (plaintext.length() > cipherlen) {
            throw new BusinessException("密码超过最大长度！");
        }
        char[] sourceChars = plaintext.toCharArray();
        char[] targetChars = new char[30];
        int len = sourceChars.length;
        int displacement = (len + offset) % len;
        for (int i = 0; i < len; i++) {
            char c = sourceChars[i];
            targetChars[(i + displacement) % len] = (char) ((c + increasingVal) % (128));
        }
        for (int i = len; i < cipherlen; i++) {
            targetChars[i] = (char) (Math.random() * 128);
        }
        return new String(targetChars);
    }

    public static boolean validate(String plaintext, String ciphertext) throws BusinessException {
        int plaintextLen = plaintext.length();
        String encrypted = encrypt(plaintext);
        String source = encrypted.substring(0, plaintextLen);
        String target = ciphertext.substring(0, plaintextLen);
        return source.equals(target);
    }
}
