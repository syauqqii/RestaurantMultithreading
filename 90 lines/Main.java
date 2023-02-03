import java.util.Scanner;

abstract class menu{
    public String namaMenu;
    public int waktuPembuatan;
    abstract String getNamaMenu();
}

class list extends menu{
    public list(String namaMenu, int waktuPembuatan){
        this.namaMenu       = namaMenu;
        this.waktuPembuatan = waktuPembuatan;
    }
    @Override
    String getNamaMenu(){ return namaMenu; }
    public void process(){
        try{
            System.out.println(" # Memulai : "+namaMenu);
            Thread.sleep(waktuPembuatan);
            System.out.println(" $ "+namaMenu+" telah selesai!");
        } catch(InterruptedException e){}
    }
    int getWaktu(){ return waktuPembuatan; };
}

class paket{
    public static void paketA(){
        Thread makingHotdog      = new Thread(new list("Hotdog", 15000)::process);
        Thread makingFrenchFries = new Thread(new list("French fries", 20000)::process);
        Thread makingDrink       = new Thread(new list("Drink", 10000)::process);
        makingHotdog.start(); makingFrenchFries.start(); makingDrink.start();
        try{
            makingHotdog.join(); makingFrenchFries.join(); makingDrink.join();
        } catch(InterruptedException e){}
    }

    public static void paketB(){
        Thread makingHamburger   = new Thread(new list("Hamburger", 20000)::process);
        Thread makingFrenchFries = new Thread(new list("French fries", 20000)::process);
        Thread makingDrink       = new Thread(new list("Drink", 10000)::process);
        makingHamburger.start(); makingFrenchFries.start(); makingDrink.start();
        try{
            makingHamburger.join(); makingFrenchFries.join(); makingDrink.join();
        } catch(InterruptedException e){}
    }

    public static void paketC(){
        Thread cookingFriedChicken = new Thread(new list("Fried chicken", 30000)::process);
        Thread makingFrenchFries   = new Thread(new list("French fries", 20000)::process);
        Thread makingDrink         = new Thread(new list("Drink", 10000)::process);
        cookingFriedChicken.start(); makingFrenchFries.start(); makingDrink.start();
        try{
            cookingFriedChicken.join(); makingFrenchFries.join(); makingDrink.join();
        } catch(InterruptedException e){}
    }
}

public class Main extends paket{
    public static void main(String[] args){
        int inputOptions; Scanner input  = new Scanner(System.in);
        while(true){
            System.out.print("\n ** PILIH PAKET **\n");
            System.out.print("\n 1. Paket A :    Hotdog     + French Fries + Drink");
            System.out.print("\n 2. Paket B :  Hamburgers   + French Fries + Drink");
            System.out.print("\n 3. Paket C : Fried Chicken + French Fries + Drink\n");
            System.out.print("\n 4. Exit Program\n\n > Inputkan pilihan anda : (1-4) ");
            try{
                inputOptions = input.nextInt();
                input.nextLine();
            } catch(Exception e){ input.nextLine(); continue; }
            System.out.print("\n");
            long startTime = System.currentTimeMillis();
            switch(inputOptions){
                case 1:
                    paketA();
                    System.out.print("\n > Waktu Pembuatan Pesanan "+(double)((System.currentTimeMillis() - startTime)/1000)+" detik\n");
                    break;
                case 2:
                    paketB();
                    System.out.print("\n > Waktu Pembuatan Pesanan "+(double)((System.currentTimeMillis() - startTime)/1000)+" detik\n");
                    break;
                case 3:
                    paketC();
                    System.out.print("\n > Waktu Pembuatan Pesanan "+(double)((System.currentTimeMillis() - startTime)/1000)+" detik\n");
                    break;
                case 4: System.exit(0);
            }
        }
    }
}
