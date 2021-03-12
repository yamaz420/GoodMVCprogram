package productsControllers;

import  productsView.*;
import productsModel.*;


public class Controller
{
    MainFrame view;
    ProductRegister register;  //model

    //constructor
    public Controller()
    {
        register = new ProductRegister(200);
        view = new MainFrame(this);
        view.updateProductList(register.getInfoStrings());
    }

    //Denna metod anropas varje gång någon ändring av modelen sker
    private void updateView(int index)
    {
        Product product = register.getElementAt(index);
        if (product == null)
            return;

        view.setNameText(product.getName());
        view.setPrice(Double.toString(product.getPrice()));

        view.showProductInfo(product.toString());
        view.setProductType(product.getProductType());
    }

    //Denna metod anropas av view
    public void buttonPressed(ButtonType button)
    {
        Product product = null;

        int index =0;
        switch (button)
        {
            case Add:
                product = getProductDataFrView();
                register.addProduct(product);
                break;

            case Change:
                product = getProductDataFrView();
                index = view.getListIndex();
                register.changeAt(index, product);
                break;

            case Delete:
                index = view.getListIndex();
                register.deleteAt(index); // = new Product();   //noll-ställ
                break;
        }
        view.updateProductList(register.getInfoStrings());
    }

    public void productTypeChanged(ButtonType button)
    {
        //nothing to do
    }
    //Update view
    public void productLisIndexChanged(int index)
    {
        updateView(index);

    }


    private Product getProductDataFrView()
    {
        Product product = new Product();
        String name = view.getNameText();
        String strPrice = view.getPriceText();
        String strCount = view.getCountText();
        ProductType prodType = view.getProductTyp();
        Object unitItem = view.getUnitItem();

        if ( (name != null)  && (!name.isEmpty()) )
            product.setName(name);
        else
            view.errMessage("Give a valid name");

        //vi hoppar över kontroll av price and count
        //använd try-catch
        try
        {
            product.setPrice(Double.parseDouble(strPrice));
            product.setCount(Integer.parseInt(strCount));
            product.setProductType(prodType);
            product.setUnit((UnitType)unitItem);
        }
        catch (NumberFormatException e)
        {
            view.errMessage("Invalid price or count!");
            return null;
        }
        return product;
    }
    public void setUnitItem(Object unit, int   index )
    {
        //behöver inte göras något!
        /*
        Product product = register.getElementAt(index);
        if (product != null)
            product.setUnit ((UnitType)unit);

         */
    }
    public UnitType [] getUnitItems()
    {
        return UnitType.values ();
    }


}
