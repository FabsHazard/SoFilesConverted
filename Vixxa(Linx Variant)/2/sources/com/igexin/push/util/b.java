package com.igexin.push.util;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.a.c;
import com.igexin.push.core.d;
import java.net.URISyntaxException;
import java.util.List;

public class b {
    private static String a = "CommonUtils";
    private static volatile Boolean b;

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0266, code lost:
        if (r12 == false) goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02ef, code lost:
        throw new java.net.URISyntaxException(r1, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02f1, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x003c, B:166:0x02dd] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a2 A[Catch:{ IllegalArgumentException -> 0x02e5, IndexOutOfBoundsException -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02a5 A[Catch:{ IllegalArgumentException -> 0x02e5, IndexOutOfBoundsException -> 0x02f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(java.lang.String r17, int r18) throws java.net.URISyntaxException {
        /*
            r1 = r17
            java.lang.String r0 = "android-app:"
            r2 = 0
            boolean r3 = r1.startsWith(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f3 }
            r4 = r18 & 3
            java.lang.String r5 = "intent:"
            java.lang.String r6 = "android.intent.action.VIEW"
            if (r4 == 0) goto L_0x0031
            boolean r4 = r1.startsWith(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            if (r4 != 0) goto L_0x0031
            if (r3 != 0) goto L_0x0031
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            r0.<init>(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            android.net.Uri r3 = android.net.Uri.parse(r17)     // Catch:{ IllegalArgumentException -> 0x0026 }
            r0.setData(r3)     // Catch:{ IllegalArgumentException -> 0x0026 }
            return r0
        L_0x0026:
            r0 = move-exception
            java.net.URISyntaxException r3 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            r3.<init>(r1, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x02f4 }
        L_0x0031:
            java.lang.String r4 = "#"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f3 }
            r7 = -1
            if (r4 != r7) goto L_0x0046
            if (r3 != 0) goto L_0x0056
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            android.net.Uri r2 = android.net.Uri.parse(r17)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r0.<init>(r6, r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            return r0
        L_0x0046:
            java.lang.String r8 = "#Intent;"
            boolean r8 = r1.startsWith(r8, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r8 != 0) goto L_0x0056
            if (r3 != 0) goto L_0x0055
            android.content.Intent r0 = b((java.lang.String) r17, (int) r18)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            return r0
        L_0x0055:
            r4 = r7
        L_0x0056:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r3.<init>(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r4 < 0) goto L_0x0064
            java.lang.String r6 = r1.substring(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            int r4 = r4 + 8
            goto L_0x0065
        L_0x0064:
            r6 = r1
        L_0x0065:
            android.os.Bundle r7 = r3.getExtras()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r7 != 0) goto L_0x0073
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r3.putExtras(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x0073:
            android.os.Bundle r7 = r3.getExtras()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r10 = r2
            r12 = r10
            r9 = r3
            r11 = 0
        L_0x007b:
            java.lang.String r13 = ":"
            java.lang.String r14 = ""
            if (r4 < 0) goto L_0x0205
            java.lang.String r15 = "end"
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 != 0) goto L_0x0205
            r15 = 61
            int r15 = r1.indexOf(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 >= 0) goto L_0x0093
            int r15 = r4 + -1
        L_0x0093:
            r8 = 59
            int r8 = r1.indexOf(r8, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 >= r8) goto L_0x00a5
            int r14 = r15 + 1
            java.lang.String r14 = r1.substring(r14, r8)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r14 = android.net.Uri.decode(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x00a5:
            java.lang.String r2 = "action="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r16 = 1
            if (r2 == 0) goto L_0x00b9
            r9.setAction(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r10 != 0) goto L_0x00b6
            r12 = r16
        L_0x00b6:
            r13 = 0
            goto L_0x01f8
        L_0x00b9:
            java.lang.String r2 = "category="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x00c5
            r9.addCategory(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x00c5:
            java.lang.String r2 = "type="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x00d1
            r9.setType(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x00d1:
            java.lang.String r2 = "launchFlags="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.decode(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            int r2 = r2.intValue()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r9.setFlags(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2 = r18 & 4
            if (r2 != 0) goto L_0x00b6
            r2 = 67
            r2 = r2 | 128(0x80, float:1.794E-43)
            int r13 = r9.getFlags()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            int r2 = ~r2     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2 = r2 & r13
            r9.setFlags(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x00f6:
            java.lang.String r2 = "package="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x0102
            r9.setPackage(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0102:
            java.lang.String r2 = "component="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x0112
            android.content.ComponentName r2 = android.content.ComponentName.unflattenFromString(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r9.setComponent(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0112:
            java.lang.String r2 = "scheme="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x0138
            if (r10 == 0) goto L_0x0135
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r2 = r2.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r2 = r2.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r9.setData(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0135:
            r11 = r14
            goto L_0x00b6
        L_0x0138:
            java.lang.String r2 = "sourceBounds="
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x0149
            android.graphics.Rect r2 = android.graphics.Rect.unflattenFromString(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r9.setSourceBounds(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0149:
            int r2 = r4 + 3
            if (r8 != r2) goto L_0x015e
            java.lang.String r2 = "SEL"
            boolean r2 = r1.startsWith(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x015e
            android.content.Intent r9 = new android.content.Intent     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r10 = r16
            goto L_0x00b6
        L_0x015e:
            int r2 = r4 + 2
            java.lang.String r2 = r1.substring(r2, r15)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r2 = android.net.Uri.decode(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r13 = "S."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r13 == 0) goto L_0x0175
            r7.putString(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0175:
            java.lang.String r13 = "B."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r13 == 0) goto L_0x0186
            boolean r13 = java.lang.Boolean.parseBoolean(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putBoolean(r2, r13)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0186:
            java.lang.String r13 = "b."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r13 == 0) goto L_0x0197
            byte r13 = java.lang.Byte.parseByte(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putByte(r2, r13)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x00b6
        L_0x0197:
            java.lang.String r13 = "c."
            boolean r13 = r1.startsWith(r13, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r13 == 0) goto L_0x01a8
            r13 = 0
            char r14 = r14.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putChar(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x01f8
        L_0x01a8:
            r13 = 0
            java.lang.String r15 = "d."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 == 0) goto L_0x01b9
            double r14 = java.lang.Double.parseDouble(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putDouble(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x01f8
        L_0x01b9:
            java.lang.String r15 = "f."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 == 0) goto L_0x01c9
            float r14 = java.lang.Float.parseFloat(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putFloat(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x01f8
        L_0x01c9:
            java.lang.String r15 = "i."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 == 0) goto L_0x01d9
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putInt(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x01f8
        L_0x01d9:
            java.lang.String r15 = "l."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 == 0) goto L_0x01e9
            long r14 = java.lang.Long.parseLong(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putLong(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x01f8
        L_0x01e9:
            java.lang.String r15 = "s."
            boolean r15 = r1.startsWith(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r15 == 0) goto L_0x01fd
            short r14 = java.lang.Short.parseShort(r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r7.putShort(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x01f8:
            int r4 = r8 + 1
            r2 = r13
            goto L_0x007b
        L_0x01fd:
            java.net.URISyntaxException r0 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r2 = "unknown EXTRA type"
            r0.<init>(r1, r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x0205:
            r9.putExtras(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r10 == 0) goto L_0x0214
            java.lang.String r2 = r3.getPackage()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 != 0) goto L_0x0215
            r3.setSelector(r9)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x0215
        L_0x0214:
            r3 = r9
        L_0x0215:
            if (r6 == 0) goto L_0x02f0
            boolean r2 = r6.startsWith(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r2 == 0) goto L_0x023d
            r0 = 7
            java.lang.String r6 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r11 == 0) goto L_0x02d7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2 = 58
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r6 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x02d7
        L_0x023d:
            boolean r0 = r6.startsWith(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r0 == 0) goto L_0x02d7
            r0 = 12
            char r0 = r6.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2 = 47
            if (r0 != r2) goto L_0x02d6
            r0 = 13
            char r0 = r6.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r0 != r2) goto L_0x02d6
            r0 = 14
            int r5 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r7 = "android.intent.action.MAIN"
            if (r5 >= 0) goto L_0x026d
            java.lang.String r0 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r3.setPackage(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r12 != 0) goto L_0x02d6
        L_0x0268:
            r3.setAction(r7)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x02d6
        L_0x026d:
            java.lang.String r0 = r6.substring(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r3.setPackage(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            int r0 = r5 + 1
            int r8 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r0 >= r8) goto L_0x029f
            int r8 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r8 < 0) goto L_0x029b
            java.lang.String r11 = r6.substring(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            int r0 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r8 >= r0) goto L_0x0299
            int r0 = r8 + 1
            int r5 = r6.indexOf(r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r5 < 0) goto L_0x0299
            java.lang.String r8 = r6.substring(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x02a0
        L_0x0299:
            r5 = r8
            goto L_0x029f
        L_0x029b:
            java.lang.String r11 = r6.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x029f:
            r8 = 0
        L_0x02a0:
            if (r11 != 0) goto L_0x02a5
            if (r12 != 0) goto L_0x02d6
            goto L_0x0268
        L_0x02a5:
            if (r8 != 0) goto L_0x02ba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x02b4:
            java.lang.String r0 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r6 = r0
            goto L_0x02d7
        L_0x02ba:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r2 = "://"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r2 = r6.substring(r5)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            goto L_0x02b4
        L_0x02d6:
            r6 = r14
        L_0x02d7:
            int r0 = r6.length()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            if (r0 <= 0) goto L_0x02f0
            android.net.Uri r0 = android.net.Uri.parse(r6)     // Catch:{ IllegalArgumentException -> 0x02e5 }
            r3.setData(r0)     // Catch:{ IllegalArgumentException -> 0x02e5 }
            goto L_0x02f0
        L_0x02e5:
            r0 = move-exception
            java.net.URISyntaxException r2 = new java.net.URISyntaxException     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            r2.<init>(r1, r0)     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
            throw r2     // Catch:{ IndexOutOfBoundsException -> 0x02f1 }
        L_0x02f0:
            return r3
        L_0x02f1:
            r2 = r4
            goto L_0x02f4
        L_0x02f3:
            r13 = r2
        L_0x02f4:
            java.net.URISyntaxException r0 = new java.net.URISyntaxException
            java.lang.String r3 = "illegal Intent URI format"
            r0.<init>(r1, r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.b.a(java.lang.String, int):android.content.Intent");
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        try {
            ServiceInfo[] c = n.c(context);
            if (c != null && c.length > 0) {
                for (ServiceInfo serviceInfo : c) {
                    Class<?> cls2 = Class.forName(serviceInfo.name);
                    if (cls2 != cls) {
                        if (cls.isAssignableFrom(cls2)) {
                            com.igexin.a.a.c.b.a(a + cls.getSimpleName() + " child is " + cls2.getSimpleName(), new Object[0]);
                            return Pair.create(serviceInfo, cls2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.a.a.c.b.a(a, th.toString());
            c.a().a(" findGtImplClassInManifest error = " + th.toString());
        }
        return Pair.create((Object) null, (Object) null);
    }

    private static String a(Context context) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 0);
            return queryIntentActivities.size() > 0 ? queryIntentActivities.get(0).activityInfo.name : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString("BUILD_CONFIG");
            if (TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(string + ".BuildConfig");
            return (String) cls.getField("GETUI_APP_ID").get(cls);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a() {
        boolean z;
        try {
            if (b != null) {
                return b.booleanValue();
            }
            String a2 = a("ro.miui.ui.version.name");
            String a3 = a("ro.miui.ui.version.code");
            if (!"Xiaomi".equalsIgnoreCase(n.a()) && TextUtils.isEmpty(a2)) {
                if (TextUtils.isEmpty(a3)) {
                    z = false;
                    b = Boolean.valueOf(z);
                    return b.booleanValue();
                }
            }
            z = true;
            b = Boolean.valueOf(z);
            return b.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized boolean a(int i, Notification notification) {
        synchronized (b.class) {
            try {
                if (a()) {
                    Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                    obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static synchronized boolean a(int i, boolean z) {
        synchronized (b.class) {
            try {
                if (d.e == null) {
                    return false;
                }
                String a2 = n.a();
                if ("huawei".equalsIgnoreCase(a2) || "honor".equalsIgnoreCase(a2)) {
                    int intValue = ((Integer) o.c(d.e, "hwBadgeNum", 0, new String[0])).intValue();
                    if (!z) {
                        i += intValue;
                    }
                    o.a(d.e, "hwBadgeNum", Integer.valueOf(i), new String[0]);
                    Bundle bundle = new Bundle();
                    bundle.putString(WiseOpenHianalyticsData.UNION_PACKAGE, d.c);
                    bundle.putString("class", a(d.e));
                    bundle.putInt("badgenumber", i);
                    Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                    Uri parse2 = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                    if (TextUtils.isEmpty(d.e.getContentResolver().getType(parse))) {
                        parse = parse2;
                    }
                    d.e.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                    return true;
                }
            } catch (Throwable th) {
                com.igexin.a.a.c.b.c("CU", th.getMessage());
            }
        }
        return false;
    }

    private static Intent b(String str, int i) throws URISyntaxException {
        boolean z;
        int i2;
        String str2;
        String str3 = str;
        int lastIndexOf = str3.lastIndexOf(35);
        if (lastIndexOf < 0) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        int i3 = lastIndexOf + 1;
        boolean z2 = true;
        if (str3.regionMatches(i3, "action(", 0, 7)) {
            int i4 = lastIndexOf + 8;
            int indexOf = str3.indexOf(41, i4);
            str2 = str3.substring(i4, indexOf);
            i2 = indexOf + 1;
            z = true;
        } else {
            z = false;
            i2 = i3;
            str2 = null;
        }
        Intent intent = new Intent(str2);
        int i5 = 33;
        if (str3.regionMatches(i2, "categories(", 0, 11)) {
            int i6 = i2 + 11;
            int indexOf2 = str3.indexOf(41, i6);
            while (i6 < indexOf2) {
                int indexOf3 = str3.indexOf(33, i6);
                if (indexOf3 < 0 || indexOf3 > indexOf2) {
                    indexOf3 = indexOf2;
                }
                if (i6 < indexOf3) {
                    intent.addCategory(str3.substring(i6, indexOf3));
                }
                i6 = indexOf3 + 1;
            }
            i2 = indexOf2 + 1;
            z = true;
        }
        if (str3.regionMatches(i2, "type(", 0, 5)) {
            int i7 = i2 + 5;
            int indexOf4 = str3.indexOf(41, i7);
            intent.setType(str3.substring(i7, indexOf4));
            i2 = indexOf4 + 1;
            z = true;
        }
        if (str3.regionMatches(i2, "launchFlags(", 0, 12)) {
            int i8 = i2 + 12;
            int indexOf5 = str3.indexOf(41, i8);
            intent.setFlags(Integer.decode(str3.substring(i8, indexOf5)).intValue());
            if ((i & 4) == 0) {
                intent.setFlags((~(67 | 128)) & intent.getFlags());
            }
            i2 = indexOf5 + 1;
            z = true;
        }
        if (str3.regionMatches(i2, "component(", 0, 10)) {
            int i9 = i2 + 10;
            int indexOf6 = str3.indexOf(41, i9);
            int indexOf7 = str3.indexOf(33, i9);
            if (indexOf7 >= 0 && indexOf7 < indexOf6) {
                intent.setComponent(new ComponentName(str3.substring(i9, indexOf7), str3.substring(indexOf7 + 1, indexOf6)));
            }
            i2 = indexOf6 + 1;
            z = true;
        }
        if (str3.regionMatches(i2, "extras(", 0, 7)) {
            int i10 = i2 + 7;
            int indexOf8 = str3.indexOf(41, i10);
            int i11 = -1;
            if (indexOf8 != -1) {
                if (intent.getExtras() == null) {
                    intent.putExtras(new Bundle());
                }
                Bundle extras = intent.getExtras();
                while (i10 < indexOf8) {
                    int indexOf9 = str3.indexOf(61, i10);
                    int i12 = i10 + 1;
                    if (indexOf9 <= i12 || i10 >= indexOf8) {
                        throw new URISyntaxException(str3, "EXTRA missing '='", i10);
                    }
                    char charAt = str3.charAt(i10);
                    String substring = str3.substring(i12, indexOf9);
                    int i13 = indexOf9 + 1;
                    int indexOf10 = str3.indexOf(i5, i13);
                    if (indexOf10 == i11 || indexOf10 >= indexOf8) {
                        indexOf10 = indexOf8;
                    }
                    if (i13 < indexOf10) {
                        String substring2 = str3.substring(i13, indexOf10);
                        if (charAt == 'B') {
                            extras.putBoolean(substring, Boolean.parseBoolean(substring2));
                        } else if (charAt == 'S') {
                            extras.putString(substring, Uri.decode(substring2));
                        } else if (charAt == 'f') {
                            extras.putFloat(substring, Float.parseFloat(substring2));
                        } else if (charAt == 'i') {
                            extras.putInt(substring, Integer.parseInt(substring2));
                        } else if (charAt == 'l') {
                            extras.putLong(substring, Long.parseLong(substring2));
                        } else if (charAt != 's') {
                            switch (charAt) {
                                case 'b':
                                    extras.putByte(substring, Byte.parseByte(substring2));
                                    break;
                                case 'c':
                                    extras.putChar(substring, Uri.decode(substring2).charAt(0));
                                    break;
                                case 'd':
                                    extras.putDouble(substring, Double.parseDouble(substring2));
                                    break;
                                default:
                                    try {
                                        throw new URISyntaxException(str3, "EXTRA has unknown type", indexOf10);
                                    } catch (NumberFormatException unused) {
                                        throw new URISyntaxException(str3, "EXTRA value can't be parsed", indexOf10);
                                    }
                            }
                        } else {
                            extras.putShort(substring, Short.parseShort(substring2));
                        }
                        char charAt2 = str3.charAt(indexOf10);
                        if (charAt2 == ')') {
                            intent.putExtras(extras);
                        } else if (charAt2 == '!') {
                            i10 = indexOf10 + 1;
                            i5 = 33;
                            i11 = -1;
                        } else {
                            throw new URISyntaxException(str3, "EXTRA missing '!'", indexOf10);
                        }
                    } else {
                        throw new URISyntaxException(str3, "EXTRA missing '!'", i13);
                    }
                }
                intent.putExtras(extras);
            } else {
                throw new URISyntaxException(str3, "EXTRA missing trailing ')'", i10);
            }
        } else {
            z2 = z;
        }
        intent.setData(z2 ? Uri.parse(str3.substring(0, lastIndexOf)) : Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static boolean b(int i, boolean z) {
        try {
            if (d.e == null || !"vivo".equalsIgnoreCase(n.a())) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, d.e.getPackageName());
            Intent launchIntentForPackage = d.e.getPackageManager().getLaunchIntentForPackage(d.e.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return false;
            }
            int intValue = ((Integer) o.c(d.e, "vivoBadgeNum", 0, new String[0])).intValue();
            if (!z) {
                i += intValue;
            }
            o.a(d.e, "vivoBadgeNum", Integer.valueOf(i), new String[0]);
            intent.putExtra("className", launchIntentForPackage.getComponent().getClassName());
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            d.e.sendBroadcast(intent, d.az);
            return true;
        } catch (Throwable th) {
            com.igexin.a.a.c.b.c("CU", th.getMessage());
            return false;
        }
    }

    public static boolean c(int i, boolean z) {
        try {
            if (d.e == null || !"oppo".equalsIgnoreCase(n.a())) {
                return false;
            }
            int intValue = ((Integer) o.c(d.e, "oppoBadgeNum", 0, new String[0])).intValue();
            if (!z) {
                i += intValue;
            }
            o.a(d.e, "oppoBadgeNum", Integer.valueOf(i), new String[0]);
            Intent intent = new Intent("com.oppo.unsettledevent");
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, d.e.getPackageName());
            intent.putExtra("number", i);
            intent.putExtra("upgradeNumber", i);
            List<ResolveInfo> queryBroadcastReceivers = d.e.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("app_badge_count", i);
                d.e.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                return true;
            }
            d.e.sendBroadcast(intent, d.az);
            return true;
        } catch (Exception e) {
            com.igexin.a.a.c.b.c("CU", e.getMessage());
            return false;
        }
    }
}
