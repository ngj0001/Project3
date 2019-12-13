public interface IDataAdapter {

    int CONNECTION_OPEN_OK = 100;
    int CONNECTION_OPEN_FAILED = 101;

    int CONNECTION_CLOSE_OK = 200;
    int CONNECTION_CLOSE_FAILED = 201;

    int PRODUCT_SAVE_OK = 0;
    int PRODUCT_SAVE_FAILED = 1;

    int USER_SAVE_OK = 0;
    int USER_SAVE_FAILED = 1;

    int CUSTOMER_SAVE_OK = 0;
    int CUSTOMER_SAVE_FAILED = 1;

    int PURCHASE_SAVE_OK = 500;
    int PURCHASE_SAVE_FAILED = 501;

    int PRODUCT_SAVED_OK = 300;
    int PRODUCT_DUPLICATE_ERROR = 301;

    int PURCHASE_SAVED_OK = 400;
    int PURCHASE_DUPLICATE_ERROR = 401;

    int USER_SAVED_OK = 400;
    int USER_DUPLICATE_ERROR = 401;

    int CUSTOMER_SAVED_OK = 600;
    int CUSTOMER_DUPLICATE_ERROR = 601;

    int connect(String dbfile);

    int disconnect();


    ProductModel loadProduct(int id);

    int saveProduct(ProductModel model);

    CustomerModel loadCustomer(int id);

    int saveCustomer(CustomerModel model);

    PurchaseModel loadPurchase(int id);

    PurchaseListModel loadPurchaseHistory(int customerID);

    int savePurchase(PurchaseModel model);


    ProductListModel searchProduct(String name, double minPrice, double maxPrice);

    UserModel loadUser(String username);

    int saveUser(UserModel user);

    PurchaseListModel searchPurchase(String purchaseID, int productID, double Total);
}
