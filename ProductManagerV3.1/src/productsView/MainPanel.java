package productsView;

import productsControllers.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel
{
    Controller controller;

    CenterPanel pnlCenter;
    SouthPanel pnlSouth;

    //JTextArea txtAreaInfo;
    BorderLayout layout;
    ListPanel pnlEast;

    public MainPanel(Controller controller)
    {
        this.controller = controller;
        setupPanel();
    }

    private void setupPanel()
    {
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(12, 12, 12, 12);
        setBorder(new CompoundBorder(border, margin));


        pnlCenter = new CenterPanel(controller);  //labels and textboxes


        //createInfoTextAreaAtEast();  //output at right
        //Buttons at south
        pnlSouth = new SouthPanel(controller);
        add(pnlSouth, layout.SOUTH);

        pnlEast = new ListPanel(controller);
        add(pnlCenter, layout.CENTER);
        //getPnlCenter().createInfoTextArea();

        add(pnlEast, BorderLayout.EAST);
    }


    public void setTxtAreaInfo(String text)
    {
        pnlEast.txtAreaInfo.setText(text);
    }

    public CenterPanel getPnlCenter()
    {
        return pnlCenter;
    }

    public SouthPanel getPnlSouth()
    {
        return pnlSouth;
    }
    public ListPanel getPnlEast() {return  pnlEast;}
    //public int getListIndex(){return pnlEast.getListIndex();}

}

