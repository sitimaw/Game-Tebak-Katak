
/**
 * Class Danau untuk membuat objek danau sebagai tempat katak 
 * melompat pada permainan <b>Lompat si Katak Lompat, Lompat!</b>
 *
 * @author Siti Mawaddah
 * @version 20 November 2020
 */
public class Danau
{
    private int jumlahBatu;
    private int[][] batu;

    /**
     * Constructor tanpa parameter dengan nilai default jumlahBatu = 5
     */
    public Danau()
    {
        jumlahBatu = 5;
        System.out.println("\nDanau tidak tersedia :(\nKamu akan dialihkan ke Danau Lut Tawar...");
        deskripsiDanau();
        buatBatu();
    }
    
    /**
     * Contructor dengan parameter
     * 
     * @param jumBatu jumlah batu dalam satu baris atau satu lajur
     */
    public Danau(int jumBatu)
    {
        jumlahBatu = jumBatu;
        deskripsiDanau();
        buatBatu();
    }

    /**
     * Method untuk mendapatkan jumlah batu
     * 
     * @return jumlahBatu
     */
    public int getJumlahBatu()
    {
        return jumlahBatu;
    }
    
    /**
     * Method untuk mendapatkan batu dalam bentuk array 2 dimensi
     * 
     * @return batu
     */
    public int[][] getBatu()
    {
        return batu;
    }
    
    /**
     * Method untuk menampilkan deskripsi dari danau
     */
    private void deskripsiDanau()
    {
        if(jumlahBatu == 5) {
            System.out.println("\n            ^o^ SELAMAT DATANG DI DANAU LUT TAWAR ^o^");
            System.out.println("\nDanau Lut Tawar adalah sebuah danau dan kawasan wisata yang terletak\ndi Dataran Tinggi Gayo. Di sisi barat danau ini terdapat sebuah kota\nkabupaten yaitu kota Takengon, yang juga merupakan ibu kota Kabupaten\nAceh Tengah. Suku Gayo menyebut danau ini dengan sebutan Danau Lut \nTawar karena terlihat seperti laut. Di tempat ini terdapat berbagai\nspesies flora dan fauna yang hidup di dalam dan di sekitar danau.");
        }
        else if(jumlahBatu == 10) {
            System.out.println("\n            ^o^ SELAMAT DATANG DI DANAU RANU KUMBOLO ^o^");
            System.out.println("\nRanu Kumbolo adalah sebuah danau yang terletak di kaki Gunung Semeru.\nRanu Kumbolo berada di kawasan Taman Nasional Bromo Tengger Semeru, di\nantara Kabupaten Lumajang dan Kabupaten Malang, provinsi Jawa Timur.\nDanau ini sering disebut-sebut sebagai surga yang tersembunyi, karena\nuntuk mencapai danau terindah di Indonesia ini kamu harus melakukan\ntrekking yang cukup berat terutama bagi para pendaki pemula.");
        }
        else if(jumlahBatu == 15) {
            System.out.println("\n            ^o^ SELAMAT DATANG DI DANAU TOBA ^o^");
            System.out.println("\nSiapa yang tak kenal Danau Toba? Danau terbesar di Indonesia yang \nmempunyai panjang 100 km dan lebar 30 km ini merupakan salah satu\ntempat wisata favorit Sumatera Utara. Danau Toba terbentuk karena\nletusan gunung berapi yang sangat besar. Letusan ini menghasilkan\nkaldera yang kemudian terisi air. Berbeda dengan danau pada umum-\nnya, di tengah-tengah danau yang mempunyai kedalaman 450 meter ini\nterdapat sebuah pulau yang bernama Pulau Samosir.");
        }
    }
    
    /**
     * Method untuk membuat array batu sesuai dengan jumlah batu
     */
    private void buatBatu()
    {
        batu = new int[jumlahBatu][jumlahBatu];
    }
   
    /**
     * Method untuk menampilkan batu dengan nomor urut dimulai dari 1
     */
    public void tampilkanBatu()
    {
        int counter = 0;
        System.out.println("\nAda " + jumlahBatu*jumlahBatu + " batu di danau ini ");
        for(int[] b : batu) {
            for(int bt : b) {
                counter++;
                System.out.printf("[ %-3d ]", counter);
            }
            System.out.println();
        }
        System.out.println("Keterangan:\n[ ] = batu");
    }
    
    /**
     * Method untuk menambah katak ke dalam array batu
     * 
     * @param baris indeks baris dari array batu
     * @param lajur indeks kolom dari array batu
     */
    public void tambahKatak(int baris, int lajur)
    {
        batu[baris][lajur] = 1;
    }
    
    /**
     * Method untuk memeriksa apakah terdapat katak pada baris dan kolom yang diminta
     * 
     * @param baris indeks baris dari array batu
     * @param lajur indeks kolom dari array batu
     * @return      true jika terdapat katak, false jika tidak ada katak
     */
    public boolean adaKatak(int baris, int lajur)
    {
        return (batu[baris][lajur] == 1);
    }
    
    /**
     * Method untuk menghapus katak dari dalam array batu
     * 
     * @param baris indeks baris dari array batu
     * @param lajur indeks kolom dari array batu
     */
    public void hapusKatak(int baris, int lajur)
    {
        batu[baris][lajur] = 0;
    }
}
