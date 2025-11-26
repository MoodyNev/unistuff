public record SquareFun(double a, double b, double c) {
    //stell t eine quadratische funktion jdar ax² + bx + c
    public double findExtremum(double l, double r){
        //I AM NOT REALLY SURE WHETHER USE FLOAT OR DOUBLE
        double epsilon = 1e-15;
        double m = (l+r) / 2;
        double dm = 2*a*m +b;
        if(dm == 0) return m;
        if (dm > 0) return findExtremum(m, l);
        else return findExtremum(r, m);

    }
    
}
