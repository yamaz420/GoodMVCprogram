package productsView;

import productsControllers.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CenterPanel extends JPanel
{
    private int width = 200;
    private int height = 200;

    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtCount;
    private JComboBox  cmbUnits;

    private JPanel pnlLeft;  //for labels at left
    private JPanel pnlRight; //for textboxes at right

    private Controller controller;

    public CenterPanel(Controller controller)
    {
        this.controller = controller;
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(width,height));
        CreateComponents();
    }


    private void CreateComponents()
    {
        createComponentsOnLeftPanel();
        createComponentsOnRightPanel();
        createAndInitiateCombox();
    }

    private void createComponentsOnLeftPanel()
    {
        JLabel lblName  = new JLabel("Product name");
        JLabel lblPrice = new JLabel("Price");
        JLabel lblCount = new JLabel("Quantity");
        JLabel lblUnit  = new JLabel("Unit");

        GridLayout layoutLeft = new GridLayout(8, 1, 2, 2);

        pnlLeft = new JPanel(layoutLeft);
        pnlLeft.setPreferredSize(new Dimension(width / 2, height));
        pnlLeft.add(lblName);

        pnlLeft.add(lblPrice);
        pnlLeft.add(lblCount);
        pnlLeft.add(lblUnit);

        add(pnlLeft, BorderLayout.WEST);
    }

    private void createComponentsOnRightPanel()
    {
        GridLayout layoutRight = new GridLayout(8, 1, 2, 2);
        pnlRight = new JPanel(layoutRight);
        pnlRight.setPreferredSize(new Dimension(width / 2, height));


        Dimension dim = new Dimension(90, 50);
        txtName = new JTextField("Egg");
        txtName.setPreferredSize(dim);

        txtPrice = new JTextField("19.90");
        txtPrice.setPreferredSize(dim);

        txtCount = new JTextField("24");
        txtCount.setPreferredSize(dim);

        pnlRight.add(txtName);
        pnlRight.add(txtPrice);
        pnlRight.add(txtCount);

        add(pnlRight, BorderLayout.CENTER);
    }
    private void createAndInitiateCombox()
    {
        cmbUnits = new JComboBox(controller.getUnitItems());
        cmbUnits.setSelectedIndex(0);
        pnlRight.add(cmbUnits);
        cmbUnits.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                Object obj = cmbUnits.getSelectedItem();
                int index = cmbUnits.getSelectedIndex();
                controller.setUnitItem(obj, index);
            }
        });
    }

    public String getNameText()
    {
        return txtName.getText();
    }

    public void setNameText(String text)
    {
        txtName.setText(text);
    }
    public void setPrice(String text)
    {
        txtPrice.setText(text);
    }

    public String getPriceText()
    {
        return txtPrice.getText();
    }
    public void setPriceText(String text)
    {
        txtPrice.setText(text);
    }
    public String getCountText()
    {
        return txtCount.getText();
    }
    public void setCountText(String text)
    {
        txtCount.setText(text);
    }
    public Object getUnitItem()
    {
        return cmbUnits.getSelectedItem();
    }
/*
    JTextArea txtAreaInfo;
    public void createInfoTextArea()
    {
        JPanel pnlProductInfo = new JPanel();
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setBorder(BorderFactory.createLoweredBevelBorder());
        //txtAreaInfo.setSize(new Dimension(150,150));
        Font font = new Font("Courier New", Font.ITALIC, 12);
        txtAreaInfo.setFont(font);
        txtAreaInfo.setPreferredSize(new Dimension(200, 100));
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setBackground(new Color(139, 255, 250));
        //pnlProductInfo.add(txtAreaInfo);
        add(pnlProductInfo, BorderLayout.CENTER);
        pnlProductInfo.add(txtAreaInfo);

      //  add(pnlProductInfo, layout.EAST);
    }

 */
}




