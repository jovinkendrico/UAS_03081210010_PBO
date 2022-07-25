package entity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import util.Util;


public class EmployeeCashier extends Employee {


    public EmployeeCashier(String employeeName, String userName, String password) {
        super(employeeName, userName, password, "Cashier");
        //TODO Auto-generated constructor stub
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

    public void cashier(Employee employee, Scanner scanner,  ArrayList<Sale> dataSale, ArrayList<Invoice> dataInvoice){
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : terdapat perubahan parameter karena sudah tidak menggunakan 
         *              arraylist di data item, data customer, dan data category
         */
        String phone = checkInputPhoneNumber(scanner);
        if(checkPhoneNumberRegistered(phone)){
            tambahDataInvoiceSale(phone, scanner, employee, dataSale, dataInvoice);
        } else{
            tambahDataCustomer(scanner, phone);
            tambahDataInvoiceSale(phone, scanner, employee, dataSale, dataInvoice);
        }
    }
    //==============================//
    public void cetakInvoice(Scanner scanner, ArrayList<Invoice> dataInvoice, ArrayList<Sale> dataSale){
        int invoiceId;
        boolean iDitemukan = false;
        int idxInvoice = 0;
        try{
            System.out.print("Masukkan Invoice ID = ");
            invoiceId = scanner.nextInt();
            for (Invoice invoice : dataInvoice) {
                if(invoice.getInvoiceId() == invoiceId){
                    iDitemukan = true;
                    break;
                }
                idxInvoice++;
            }          
            if(iDitemukan){
                Invoice invoice = dataInvoice.get(idxInvoice);
                cetakInvoice(dataSale, invoice);
            }
            /*
                * Nama : Jovin Kendrico
                * NIM : 03081210010
                * Keterangan : untuk jawaban no 4 : Terjadi perubahan karena sebelumnya tidak ada exception handling 
                *              dimana ketika invoice  belum terdapat data akan terjadi looping trus 
                *              karena data belum ada dan input tidak dapat divalidasi
                */
            else{
                throw new Exception("Invoice ID tidak ditemukan");
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
        System.out.println("===============================");

    }

    public void cetakInvoice(ArrayList<Sale> dataSale , Invoice invoice){
        System.out.println("=============================================================================");
        System.out.println("                                    INVOICE                                  ");
        System.out.println("=============================================================================");
        System.out.println("Nama Customer = " + invoice.getCustomer().getCustomerName());
        System.out.println("Nama Kasir = " + invoice.getEmployee().getEmployeeName());
        System.out.println("Tanggal Transaksi = " + invoice.getLocalDate());
        System.out.println("=============================================================================");
        System.out.format("%8s %30s %10s %10s %10s \n", "ID", "Nama Item", "Jumlah", "Harga", "Total");    
        for (Sale sale : dataSale) {
            if(sale.getInvoice().getInvoiceId() == invoice.getInvoiceId()) System.out.format("%8s %30s %10s %10s %10s \n", sale.getItem().getItemId(), sale.getItem().getItemName(), sale.getQuantity(), sale.getItem().getPrice(), sale.getTotal());
        }
        System.out.println("=============================================================================");

        System.out.println("Total Harga = " + invoice.getTotalPrice());
        System.out.println("Tax         = " + invoice.getTax());
        System.out.println("Diskon      = " + invoice.getDiscount());
        System.out.println("Total Bayar = " + invoice.getTotalPay());
        System.out.println("Bayar       = " + invoice.getPaid());
        System.out.println("Kembalian   = " + invoice.getReturned());
        System.out.println("=============================================================================");

    }
    private void tambahDataCustomer(Scanner scanner, String phone){
        /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : Terjadi perubahan karena sebelumny data ditambahkan ke dalam arraylist dan sekarang data ditambahkan 
         *              ke dalam file customer.txt
         */
        String namaCustomer;
        String emailCust;
        Util util = new Util();
        util.init("Customer.txt");
        ArrayList<String> dataFile = util.readFile();
        while(true){
            try {
                scanner.nextLine();
                System.out.print("Nama Customer = ");
                namaCustomer = scanner.nextLine();
                System.out.print("Email Customer = ");
                emailCust = scanner.nextLine();
                String dataId = dataFile.get(dataFile.size()-2);
                int customerId = Integer.parseInt(dataId.split(",")[0])+1;
                Customer customer = new Customer(customerId,namaCustomer, phone, emailCust);
                String data = customer.getCustomerId() + "," + customer.getCustomerName() + "," + customer.getPhone() + "," + customer.getEmail();
                util.writeFile(data);
                break;
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    private void tambahDataInvoiceSale(String phone,Scanner scanner, Employee employee, ArrayList<Sale> dataSale, ArrayList<Invoice> dataInvoice){
        Customer customer = getDataCustomer(phone);
        LocalDate localDate = getTanggalTransaksi(scanner);
        Invoice invoice = new Invoice(employee, customer, localDate);
        boolean tambahItem = true;
        while(tambahItem){
            tambahDataSale(scanner, invoice, dataSale);
            scanner.nextLine();
            System.out.print("Tambah Item lain ? (y/n)");
            String pilihan = scanner.nextLine();
            if(pilihan.equalsIgnoreCase("n")){
                break;
            }
        }
        
        for (Sale sale : dataSale) {
            if(sale.getInvoice().getInvoiceId() == invoice.getInvoiceId()){
                invoice.tambahTotalPrice(sale.getTotal());
            }
        }

        invoice.setTax(0.11 * invoice.getTotalPrice());
        invoice.setTotalPay(invoice.getTotalPrice() + invoice.getTax() - invoice.getDiscount());

        System.out.println("Total Harga = " + invoice.getTotalPay());
        int bayar;
        while(true){
            try {
                System.out.print("Bayar = ");
                bayar = scanner.nextInt();
                if(bayar < invoice.getTotalPay()) throw new Exception("Kurang bayar");
                else{
                    System.out.println("Kembalian = " + (invoice.getTotalPay()-bayar));
                    invoice.setPaid(bayar);
                    invoice.setReturned((bayar-invoice.getTotalPay()));
                    break;
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
        dataInvoice.add(invoice);

        cetakInvoice(dataSale, invoice);
    }
    private boolean checkPhoneNumberRegistered(String phoneNumber){
        /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : Terdapat perubahan karena sebelumnya mengecheck data di arraylist 
         *              tetapi sekarang dicheck datanya di customer.txt
         */
        Util util = new Util();
        util.init("customer.txt");
        ArrayList<String> dataFile = util.readFile();
        for(String data : dataFile){    
            if(data!=null){
                String dataPhone = data.split(",")[2];
                if(phoneNumber.equalsIgnoreCase(dataPhone)){
                    return true;
                }
            }
        }
        return false;
    }
    private String checkInputPhoneNumber(Scanner scanner){
        String phone;
        while(true){
            try {
                scanner.nextLine();
                System.out.print("Masukkan No Telepon Customer = ");
                phone = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                //TODO: handle exception
            }            
        }
        return phone;
    }
    private Customer getDataCustomer(String phoneNumber){
        /*
         * Nama : Jovin Kendrico
         * Nim : 03081210010
         * Keterangan : terdapat perubahan karena sebelumnya untuk mendapatkan data customer diambil datanya dari arraylist 
         *              dan sekarang datanya diambil dari customer.txt
         */
        Util util = new Util();
        util.init("customer.txt");
        ArrayList<String> dataFile = util.readFile();
        for (String data : dataFile) {
            if(data!=null){
                String dataPhone = data.split(",")[2];
                if(phoneNumber.equals(dataPhone)){
                    return new Customer(Integer.parseInt(data.split(",")[0]), data.split(",")[1], data.split(",")[2], data.split(",")[3]);
                }
            }
        }
        return null;
    }
    private LocalDate getTanggalTransaksi(Scanner scanner){
        while(true){
            try {
                System.out.print("Tahun Transaksi = ");
                int tahun = scanner.nextInt();
                System.out.print("Bulan Transaksi = ");
                int bulan = scanner.nextInt();
                System.out.print("Tanggal Transaksi = ");
                int tanggal = scanner.nextInt();
                if(bulan >12) throw new Exception("Masukkan tanggal, bulan atau tahun yang beanr");
                if(tanggal>31) throw new Exception("Masukkan tanngal, bulan atau tahun yang benar");
                LocalDate localDate = LocalDate.of(tahun, bulan, tanggal);
                return localDate;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                //TODO: handle exception
            }
        }

    }
    private void tambahDataSale(Scanner scanner, Invoice invoice, ArrayList<Sale> dataSale){
        /*
         *  Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : terdapat perubahan karena data item yang sudah bukan merupakan arraylist
         */
        while(true){
            int amount;
            try {
                System.out.print("Kode item = ");
                int itemId = scanner.nextInt();
                boolean iFound = false;
                Util utilI = new Util();
                utilI.init("item.txt");
                ArrayList<String> dataFileI = utilI.readFile();
                Item item = new Item();
                for(String data : dataFileI){
                    if(data!=null){
                        if(String.valueOf(itemId).equals((data.split(",")[0]))){
                            item.setItemId(Integer.parseInt(data.split(",")[0]));
                            item.setItemName(data.split(",")[1]);
                            item.setPrice(Integer.parseInt(data.split(",")[2]));
                            item.setAmount(Integer.parseInt(data.split(",")[3]));
                            Util utilC = new Util();
                            utilC.init("category.txt");
                            ArrayList<String> dataFileC = utilC.readFile();
                            for(String dataC : dataFileC){
                                if(data!=null){
                                    if(dataC.split(",")[1].equals(data.split(",")[4])){
                                        Category category = new Category(Integer.parseInt(dataC.split(",")[0]), dataC.split(",")[1]);
                                        item.setCategory(category);
                                        break;
                                    }
                                }  
                            }
                            iFound = true;
                            break;
                        } 
                    }
                }
                if(!iFound) throw new Exception("Masukkan item id yang benar");
                System.out.print("Jumlah dibeli = ");
                amount = scanner.nextInt();
                dataSale.add(new Sale(invoice, item, amount));
                updateStockItem(item.getItemId(), amount);
                break;
            }catch(Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            } 
        }
    }
    private void updateStockItem(int idItem, int amount) throws IOException{
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Terdapat method baru untuk updateStockItem karena data item.txt yang bukan merupakan arrayl
         */

        Util util = new Util();
        util.init("item.txt");
        ArrayList<String> dataFile = util.readFile();
        for(String data : dataFile){
            if(data!=null){
                if(Integer.parseInt(data.split(",")[0]) == idItem){
                    util.updateFileItemAmount(String.valueOf(amount*-1), String.valueOf(idItem));
                    break;
                }
            }
        }    
    }
}
