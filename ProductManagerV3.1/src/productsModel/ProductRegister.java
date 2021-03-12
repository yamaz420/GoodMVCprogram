package productsModel;

public class ProductRegister
{
    private Product [] productList;//deklaration
    private int numOfElem =0;  //antall registrerade

    public ProductRegister(int maxElems)
    {
        productList = new Product[maxElems];
    }
    //Add getInfoStrings
    //Change product
    //Delete product
    //Get product
    //Get en lista av producter som strängar
    //Sök product

    public int Count()
    {
        return numOfElem;
    }
    public Product getElementAt(int index)
    {
        return productList[index];
    }
    public boolean addProduct(Product productIn)
    {
        boolean ok = true;
        if ( (numOfElem < productList.length) && (productIn != null) )
        {
            productList[numOfElem++] = productIn;
            //numOfElem++;
            //numOfElem++;
        }
        else
            ok = false;
        return ok;
    }

    public boolean addProduct(String name, double price, int count)
    {
        boolean ok = true;

        if ( numOfElem < productList.length)
        {
            Product product =new Product();
            product.setName(name);
            product.setPrice(price);
            product.setCount(count);
            productList[numOfElem++] = product;
        }
        else
            ok = false;

        return ok;
    }

    public String [] getInfoStrings()
    {
        int size = numOfElem; //.length;
        String [] infoStrings = new String [size];

        int i = 0;

        for (i=0; i < infoStrings.length;i++)
        {
            infoStrings[i] = productList[i].toShortString() ;
        }
        return infoStrings;

    }


    //kolla index
    //kolla product
    public void changeAt(int index, Product product)
    {
        if ( checkIndex(index))
            if (product != null)
                productList[index] = product;
    }

    public void deleteAt(int index)
    {
        if (checkIndex(index))
        {
            productList[index] = null;
            numOfElem--;
            moveElementsToLef(index);
        }
    }
    private void moveElementsToLef(int index){
        for (int i = index+1; i< productList.length; i++)
        {
            if (i > 0)
                productList[i-1] = productList[i];
        }

    }

    public boolean checkIndex(int index)
    {
        if ((index >= 0) && (index < productList.length) )
            return true;

        return false;
    }
/*
    public String [] getInfoStrings()
    {
        String [] infoStrings = new String [numOfElem];

        int i = 0;
        for (Product product : productList)
        {
            if (product != null)
                infoStrings[i++] = product.toShortString();
        }
        return infoStrings;
    }
*/
}
