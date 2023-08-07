import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class UyeManager extends Veritabani {
    static Scanner Consol = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String Tercih = "";
        while (!Tercih.equalsIgnoreCase("Q")) {
            System.out.println("\n" + "\u001B[1;34m=== ÜYE İŞLEMLERİ ===\u001B[0m");
            System.out.println("1| Üye Listesi Yazdır");
            System.out.println("2| Soyisimden Üye Bul");
            System.out.println("3| Şehre Göre Üye Bul");
            System.out.println("4| Üye Ekleme");
            System.out.println("5| Kimlik No ile Kayıt Silme");
            System.out.println("6| Kayıt Taleplerini Görüntüle");
            System.out.println("7| Üye Taleplerini Görüntüle");
            System.out.println("A| Bir Önceki Menü");
            System.out.println();
            System.out.print("Lütfen Geçerli Bir Tercih Yapınız: ");
            Tercih = Consol.nextLine();
            switch (Tercih.toUpperCase()) {
                case "1":
                    uyeListesiYazdir();
                    break;
                case "2":
                    soyisimdenUyeBulma();
                    break;
                case "3":
                    sehreGoreUyeBulma();
                    break;
                case "4":
                    uyeEkleme();
                    break;
                case "5":
                    tcnoIleUyeSil();
                    break;
                case "6":
                    uyeTalepleriYazdir();
                    break;
                case "7":
                    yonetimTalepKontrol();
                    break;
                case "A":
                    Helper.showAdminMenu();
                    break;
                default:
                    System.out.println("\033[1;31mHatalı Tercih!\033[0m");
            }
        }
    }

    public static void uyeListesiYazdir() throws InterruptedException {
        System.out.print("Üye Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "    =========== ÜYE LİSTESİ ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");
        for (Map.Entry<String, String> X : uyelerMap.entrySet()) {
            System.out.println(X.getKey() + " - " + X.getValue() + " | ");
        }
    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Aradığınız üyenin soyisminin tamamını ya da bir kısmını giriniz: ");
        String uyeSoyad = Consol.nextLine();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYİSİM İLE ÜYE ARAMA ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");

        for (Map.Entry<String, String> uyelerEntrySet : uyelerMap.entrySet()) {

            String [] valueParca = uyelerEntrySet.getValue().split(", ");

            if (valueParca[1].contains(uyeSoyad) || uyeSoyad.equalsIgnoreCase(valueParca[1])) {

                System.out.println(uyelerEntrySet.getKey() + " " + uyelerEntrySet.getValue() + " | ");

                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\n\033[1;31mBelirtilen bilgiler ile eşleşen bir üye mevcut değildir.\033[0m\n");
        }
    }

    public static void sehreGoreUyeBulma() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Aranan Şehir Adı: ");
        String Sehir = Consol.nextLine();
        System.out.print("Aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== ŞEHİR İLE ÜYE ARAMA ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");
        for (Map.Entry<String, String> X : uyelerMap.entrySet()) {
            if (X.getValue().contains(Sehir)) {
                System.out.println(X.getKey() + " - " + X.getValue() + " | ");
                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\033[1;31mBelirtilen Şehre Ait Üyelik Mevcut Değildir\033[0m");
        }
    }

    public static void uyeEkleme() throws InterruptedException {
        System.out.println("=== ÜYELİK KAYDI ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!intControl(tcNO)) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mTC NO KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String isim = "";
        while (true) {
            System.out.print("İSİM: ");
            isim = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(isim)) {
                System.out.println("\033[1;31mİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String soyisim = "";
        while (true) {
            System.out.print("SOYİSİM: ");
            soyisim = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(soyisim)) {
                System.out.println("\033[1;31mSOYİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mSOYİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String Sehir = "";
        while (true) {
            System.out.print("ŞEHİR: ");
            Sehir = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(Sehir)) {
                System.out.println("\033[1;31mŞEHİR RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mŞEHİR KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String dYili = "";
        while (true) {
            System.out.print("DOĞUM YILI: ");
            dYili = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!intControl(dYili)) {
                System.out.println("\033[1;31mDOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mDOĞUM YILI KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        uyelerMap.put(tcNO, UyeBilgileri);
        uyeTalepleri.remove(tcNO);
        System.out.print("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("\033[1;32m=== ÜYE KAYDI TAMAMLANDI ===\033[0m");
    }

    public static boolean strControl(String str) {
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞü]+$";
        return Pattern.matches(regex, str);
    }

    public static boolean intControl(String str) {
        String regex = "^[0-9]+$";
        return Pattern.matches(regex, str);
    }

    public static void tcnoIleUyeSil() throws InterruptedException {
        System.out.println("=== TC NO İLE ÜYE KAYDI SİLME ===");
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC NO: ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            }
        }
        if (uyelerMap.containsKey(tcNo)) {
            String silinecekUyeBilgisi = uyelerMap.get(tcNo);
            uyelerMap.remove(tcNo);
            System.out.print(silinecekUyeBilgisi + " " + "siliniyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            System.out.println("\033[1;32mÜYE BAŞARIYLA SİLİNDİ\033[0m");
        } else {
            System.out.println("\033[1;31mÜYE BULUNAMADI\033[0m");
        }
    }

    public static void uyeTalepleriYazdir() throws InterruptedException {
        System.out.println("=== ÜYE KAYIT TALEPLERİ ===");
        System.out.print("Talepler Görüntüleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        for (Map.Entry<String, String> X : uyeTalepleri.entrySet()) {
            System.out.println(X.getKey() + " " + X.getValue());
        }
    }

    private static int numara = 1000;

    public static void yonetimdenTalep() throws InterruptedException {
        System.out.println("=== TALEPTE BULUN ===");
        String tcNO = "";

        while (true) {
            System.out.print("TC Numaranızı Giriniz : ");
            tcNO = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!intControl(tcNO)) {
                System.out.println("\033[1;31m" + "TC NO SADECE RAKAMLARDAN OLUŞMALIDIR" + "\033[0m\n");
            } else if (uyelerMap.containsKey(tcNO)) {
                System.out.println("\033[1;32m" + "TC NO KABUL EDİLDİ" + "\033[0m\n");
                break;
            } else {
                System.out.println("\033[1;31m" + "HATALI TC NO ya da ÜYELİK MEVCUT DEĞİL!" + "\033[0m\n");
            }
        }

        System.out.print("\033[1;33m" + "!! TALEBİNİZİ YAZARKEN !! \n" +
                "- DOĞRU BİR ÜSLUP KULLANINIZ.\n- BİRDEN FAZLA TALEBİNİZ VARSA MADDELER HALİNDE YAZINIZ.\n- TALEPLERİNİZE BİR KONU BAŞLIĞI YAZINIZ örn: (KİTAP TALEBİ vb.) \n" +
                "- TALEP YAZINIZIN SONUNA İLETİŞİM BİLGİLERİNİZİ EKLEYİNİZ (E-posta ve Telefon)\n " + "\033[0m");
        System.out.print("\033[1;32m" + "\n-Talebinizi yazınız-" + "\033[0m\n");
        System.out.print("TALEP : ");
        String talep = Consol.nextLine();

        LocalDateTime suan = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.YYYY hh:mm:ss");

        String basvuruNo = "BSVR" + numara++;
        String basvuruTarihi = suan.format(f);
        String guncelTalep = "\033[1;36mBaşvuru Tarihi : \033[0m" + basvuruTarihi +
                "\033[1;36m\nBaşvuru NO     : \033[0m" + basvuruNo +
                "\033[1;36m\n-Başvuru Metni-   \033[0m\n" + talep;
        if (!tumTalepler.containsKey(tcNO)) {
            tumTalepler.put(tcNO, yonetimeTalepler = new ArrayList<>());
        }
        yonetimeTalepler = tumTalepler.get(tcNO);
        yonetimeTalepler.add(guncelTalep);
        System.out.println("\033[1;32m\n" + "TALEBİNİZ BAŞARIYLA KAYIT ALTINA ALINDI\n- 15 İŞ GÜNÜ İÇİNDE TARAFINIZA TALEBİNİZ İLE İLGİLİ GERİ DÖNÜŞ SAĞLANACAKTIR -" + "\033[0m\n");
    }

    public static void talepleriGoruntule() throws InterruptedException {
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC Numaranızı Giriniz : ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            }
        }

        if (tumTalepler.containsKey(tcNo)) {
            System.out.print("Aranıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }

            System.out.println();
            yonetimeTalepler = tumTalepler.get(tcNo);
            System.out.println("\033[1;36m\n" + "               TALEPLERİNİZ" + "\033[0m");
            for (String talep : yonetimeTalepler) {
                System.out.println("=----------------------------------------=");
                System.out.println(talep);
                System.out.println("\033[1;32m\n" + "TALEBİNİZ İŞLEM SIRASINDADIR.\n-" +
                        " BAŞVURU TARİHİNDEN SONRAKİ 15 İŞ GÜNÜ İÇİNDE TARAFINIZA TALEBİNİZ İLE İLGİLİ GERİ DÖNÜŞ SAĞLANACAKTIR -" + "\033[0m\n");
            }


        } else {
            System.out.println("\033[1;31mTALEP BULUNAMADI\033[0m");
        }

    }

    public static void yonetimTalepKontrol() throws InterruptedException {
        if (!tumTalepler.isEmpty()) {
            System.out.print("Aranıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            System.out.println("\033[1;36m\n" + "                 TALEPLER" + "\033[0m");

            for (Map.Entry<String, ArrayList<String>> talep : tumTalepler.entrySet()) {
                for (String talep2 : talep.getValue()) {
                    System.out.println("=----------------------------------------=");
                    System.out.println("\033[1;36mTC Numarası    : \033[0m" + talep.getKey());
                    System.out.println(talep2);
                }
            }
        } else {
            System.out.println("\033[1;31mTALEP BULUNAMADI\033[0m");
        }
    }

    public static void uyelikTalebiOlustur() throws InterruptedException {
        System.out.println("=== ÜYELİK TALEBİ OLUŞTUR ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(tcNO)) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mTC NO KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String isim = "";
        while (true) {
            System.out.print("İSİM: ");
            isim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(isim)) {
                System.out.println("\033[1;31mİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String soyisim = "";
        while (true) {
            System.out.print("SOYİSİM: ");
            soyisim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(soyisim)) {
                System.out.println("\033[1;31mSOYİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mSOYİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String Sehir = "";
        while (true) {
            System.out.print("ŞEHİR: ");
            Sehir = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(Sehir)) {
                System.out.println("\033[1;31mŞEHİR RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mŞEHİR KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String dYili = "";
        while (true) {
            System.out.print("DOĞUM YILI: ");
            dYili = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(dYili)) {
                System.out.println("\033[1;31mDOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mDOĞUM YILI KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        uyeTalepleri.put(tcNO, UyeBilgileri);
        System.out.println("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\033[1;32m=== ÜYE TALEBİ ALINDI ===\033[0m");
    }

    public static void kayitTalebiGoster() throws InterruptedException {
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC Numaranızı Giriniz : ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            }
        }
        if (uyeTalepleri.containsKey(tcNo)) {
            System.out.println("Aranıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            System.out.println("\u001B[1;32mTalebiniz işlem sırasındadır. Başvuru bilgileriniz aşağıdaki gibidir.\u001B[0m");
            System.out.println(uyeTalepleri.get(tcNo) + "\n");

        } else {
            System.out.println("\033[1;31mTALEP BULUNAMADI\033[0m");
        }
    }
}
