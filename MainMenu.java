package TugasBesar;

import java.io.IOException;
import java.util.*;
public class MainMenu {
    //Header aplikasi aktivitasku
    Scanner in = new Scanner(System.in);
    public void mainmenu(){
        clearScreen();
        System.out.print
                ("__________________________________________________\n" +
                        "|                   AKTIVITASKU                   |\n" +
                        "|             Catat Aktivitas Harianmu            |\n" +
                        "|                Program by Kelompok 2            |\n" +
                        "|     Imam - Afrinaldi - Mujahid - M Krisnandi    |\n" +
                        "__________________________________________________\n");
        System.out.println("1. Catat Tugas ");
        System.out.println("2. Catat Keuangan ");
        System.out.println("3. Catat Aktivitas ");
        System.out.println("4. Catat Target");
        System.out.println("5. Keluar ");
        System.out.println("masukkan pilihanmu: ");
        int pilihan = in.nextInt();
        for(int i = 0; i < 80*300; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.print("\b"); // Prints a backspace

        switch (pilihan) {
            case 1:tugas();
                break;
            case 2: keuangan();
                break;
            case 3: aktivitas();
                break;
            case 4: target();
                break;
            case 5: keluar();
                break;
            default : System.out.println("Pilih menu yang tersedia");
                mainmenu();
        }
    }

    public static void clearScreen(){
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    int pilih;
    //Menu catat tugas apps aktivitasku
    void tugas() {
        TugasKu tugasku = new TugasKu();
        tugasku.menuProgram();
        pilih = in.nextInt();
        tugasku.menuChooser(pilih);
    }
    //Menu catat keuangan apps aktivitasku
    void keuangan(){
        //mengambil class keuangan untuk menampilkan menu keuangan
//        KeuanganKu get = new KeuanganKu();
//        get.menuChooser(10);
        linkedlist obj = new linkedlist();
        obj.menuProgram();
        pilih = in.nextInt();
        obj.menuChooser(pilih);
    }

    //Menu catat aktivitas apps aktivitasku
    void aktivitas(){
        AktifitasKu aktifitasKu = new AktifitasKu();
        aktifitasKu.menuProgram();
        pilih = in.nextInt();
        aktifitasKu.menuChooser(pilih);
    }

    //Menu Catat Target apps aktivitasku
    void target(){
        Target target = new Target();
        target.menuProgram();
        pilih = in.nextInt();
        target.menuChooser(pilih);
    }

    //Menu keluar apps aktivitasku
    void keluar() {
        System.out.println("Terimakasih Telah Mencatat Aktivitasmu\n" +
                "Jangan lupa untuk catat aktivitasmu terus!");
        System.exit(0);
    }

}
