package TugasBesar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AktifitasKu {

    static HashMap<Integer, String> mymap = new HashMap<Integer, String>();
    Scanner in = new Scanner(System.in);
    MainMenu BackToMenu = new MainMenu();
    String namaAktifitas;
    int tanggal;
    boolean check;
    void menuProgram (){
        System.out.print("__________________________________________________\n" +
                "|                   AKTIVITASKU                   |\n" +
                "|                   Kegiatanku                    |\n" +
                "|            Catat Aktivitas Pentingmu!           |\n" +
                "|     Program By: M Krisnandi - 1197050077        |\n" +
                "__________________________________________________\n");
        System.out.print("1.Catat Aktifitas\n" +
                "2.Lihat Aktifitas\n" +
                "3.Hapus Aktifitas\n" +
                "4.Kembali ke menu utama\n" +
                "5.Keluar \n" +
                "pilih nomor: ");
    }

    void menuChooser(int choosenMenu){
        switch (choosenMenu){
            case 1:
                System.out.print("Masukan tanggal Aktiftias: ");
                tanggal = in.nextInt();
                System.out.println("Masukan Nama aktifitas: ");
                namaAktifitas = in.next();
                tambahAktifitas(tanggal,namaAktifitas);
                break;
            case 2:
                lihatAktifitas();
                break;
            case 3:
                System.out.println("Masukan Tanggal berapa Aktifitas akan dihapus: ");
                tanggal = in.nextInt();
                HapusAktifitas(tanggal);
                break;
            case 4:
                BackToMenu.mainmenu();
                break;
            case 5:
                return;
            default:
                BackToMenu.mainmenu();
                break;
        }
        BackToMenu.mainmenu();
    }

    void tambahAktifitas(int waktu, String namaAktifitas){
        mymap.put(waktu,namaAktifitas);
    }

    void lihatAktifitas(){
        if(mymap.isEmpty())
            System.out.println(" Tidak ada aktifitas");
        else{
        mymap.entrySet().forEach(entry->{
            System.out.println("Pada tanggal " + entry.getKey() + " Aktifitasnya\t" + entry.getValue());
        });}
    }

    void HapusAktifitas(int Tanggal){
        check = mymap.isEmpty();
        if(check)
        {
            System.out.println(" Maaf Aktifitas Kosong.");
        } else{
            if(mymap.containsKey(Tanggal))
            {
                mymap.remove(Tanggal);
                System.out.println("Aktifitas pada tanggal "+Tanggal+" berhasil dihapus");
            }
            else
            {
                System.out.println("Maaf pada tanggal "+Tanggal+" Tidak ada aktifitas");
            }
        }
    }
}
