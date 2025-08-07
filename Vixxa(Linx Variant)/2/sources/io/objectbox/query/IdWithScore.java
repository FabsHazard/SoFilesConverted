package io.objectbox.query;

public class IdWithScore {
    private final long id;
    private final double score;

    public IdWithScore(long j, double d) {
        this.id = j;
        this.score = d;
    }

    public long getId() {
        return this.id;
    }

    public double getScore() {
        return this.score;
    }
}
