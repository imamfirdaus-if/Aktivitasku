package TugasBesar;

import java.util.Hashtable;
import java.util.Scanner;

public class Target{
    static Hashtable <String, String> target = new Hashtable <String, String>();
    Scanner input = new Scanner (System.in);
    MainMenu BackToMenu = new MainMenu();

    String main= "";
    String sub= "";
    void menuProgram(){
        System.out.print("__________________________________________________\n" +
                "|                   AKTIVITASKU                   |\n" +
                "|                     Targetku                    |\n" +
                "|                  Catat targetmu!                |\n" +
                "|     Program By: Afrinaldi - 1197050007          |\n" +
                "__________________________________________________\n");
        System.out.print("1. Catat Target\n"+
                "2. Lihat catatan target\n"+
                "3. Cari catatan target\n"+
                "4. Edit catatan target\n"+
                "5. Hapus catatan target\n"+
                "6. Keluar\n"+
                "Pilih nomor : ");
    }

    void menuChooser(int choosenMenu){
        switch (choosenMenu) {
            case 1:
                while(true){
                    System.out.print("*Jika sudah selesai input target, tulis break di inputan selanjutnya\n" +
                            "Masukan tanggal target : ");
                    main = input.nextLine();
                    if(main.equals("break")){
                        break;
                    }
                    System.out.print("masukan target yang akan dicapai : ");
                    sub = String.valueOf(input.nextLine());
                    tambahTarget(main, sub);
                }
                break;

            case 2:
                lihatTarget();
                break;

            case 3:
                System.out.print("Masukan tanggal target : ");
                main = input.nextLine();
                cariTarget(main);
                break;

            case 4:
                System.out.print("Masukan tanggal target : ");
                main = input.nextLine();
                editTarget(main);
                break;

            case 5:
                System.out.print("masukan tanggal target yang akan dihapus : ");
                main = input.nextLine();
                hapusTarget(main);
                break;

            case 6:
                return ;

            default:
                BackToMenu.mainmenu();
                break;

        }
        BackToMenu.mainmenu();
    }

    void tambahTarget(String tanggal, String namaTarget){
        target.put(tanggal, namaTarget);
    }

    void lihatTarget(){
        if(target.isEmpty()){
            System.out.println("Belum ada target");
        }
        else{
            System.out.println("list target :");
            for(String tampil : target.keySet()){
                System.out.println(tampil + "\n      " + target.get(tampil) + "\n");
            }
        }
    }

    void cariTarget(String tanggal){
        if(target.isEmpty()){
            System.out.println("Tidak ada target yang dapat di cari");
        }
        else{
            if(target.containsKey(tanggal)){
                System.out.println("Target pada tanggal tersebut adalah "+ target.get(tanggal));
            }
            else{
                System.out.println("Tanggal salah");
            }
        }
    }

    void editTarget(String tanggal){
        if(target.isEmpty()){
            System.out.println("Tidak ada target yang dapat di edit");
        }
        else{
            if(target.containsKey(tanggal)){
                System.out.println("masukan target baru : ");
                String edit = input.nextLine();
                target.replace(tanggal, edit);
            }
            else{
                System.out.println("Tanggal tersebut tidak ada dalam target");
            }
        }
    }

    void hapusTarget(String tanggal){
        if(target.isEmpty()){
            System.out.println("Tidak ada target yang dapat di hapus");
        }
        else{
            if(target.containsKey(tanggal)){
                target.remove(tanggal);
                System.out.println("Target telah di hapus");
            }
            else{
                System.out.println("Tanggal tersebut tidak ada dalam target");
            }
        }
    }
}
