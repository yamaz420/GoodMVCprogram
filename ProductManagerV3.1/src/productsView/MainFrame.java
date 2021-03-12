package productsView;
import javax.swing.*;

import productsModel.ProductType;
import productsControllers.Controller;
import productsModel.UnitType;

public class MainFrame extends JFrame
{
    private int width = 500;
    private int height = 400;

    Controller controller;
    MainPanel panel;

    public MainFrame(Controller controller)
    {
        this.controller = controller;
        setupFrame();

    }
    //standard settings
    public void setupFrame()
    {
        final int offsetX = width/5;
        final int offsetY = height / 5;

        setSize(width, height);
        setTitle("Product Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX, offsetY);

        panel = new MainPanel(controller);
        setContentPane(panel);
        pack();

        setVisible(true);
    }

    public String getNameText ()
    {
        return panel.getPnlCenter().getNameText();
    }

    public void setNameText (String str)
    {
        panel.getPnlCenter().setNameText(str);
    }
    public void setPrice (String str)
    {
        panel.getPnlCenter().setPrice(str);
    }
    public String getPriceText ()
    {
        return panel.getPnlCenter().getPriceText();
    }
    public String getCountText ()
    {
        return panel.getPnlCenter().getCountText();
    }

    public ProductType getProductTyp(){return panel.getPnlSouth().getProductType();}
    public Object getUnitItem(){return panel.getPnlCenter().getUnitItem();}

    public void setProductType(ProductType productType){panel.getPnlSouth().setProductType(productType);}

    public void showProductInfo (String str)
    {
        panel.setTxtAreaInfo(str);
    }
    public void errMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    public void updateProductList(String [] stringList)
    {
        panel.getPnlEast().updateProductList(stringList);
    }
    public int getListIndex()
    {
        return panel.getPnlEast().getListIndex();
    }
}
