public record SquareFun(double a, double b, double c) {
    //stell t eine quadratische funktion jdar ax² + bx + c
    public double findExtremum(double l, double r){
        //I AM NOT REALLY SURE WHETHER USE FLOAT OR DOUBLE
        double epsilon = 1e-15;
        double m = (l+r) / 2;
        double dm = 2*a*m +b;
        if(r -l <= epsilon || dm == 0) return m;
        if (dm > 0) return findExtremum(l, m);
        else return findExtremum(m, r);

    }

    public double[] getRoots(double l, double r){
        double epsilon = 1e-15;
        //x_extrem 
        double m = (l+r) / 2;
        double dm = 2*a*m +b;

    }
    
}
