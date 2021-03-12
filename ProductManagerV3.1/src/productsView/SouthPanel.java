package productsView;

import productsModel.ProductType;
import productsControllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel
{
    private Controller controller;
    private JRadioButton rbtnBooks;
    private JRadioButton rbtnFood;
    private JRadioButton rbtnOther;
    private ButtonGroup  btnGroup;
    JButton btnOK, btnChange, btnDelete;


    public SouthPanel(Controller controller)
    {
        this.controller = controller;
        btnGroup = new ButtonGroup();

        GridLayout layout = new GridLayout(2, 1, 2, 2);  //fungerar inte!!
        JPanel pnlRButtons = new JPanel();
        JPanel pnlButtons = new JPanel();

        pnlButtons.setBorder(BorderFactory.createTitledBorder(""));
        // pnlRButtons.setBorder(BorderFactory.createTitledBorder(""));

        rbtnBooks = new JRadioButton("Books");
        rbtnFood = new JRadioButton("Food");
        rbtnOther = new JRadioButton("Other");

        btnGroup.add (rbtnFood);
        btnGroup.add(rbtnBooks);
        btnGroup.add(rbtnOther);

        //default value
        rbtnFood.setSelected(true);
        pnlRButtons.add(rbtnFood);
        pnlRButtons.add(rbtnBooks);
        pnlRButtons.add(rbtnOther);


        btnOK = new JButton("Add");
        Dimension dim = new Dimension(50,50);
        btnOK.setSize(dim);

        btnChange = new JButton("Change");
        btnChange.setSize(dim);

        btnDelete = new JButton("Delete");
        btnChange.setSize(dim);

        pnlButtons.add(btnOK);
        pnlButtons.add(btnChange);
        pnlButtons.add(btnDelete);

        add(pnlRButtons);
        add(pnlButtons);

        addListeners();

    }
    private void addListeners()
    {
        ActionListener listener = new ButtonActionListeners();

        rbtnBooks.addActionListener(listener);
        rbtnFood.addActionListener(listener);
        rbtnOther.addActionListener(listener);

        btnOK.addActionListener(listener);
        btnChange.addActionListener(listener);
        btnDelete.addActionListener(listener);
    }

    class ButtonActionListeners implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == rbtnBooks)
                controller.productTypeChanged(ButtonType.rbtnBook);
            else if (e.getSource()== rbtnFood)
                controller.productTypeChanged(ButtonType.rbtnFood);
            else if (e.getSource() == rbtnOther)
                controller.productTypeChanged(ButtonType.rbtnOther);

            if (e.getSource() == btnOK)
                controller.buttonPressed(ButtonType.Add);
            else if (e.getSource()== btnChange)
            {
                controller.buttonPressed(ButtonType.Change);
            }
            else if (e.getSource() == btnDelete)
            {
                controller.buttonPressed(ButtonType.Delete);
            }

        }
    }

    public void setProductType(ProductType productType)
    {
        switch (productType)
        {
            case Food:
                rbtnFood.setSelected(true);
                break;
            case Books:
                rbtnBooks.setSelected(true);
                break;
            default:
                rbtnOther.setSelected(true);
        }
    }
    public ProductType getProductType()
    {
        ProductType prodType;
        if (rbtnFood.isSelected())
            prodType = ProductType.Food;
        else if (rbtnBooks.isSelected())
            prodType = ProductType.Books;
        else
            prodType= ProductType.Other;

        return prodType;
    }

}
