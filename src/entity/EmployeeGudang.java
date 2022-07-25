package entity;

import java.util.ArrayList;
import java.util.Scanner;

import util.Util;
/*
 * Nama : Jovin Kendrico
 * NIM : 03081210010
 * Keterangan : Untuk jawaban no-1 dimana diminta untuk menambahkan sub class baru dari class yang telah dipilih
 */
public class EmployeeGudang extends Employee {
    public EmployeeGudang(String employeeName, String userName, String password) {
        super(employeeName, userName, password, "Gudang");
        //TODO Auto-generated constructor stub
    }
    /*
     * Nama : Jovin Kendrico
     * NIM : 03081210010
     * Keterangan : untuk jawaban no-2 : method overloading pada method tambah stockitem dimana parameter yang berbeda adalah parameter
     *              namaItem dengan int idItem
     */
    public void tambahStockItem(Scanner scanner, String namaItem){
        System.out.println("===============================");
        System.out.println("Tambah Stock Item");
        System.out.println("===============================");
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Untuk jawaban no-4 dimana diminta validasi data yang memanfaatkan exception handling untuk
         *              setiap data yang di entry
         */
        try {
            Util utilI = new Util();
            utilI.init("item.txt");
            ArrayList<String> dataItemFile = utilI.readFile();
            for (String data : dataItemFile) {
                if(data!=null){
                    String dataItem[] = data.split(",");
                    int itemId = Integer.parseInt(dataItem[0]);
                    String namaItemFile = dataItem[1];
                    if (namaItemFile.equals(namaItem)) {
                        System.out.print("Masukkan Jumlah Stock Item yang ingin ditambahkan : ");
                        int amount = scanner.nextInt();
                        utilI.updateFileItemAmount(String.valueOf(amount), String.valueOf(itemId));
                        System.out.println("Stock Item berhasil ditambahkan!");
                        break;
                    } else {
                        throw new Exception("Item tidak ditemukan");
                    }
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
    }
        /*
     * Nama : Jovin Kendrico
     * NIM : 03081210010
     * Keterangan : untuk jawaban no-2 : method overloading pada method tambah stockitem dimana parameter yang berbeda adalah parameter
     *              namaItem dengan int idItem
     */
    public void tambahStockItem(Scanner scanner, int idItem){
        System.out.println("===============================");
        System.out.println("Tambah Stock Item");
        System.out.println("===============================");
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Untuk jawaban no-4 dimana diminta validasi data yang memanfaatkan exception handling untuk
         *              setiap data yang di entry
         */
        try {
            Util utilI = new Util();
            utilI.init("item.txt");
            ArrayList<String> dataItemFile = utilI.readFile();
            for (String data : dataItemFile) {
                if(data!=null){
                    String dataItem[] = data.split(",");
                    int id = Integer.parseInt(dataItem[0]);
                    System.out.println("Nama Item = " + dataItem[1]);
                    if (id == idItem) {
                        System.out.print("Masukkan Jumlah Stock Item yang ingin ditambahkan : ");
                        int amount = scanner.nextInt();
                        utilI.updateFileItemAmount(String.valueOf(amount), String.valueOf(idItem));
                        System.out.println("Stock Item berhasil ditambahkan!");
                        break;
                    } else {
                        throw new Exception("Item tidak ditemukan");
                    }
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        } 
    }
    public void tambahDataItem(Scanner scanner){
        String namaItem;
        int price;
        int amount;
        String jenisKategori;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Item");
            System.out.println("===============================");
            System.out.print("Nama Barang = ");
            namaItem = scanner.nextLine();
            System.out.print("Harga Barang = ");
            price = scanner.nextInt();
            System.out.print("Total Barang = ");
            amount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Jenis Kategori barang = ");
            jenisKategori = scanner.nextLine();
            /*
             * Nama : Jovin Kendrico
             * NIM : 03081210010
             * Keterangan : Terjadi perubahan karena data item yang dibanding sekarang merupakan nama barang
             *              yang dimana sebelumnya adalah itemId
             */
            Util utilI = new Util();
            utilI.init("item.txt");
            ArrayList<String> dataFileI = utilI.readFile();
            for (String dataI : dataFileI) {
                if(dataI!=null){
                    String dataItemI[] = dataI.split(",");
                    if(dataItemI[1].equalsIgnoreCase(namaItem)){
                        throw new Exception("Nama barang yang diinput sudah terdapat dalam data");
                    }
                }
            }

            /*
             * Nama : Jovin Kendrico
             * NIM : 03081210010
             * Keterangan : Terjadi perubahan pada pengecekan category karena data category telah disimpan dalam category.txt
             */
            Category hCategory = new Category();
            boolean cDitemukan = false;
            Util utilC = new Util();
            utilC.init("category.txt");
            ArrayList<String> dataFile = utilC.readFile();
            for (String data : dataFile){
                if(data!=null){
                    String dataCategory[] = data.split(",");
                    int id = Integer.parseInt(dataCategory[0]);
                    String jenisKategoriF = dataCategory[1];
                    if(jenisKategori.equalsIgnoreCase(jenisKategoriF)){
                        cDitemukan = true;
                        hCategory.setCategoryId(id);
                        hCategory.setJenisKategori(jenisKategori);
                        break;
                    }
                }
            }
            /*
             * Nama : Jovin Kendrico
             * NIM : 03081210010
             * Keterangan: terjadi perubahan karena sebelumnya data di update dalam arraylist dan sekarang di update di
             *             file item.txt
             */                
            if(cDitemukan){
                int itemId = Integer.parseInt(dataFileI.get(dataFileI.size()-2).split(",")[0]) + 1;
                Item item = new Item(itemId, namaItem, price, amount, hCategory);
                String dataItem = item.getItemId() + "," + item.getItemName() + "," + item.getPrice() + "," + item.getAmount() + "," + item.getCategory().getJenisKategori();
                utilI.writeFile(dataItem);
                System.out.println("\n Data item berhasil ditambahkan..\n");
            }else{
                System.out.println("\n Jenis Kategori tidak ditemukan..\n");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    public void showCustomerData() {
        // TODO Auto-generated method stub
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Terjadi perubahan karena data customer yang sudah diubah menjadi customer.txt sehingga perlu
         *              perubahan pada method ini
         */
        System.out.println("===============================");
        System.out.println("Cetak Data Customer");
        System.out.println("===============================");
        System.out.format("| %4s | %30s | %15s | %40s |", "ID", "Nama", "Phone", "Email");    
        System.out.println();
        Util util = new Util();
        util.init("customer.txt");
        ArrayList<String> dataFile = util.readFile();
        for(String data : dataFile){
            if(data!=null){
                String dataCustomer[] = data.split(",");
                Customer customer = new Customer(Integer.parseInt(dataCustomer[0]), dataCustomer[1], dataCustomer[2], dataCustomer[3]);
                System.out.format("| %4s | %30s | %15s | %40s |", customer.getCustomerId(), customer.getCustomerName(), customer.getPhone(), customer.getEmail());    
                System.out.println();
            }
        }
        System.out.println("===============================");
    }

    @Override
    public void showInvoiceData(ArrayList<Invoice> dataInvoice) {
        // TODO Auto-generated method stub
        System.out.println("===============================");
        System.out.println("Cetak Data Invoice");
        System.out.println("===============================");
        System.out.format("| %3s | %20s | %20s | %15s | %12s | %12s | %12s | %12s | %12s | %12s |", "ID", "Nama Kasir", "Nama Customer", "Tanggal", "Total Harga", "Tax", "Diskon", "Total Bayar", "Bayar", "Kembalian");    
        System.out.println();
        for (Invoice invoice : dataInvoice) {
            System.out.format("| %3d | %20s | %20s | %15s | %12.2f | %12.2f | %12.2f | %12.2f | %12.2f | %12.2f |", invoice.getInvoiceId(), invoice.getEmployee().getEmployeeName(), invoice.getCustomer().getCustomerName(), invoice.getLocalDate(), invoice.getTotalPrice(), invoice.getTax(), invoice.getDiscount(), invoice.getTotalPay(), invoice.getPaid(), invoice.getReturned());    
            System.out.println();
        }
        System.out.println("===============================");
    }

    @Override
    public void showItemData() {
        // TODO Auto-generated method stub
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Terjadi perubahan karena data item yang sudah diubah menjadi item.txt sehingga perlu
         *              perubahan pada method ini
         */
        System.out.println("===============================");
        System.out.println("Cetak Data Item");
        System.out.println("===============================");
        System.out.format("| %13s | %35s | %15s | %8s | %25s |", "ID", "Nama Item", "Harga", "Jumlah", "Jenis Kategori");    
        System.out.println();
        Util util = new Util();
        util.init("item.txt");
        ArrayList<String> dataFile = util.readFile();
        for (String data:dataFile) {
            if(data!=null){
                String dataItem[] = data.split(",");
                Util utilC = new Util();
                utilC.init("category.txt");
                ArrayList<String> dataFileC = utilC.readFile();
                for (String dataC : dataFileC) {
                    if(dataC!=null){
                        String dataCategory[] = dataC.split(",");
                        if(dataCategory[1].equals(dataItem[4])){
                            Category category = new Category(Integer.parseInt(dataCategory[0]), dataCategory[1]);
                            Item item = new Item(Integer.parseInt(dataItem[0]),dataItem[1], Integer.parseInt(dataItem[2]), Integer.parseInt(dataItem[3]), category);
                            System.out.format("| %13d | %35s | %15d | %8d | %25s |", item.getItemId(), item.getItemName(), item.getPrice(), item.getAmount(), item.getCategory().getJenisKategori());    
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("===============================");
    }

    @Override
    public void showItemCategory() {
        // TODO Auto-generated method stub
         /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Terjadi perubahan karena data category yang sudah diubah menjadi category.txt sehingga perlu
         *              perubahan pada method ini
         */
        System.out.println("===============================");
        System.out.println("Cetak Data Kategori Item");
        System.out.println("===============================");
        System.out.format("| %5s | %35s |", "ID", "Jenis Kategori");   
        System.out.println();
        Util util = new Util();
        util.init("category.txt");
        ArrayList<String> dataFile = util.readFile();
        for(String data : dataFile){
            if(data!=null){
                String dataCategory[] = data.split(",");
                Category category = new Category(Integer.parseInt(dataCategory[0]), dataCategory[1]);
                System.out.format("| %5s | %35s |", category.getCategoryId(), category.getJenisKategori());   
                System.out.println();
            }
        }
        System.out.println("===============================");
    }

    private int partitionPriceAsc(ArrayList<String> data, int low, int high){
        String pivot = data.get(high).split(",")[2];
        int i = low - 1;
        for(int j = low; j<high; j++){
            if(Integer.parseInt(data.get(j).split(",")[2])<=Integer.parseInt(pivot)){
                i++;
                String temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        String temp = data.get(i+1);
        data.set(i+1, data.get(high));
        data.set(high, temp);
        return i+1;
    }
    private void quickSortPriceAsc(ArrayList<String> data, int low, int high){
        if(low < high){
            int pivot = partitionPriceAsc(data,low,high);
            quickSortPriceAsc(data, low, pivot-1);
            quickSortPriceAsc(data, pivot+1, high);
        }
    }
    private int partitionPriceDesc(ArrayList<String> data, int low, int high){
        String pivot = data.get(high).split(",")[2];
        int i = low - 1;
        for(int j = low; j<high; j++){
            if(Integer.parseInt(data.get(j).split(",")[2])>=Integer.parseInt(pivot)){
                i++;
                String temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        String temp = data.get(i+1);
        data.set(i+1, data.get(high));
        data.set(high, temp);
        return i+1;
    }
    private void quickSortPriceDesc(ArrayList<String> data, int low, int high){
        if(low < high){
            int pivot = partitionPriceDesc(data,low,high);
            quickSortPriceDesc(data, low, pivot-1);
            quickSortPriceDesc(data, pivot+1, high);
        }
    }
    
    /*
     * Nama : Jovin Kendrico
     * NIM : 03081210010
     * Keterangan : Jawaban no-5 = sort by ascending berdasarkan harga tertinggi
     */
    public void showItemDataSortByPriceAsc(){
        System.out.println("=========================================");
        System.out.println("Cetak Data Item (Urutkan Harga Ascending)");
        System.out.println("=========================================");
        System.out.format("| %13s | %35s | %15s | %8s | %25s |\n", "ID", "Nama Item", "Harga", "Jumlah", "Jenis Kategori");    
        Util util = new Util();
        util.init("item.txt");
        ArrayList<String> dataFile = util.readFile();
        int i = 0;
        dataFile.remove(dataFile.size()-1);
        quickSortPriceAsc(dataFile, i, dataFile.size()-1);
        for (String data : dataFile) {
            String[] dataAsc = data.split(",");
            System.out.format("| %13d | %35s | %15d | %8d | %25s |\n", Integer.parseInt(dataAsc[0]), dataAsc[1], Integer.parseInt(dataAsc[2]), Integer.parseInt(dataAsc[3]), dataAsc[4]);
        }
    }
    /*
     * Nama : Jovin Kendrico
     * NIM : 03081210010
     * Keterangan : Jawaban no-5 = sort by Descending berdasarkan Harga Terendah
     */
    public void showItemDataSortByPriceDesc(){
        System.out.println("=========================================");
        System.out.println("Cetak Data Item (Urutkan Harga Ascending)");
        System.out.println("=========================================");
        System.out.format("| %13s | %35s | %15s | %8s | %25s |\n", "ID", "Nama Item", "Harga", "Jumlah", "Jenis Kategori");    
        Util util = new Util();
        util.init("item.txt");
        ArrayList<String> dataFile = util.readFile();
        int i = 0;
        dataFile.remove(dataFile.size()-1);
        quickSortPriceDesc(dataFile, i, dataFile.size()-1);
        for (String data : dataFile) {
            String[] dataAsc = data.split(",");
            System.out.format("| %13d | %35s | %15d | %8d | %25s |\n", Integer.parseInt(dataAsc[0]), dataAsc[1], Integer.parseInt(dataAsc[2]), Integer.parseInt(dataAsc[3]), dataAsc[4]);
        }
    }
}
