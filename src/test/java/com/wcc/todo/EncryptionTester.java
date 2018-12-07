package com.wcc.todo;

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
    public void testEncryption() {
        String old;
        String encrypted;
        for (int i = 0; i < 100; i++) {
            old = generateString(8);
            encrypted = EncryptionUtils.encrypt(old);
            boolean same = EncryptionUtils.validate(old,encrypted);
            System.out.println("same = " + same);
        }
    }
}
