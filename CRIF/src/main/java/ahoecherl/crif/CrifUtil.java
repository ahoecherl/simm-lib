package ahoecherl.crif;

public class CrifUtil {
    public Crif bumpCrif(Crif inputCrif, String tradeId, double epsilon){
        return inputCrif;
    }

    // Overload to call with default epsilon of 1 percent
    public Crif bumpCrif(Crif inputCrif, String tradeId){
        double epsilon = 0.01;
        return this.bumpCrif(inputCrif, tradeId, epsilon);
    }
}
