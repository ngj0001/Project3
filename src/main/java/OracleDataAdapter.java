public class OracleDataAdapter implements IDataAdapter {
    public int connect(String dbfile) {
        //...
        return CONNECTION_OPEN_OK;
    }

    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }
    public CustomerModel loadCustomer(int id) {
        return null;
    }

    @Override
    public int saveCustomer(CustomerModel model) {
        return CUSTOMER_SAVE_OK;
    }

    @Override
    public PurchaseModel loadPurchase(int id) {
        return null;
    }

    public ProductModel loadProduct(int id) {
        return null;
    }
    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVE_OK;
    }

    @Override
    public int savePurchase(PurchaseModel model) {
        return 0;
    }

    @Override
    public PurchaseListModel loadPurchaseHistory(int customerID) {
        return null;
    }


    @Override
    public ProductListModel searchProduct(String name, double minPrice, double maxPrice) {
        return null;
    }

    @Override
    public UserModel loadUser(String username) {
        return null;
    }

    @Override
    public int saveUser(UserModel user) {
        return 0;
    }

    @Override
    public PurchaseListModel searchPurchase(String purchaseID, int productID, double Total) {
        return null;
    }

}
