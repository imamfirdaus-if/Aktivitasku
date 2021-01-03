package TugasBesar;

import java.util.LinkedList;
import java.util.Scanner;

/*Menu keuanganku By Imam Firdaus - 1197050051
Build with stack function in java programing language*/

//Fungsi untuk menambahkan data pengeluaran
public class keuangan {
    static linkedlist ll = new linkedlist();
    int tanggal,tahun,uang, saldo=0;
    String bulan, keterangan;
    keuangan next;
    public static Scanner in=new Scanner(System.in);
    public static Scanner str=new Scanner(System.in);
    public void input(){
        linkedlist ll=new linkedlist();
        ll.header();
        System.out.print("Tanggal               : ");
        tanggal=in.nextInt();
        System.out.print("Bulan (ex:Februari)   : ");
        bulan=str.nextLine();
        System.out.print("Tahun                 : ");
        tahun=in.nextInt();
        System.out.print("Nominal uang          : ");
        uang=in.nextInt();
        System.out.print("Keterangan            :");
        keterangan=str.nextLine();
        next=null;
    }

    //Fungsi untuk melihat data pengeluaran
    public void view(){
        linkedlist ll=new linkedlist();
        System.out.println("| "+tanggal+" "+bulan +" "+tahun+"  | "+uang+"  | "+keterangan+"    |");
    }

    //Fungsi untuk menampilkan menu
    void menuProgram() {
            ll.header();
            System.out.print("1.Catat Pengeluaran\n" +
                    "2.Lihat Pengeluaran\n" +
                    "3.Batal Menambahkan Data\n" +
                    "4.Kembali ke menu utama\n" +
                    "5.Keluar \n" +
                    "Mau ngapain nih? pilih nomornya: ");
    }
    void menuChooser(int menuChoosen) {
        MainMenu BackToMenu = new MainMenu();
        switch (menuChoosen){
            case 1:
                ll.add();
                break;
            case 2:
                ll.view();
                break;
            case 3:
                ll.removeLast();
                break;
            default:
                BackToMenu.mainmenu();
                break;
        }
        BackToMenu.mainmenu();
    }
}

class linkedlist extends keuangan{
    keuangan head,tail;

    //Link linked list
    public linkedlist(){
        head=null;
        tail=null;
    }

    //Link Header
    public void header(){
        System.out.print("__________________________________________________\n" +
                "|                   AKTIVITASKU                   |\n" +
                "|                   KEUANGANKU                    |\n" +
                "|            Catat Pengeluaran Uangmu!            |\n" +
                "|     Program By: Imam Firdaus - 1197050051       |\n" +
                "__________________________________________________\n");
    }

    //Link untuk menambahkan data pengeluaran
    public void add(){
        keuangan baru=new keuangan();
        baru.input();
        if(head==null) head=baru;
        else tail.next=baru;
        tail=baru;
    }

    //Link untuk melihat data pengeluaran
    public void view(){
        if(head==null){
            System.out.println("Tidak ada pengeluaran");
            return;
        }
        System.out.println("|     Tanggal    | Nominal  | Keterangan    |");
        keuangan ptr=head;
        while(ptr!=null){
            ptr.view();
            ptr=ptr.next;
        }
    }

    //Link untuk memabatalkan menambahkan data
    public void removeLast(){
        if(head==null){
            System.out.println("Kosong");
            return;
        }
        System.out.println("Data pengeluaran sebesar Rp."+tail.uang+" Berhasil Dihapus");
        if(head==tail){
            head=null;
            tail=null;
        }else{
            keuangan ptr=head.next;
            keuangan prev=head;
            while(ptr!=tail){
                ptr=ptr.next;
                prev=prev.next;
            }
            prev.next=null;
            tail=prev;
        }
    }
}
