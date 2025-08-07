package com.github.mikephil.charting.data.filter;

import java.util.ArrayList;

public class ApproximatorN {
    public float[] reduceWithDouglasPeucker(float[] fArr, float f) {
        int i = 2;
        int length = fArr.length / 2;
        if (f <= 2.0f || f >= ((float) length)) {
            return fArr;
        }
        boolean[] zArr = new boolean[length];
        int i2 = 0;
        zArr[0] = true;
        int i3 = length - 1;
        zArr[i3] = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Line(0, i3, fArr));
        do {
            Line line = (Line) arrayList.remove(arrayList.size() - 1);
            zArr[line.index] = true;
            i++;
            if (((float) i) == f) {
                break;
            }
            Line line2 = new Line(line.start, line.index, fArr);
            if (line2.index > 0) {
                arrayList.add(insertionIndex(line2, arrayList), line2);
            }
            Line line3 = new Line(line.index, line.end, fArr);
            if (line3.index > 0) {
                arrayList.add(insertionIndex(line3, arrayList), line3);
            }
        } while (arrayList.isEmpty());
        float[] fArr2 = new float[(i * 2)];
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            if (zArr[i2]) {
                int i6 = i4 + 1;
                fArr2[i4] = fArr[i5];
                i4 += 2;
                fArr2[i6] = fArr[i5 + 1];
            }
            i2++;
            i5 += 2;
        }
        return fArr2;
    }

    /* access modifiers changed from: private */
    public static float distanceToLine(float f, float f2, float[] fArr, float[] fArr2) {
        float f3 = fArr2[0];
        float f4 = fArr[0];
        float f5 = f3 - f4;
        float f6 = fArr2[1];
        float f7 = fArr[1];
        float f8 = f6 - f7;
        return (float) (((double) Math.abs((((f * f8) - (f2 * f5)) - (f4 * f6)) + (f3 * f7))) / Math.sqrt((double) ((f5 * f5) + (f8 * f8))));
    }

    private static class Line {
        float distance = 0.0f;
        int end;
        int index = 0;
        int start;

        Line(int i, int i2, float[] fArr) {
            this.start = i;
            this.end = i2;
            int i3 = i * 2;
            float[] fArr2 = {fArr[i3], fArr[i3 + 1]};
            int i4 = i2 * 2;
            float[] fArr3 = {fArr[i4], fArr[i4 + 1]};
            int i5 = i + 1;
            if (i2 > i5) {
                int i6 = i5 * 2;
                while (i5 < i2) {
                    float access$000 = ApproximatorN.distanceToLine(fArr[i6], fArr[i6 + 1], fArr2, fArr3);
                    if (access$000 > this.distance) {
                        this.index = i5;
                        this.distance = access$000;
                    }
                    i5++;
                    i6 += 2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean equals(Line line) {
            return this.start == line.start && this.end == line.end && this.index == line.index;
        }

        /* access modifiers changed from: package-private */
        public boolean lessThan(Line line) {
            return this.distance < line.distance;
        }
    }

    private static int insertionIndex(Line line, ArrayList<Line> arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (!arrayList.isEmpty()) {
            int i2 = ((size - i) / 2) + i;
            Line line2 = arrayList.get(i2);
            if (line2.equals(line)) {
                return i2;
            }
            if (line.lessThan(line2)) {
                size = i2;
            } else {
                i = i2 + 1;
            }
        }
        return i;
    }
}
