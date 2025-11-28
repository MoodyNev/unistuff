public class PolyFun {
    //THIS IS SO CONFUSING I CANTTTTT
    double c;
    int n;
    public double findExtremum(double l, double r){
        double epsilon = 1e-15;
        double m = (l+r) / 2;
        double a = funktion(c, n, l, r); //Funktion
        double dm = ableiten(c, n, l, r); //ableitung
        if(r -l <= epsilon || dm == 0) return m;
        if (dm > 0 && a > 0 || dm < 0 && a < 0) return findExtremum(l, m);
        else return findExtremum(m, r);

    }
    public double[] getRoots(double l, double r){

    }
    public double ableiten(double c, int n, double l, double r){ //ich werde es selber ableiten für dm muhahahahah
        double ableitung = 0;
        double m = (l+r) / 2;
        for(int i = n; i < 0; i --){
            ableitung += c * i * Math.pow(m, i - 1);
        }
        return ableitung;
    }
    
    public double funktion(double c, int n, double l, double r){
        double funktion = 0;
        double m = (l+r) / 2;
        for(int i = n; i <= 0; i --){
            funktion += c * Math.pow(m, i);
        }
        return funktion;
    }
}
