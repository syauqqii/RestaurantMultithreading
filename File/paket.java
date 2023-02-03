public class paket{
    /* **NOTE :
     *
     * Waktu dalam program ini dalam satuan milisecond,
     *  jadi kalau 10 detik x 1000 = input harus 10.000
     *  ***(ingat, tanpa . kalau input)
     */
    
    // Tambahkan makanan : Hotdog, harga 20.000, waktu pembuatan (misal) 20 detik
    public static makanan hotdog       = new makanan("Hotdog", 20000, 20000);
    // Tambahkan makanan : Hamburger, harga 25.000, waktu pembuatan (misal) 30 detik
    public static makanan hamburger    = new makanan("Hamburger", 25000, 30000);
    // Tambahkan makanan : Fried chicken, harga 18.000, waktu pembuatan (misal) 35 detik
    public static makanan friedChicken = new makanan("Fried chicken", 18000, 35000);
    // Tambahkan makanan : French fries, harga 12.000, waktu pembuatan (misal) 25 detik
    public static makanan frenchFried  = new makanan("French fries", 18000, 25000);
    
    // Tambahkan minuman : drink, harga 7.000, waktu pembuatan (misal) 10 detik
    public static minuman drink        = new minuman("drink", 7000, 10000);
    
    public static void paketA(){
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'hotdog' dari class makanan
        Thread makingHotdog      = new Thread(hotdog::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'French fries' dari class makanan
        Thread makingFrenchFries = new Thread(frenchFried::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'drink' dari class minuman
        Thread makingDrink       = new Thread(drink::proesePembuatan);
        
        // Jalankan thread secara multi processing
        makingHotdog.start();
        makingFrenchFries.start();
        makingDrink.start();
        
        try{
            makingHotdog.join();
            makingFrenchFries.join();
            makingDrink.join();
        } catch(InterruptedException e){
            
        }
    }
    
    public static void paketB(){
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'hamburger' dari class makanan
        Thread makingHamburger   = new Thread(hamburger::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'French fries' dari class makanan
        Thread makingFrenchFries = new Thread(frenchFried::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'drink' dari class minuman
        Thread makingDrink       = new Thread(drink::proesePembuatan);
        
        // Jalankan thread secara multi processing
        makingHamburger.start();
        makingFrenchFries.start();
        makingDrink.start();
        
        try{
            makingHamburger.join();
            makingFrenchFries.join();
            makingDrink.join();
        } catch(InterruptedException e){
            
        }
    }
    
    public static void paketC(){
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'Fried chicken' dari class makanan
        Thread cookingFriedChicken = new Thread(friedChicken::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'French fries' dari class makanan
        Thread makingFrenchFries   = new Thread(frenchFried::proesePembuatan);
        // Jalankan function->proesePembuatan() untuk permisalan pembuatan 'drink' dari class minuman
        Thread makingDrink         = new Thread(drink::proesePembuatan);
        
        // Jalankan thread secara multi processing
        cookingFriedChicken.start();
        makingFrenchFries.start();
        makingDrink.start();
        
        try{
            cookingFriedChicken.join();
            makingFrenchFries.join();
            makingDrink.join();
        } catch(InterruptedException e){
            
        }
    }
    
    public static int hargaTotalPaketA(){
        return ((int)hotdog.getHargaMenu() + (int)frenchFried.getHargaMenu() + (int)drink.getHargaMenu());
    }
    
    public static int hargaTotalPaketB(){
        return ((int)hamburger.getHargaMenu() + (int)frenchFried.getHargaMenu() + (int)drink.getHargaMenu());
    }
    
    public static int hargaTotalPaketC(){
        return ((int)friedChicken.getHargaMenu() + (int)frenchFried.getHargaMenu() + (int)drink.getHargaMenu());
    }
}
