import java.util.ArrayList;
import java.util.Scanner;

import entity.Employee;
import entity.EmployeeAdmin;
import entity.EmployeeCashier;
import entity.EmployeeGudang;
import entity.Invoice;
import entity.Sale;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> dataEmployee = initEmployee();
        ArrayList<Invoice> dataInvoice = new ArrayList<Invoice>();
        ArrayList<Sale> dataSale = new ArrayList<Sale>();
        while (true){
            String logout = "n";
            Employee employee = LoginEmployee(scanner, dataEmployee);
            while (logout.equalsIgnoreCase("n")){
                runApp(scanner, employee, dataEmployee, dataInvoice, dataSale);
                System.out.print("Logout (y/n) ? = ");
                logout = scanner.next();
                bersihkanLayar();
            }
        }
    }
    public static void runApp(Scanner scanner, Employee employee, ArrayList<Employee> dataEmployee, ArrayList<Invoice> dataInvoice, ArrayList<Sale> dataSale){
         /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : karena penambahan subclass baru untuk jawaban no-1  maka dibutuhkan tambahan else if dan perubahan dari
         *              class sebelumnya yang hanya terdiri dari admin dan cashier dimana untuk percabangan ini sebelumnya
         *              hanya memanfaatkan boolean isAdmin sedangkan sekarangn menggunakan jabatan sebagai percabangan
         */
        if(employee.getJabatan().equalsIgnoreCase("admin")){
            bersihkanLayar();
            EmployeeAdmin login = (EmployeeAdmin) employee;
            System.out.println("===============================");
            System.out.println("Menu Employee Admin");
            System.out.println("===============================");
            System.out.println("1. Tambah Data Karyawan");
            System.out.println("2. Tambah Data Item");
            System.out.println("3. Tambah Data Kategori");
            System.out.println("4. Tambah Data Customer");
            System.out.println("5. Cetak Data Invoice");
            System.out.println("6. Cetak Data Karyawan");
            System.out.println("7. Cetak Data Item");
            System.out.println("8. Cetak Data Kategori");
            System.out.println("9. Cetak Data Customer");
            System.out.println("===============================");
            System.out.print("Masukkan Pilihan = ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                if(pilihan>10 || pilihan <1){
                    throw new Exception("Masukkan Pilihan Antara 1-10");
                }
                if(pilihan == 1){
                    bersihkanLayar();
                    login.tambahDataKaryawan(scanner, dataEmployee);
                }
                else if(pilihan == 2){
                    bersihkanLayar();
                    login.tambahDataItem(scanner);
                }else if(pilihan == 3){
                    bersihkanLayar();
                    login.tambahDataCategory(scanner);
                }else if(pilihan == 4){
                    bersihkanLayar();
                    login.tambahDataCustomer(scanner);
                }else if(pilihan == 5){
                    bersihkanLayar();
                    login.showInvoiceData(dataInvoice);
                }else if(pilihan == 6){
                    bersihkanLayar();
                    login.showEmployeeData(dataEmployee);
                }else if(pilihan == 7){
                    bersihkanLayar();
                    login.showItemData();
                }else if(pilihan == 8){
                    bersihkanLayar();
                    login.showItemCategory();
                }else{
                    bersihkanLayar();
                    login.showCustomerData();
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }

        else if(employee.getJabatan().equalsIgnoreCase("Cashier")){
            bersihkanLayar();
            EmployeeCashier login = (EmployeeCashier) employee;
            System.out.println("===============================");
            System.out.println("Menu Employee Kasir");
            System.out.println("===============================");
            System.out.println("1. Cetak Data Invoice");
            System.out.println("2. Cetak Data Item");
            System.out.println("3. Cetak Data Kategori");
            System.out.println("4. Cetak Data Customer");
            System.out.println("5. Aplikasi Kasir");
            System.out.println("6. Cetak Invoice berdasarkan Invoice ID");
            System.out.println("===============================");
            System.out.print("Masukkan Pilihan = ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                if(pilihan>6 || pilihan <1){
                    bersihkanLayar();
                    throw new Exception("Masukkan Pilihan Antara 1-6");
                }
                if (pilihan == 1){
                    bersihkanLayar();
                    login.showInvoiceData(dataInvoice);
                }
                else if(pilihan == 2){
                    bersihkanLayar();
                    login.showItemData();
                }
                else if(pilihan == 3){
                    bersihkanLayar();
                    login.showItemCategory();
                }
                else if(pilihan == 4){
                    bersihkanLayar();
                    login.showCustomerData();
                }
                else if(pilihan == 5){
                    bersihkanLayar();
                    login.cashier(login, scanner, dataSale, dataInvoice);
                }
                else if(pilihan == 6){
                    bersihkanLayar();
                    login.cetakInvoice(scanner, dataInvoice, dataSale);
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
        else{
            bersihkanLayar();
            EmployeeGudang login = (EmployeeGudang) employee;
            System.out.println("===============================");
            System.out.println("Menu Employee Kasir");
            System.out.println("===============================");
            System.out.println("1. Cetak Data Invoice");
            System.out.println("2. Cetak Data Item");
            System.out.println("3. Cetak Data Kategori");
            System.out.println("4. Cetak Data Customer");
            System.out.println("5. Tambah Data Item");
            System.out.println("6. Tambah Stock Item Berdasarkan Item ID");
            System.out.println("7. Tambah Stock Item Berdasrkan Nama Item");
            System.out.println("8. Cetak Data Item Sorting Berdasarkan Harga Tertinggi");
            System.out.println("9. Cetak Data Item Sorting Berdasarkan Harga Terendah");
            System.out.println("===============================");
            System.out.print("Masukkan Pilihan = ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                if(pilihan>9 || pilihan <1){
                    bersihkanLayar();
                    throw new Exception("Masukkan Pilihan Antara 1-6");
                }
                if (pilihan == 1){
                    bersihkanLayar();
                    login.showInvoiceData(dataInvoice);
                }
                else if(pilihan == 2){
                    bersihkanLayar();
                    login.showItemData();
                }
                else if(pilihan == 3){
                    bersihkanLayar();
                    login.showItemCategory();
                }
                else if(pilihan == 4){
                    bersihkanLayar();
                    login.showCustomerData();
                }
                else if(pilihan == 5){
                    bersihkanLayar();
                    login.tambahDataItem(scanner);
                }
                else if(pilihan == 6){
                    bersihkanLayar();
                    int idItem = 0;
                    try {
                        System.out.print("Masukkan Id Item : ");
                        idItem = scanner.nextInt();
                        if(idItem<1){
                            throw new Exception("Id Item Tidak Boleh Kurang Dari 1");
                        }
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println("Error : " + e.getMessage());
                    }
                    login.tambahStockItem(scanner,idItem);
                } else if(pilihan == 7){
                    bersihkanLayar();
                    scanner.nextLine();
                    String namaItem = "";
                    try {
                        System.out.print("Masukkan Nama Item : ");
                        namaItem = scanner.nextLine();
                        if(namaItem.equalsIgnoreCase("")){
                            throw new Exception("Nama Item Tidak Boleh Kosong");
                        }
                        login.tambahStockItem(scanner, namaItem);
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                } else if(pilihan == 8){
                    bersihkanLayar();
                    login.showItemDataSortByPriceAsc();
                } else if(pilihan == 9){
                    bersihkanLayar();
                    login.showItemDataSortByPriceDesc();
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    
    public static Employee LoginEmployee(Scanner scanner, ArrayList<Employee> dataEmployee){
        String userName;
        String password;
        while(true){
            try {
                System.out.println("=================");
                System.out.println("Login");
                System.out.println("=================");
                System.out.print("Username = ");
                userName = scanner.next();
                System.out.print("Password = ");
                password = scanner.next();
                for(Employee employee : dataEmployee){
                    if(employee.getUserName().equals(userName)){
                        if(employee.getPassword().equals(password)){
                            return employee;
                        }
                    }
                }
                throw new Exception("Masukkan Username dan Password yang benar");
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error = "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Employee> initEmployee(){
        ArrayList<Employee> dataEmployee = new ArrayList<Employee>();
        dataEmployee.add(new EmployeeAdmin("Jovian", "Jovian", "12345abc"));
        dataEmployee.add(new EmployeeAdmin("Vanes", "Vanes", "qwerty12345"));
        dataEmployee.add(new EmployeeCashier("Carlos", "Carlos", "abcdefghij"));
        dataEmployee.add(new EmployeeGudang("Nando", "nando", "12345678"));
        return dataEmployee;
    }

    public static void bersihkanLayar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
