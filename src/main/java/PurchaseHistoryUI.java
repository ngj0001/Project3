import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PurchaseHistoryUI {

    public JFrame view;
    //public JList purchases;
    public JTable purchaseTable;

    public UserModel user = null;


    public PurchaseHistoryUI(UserModel user) {
        this.user = user;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("View Purchase History - Customer View");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Purchase history for " + user.mFullname);

        title.setFont (title.getFont().deriveFont (24.0f));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        view.getContentPane().add(title);

        PurchaseListModel list = StoreManager.getInstance().getDataAdapter().loadPurchaseHistory(user.mCustomerID);//        DefaultListModel<String> data = new DefaultListModel<>();
        DefaultTableModel tableData = new DefaultTableModel();

        tableData.addColumn("PurchaseID");
        tableData.addColumn("ProductID");
        tableData.addColumn("Product Name");
        tableData.addColumn("Total");

        for (PurchaseModel purchases : list.purchases) {
            Object[] row = new Object[tableData.getColumnCount()];
            row[0] = purchases.mPurchaseID;
            row[1] = purchases.mProductID;
            ProductModel product = StoreManager.getInstance().getDataAdapter().loadProduct(purchases.mProductID);
            row[2] = purchases.mTotal;
            tableData.addRow(row);
        }


        purchaseTable = new JTable(tableData);

        JScrollPane scrollableList = new JScrollPane(purchaseTable);

        view.getContentPane().add(scrollableList);


    }
}