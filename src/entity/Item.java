package entity;


public class Item {
    /*
     * Nama : Jovin Kendrico
     * NIM : 03081210010
     * Keterangan : terjadi perubahan pada variabel itemId dimana sebelumnya adalah String dana berubah menjadi Integer
     */
    private int itemId;
    private String itemName;
    private int price;
    private int amount;
    private Category category;



    public Item() {
    }

    public Item(int itemId, String itemName, int price, int amount, Category category) {
                /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : Terjadi perubahan karena sebelumnya data ditambahkan dengan menginput sendiri itemid 
         *              dan sekarang itemid akan bertambah dengan sendiriny di file item.txt
         */
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }



    public int getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
    