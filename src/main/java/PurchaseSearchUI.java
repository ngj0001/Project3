import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PurchaseSearchUI {

        public JFrame view;
        public JTable purchaseTable;
        public UserModel user = null;

        public JButton btnSearch = new JButton("Search");


        public PurchaseSearchUI(UserModel user) {
            this.user = user;

            this.view = new JFrame();

            view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            view.setTitle("Search Purchase");
            view.setSize(600, 400);
            view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

            JLabel title = new JLabel("Sale Results for Manager" );

            title.setFont (title.getFont().deriveFont (24.0f));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            view.getContentPane().add(title);

            PurchaseListModel list = StoreManager.getInstance().getDataAdapter().searchPurchase("", 0, 10000);
            DefaultTableModel tableData = new DefaultTableModel();

            tableData.addColumn("PurchaseID");
            tableData.addColumn("Purchase Name");
            tableData.addColumn("Total");


            for (PurchaseModel purchase : list.purchases) {
                Object[] row = new Object[tableData.getColumnCount()];

                row[0] = purchase.mPurchaseID;
                row[1] = purchase.mProductID;
                row[2] = purchase.mTotal;
                tableData.addRow(row);
            }

//        purchases = new JList(data);

            purchaseTable = new JTable(tableData);

            JScrollPane scrollableList = new JScrollPane(purchaseTable);

            view.getContentPane().add(scrollableList);


        }
    }


