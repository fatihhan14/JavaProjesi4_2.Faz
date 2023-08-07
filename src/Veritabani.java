import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Veritabani {
    static Map<String, String> uyelerMap = new HashMap<>();

    public static void baslangicUyelerVeritabaniOlustur() {
        uyelerMap.put("469922399405", "Ali, Can, İzmir, 2008");
        uyelerMap.put("165776787406", "Hikmet, Ran, Ankara, 2000");
        uyelerMap.put("143244487408", "Ayse, Can, Mersin, 1995");
        uyelerMap.put("648643787403", "Ahmet, Yesil, Adana, 2003");
        uyelerMap.put("123245967407", "Zehra, Kara, İzmir, 1979");
        uyelerMap.put("124366976453", "Betul, Usluer, İstanbul, 2005");
        uyelerMap.put("125422676778", "Oktay, Sari, İstanbul, 1999");
        uyelerMap.put("129390405664", "Bahtiyar, Gul, Siirt, 1983");
        uyelerMap.put("654322503029", "Ali hikmet, Yasar, İzmir, 1983");
        uyelerMap.put("212454369848", "Nermin, Ali, Ankara, 1983");
    }

    static Map<String, String> kitaplarMap = new HashMap<>();

    public static void baslangicKitaplarVeritabaniOlustur() {
        kitaplarMap.put("A Tale of Two Cities", "Charles Dickens, TARIH, 1859");
        kitaplarMap.put("Ten Little Niggers", "Agatha Christie, POLISIYE, 1939");
        kitaplarMap.put("Le Petit Prince", "Antoine de Saint-Exupery, KURGU, 1943");
        kitaplarMap.put("The Hobbit", "J. R. R. Tolkien, KURGU, 1937");
        kitaplarMap.put("The Lord of the Rings", "J. R. R. Tolkien, KURGU, 1954-1955");
        kitaplarMap.put("Hong lou meng", "Cao Xueqin, DESTAN, 1759-1791");
        kitaplarMap.put("Simyaci", "Paulo Coelho, ROMAN, 1988");
        kitaplarMap.put("Hayvan Ciftligi", "George Orwell, ROMAN, 1945");
        kitaplarMap.put("Bindokuzyuzseksendort", "George Orwell, ROMAN, 1949");
        kitaplarMap.put("Harry Potter", "J.K. Rowling, KURGU, 1997");
    }

    static Map<String, String> OduncMap = new HashMap<>();

    public static void oduncKitaplarVeritabaniOlustur() {
        OduncMap.put("The Hobbit", "J. R. R. Tolkien, KURGU, 1937");
        OduncMap.put("The Lord of the Rings", "J. R. R. Tolkien, KURGU, 1954-1955");
        OduncMap.put("Harry Potter", "J.K. Rowling, KURGU, 1997");
    }

    static Map<String, String> uyeTalepleri = new HashMap<>();

    public static void UyeTalepleriVeritabaniOlustur() {
        uyeTalepleri.put("469922399499", "Burhan, Şengül, İzmir, 1995");
        uyeTalepleri.put("165776787498", "Fatih, Karahanlı, Samsun, 1994");
        uyeTalepleri.put("143244487497", "Secan, Işık, Batman, 1990");
    }

    static ArrayList<String> yonetimeTalepler;
    static Map<String, ArrayList<String>> tumTalepler = new TreeMap<>();

}
