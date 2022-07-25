package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
 * Nama : Jovin Kendrico
 * NIM : 03081210010
 * Keterangan : Untuk jawaban no-3 untuk simpan dan baca file data 
 */
public class Util {
    String lokasiFile;
    public void init(String file){
        /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Untuk jawaban no-3 dimana diminta untuk validasi data apakah data init yang dientry adalah string atau bukan 
         */
        try {
            String lokasi = new File(".").getCanonicalPath();
            lokasiFile = lokasi + "\\" + file;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
    }

    public ArrayList<String> readFile(){
        String data;
        ArrayList<String> dataFile = new ArrayList<String>();
         /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Untuk Jawaban no-4 dimana diminta untuk validasi data apakah lokasi file yang dientry ada atau tidak
         */
        try(BufferedReader br = new BufferedReader(new FileReader(lokasiFile))){
            do {
                data = br.readLine();
                dataFile.add(data);
            } while (data!=null);
        } catch (FileNotFoundException e) {
            System.out.println("File yang anda cari tidak ditemukan! " + lokasiFile);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return dataFile;
    }

    public void writeFile(String data){

         /*
         * Nama : Jovin Kendrico
         * NIM : 03081210010
         * Keterangan : Untuk Jawaban no-3 dimana diminta untuk validasi data apakah lokasi file yang dientry ada atau tidak
         */
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(lokasiFile, true)))){
            pw.println(data);
        }catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan! coba periksa kembali "+lokasiFile);
        } 
        catch (Exception e) {
            //TODO: handle exception
               System.out.println(e.getMessage());
        }
    }

    public void updateFileItemAmount(String update, String idItem) throws IOException{
        File originalFile = new File("item.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File("tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String data ;
        try{
            do {
                data = br.readLine();
                if(data!=null){
                    String[] dataSplit = data.split(",");
                    String id = dataSplit[0];
                    String nama = dataSplit[1];
                    String harga = dataSplit[2];
                    String jumlah = dataSplit[3];
                    String kategori = dataSplit[4];
                    if(id.equals(idItem)){
                        data = id + "," + nama + "," + harga + "," + (Integer.parseInt(jumlah)+Integer.parseInt(update)) + "," + kategori;
                        pw.println(data);
                    }
                    else{
                        pw.println(data);
                    }
                }
            } while (data!=null);
        } catch (FileNotFoundException e) {
            System.out.println("File yang anda cari tidak ditemukan! " + lokasiFile);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        pw.close();
        br.close();

        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
    }
}
