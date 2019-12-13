/*
import javax.swing.*;

public class StoreManager {
    public static String dbms = "SQLite";
    public static String path = "store.db";

    IDataAdapter dataAdapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {
            instance = new StoreManager(dbms, path);
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            dataAdapter = new OracleDataAdapter();
        else
        if (dbms.equals("SQLite"))
            dataAdapter = new SQLiteDataAdapter();
        else
        if (dbms.equals("Network"))
            dataAdapter = new NetworkDataAdapter();

        dataAdapter.connect(dbfile);

    }

    public IDataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        dataAdapter = a;
    }


    public void run() {
        LoginUI ui = new LoginUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
        if (args.length > 0) { // having runtime arguments
            dbms = args[0];
            if (args.length == 1) { // do not have 2nd arguments for dbfile
                if (dbms.equals("SQLite")) {
                    JFileChooser fc = new JFileChooser();
                    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                        path = fc.getSelectedFile().getAbsolutePath();
                }
                else
                    path = JOptionPane.showInputDialog("Enter address of database server as host:port");
            }
            else
                path = args[1];
        }
        StoreManager.getInstance().run();
    }

}
*/


import javax.swing.*;

public class StoreManager {
    public static final String DBMS_SQ_LITE = "SQLite";
    public static final String DB_FILE = "data/store.db";

    IDataAdapter adapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {

            String dbfile = DB_FILE;
            if (dbfile.length() == 0) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                    dbfile = fc.getSelectedFile().getAbsolutePath();
            }
            instance = new StoreManager(DBMS_SQ_LITE, dbfile);
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            adapter = new OracleDataAdapter();
        else
        if (dbms.equals("SQLite"))
            adapter = new SQLiteDataAdapter();

        adapter.connect(dbfile);
    }

    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }
//

    public void run() {
        LoginUI ui = new LoginUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
//        StoreManager.getInstance().init();
        StoreManager.getInstance().run();
    }

}

