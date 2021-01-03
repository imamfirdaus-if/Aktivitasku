package TugasBesar;


import java.io.IOException;
import java.util.*;
public class TugasKu {

    /**
     * Bismillah
     * @author Mujahid Ansori Majid
     * date - 31/12/2020
     */

      static ArrayList arrayList = new ArrayList();
      static Map<String,Integer> hashMap = new HashMap<String,Integer>();
    int count = 1;
    Scanner in = new Scanner(System.in);

    void menuProgram(){
        System.out.print
                ("__________________________________________________\n" +
                        "|                   AKTIVITASKU                  |\n" +
                        "|                   Tugasku                      |\n" +
                        "|               Catat Setiap Tugasmu!            |\n" +
                        "|     Program By: Mujahid Ansori - 1197050093    |\n" +
                        "__________________________________________________\n");

        System.out.println("1.\tLihat Tugas\n" +
                "2.\tTambah Tugas\n" +
                "3.\tSelesai Tugas\n" +
                "4.\tDeadline Tugas\n" +
                "5.\tCari Tugas\n" +
                "6.\tKembali ke Menu Utama\n" +
                "7.\tKeluar program\n");
    }

    void lihatTugas(){
        if(arrayList.isEmpty())
        {
            System.out.println("Selamat tidak ada tugas yang harus dikerjakan !");
        } else {
            Iterator iterator = arrayList.iterator();
            System.out.println("List Tugas");
            while(iterator.hasNext())
            {
                String element = (String) iterator.next();
                 System.out.println(count + ".\t"+element);
                 count++;
            }
        }
    }

    void tambahTugas(String s,int waktu){
        arrayList.add(s);
        hashMap.put(s,waktu);
    }

    void selesaiTugas(String namaTugas){
        boolean check = arrayList.contains(namaTugas);
        if(check){
            System.out.println("Selamat anda telah mengerjakan Tugas "+namaTugas);
            System.out.println(namaTugas + " Dihapus dalam list");
            arrayList.remove(namaTugas);
            hashMap.remove(namaTugas);
        } else {
            System.out.println(namaTugas + " Tidak tersedia dalam list");
        }
        count--;
    }

    void displayDeadLine(){
        hashMap.entrySet().forEach(entry->{
            System.out.println("Tugas " + entry.getKey() + "\t" + entry.getValue() + " Hari lagi");
        });
    }

    void searchTugas(String namaTugas){
        if (hashMap.containsKey(namaTugas)) {
            System.out.println("Ada tugas "+namaTugas+" Pada tanggal "+hashMap.get(namaTugas));
        } else {
            System.out.println("Tidak ada Tugas yang bernama " + namaTugas);
        }
    }

    void menuChooser(int choosenMenu){
        MainMenu BackToMenu = new MainMenu();
        String namaTugas;
        int deadLine;
        switch (choosenMenu){
            case 1:
                lihatTugas();
                BackToMenu.mainmenu();
                break;
            case 2:
                String s = "";
                System.out.println("Masukan nama Tugas: ");
                s += in.nextLine();
                System.out.println("Masukan bererapa hari lagi deadline tugas: ");
                int waktu = Integer.parseInt(in.nextLine());
                tambahTugas(s,waktu);
                BackToMenu.mainmenu();
                break;
            case 3:
                System.out.println("Masukan nama Tugas yang telah selesai");
                namaTugas = in.next();
                selesaiTugas(namaTugas);
                BackToMenu.mainmenu();
                break;
            case 4:
                displayDeadLine();
                BackToMenu.mainmenu();
                break;
            case 5:
                String namatugas;
                System.out.println("Masukan tugas yang dicari: ");
                namatugas = in.nextLine();
                searchTugas(namatugas);
            case 6:
                BackToMenu.mainmenu();
                break;
            case 7:
                return;
        }
    }
}
