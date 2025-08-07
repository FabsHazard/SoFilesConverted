package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* compiled from: RandomUtil */
public class n6 {
    private static final SecureRandom a = new SecureRandom();

    public static int a(int i) {
        return a.nextInt(i);
    }

    public static float a(float f) {
        return a.nextFloat() * f;
    }
}
