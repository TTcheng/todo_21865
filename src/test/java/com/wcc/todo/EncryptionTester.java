package com.wcc.todo;

import com.wcc.base.exception.BusinessException;
import com.wcc.base.utils.EncryptionUtils;
import org.junit.Test;

public class EncryptionTester {
    private String generateString(int len) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = (char) ((Math.random() * 1000) % 128);
            builder.append(c);
        }
        return builder.toString();
    }

    @Test
    public void testEncryption() throws BusinessException {
        String old;
        String encrypted;

        old = "19960314";
        encrypted = EncryptionUtils.encrypt(old);
        System.out.println("old = " + old);
        System.out.println("encrypted = " + encrypted);
        /*for (int i = 0; i < 100; i++) {
            old = generateString(8);
            encrypted = EncryptionUtils.encrypt(old);
            boolean same = EncryptionUtils.validate(old,encrypted);
            System.out.println("old = " + old);
            System.out.println("encrypted = " + encrypted);
            System.out.println("same = " + same);
        }*/
    }

    @Test
    public void generatePwd() throws BusinessException {
        String password = "19960314";
        String ciphertext = EncryptionUtils.encrypt(password);
        System.out.println("ciphertext = " + ciphertext);
    }

}
