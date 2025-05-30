package Layout;

import java.awt.CardLayout;
import javax.swing.*;

public class MainFrame extends JFrame {
    private String selectedVendorId;
    private String customerNickname;
    CardLayout layout;
    JPanel mainPanel;

    VendorLoginPanel VendorLogin;
    VendorEditPanel VendorEdit;
    CustomerLoginPanel CustomerLogin;
    CustomerBrowsePanel CustomerBrowse;
    CustomerDetailPanel CustomerDetail;
    AdminLoginPanel AdminLogin;
    AdminEditPanel AdminEdit;
    AdminBrowsePanel AdminBrowse;
    AdminDatabasePanel AdminDatabase;
    AdminVendorEditPanel AdminVendorEdit;
    LoginPanel Login;


    public MainFrame() {
        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        VendorLogin = new VendorLoginPanel(this);
        VendorEdit = new VendorEditPanel(this);
        CustomerLogin = new CustomerLoginPanel(this);
        CustomerBrowse = new CustomerBrowsePanel(this);
        CustomerDetail = new CustomerDetailPanel(this);
        AdminLogin = new AdminLoginPanel(this);
        AdminEdit = new AdminEditPanel(this);
        AdminBrowse = new AdminBrowsePanel(this);
        AdminDatabase = new AdminDatabasePanel(this);
        AdminVendorEdit = new AdminVendorEditPanel(this);
        Login = new LoginPanel(this);
        AdminDatabase = new AdminDatabasePanel(this);
        
        mainPanel.add(AdminDatabase, "AdminDatabase");
        mainPanel.add(VendorLogin, "VendorLogin");
        mainPanel.add(VendorEdit, "VendorEdit");
        mainPanel.add(CustomerLogin, "CustomerLogin");
        mainPanel.add(CustomerBrowse, "CustomerBrowse");
        mainPanel.add(CustomerDetail, "CustomerDetail");
        mainPanel.add(AdminLogin, "AdminLogin");
        mainPanel.add(AdminEdit, "AdminEdit");
        mainPanel.add(Login, "Login");
        mainPanel.add(AdminBrowse , "AdminBrowse");
        // mainPanel.add(AdminDatabase, "AdminDatabase");
        mainPanel.add( AdminVendorEdit, "AdminVendorEdit");

        add(mainPanel);
        layout.show(mainPanel, "Login");

        setTitle("政大市集+");
        setSize(405, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void switchTo(String panelName) {
        layout.show(mainPanel, panelName);
        System.out.println(panelName);
    }

    public void setSelectedVendorId(String id) {
        this.selectedVendorId = id;
    }

    public String getSelectedVendorId() {
        return selectedVendorId;
    }

    public void refresh(String id) {
        if (VendorEdit.isShowing()) {
            VendorEdit.refresh(id);
        } else if (AdminVendorEdit.isShowing()) {
            AdminVendorEdit.refresh(id);
        } else if (CustomerDetail.isShowing()) {
            CustomerDetail.refresh(id);
        }
    }

    public void setCustomerNickname(String nickname){
        this.customerNickname=nickname;
    }
    public String getCustomerNickname(){
        return customerNickname;
    }

}

