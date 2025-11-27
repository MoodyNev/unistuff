public record SquareFun(double a, double b, double c) {
    //stell t eine quadratische funktion jdar ax² + bx + c
    public double findExtremum(double l, double r){
        double epsilon = 1e-15;
        double m = (l+r) / 2;
        double dm = 2*a*m +b; //ableitung
        if(r -l <= epsilon || dm == 0) return m;
        if (dm > 0 && a > 0 || dm < 0 && a < 0) return findExtremum(l, m);
        else return findExtremum(m, r);

    }

    public double[] getRoots(double l, double r){
        //double mit der länge 2
        //einer rechts von der extremstelle die andere link davon
        //n.v. es gibt bs
        double extremwert = findExtremum(l, r);
        return getR(l,r,extremwert);
    }

    private double[] getR(double l, double r, double extremwert){
        double[] ergebnis = new double[2];
        ergebnis[0] = getR1(l, extremwert);
        ergebnis[1] = getR1(extremwert, r);
        return ergebnis;
    }

    private double getR1(double u, double o){
        double m = (u+o) / 2;
        double epsilon = 1e-15;
        double fm = a*(m*m) + b*m + c;
        double dm = 2*a*m + b;
        if((o-u <= epsilon) || (fm == 0)) return m;
        if((fm <  0 && dm < 0) || (fm > 0 || dm > 0)) return getR1(u,m);
        return getR1(m, o);
    }
}