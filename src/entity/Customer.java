package entity;

public class Customer{
    private int customerId;
    private String customerName;
    private String phone;
    private String email;


    public Customer() {
    }

    public Customer(int customerId,String customerName, String phone, String email) {
        /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : Terjadi perubahan karena sebelumnya data ditambahkan dengan static increment 
         *              dan sekarang customerid akan bertambah dengan sendirinya di customer.txt
         */
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
