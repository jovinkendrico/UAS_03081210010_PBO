package entity;

import java.util.ArrayList;


public abstract class Employee{
    private static int increment = 0;
    private int employeeId;
    private String employeeName;
    private String userName;
    private String password;
    private String jabatan;

    public Employee( String employeeName, String userName, String password, String jabatan) {
        this.employeeId = ++increment;
        this.employeeName = employeeName;
        this.userName = userName;
        this.password = password;
        this.jabatan = jabatan;
    }
    
    abstract void showCustomerData();
    abstract void showInvoiceData(ArrayList<Invoice> dataInvoice);
    abstract void showItemData();
    abstract void showItemCategory();

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return this.jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

}