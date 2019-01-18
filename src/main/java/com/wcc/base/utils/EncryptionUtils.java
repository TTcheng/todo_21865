package com.wcc.base.utils;


import com.wcc.base.exception.BusinessException;

import javax.validation.constraints.NotNull;

/**
 * 简单的加密
 * @author wangchuncheng
 */
public class EncryptionUtils {
    /** 密文长度 */
    private static final int CIPHER_LEN = 30;
    private static final char INCREASING_VAL = 57;
    private static final int OFFSET = 19;

    private EncryptionUtils() {
    }

    public static String encrypt(String plaintext) throws BusinessException {
        if (plaintext.length() > CIPHER_LEN) {
            throw new BusinessException("密码超过最大长度！");
        }
        char[] sourceChars = plaintext.toCharArray();
        char[] targetChars = new char[30];
        int len = sourceChars.length;
        int displacement = (len + OFFSET) % len;
        for (int i = 0; i < len; i++) {
            char c = sourceChars[i];
            targetChars[(i + displacement) % len] = (char) ((c + INCREASING_VAL) % (128));
        }
        return new String(targetChars);
    }

    public static boolean validate(@NotNull String plaintext, String ciphertext) throws BusinessException {
        String source = encrypt(plaintext);
        return source.equals(ciphertext);
    }
}