package model.enumerations;

public enum Prefixes {
    a(Math.pow(10,-18)),
    f(Math.pow(10,-15)),
    p(Math.pow(10,-12)),
    n(Math.pow(10,-9)),
    u(Math.pow(10,-6)),
    m(Math.pow(10,-3)),
    c(Math.pow(10,-2)),
    k(Math.pow(10,3)),
    M(Math.pow(10,6)),
    G(Math.pow(10,9));



    private double value;

    private Prefixes(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;

    }
}
