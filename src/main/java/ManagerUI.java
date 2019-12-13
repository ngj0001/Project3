
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManagerUI {

    public   UserModel user = null;

    public JFrame view;

    public JButton btnManageProducts = new JButton("Manage Products");
    public JButton btnViewSales = new JButton("View Sales");
    public JButton btnManageUser = new JButton("Manage User");


    public ManagerUI() {



        this.view = new JFrame();
        this.user = user;



        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Manager View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnViewSales);
        panelButtons.add(btnManageProducts);
        panelButtons.add(btnManageUser);


        view.getContentPane().add(panelButtons);

        btnViewSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PurchaseSearchUI ui = new PurchaseSearchUI(user);
                ui.view.setVisible(true);
            }
                });


        btnManageProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageProductUI ui = new ManageProductUI();
                ui.run();
            }
        });

        btnManageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageUserUI ui = new ManageUserUI();
                ui.run();
            }
        });

    }
}
