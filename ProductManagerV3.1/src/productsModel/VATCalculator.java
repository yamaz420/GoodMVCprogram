package productsModel;

public class VATCalculator
{
    public static double getVATFactor(ProductType prodType)
    {
        double moms = 0.0;

        switch (prodType)
        {
            case Food:
                moms = 0.12;
                break;
            case Books:
                moms = 0.06;
                break;

            case Beverage:
            default:
                moms = 0.25;
                break;
        }
        return moms;
    }
}
