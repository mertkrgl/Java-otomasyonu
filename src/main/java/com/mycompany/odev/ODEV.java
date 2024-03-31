
package com.mycompany.odev;

import java.util.Scanner;

public class ODEV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen öğrenci sayısını giriniz");
        int sizestudents = scanner.nextInt();
        
        int [] ids = new int [sizestudents];
        String [] names = new String [sizestudents];
        double [] midtermgrade = new double [sizestudents];
        double [] finalgrade = new double [sizestudents];
        getstudentsinfo(sizestudents, ids, names, midtermgrade, finalgrade, scanner);
        while (true) {            
        menu();
        int choice = scanner.nextInt();
        
            switch (choice) {
                case 1:
                    printsutendtsinfo(sizestudents, ids, names, midtermgrade, finalgrade);
                    break;
                case 2:
                    endoftermgrade(sizestudents,  midtermgrade, finalgrade);
                    break;
                case 3:
                    under60finalgrade(sizestudents, names,  finalgrade);
                    break;
                case 4:
                    aboveclassaverage(sizestudents, names, midtermgrade, finalgrade);
                    break;
                case 5:
                     minmidtermgrade(sizestudents,  names, midtermgrade);
                     break;
                case 6:
                    maxfinalgrade(sizestudents, names, finalgrade);
                    break;
                case 0:
                    System.out.println("Programdan çıkılıyor");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz bir işlem yaptınız tekrar deneyiniz");
            }
        
        }
        
    }
    
    
    public static void menu () {
        System.out.println("Yapmak istediğiniz işlemi seçiniz");
        System.out.println("0. Programdan çık");
        System.out.println("1. Öğrenci bilgilerini listele");
        System.out.println("2. Dönem sonu notunu hesapla");
        System.out.println("3. Final sınav puanı 60'ın altında olan öğrencileri listele");
        System.out.println("4. Dönem sonu notu sınıf ortalamasının üzerinde olan öğrencileri listele");
        System.out.println("5. Minimum vize notunu bul");
        System.out.println("6. Maksimum final notunu bul");
        
    }
    
    public static void getstudentsinfo (int sizestudents, int [] ids, String [] names, double [] midtermgrade, double [] finalgrade, Scanner scanner) {
        for (int i = 0; i < sizestudents; i++) {
            System.out.println((i+1)+". Öğrencinin bilgilerini giriniz");
            
            System.out.print("Öğrencinin kimlik numarasını giriniz :");
            ids [i] = scanner.nextInt();
            
            
            System.out.print("Öğrencinin adını giriniz :");
            names [i] = scanner.next();
            
            
            System.out.print("Öğrencinin ara sınav notunu giriniz :");
            midtermgrade [i] = scanner.nextDouble();
            
            
            System.out.print("Öğrencinin final notunu giriniz :");
            finalgrade [i] = scanner.nextDouble();
            
            System.out.println("-----------------------------------------");

        }
        
    }
    
 
    public static void printsutendtsinfo (int sizestudents, int [] ids, String [] names, double [] midtermgrade, double [] finalgrade) {
        for (int i = 0; i < sizestudents; i++) {
            System.out.println((i+1) + ". Öğrencinin bilgileri aşağıdaki gibidir");
            System.out.println("Öğrencinin kimlik numarası: "+ids[i]);
            System.out.println("Öğrencinin ismi: "+names[i]);
            System.out.println("Öğrencinin ara sınav puanı: "+midtermgrade[i]);
            System.out.println("Öğrencinin final puanı: "+finalgrade[i]);
            System.out.println("-----------------------------------------");
            System.out.println("");
        }
    }
    
    
    public static void endoftermgrade (int sizestudents, double [] midtermgrade, double [] finalgrade) {
        for (int i = 0; i < sizestudents; i++) {
            
            double endoftermgrade = midtermgrade[i]*0.4 + finalgrade[i]*0.6;
            System.out.println((i+1)+". Öğrencinin dönem sonu puanı: " + endoftermgrade);
            
        }
    }
    
    
    public static void under60finalgrade (int sizestudents, String [] names,  double [] finalgrade) {
        for (int i = 0; i < sizestudents; i++) {
            if (finalgrade[i]<60) {
                System.out.println(names[i] +" -----> "+ finalgrade[i]);
                
            }
        }
        
        
    }
    
    
    public static void aboveclassaverage (int sizestudents,  String [] names, double [] midtermgrade, double [] finalgrade) {
        int average = 0;
        for (int i = 0; i < sizestudents; i++) {
            double endoftermgrade = midtermgrade[i]*0.4 + finalgrade[i]*0.6;
            average+=endoftermgrade;
        }
        
        System.out.println("Sınıf ortalaması: "+ average/sizestudents);
        
        for (int i = 0; i < sizestudents; i++) {
            if ( (average/sizestudents) < midtermgrade[i]*0.4 + finalgrade[i]*0.6) {
                System.out.println(names[i] +" "+ (midtermgrade[i]*0.4 + finalgrade[i]*0.6));
            }
        }
           
    }
    
    
    public static void minmidtermgrade (int sizestudents, String [] names, double [] midtermgrade) {
        int min = 0;
        
        for (int i = 0; i < sizestudents; i++) {
            for (int j = i; j < sizestudents; j++) {
                if (midtermgrade[j] < midtermgrade[i] ) {
                    min = j;
                }        
            }
        }
     
        System.out.println(names[min] + " " + midtermgrade[min]);
        
    }
    
    
    public static void maxfinalgrade (int sizestudents, String [] names,  double [] finalgrade) {
        int max = 0;
        
        for (int i = 0; i < sizestudents; i++) {
            for (int j = i; j < sizestudents; j++) {
                if (finalgrade[i] < finalgrade[j] ) {
                    max = j;
                }        
            }
        }
     
        System.out.println(names[max]+ " " + finalgrade[max]);
        
    }
   
}

