package entity;

import java.util.ArrayList;
import java.util.Scanner;


import util.Util;
public class EmployeeAdmin extends Employee {

    
    public EmployeeAdmin(String employeeName, String userName, String password) {
        super(employeeName, userName, password, "Admin");
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

    public void showEmployeeData(ArrayList<Employee> dataEmployee){
        System.out.println("===============================");
        System.out.println("Cetak Data Karyawan");
        System.out.println("===============================");
        System.out.format("| %5s | %35s | %20s | %20s | %15s", "ID", "Nama", "Username", "Password", "Jabatan");
        System.out.println();
        for (Employee employee : dataEmployee) {
            System.out.format("| %5d | %35s | %20s | %20s | %15s", employee.getEmployeeId(), employee.getEmployeeName(), employee.getUserName(), employee.getPassword(), employee.getJabatan());
            System.out.println();
        }   
        System.out.println("===============================");
    }

    public void tambahDataKaryawan(Scanner scanner,ArrayList<Employee> dataEmployee){
        String nama;
        String username;
        String password;
        String pilihan;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Karyawan");
            System.out.println("===============================");
            System.out.print("Nama Karyawan = ");
            nama = scanner.nextLine();
            System.out.print("Username = ");            
            username = scanner.nextLine();
            System.out.print("Password = ");
            password = scanner.nextLine();
            System.out.print("[Kasir / Admin] = ");
            pilihan = scanner.nextLine();
            for(Employee employee : dataEmployee){
                if(employee.getUserName() == username){
                    throw new Exception("Username sudah ada masukkan username lain");
                }
            }
            if(password.length()<8){
                throw new Exception("Password harus memiliki 8 angka atau huruf");
            }
            if(pilihan.equalsIgnoreCase("kasir")){
                // dataEmployee.add(new EmployeeCashier(nama, username, password));
                System.out.println("\n Data kasir berhasil ditambahkan..\n");
            }else if(pilihan.equalsIgnoreCase("admin")){
                dataEmployee.add(new EmployeeAdmin(nama, username, password));
                System.out.println("\n Data Admin berhasil ditambahkan..\n");
            }else{
                throw new Exception("Masukkan pilihan antara kasir atau admin");
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        } 
        System.out.println("===============================");
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
             * Keterangan : Terjadi perubahan karena data item yang dibanding dimana sekarang merupakan nama barang
             *              dan sebelumnya merupakan itemId
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

    public void tambahDataCategory(Scanner scanner){
        /*
         *  Nama : Jovin Kendrico
         *  NIM : 03081210010
         *  Keterangan : terjadi perubhaan karena data yang ditambah sebelumnya ditambahkan ke arraylist dan
         *              sekarang data ditambahkan di category.txt
         */
        String kategori;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Kategori");
            System.out.println("===============================");
            System.out.print("Nama Category = ");
            kategori = scanner.nextLine();
            Util util = new Util();
            util.init("category.txt");
            ArrayList<String> dataFile = util.readFile();
            for(String data : dataFile){
                if(data!=null){
                    String dataCategory[] = data.split(",");
                    String jenisKategori = dataCategory[1];
                    if(jenisKategori.equalsIgnoreCase(kategori)){
                        throw new Exception("Jenis Kategori sudah ada");
                    }
                }
            }
            String dataCategory = dataFile.get(dataFile.size()-2);
            int id = Integer.parseInt(dataCategory.split(",")[0])+1;
            String data = id + "," + kategori;
            util.writeFile(data);
            System.out.println("\n Data kategori berhasil ditambahkan..\n");
        }catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void tambahDataCustomer(Scanner scanner){
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : terjadi perubahan karena data yang ditambah sebelumnya ditambahkan ke arraylist dan
         *             sekarang data ditambahkan di customer.txt
         */
        String namaCustomer;
        String phoneCust;
        String emailCust;
        Util util = new Util(); 
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Customer");
            System.out.println("===============================");
            System.out.print("Nama Customer = ");
            namaCustomer = scanner.nextLine();
            System.out.print("Nomor Hp Customer = ");
            phoneCust = scanner.nextLine();
            System.out.print("Email Customer = ");
            emailCust = scanner.nextLine();
            util.init("customer.txt");
            ArrayList<String> dataFile = util.readFile();
            for (String data : dataFile) {
                if(data!=null){
                    String[] dataSplit = data.split(",");
                    String phone = dataSplit[2];
                    if(phoneCust.equals(phone)) {
                        throw new Exception("Nomor telp Customer yang diinput sudah terdapat dalam data");
                    }
                }
            }
            String dataId = dataFile.get(dataFile.size()-2);
            int customerId = Integer.parseInt(dataId.split(",")[0])+1;
            Customer customer = new Customer(customerId,namaCustomer, phoneCust, emailCust);
            String data = customer.getCustomerId() + "," + customer.getCustomerName() + "," + customer.getPhone() + "," + customer.getEmail();
            util.writeFile(data);
            System.out.println("\n Data kustomer berhasil ditambahkan..\n");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
    }
}
