package com.kongzue.dialogx.util;

public class DialogXViewLoc {
    private float h;
    private float w;
    private float x;
    private float y;

    public float getX() {
        return this.x;
    }

    public DialogXViewLoc setX(float f) {
        this.x = f;
        return this;
    }

    public float getY() {
        return this.y;
    }

    public DialogXViewLoc setY(float f) {
        this.y = f;
        return this;
    }

    public float getW() {
        return this.w;
    }

    public DialogXViewLoc setW(float f) {
        this.w = f;
        return this;
    }

    public float getH() {
        return this.h;
    }

    public DialogXViewLoc setH(float f) {
        this.h = f;
        return this;
    }

    public boolean isSameLoc(int[] iArr) {
        if (iArr.length == 2) {
            if (this.x == ((float) iArr[0]) && this.y == ((float) iArr[1])) {
                return true;
            }
            return false;
        } else if (iArr.length != 4) {
            return false;
        } else {
            if (this.x == ((float) iArr[0]) && this.y == ((float) iArr[1]) && this.w == ((float) iArr[2]) && this.h == ((float) iArr[3])) {
                return true;
            }
            return false;
        }
    }

    public void set(int[] iArr) {
        if (iArr.length == 2) {
            this.x = (float) iArr[0];
            this.y = (float) iArr[1];
        }
        if (iArr.length == 4) {
            this.x = (float) iArr[0];
            this.y = (float) iArr[1];
            this.w = (float) iArr[2];
            this.h = (float) iArr[3];
        }
    }
}
