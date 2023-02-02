/* Dalam file ini kita membuat class makanan,
 *  dengan menerapkan sebuah konsep inheritance,
 *  dan juga menerapkan konsep polymorphism tentunya,
 *  serta mendefinisikan isi dari sebuah function :
 *
 *  1. getNamaMenu() -> untuk return dari variable namaMenu
 *  2. getHargaMenu() -> untuk return dari variable hargaMenu
 *  3. getWaktuPembuatan() -> -> untuk return dari variable waktuPembuatan
 */
public class makanan<N, H, W> extends menu{
    public makanan(N namaMenu, H hargaMenu, W waktuPembuatan){
        this.namaMenu       = namaMenu;
        this.hargaMenu      = hargaMenu;
        this.waktuPembuatan = waktuPembuatan;
    }
    
    @Override
    N getNamaMenu(){
        return (N)namaMenu;
    }
    
    @Override
    H getHargaMenu(){
        return (H)hargaMenu;
    }
    
    @Override
    W getWaktuPembuatan(){
        return (W)waktuPembuatan;
    }
    
    /* Di dalam function ini kita membuat sebuah thread
     *  untuk melakukan multi threading
     */
    public void proesePembuatan(){
        try{
            System.out.println(" $ Memulai prose pembuatan : "+namaMenu);
            Thread.sleep((int)waktuPembuatan);
            System.out.println(" > Proses pembuatan \""+namaMenu+"\" telah selesai!");
        } catch(InterruptedException e){
            /* try catch berfungsi untuk menangkap error,
             *  di dalam case ini catch akan menangkap jenis error :
             *  'InterruptedException' fungsinya agar tidak terjadi
             *  crash saat running threading (multi processing) ini.
             *
             *  nah, jika kalian ingin menghandle sebuah error jenis ini,
             *  dengan cara misalnya anda ingin kalau error program akan exit,
             *  maka kalian bisa mengeksekusi dengan menambahkan code :
             *  System.exite(0);
             *
             *  akan tetapi di case saya, saya membiarkannya saja hehehe jadi
             *  saya kosongi tidak saya berikan sebuah code.
             */
        }
    }
}
