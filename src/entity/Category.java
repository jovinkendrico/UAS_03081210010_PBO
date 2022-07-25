package entity;

public class Category {
    private int categoryId;
    private String jenisKategori;


    public Category() {
    }

    public Category(int categoryId, String jenisKategori) {
        /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : Terjadi perubahan karena sebelumnya data ditambahkan dengan static increment 
         *              dan sekarang customerid akan bertambah dengan sendirinya di customer.txt
         */
        this.categoryId = categoryId;
        this.jenisKategori = jenisKategori;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getJenisKategori() {
        return this.jenisKategori;
    }

    public void setJenisKategori(String jenisKategori) {
        this.jenisKategori = jenisKategori;
    }
   
}
