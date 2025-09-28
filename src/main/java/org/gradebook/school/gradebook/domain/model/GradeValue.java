package org.gradebook.school.gradebook.domain.model;

public enum GradeValue {
    A(5.0),
    B(4.0),
    C(3.0),
    D(2.0),
    F(1.0);

    private final double numeric;

    GradeValue(double numeric) {
        this.numeric = numeric;
    }

    public double numericValue() {
        return numeric;
    }

    public static GradeValue fromNumeric(double avg) {
        if (avg >= 4.5) return A;
        if (avg >= 3.5) return B;
        if (avg >= 2.5) return C;
        if (avg >= 1.5) return D;
        return F;
    }
}