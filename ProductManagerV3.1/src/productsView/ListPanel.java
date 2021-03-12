package productsView;

import productsControllers.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListPanel extends JPanel
{
    private JList<String> list;
    private Controller controller;

    public ListPanel(Controller controller)
    {
        this.controller = controller;

        setBorder(BorderFactory.createTitledBorder("Product Register"));

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        setBorder(new CompoundBorder(border, margin));

        //String[] data = addTestValue();
        list = new JList(); //data has type Object[]

        Font font = new Font("Courier New", Font.PLAIN, 10);
        list.setFont(font);

        JScrollPane s = new JScrollPane(list);
        //extra saker
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(360, 310));

        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        addListener();
        add(s);
        createInfoTextArea();
    }

    public int getListIndex()
    {
        return list.getSelectedIndex();
    }

    public void updateProductList(String [] stringList)
    {
        list.setListData(stringList);
    }

    public void addListener()
    {
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt)
            {
                //int index = evt.getFirstIndex();
                int index = list.getSelectedIndex();
                if ( index > -1)
                {
                    controller.productLisIndexChanged(index);
                }
            }});
    }

    JTextArea txtAreaInfo;
    public void createInfoTextArea(){
        JPanel pnlContactInfo = new JPanel();
        pnlContactInfo.setBorder(BorderFactory.createTitledBorder("Product Info"));

        Border border = pnlContactInfo.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        pnlContactInfo.setBorder(new CompoundBorder(border, margin));

        txtAreaInfo = new JTextArea();
        txtAreaInfo.setBorder(BorderFactory.createLineBorder(Color.lightGray,1,true));

        txtAreaInfo.setPreferredSize(new Dimension(220, 250));
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setBackground(pnlContactInfo.getBackground());
        Font font = new Font("Courier New", Font.PLAIN, 10);
        txtAreaInfo.setFont(font);

        add(pnlContactInfo, BorderLayout.CENTER);
        pnlContactInfo.add(txtAreaInfo);
    }
}
