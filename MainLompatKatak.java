import java.util.Scanner;
import java.util.Random;

/**
 * Class MainLompatKatak yang berisi Permainan <b>Lompat si Katak Lompat, Lompat!</b>
 * 
 * @author Siti Mawaddah
 * @version 20 November 2020
 */
public class MainLompatKatak
{
    private static boolean play;
    
    /**
     * Constructor untuk objek dari class MainLompatKatak
     */
    public MainLompatKatak()
    {
        play = true;
    }
    
    /**
     * Method untuk mengatur posisi katak secara acak,
     * meminta pemain menebak posisi katak,
     * dan menentukan apakah tebakannya benar atau salah
     * 
     * @param danau      danau tempat katak melompat
     * @param kesempatan sisa kesempatan yang dimiliki pemain untuk menebak
     * @return           poin pemain (10 jika tebakan benar, 0 jika tebakan salah)
     */
    public static int tebakKatak(Danau danau, int kesempatan)
    {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int poin, katak, baris, lajur, barisTebakan, lajurTebakan;

        // menentukan posisi untuk katak dalam baris dan lajur secara acak
        baris = rd.nextInt(danau.getJumlahBatu());
        lajur = rd.nextInt(danau.getJumlahBatu());
        danau.tambahKatak(baris, lajur);
        katak = (baris * danau.getJumlahBatu()) + (lajur + 1);
        System.out.println("\n  ^o^ katak melompat di batu danau ^o^");

        // meminta pemain menginput sebuah bilangan untuk menebak posisi katak
        System.out.println("Bisakah kamu menebak dimana posisi katak?");
        System.out.println("\nSisa kesempatan: " + kesempatan + " kali");
        int tebak;
        while(true) {
            System.out.print("\nTebakan kamu? ");
            tebak = sc.nextInt();
            if(tebak >= 1 && tebak <= Math.pow(danau.getJumlahBatu(), 2)) {
                break;
            }
            System.out.println("Pilih batu antara 1 - " + (danau.getJumlahBatu() * danau.getJumlahBatu()));
        }

        // convert bilangan tebakan pemain ke dalam bentuk baris dan lajur
        barisTebakan = (tebak - 1) / danau.getJumlahBatu();
        lajurTebakan = (tebak - 1) - (barisTebakan * danau.getJumlahBatu());
        
        // memeriksa tebakan 
        if(danau.adaKatak(barisTebakan, lajurTebakan)) {
            poin = 10;
            System.out.println("Benar! Kamu mendapat 10 poin ^o^");
        }
        else {
            poin = 0;
            System.out.println("Tebakanmu salah :(");
        }
        
        // menampilkan posisi katak yang sebenarnya
        tampilkanKatak(danau.getBatu(), katak);
        danau.hapusKatak(baris, lajur);

        return poin;
    }
   
    /**
     * Method untuk menampilkan posisi katak
     * 
     * @param batu  batu di danau
     * @param katak posisi katak
     */
    public static void tampilkanKatak(int[][] batu, int katak)
    {
        System.out.println("\nKatak berada di batu " + katak);

        int counter = 0;
        for(int[] b : batu) {
            for(int bt : b) {
                counter++;
                if(bt == 1) {
                    System.out.print("[ ^o^ ]");
                }
                else {
                    System.out.printf("[ %-3d ]", counter);
                }
            }
            System.out.println();
        }

        System.out.println("Keterangan:\n[ ] = batu\n^o^ = katak");
    }

    /**
     * Method untuk menampilkan komentar sesuai nilai pemain
     * 
     * @param nilai nilai pemain
     */
    public static void komentar(int nilai)
    {
        Random rd = new Random();

        String[] excellent = {"SEMPURNA", "LUAR BIASA", "PRO PLAYER"};
        String[] good = {"BAGUS", "MANTAP", "HEBAT"};
        String[] bad = {"BURUK", "NOOB", "GAGAL"};
        String komentar;

        if(nilai > 100) {
            komentar = excellent[rd.nextInt(3)];
        }
        else if(nilai >= 50) {
            komentar = good[rd.nextInt(3)];
        }
        else {
            komentar = bad[rd.nextInt(3)];
        }

        System.out.println("\nTotal nilai: " + nilai + " poin");
        System.out.println(">>>>>>>>>>>>>> " + komentar + " <<<<<<<<<<<<<<");
    }
    
    /**
     * Method yang berisi inti dari permainan
     */
    public static void mainkan()
    {
        Scanner sc = new Scanner(System.in);
        int pilihanDanau;
        Danau danau;
        Pemain pemain;
        
        // Input nama pemain
        System.out.print("\nMasukkan nama kamu: ");
        pemain = new Pemain(sc.next());
        System.out.println("\nSelamat Datang, " + pemain.getNama().toUpperCase() + " !!");
       
        // input danau pilihan pemain
        System.out.println("\nSilakan pilih danau berikut:\n"+
                                "1. Danau Lut Tawar\n"+
                                "2. Danau Ranu Kumbolo\n"+
                                "3. Danau Toba");
        System.out.print("Danau pilihanmu?(1/2/3) ");
        pilihanDanau = sc.nextInt();

        // menciptakan objek danau sesuai pilihan pemain
        switch (pilihanDanau) {
            case 1:
            danau = new Danau(5);
            break;

            case 2:
            danau = new Danau(10);
            break;

            case 3:
            danau = new Danau(15);
            break;

            default:
            danau = new Danau();
        }
        
        // menampilkan batu dari danau
        danau.tampilkanBatu();

        // menebak posisi katak sebanyak 20 kali
        int poin;
        for(int kesempatan = 20; kesempatan > 0; --kesempatan) {
            poin = tebakKatak(danau, kesempatan);
            pemain.setNilai(pemain.getNilai() + poin);
        }
        
        // memberi komentar sesuai nilai yang diperoleh
        komentar(pemain.getNilai());
    }
    
    /**
     * Method utama dalam program
     * 
     * @param a command line argument
     */
    public static void main(String[] a)
    {
        Scanner sc = new Scanner(System.in);
        String lanjut;
        
        System.out.println("\n\n            =^o^= LOMPAT SI KATAK LOMPAT, LOMPAT!! =^o^=");
        System.out.println("\nAlkisah, terdapat seekor katak yang senang melompat-lompat di antara\nbatu-batu danau. Setelah ditelusuri ternyata katak ini adalah milik\nsalah satu penduduk setempat. Pemiliknya sangat ingin mengambil katak\nnya kembali, karena itu kamu diminta tolong untuk menangkap kataknya.\nNamun katak ini sangat gesit, kamu harus bisa menebak dengan benar\ndimana posisi katak sebelum menangkapnya. Ingat, kamu hanya memiliki\n20 kesempatan untuk menebak.\nSEMOGA BERUNTUNG ^o^");
        
        play = true;
        while(play) {
            mainkan();
            
            System.out.print("\nMain lagi?(y/n) ");
            lanjut = sc.next();
            if(!lanjut.equals("y")) {
                play = false;
            }
        }
        
        System.out.println("\n                       -------- GAME SELESAI --------");
        System.out.println("                  =^o^=  Terimakasih Telah Bermain!  =^o^=");
        
    }
}
