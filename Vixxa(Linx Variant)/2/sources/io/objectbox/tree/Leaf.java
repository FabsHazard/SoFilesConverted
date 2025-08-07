package io.objectbox.tree;

import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class Leaf {
    private final LeafNode node;

    public Leaf(LeafNode leafNode) {
        this.node = leafNode;
    }

    public long getId() {
        return this.node.id;
    }

    public long getParentBranchId() {
        return this.node.branchId;
    }

    public long getMetaId() {
        return this.node.metaId;
    }

    public short getValueType() {
        return this.node.valueType;
    }

    public boolean isInt() {
        return this.node.valueType == 6;
    }

    public boolean isDouble() {
        return this.node.valueType == 8;
    }

    public boolean isString() {
        return this.node.valueType == 23;
    }

    public boolean isStringArray() {
        return this.node.valueType == 24;
    }

    private void verifyIsInt() {
        if (!isInt()) {
            throw new IllegalStateException("value is not integer (" + this.node.valueType + ")");
        }
    }

    private void verifyIsDouble() {
        if (!isDouble()) {
            throw new IllegalStateException("value is not floating point (" + this.node.valueType + ")");
        }
    }

    private void verifyIsString() {
        if (!isString()) {
            throw new IllegalStateException("value is not string (" + this.node.valueType + ")");
        }
    }

    private void verifyIsStringArray() {
        if (!isStringArray()) {
            throw new IllegalStateException("value is not string array");
        }
    }

    public long getInt() {
        verifyIsInt();
        return this.node.integerValue;
    }

    public double getDouble() {
        verifyIsDouble();
        return this.node.floatingValue;
    }

    @Nullable
    public String getString() {
        verifyIsString();
        if (this.node.objectValue instanceof String) {
            return (String) this.node.objectValue;
        }
        return new String((byte[]) this.node.objectValue, StandardCharsets.UTF_8);
    }

    @Nullable
    public String[] getStringArray() {
        verifyIsStringArray();
        return (String[]) this.node.objectValue;
    }

    @Nullable
    public Long asInt() {
        String string;
        if (isInt()) {
            return Long.valueOf(getInt());
        }
        if (isDouble()) {
            return Long.valueOf((long) getDouble());
        }
        if (!isString() || (string = getString()) == null) {
            return null;
        }
        try {
            return Long.valueOf(string);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public Double asDouble() {
        String string;
        if (isDouble()) {
            return Double.valueOf(getDouble());
        }
        if (isInt()) {
            return Double.valueOf((double) getInt());
        }
        if (!isString() || (string = getString()) == null) {
            return null;
        }
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public String asString() {
        String[] stringArray;
        if (isString()) {
            return getString();
        }
        if (isInt()) {
            return String.valueOf(getInt());
        }
        if (isDouble()) {
            return String.valueOf(getDouble());
        }
        if (!isStringArray() || (stringArray = getStringArray()) == null) {
            return null;
        }
        return UByte$$ExternalSyntheticBackport0.m((CharSequence) ", ", (CharSequence[]) stringArray);
    }

    @Nullable
    public String[] asStringArray() {
        if (isStringArray()) {
            return getStringArray();
        }
        String asString = asString();
        if (asString == null) {
            return null;
        }
        return new String[]{asString};
    }

    public void setInt(long j) {
        verifyIsInt();
        this.node.integerValue = j;
    }

    public void setDouble(double d) {
        verifyIsDouble();
        this.node.floatingValue = d;
    }

    public void setString(@Nullable String str) {
        verifyIsString();
        this.node.objectValue = str;
    }

    public void setStringArray(@Nullable String[] strArr) {
        verifyIsStringArray();
        this.node.objectValue = strArr;
    }
}
