/* Dalam file ini kita membuat sebuah kelas menu,
 *  dengan menerapkan sebuah konsep abstrak,
 *  dan polymorphism, serta menerapkan :
 *
 *  1. generic variable
 *  2. generic function
 */
abstract class menu<N, H, W>{
    public N namaMenu;
    public H hargaMenu;
    public W waktuPembuatan;
    
    abstract <N> N getNamaMenu();
    abstract <H> H getHargaMenu();
    abstract <W> W getWaktuPembuatan();
}
