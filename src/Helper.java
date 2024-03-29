import java.util.Scanner;

public class Helper {
    static Scanner Consol = new Scanner(System.in);
    public static UserRole loggedInUserRole;

    private static void loginAndShowUserMenu(UserRole role) throws InterruptedException {
        while (true) {
            System.out.print("Kullanıcı Adı: ");
            String username = Consol.nextLine();
            System.out.print("Şifre: ");
            String password = Consol.nextLine();
            role = authenticateUser(username, password);
            if (role == UserRole.ADMIN) {
                loggedInUserRole = UserRole.ADMIN;
                break;
            } else if (role == UserRole.USER) {
                loggedInUserRole = UserRole.USER;
                break;
            } else if (role == UserRole.GUEST) {
                loggedInUserRole = UserRole.GUEST;
                break;
            } else {
                System.out.print("\033[1;31m" + "Geçersiz kullanıcı adı veya şifre!\033[0m\n\n");
            }
        }
        switch (loggedInUserRole) {
            case ADMIN:
                System.out.print("\033[1;32mAdmin olarak giriş yapıldı!\033[0m\n\n");
                showAdminMenu();
            case USER:
                System.out.print("\033[1;32mUser olarak giriş yapıldı!\033[0m\n\n");
                showUserMenu();
            case GUEST:
                System.out.print("\033[1;32mGuest olarak giriş yapıldı!\033[0m\n\n");
                showGuestMenu();
        }

    }

    private static UserRole authenticateUser(String username, String password) {
        if ("Admin".equals(username) && "Admin123".equals(password)) {
            return UserRole.ADMIN;
        } else if ("User".equals(username) && "User123".equals(password)) {
            return UserRole.USER;
        } else if ("Guest".equals(username) && "Guest123".equals(password)) {
            return UserRole.GUEST;
        } else {
            return null;
        }
    }

    public static void anaMenu() throws InterruptedException {
        String Tercih = "";
        while (!Tercih.equalsIgnoreCase("Q")) {
            System.out.println("\u001B[1;32m=== TECHNO KÜTÜPHANE UYGULAMASINA HOŞGELDİNİZ ===\u001B[0m");
            System.out.println("\u001B[1;35m" + "1- Sistem Girişi");
            System.out.println("\u001B[1;35m" + "2- Kütüphane Bilgileri");
            System.out.println("\u001B[1;35m" + "Q- Çıkış" + "\u001B[0m");
            System.out.print("\u001B[1;33m" + "Lütfen menüden tercihinizi yapınız: " + "\u001B[0m");
            Tercih = Consol.nextLine();
            switch (Tercih.toUpperCase()) {
                case "1":
                    loginAndShowUserMenu(null);
                    break;
                case "2":
                    kutuphaneBilgileriniYazdir();
                    break;
                case "Q":
                    projeDurdur();
                default:
                    System.out.print("\u001B[1;31m" + "Lütfen geçerli bir tercih giriniz!\u001B[0m\n\n");
            }
        }
    }

    public static void showAdminMenu() throws InterruptedException {
        while (true) {
            System.out.println("\u001B[1;34m=== ADMİN PANELİ ===\u001B[0m");
            System.out.println("\u001B[1;35m" + "1- Üye İşlemleri");
            System.out.println("\u001B[1;35m" + "2- Kitap İşlemleri");
            System.out.println("\u001B[1;35m" + "3- Kullanıcı Oturumunu Kapat" + "\u001B[0m");
            System.out.println();
            System.out.print("\u001B[1;33m" + "Lütfen menüden tercihinizi yapınız: " + "\u001B[0m");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih) {
                case "1":
                    UyeManager.uyeMenu();
                    break;
                case "2":
                    KitapManager.adminKitapMenu();
                    break;
                case "3":
                    System.out.println("\033[1;31mKullanıcı oturumu sonlandırıldı..\033[0m\n");
                    anaMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");

            }
        }
    }

    public static void showUserMenu() throws InterruptedException {
        while (true) {
            System.out.println("\u001B[1;34m=== USER PANELİ ===\u001B[0m");
            System.out.println("\u001B[1;35m" + "1- Kitap İşlemleri");
            System.out.println("\u001B[1;35m" + "2- Yönetimden Talepte Bulun");
            System.out.println("\u001B[1;35m" + "3- Taleplerimi Görüntüle");
            System.out.println("\u001B[1;35m" + "4- Kullanıcı Oturumunu Kapat");
            System.out.println();
            System.out.print("\u001B[1;33m" + "Lütfen menüden tercihinizi yapınız: " + "\u001B[0m");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih.toUpperCase()) {
                case "1":
                    KitapManager.userKitapMenu();
                    break;
                case "2":
                    UyeManager.yonetimdenTalep();
                    break;
                case "3":
                    UyeManager.talepleriGoruntule();
                    break;
                case "4": System.out.println("\033[1;31mKullanıcı oturumu sonlandırıldı..\033[0m\n");
                    anaMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");
            }
        }
    }

    public static void showGuestMenu() throws InterruptedException {
        while (true) {
            System.out.println("\u001B[1;34m=== GUEST PANELİ ===\u001B[0m");
            System.out.println("\u001B[1;35m" + "1- Kitap İşlemleri");
            System.out.println("\u001B[1;35m" + "2- Kayıt Talebi Oluştur");
            System.out.println("\u001B[1;35m" + "3- Kayıt Talebimi Göster");
            System.out.println("\u001B[1;35m" + "4- Kullanıcı Oturumunu Kapat");
            System.out.println();
            System.out.print("\u001B[1;33m" + "Lütfen menüden tercihinizi yapınız: " + "\u001B[0m");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih.toUpperCase()) {
                case "1":
                    KitapManager.guestKitapMenu();
                    break;
                case "2":
                    UyeManager.uyelikTalebiOlustur();
                    break;
                case "3":
                    UyeManager.kayitTalebiGoster();
                    break;
                case "4": System.out.println("\033[1;31mKullanıcı oturumu sonlandırıldı..\033[0m\n");
                    anaMenu();
                    break;
                default:
                    System.out.print("\033[1;31m" + "Lütfen geçerli bir tercih giriniz!\033[0m\n\n");
            }
        }
    }

    public static void kutuphaneBilgileriniYazdir() throws InterruptedException {
        System.out.print("Kütüphane bilgileri yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t\u001B[1;35mKutuphane: " + Kutuphane.kutuphaneIsim +
                "\n\t\t\u001B[1;35mAdres    : " + Kutuphane.adres +
                "\n\t\t\u001B[1;35mTelefon  : " + Kutuphane.telefon + "\u001B[0m\n");
    }

    public static void projeDurdur() {
        System.out.println("\033[1;32m\n" + "KÜTÜPHANE PROJESİNDEN ÇIKTINIZ.." + "\033[0m\n");
        System.exit(0);
    }
}
