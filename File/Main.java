/* Import :
 *
 *  1. Scanner : untuk baca input dari keyboard
 *  2. IOException : untuk handle error
 *
 * 3. DecimalFormat & DecimalFormatSymbols : untuk set format harga agar lebih keren :D
 */
import java.util.Scanner;
import java.io.IOException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main extends paket{
    // Definisikan input untuk menerima input :D
    public static Scanner input = new Scanner(System.in);
    
    public static DecimalFormat idr = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    public static DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    
    // Untuk membersihkan console (jika run menggunakan cmd / terminal)
    public static void clearConsole(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else{
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
    
    // Untuk memberikan efek pause (press enter to continue)
    public static void pauseProgram(int opt){ 
        if(opt == 1){
            System.out.print("\n");
        } else{
            System.out.print("[ENTER]");
        }
        
        input.nextLine();
    } 
    
    public static void tampilan(int option){
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        idr.setDecimalFormatSymbols(formatRp);
        
        switch(option){
            case 1:
                System.out.print("\n [ MENU UTAMA - Cheong-sun fast-food restaurant ]\n");
                System.out.print("\n 1. Pilih Paket");
                System.out.print("\n 2. Exit\n\n");
                break;
            case 2:
                System.out.print("\n [ PILIH PAKET - Cheong-sun fast-food restaurant ]\n");
                System.out.print("\n Makanan :                      Minuman :");
                System.out.print("\n - Hotdog        "+idr.format(hotdog.getHargaMenu())+"   - Drink    "+idr.format(drink.getHargaMenu()));
                System.out.print("\n - Hamburger     "+idr.format(hamburger.getHargaMenu())+"");
                System.out.print("\n - Fried Chicken "+idr.format(friedChicken.getHargaMenu())+"");
                System.out.print("\n - French Fried  "+idr.format(frenchFried.getHargaMenu())+"\n");
                System.out.print("\n 1. Paket A (Hotdog        + French Fries + Drink)");
                System.out.print("\n 2. Paket B (Hamburgers    + French Fries + Drink)");
                System.out.print("\n 3. Paket C (Fried Chicken + French Fries + Drink)\n");
                System.out.print("\n 4. Kembali ke Menu Utama\n\n");
                break;
        }
    }
    
    // Main program    
    public static void main(String[] args){
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        idr.setDecimalFormatSymbols(formatRp);
        
        int optMenu  = 0;
        int optPaket = 0;
        
        long startTime = 0;
        long endTime   = 0;
        long result    = 0;
        
        do{
            clearConsole();
            tampilan(1);
            
            System.out.print(" > Inputkan pilihan anda : (1-2) ");
            
            try{
                optMenu = input.nextInt();
                input.nextLine();
            } catch(Exception e){
                input.nextLine();
                continue;
            }
            
            switch(optMenu){
                case 1:
                    clearConsole();
                    tampilan(2);
                    
                    System.out.print(" > Inputkan pilihan anda : (1-4) ");
            
                    try{
                        optMenu = input.nextInt();
                        input.nextLine();
                    } catch(Exception e){
                        input.nextLine();
                        continue;
                    }
                    
                    System.out.print("\n");
                    
                    switch(optMenu){
                        case 1:
                            startTime = System.currentTimeMillis();
                            paketA();
                            endTime = System.currentTimeMillis();
                            result = endTime - startTime;
                            System.out.print("\n > Total Harga : "+idr.format(hargaTotalPaketA())+" | Waktu Pembuatan Pesanan "+(double)(result/1000)+" detik ");
                            pauseProgram(2);
                            break;
                        case 2:
                            startTime = System.currentTimeMillis();
                            paketB();
                            endTime = System.currentTimeMillis();
                            result = endTime - startTime;
                            System.out.print("\n > Total Harga : "+idr.format(hargaTotalPaketB())+" | Waktu Pembuatan Pesanan "+(double)(result/1000)+" detik ");
                            pauseProgram(2);
                            break;
                        case 3:
                            startTime= System.currentTimeMillis();
                            paketC();
                            endTime = System.currentTimeMillis();
                            result = endTime - startTime;
                            System.out.print("\n > Total Harga : "+idr.format(hargaTotalPaketC())+" | Waktu Pembuatan Pesanan "+(double)(result/1000)+" detik ");
                            pauseProgram(2);
                            break;
                        case 4:
                            continue;
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        } while(true);
    }
}
