package com.microtech.aidexx.views.selector.time;

import android.support.v4.media.session.PlaybackStateCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ChinaDate {
    private static final String[] Animals = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    private static final String[] Gan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] Zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private static final long[] lunarInfo = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
    private static final String[] nStr1 = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 EEEEE");

    private static final int lYearDays(int i) {
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((lunarInfo[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + leapDays(i);
    }

    public static final int leapDays(int i) {
        if (leapMonth(i) != 0) {
            return (lunarInfo[i + -1900] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0 ? 30 : 29;
        }
        return 0;
    }

    public static final int leapMonth(int i) {
        return (int) (lunarInfo[i - 1900] & 15);
    }

    public static final int monthDays(int i, int i2) {
        return (((long) (65536 >> i2)) & lunarInfo[i + -1900]) == 0 ? 29 : 30;
    }

    public static final String AnimalsYear(int i) {
        return Animals[(i - 4) % 12];
    }

    private static final String cyclicalm(int i) {
        return Gan[i % 10] + Zhi[i % 12];
    }

    public static final String cyclical(int i) {
        return cyclicalm(i - 1864);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long[] calElement(int r17, int r18, int r19) {
        /*
            r0 = 7
            long[] r0 = new long[r0]
            java.util.GregorianCalendar r1 = new java.util.GregorianCalendar
            r2 = 31
            r3 = 1900(0x76c, float:2.662E-42)
            r4 = 0
            r1.<init>(r3, r4, r2)
            java.util.Date r1 = r1.getTime()
            java.util.GregorianCalendar r2 = new java.util.GregorianCalendar
            r5 = 1
            int r6 = r18 + -1
            r7 = r17
            r8 = r19
            r2.<init>(r7, r6, r8)
            java.util.Date r2 = r2.getTime()
            long r6 = r2.getTime()
            long r1 = r1.getTime()
            long r6 = r6 - r1
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 / r1
            r1 = 40
            long r1 = r1 + r6
            r8 = 5
            r0[r8] = r1
            r1 = 14
            r8 = 4
            r0[r8] = r1
            r1 = r4
        L_0x003a:
            r2 = 2100(0x834, float:2.943E-42)
            r9 = 12
            r11 = 0
            if (r3 >= r2) goto L_0x0054
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            int r1 = lYearDays(r3)
            long r11 = (long) r1
            long r6 = r6 - r11
            r11 = r0[r8]
            long r11 = r11 + r9
            r0[r8] = r11
            int r3 = r3 + 1
            goto L_0x003a
        L_0x0054:
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0061
            long r13 = (long) r1
            long r6 = r6 + r13
            int r3 = r3 + -1
            r13 = r0[r8]
            long r13 = r13 - r9
            r0[r8] = r13
        L_0x0061:
            long r9 = (long) r3
            r0[r4] = r9
            int r2 = r3 + -1864
            long r9 = (long) r2
            r2 = 3
            r0[r2] = r9
            int r2 = leapMonth(r3)
            r3 = 6
            r0[r3] = r11
            r9 = r5
        L_0x0072:
            r10 = 13
            r13 = 1
            if (r9 >= r10) goto L_0x00c5
            int r10 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00c5
            if (r2 <= 0) goto L_0x009a
            int r1 = r2 + 1
            if (r9 != r1) goto L_0x009a
            r15 = r0[r3]
            int r1 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x009a
            int r9 = r9 + -1
            r0[r3] = r13
            r18 = r9
            r8 = r0[r4]
            int r1 = (int) r8
            int r1 = leapDays(r1)
            r9 = r18
            r18 = r6
            goto L_0x00a3
        L_0x009a:
            r18 = r6
            r5 = r0[r4]
            int r1 = (int) r5
            int r1 = monthDays(r1, r9)
        L_0x00a3:
            r5 = r0[r3]
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x00af
            int r5 = r2 + 1
            if (r9 != r5) goto L_0x00af
            r0[r3] = r11
        L_0x00af:
            long r5 = (long) r1
            r15 = r18
            long r6 = r15 - r5
            r15 = r0[r3]
            int r5 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x00c0
            r5 = 4
            r15 = r0[r5]
            long r15 = r15 + r13
            r0[r5] = r15
        L_0x00c0:
            int r9 = r9 + 1
            r5 = 1
            r8 = 4
            goto L_0x0072
        L_0x00c5:
            r15 = r6
            int r4 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x00e4
            if (r2 <= 0) goto L_0x00e4
            r5 = 1
            int r2 = r2 + r5
            if (r9 != r2) goto L_0x00e4
            r5 = r0[r3]
            int r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x00d9
            r0[r3] = r11
            goto L_0x00e4
        L_0x00d9:
            r0[r3] = r13
            int r9 = r9 + -1
            r2 = 4
            r5 = r0[r2]
            long r5 = r5 - r13
            r0[r2] = r5
            goto L_0x00e5
        L_0x00e4:
            r2 = 4
        L_0x00e5:
            if (r4 >= 0) goto L_0x00f2
            long r3 = (long) r1
            long r6 = r15 + r3
            int r9 = r9 + -1
            r3 = r0[r2]
            long r3 = r3 - r13
            r0[r2] = r3
            goto L_0x00f3
        L_0x00f2:
            r6 = r15
        L_0x00f3:
            long r1 = (long) r9
            r3 = 1
            r0[r3] = r1
            r1 = 2
            long r6 = r6 + r13
            r0[r1] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.selector.time.ChinaDate.calElement(int, int, int):long[]");
    }

    public static final String getChinaDate(int i) {
        String str;
        if (i == 10) {
            return "初十";
        }
        if (i == 20) {
            return "二十";
        }
        if (i == 30) {
            return "三十";
        }
        int i2 = i / 10;
        if (i2 == 0) {
            str = "初";
        } else {
            str = "";
        }
        if (i2 == 1) {
            str = "十";
        }
        if (i2 == 2) {
            str = "廿";
        }
        if (i2 == 3) {
            str = "三";
        }
        switch (i % 10) {
            case 1:
                return str.concat("一");
            case 2:
                return str.concat("二");
            case 3:
                return str.concat("三");
            case 4:
                return str.concat("四");
            case 5:
                return str.concat("五");
            case 6:
                return str.concat("六");
            case 7:
                return str.concat("七");
            case 8:
                return str.concat("八");
            case 9:
                return str.concat("九");
            default:
                return str;
        }
    }

    public static String getCurrentLunarDate() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        int i = instance.get(1);
        long[] calElement = calElement(i, instance.get(2) + 1, instance.get(5));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sdf.format(instance.getTime()));
        stringBuffer.append(" 农历");
        stringBuffer.append(cyclical(i));
        stringBuffer.append('(');
        stringBuffer.append(AnimalsYear(i));
        stringBuffer.append(")年");
        stringBuffer.append(nStr1[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }

    public static String oneDay(int i, int i2, int i3) {
        long[] calElement = calElement(i, i2, i3);
        StringBuffer stringBuffer = new StringBuffer(" 农历");
        stringBuffer.append(cyclical(i));
        stringBuffer.append('(');
        stringBuffer.append(AnimalsYear(i));
        stringBuffer.append(")年");
        stringBuffer.append(nStr1[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }

    public static String getLunarYearText(int i) {
        int i2 = i - 4;
        return Gan[i2 % 10] + Zhi[i2 % 12] + "年";
    }

    public static ArrayList<String> getYears(int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (i < i2) {
            arrayList.add(String.format("%s(%d)", new Object[]{getLunarYearText(i), Integer.valueOf(i)}));
            i++;
        }
        return arrayList;
    }

    public static ArrayList<String> getMonths(int i) {
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 1;
        while (true) {
            strArr = nStr1;
            if (i2 >= strArr.length) {
                break;
            }
            arrayList.add(strArr[i2] + "月");
            i2++;
        }
        if (leapMonth(i) != 0) {
            arrayList.add(leapMonth(i), "闰" + strArr[leapMonth(i)] + "月");
        }
        return arrayList;
    }

    public static ArrayList<String> getLunarDays(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 <= i; i2++) {
            arrayList.add(getChinaDate(i2));
        }
        return arrayList;
    }
}
