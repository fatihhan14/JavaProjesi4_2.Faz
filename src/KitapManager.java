import java.util.EnumSet;
import java.util.Map;
import java.util.Scanner;

public class KitapManager extends Veritabani {
    static Scanner Consol = new Scanner(System.in);

    public static void adminKitapMenu() throws InterruptedException {
        while (true) {
            System.out.println("\n=== KİTAP İŞLEMLERİ ===");
            System.out.println("1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("4- Kitap Ekle");
            System.out.println("5- Kitap Sil");
            System.out.println("6- Kitap Ödünç Al");
            System.out.println("7- Kitap İade Et");
            System.out.println("A- Bir Önceki Menü");
            System.out.print("Seçiminiz: ");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()) {
                case "1":
                    kitapListesiYazdir();
                    break;
                case "2":
                    yazardanKitapBulma();
                    break;
                case "3":
                    turVeyaYayinTarihiIleKitapBulma();
                    break;
                case "4":
                    kitapEkle();
                    break;
                case "5":
                    isimIleKitapSilme();
                    break;
                case "6":
                    kitapOduncAl();
                    break;
                case "7":
                    kitapIadeEt();
                    break;
                case "A":
                    Helper.showAdminMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");
            }
        }
    }

    public static void userKitapMenu() throws InterruptedException {
        while (true) {
            System.out.println("\n=== KİTAP İŞLEMLERİ ===");
            System.out.println("1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("4- Kitap Ödünç Al");
            System.out.println("5- Kitap İade Et");
            System.out.println("A- Bir Önceki Menü");
            System.out.print("Seçiminiz: ");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()) {
                case "1":
                    kitapListesiYazdir();
                    break;
                case "2":
                    yazardanKitapBulma();
                    break;
                case "3":
                    turVeyaYayinTarihiIleKitapBulma();
                    break;
                case "4":
                    kitapOduncAl();
                    break;
                case "5":
                    kitapIadeEt();
                    break;
                case "A":
                    Helper.showUserMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");
            }
        }
    }

    public static void guestKitapMenu() throws InterruptedException {
        while (true) {
            System.out.println("\n=== KİTAP İŞLEMLERİ ===");
            System.out.println("1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("A- Bir Önceki Menü");
            System.out.print("Seçiminiz: ");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()) {
                case "1":
                    kitapListesiYazdir();
                    break;
                case "2":
                    yazardanKitapBulma();
                    break;
                case "3":
                    turVeyaYayinTarihiIleKitapBulma();
                    break;
                case "A":
                    Helper.showGuestMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");
            }
        }
    }

    public static void kitapListesiYazdir() throws InterruptedException {
        System.out.print("Kitap Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== KİTAP LİSTESİ ========\u001B[0m");
        for (Map.Entry<String, String> X : kitaplarMap.entrySet()) {
            if (OduncMap.containsKey(X.getKey())) {
                System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
            } else {
                System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
            }
            System.out.print(X.getKey() + " - " + X.getValue() + " | ");
        }
        System.out.println();
    }

    public static void yazardanKitapBulma() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Yazar Adı: ");
        String Yazar = Consol.nextLine();
        System.out.println("Aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== ARANAN YAZAR ========\u001B[0m");
        for (Map.Entry<String, String> X : kitaplarMap.entrySet()) {
            if (X.getValue().contains(Yazar)) {
                if (OduncMap.containsKey(X.getKey())) {
                    System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
                } else {
                    System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
                }
                System.out.print(X.getKey() + " - " + X.getValue() + " | ");
                anahtar = false;
            }
        }
        System.out.println("\n");
        if (anahtar) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen Yazara Ait Kitap Mevcut Değildir\033[0m\n\n");
        }
    }

    public static void turVeyaYayinTarihiIleKitapBulma() throws InterruptedException {
        System.out.println("\033[1;32m" + "(Tarih, Polisiye, Kurgu, Roman, Destan)" + "\033[0m");
        System.out.print("İstediğiniz kitabın türünü yazınız : ");
        String KitapTuru = Consol.nextLine();
        System.out.print("İstediğiniz kitabın yayın tarihi : ");
        String YayinTarihi = Consol.nextLine();
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== KİTAP LİSTESİ ========\u001B[0m");
        boolean anahtar = true;
        for (Map.Entry<String, String> K : kitaplarMap.entrySet()) {
            String[] eachValuarr = K.getValue().split(", ");
            if (KitapTuru.equalsIgnoreCase(eachValuarr[1]) || YayinTarihi.equalsIgnoreCase(eachValuarr[2])) {
                if (OduncMap.containsKey(K.getKey())) {
                    System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
                } else {
                    System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
                }
                System.out.print(K.getKey() + " " + K.getValue());
                anahtar = false;
            }
        }
        System.out.println();
        if (anahtar) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen bilgiler ile eşleşen bir kitap mevcut değildir\033[0m\n\n");
        }
        System.out.println();
    }

    public static void kitapEkle() throws InterruptedException {
        System.out.print("Kitap Adı: ");
        String kitapAdi = Consol.nextLine();
        System.out.print("Yazar Adı: ");
        String yazarAdi = Consol.nextLine();
        KitapTuru kitapTuru = null;
        while (kitapTuru == null) {
            try {
                System.out.print("Kitap Türü: " + EnumSet.allOf(KitapTuru.class) + ": ");
                String kTur = Consol.nextLine().toUpperCase();
                kitapTuru = KitapTuru.valueOf(kTur);
            } catch (IllegalArgumentException e) {
                System.out.print("\033[1;42m" + "\033[1;31m" + "Hatalı Giriş! Lütfen Kitap Türünü Tekrar Giriniz!\033[0m\n\n");

            }
        }
        System.out.print("Yayın Tarihi: ");
        int yayinYili = 0;
        boolean GecersizGiris = false;
        while (!GecersizGiris) {
            try {
                yayinYili = Integer.parseInt(Consol.nextLine());
                GecersizGiris = true;
            } catch (NumberFormatException e) {

                System.out.print("\033[1;42m" + "\033[1;31m" + "Hatalı Giriş! Lütfen Sayı Giriniz!\033[0m\n\n");

            }
        }
        String kitapBilgileri = yazarAdi + ", " + kitapTuru + ", " + yayinYili;
        kitaplarMap.put(kitapAdi, kitapBilgileri);

        System.out.println("\033[1;32m\nKitap Başarıyla Eklendi!\033[0m\n");
    }

    public static void isimIleKitapSilme() throws InterruptedException {
        System.out.println("Silinecek kitabin ismini giriniz");
        String silinecekKitap = Consol.nextLine();
        String silinecekValue = kitaplarMap.get(silinecekKitap);
        String sonucValue = kitaplarMap.remove(silinecekKitap);
        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "İstediğiniz kitap ismi bulunamadı!\033[0m\n\n");
        }
    }

    public static void kitapOduncAl() throws InterruptedException {
        System.out.println("Ödünç almak istediğiniz kitabın ismini giriniz: ");
        String kitapAdi = Consol.nextLine();
        if (kitaplarMap.containsKey(kitapAdi) || !OduncMap.containsKey(kitapAdi)) {
            System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap ödünç olarak verilmiştir." + "\033[0m\n");
            OduncMap.put(kitapAdi, "");
        } else {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen isim ile bir kitap mevcut değildir!\033[0m\n\n");
        }
    }


    public static void kitapIadeEt() throws InterruptedException {
        System.out.println("İade etmek istediğiniz kitabın ismini giriniz: ");
        String kitapAdi = Consol.nextLine();
        if (kitaplarMap.containsKey(kitapAdi) && OduncMap.containsKey(kitapAdi)) {
            System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap iade alınmıştır." + "\033[0m\n");
            OduncMap.remove(kitapAdi);
        } else {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen isim ile bir kitap mevcut değildir!\033[0m\n\n");
        }
    }
}
