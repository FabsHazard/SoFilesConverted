package io.objectbox.model;

public final class HnswDistanceType {
    public static final short Cosine = 2;
    public static final short DotProduct = 3;
    public static final short DotProductNonNormalized = 10;
    public static final short Euclidean = 1;
    public static final short Unknown = 0;
    public static final String[] names = {"Unknown", "Euclidean", "Cosine", "DotProduct", "", "", "", "", "", "", "DotProductNonNormalized"};

    private HnswDistanceType() {
    }

    public static String name(int i) {
        return names[i];
    }
}
