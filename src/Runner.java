public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Veritabani.baslangicKitaplarVeritabaniOlustur();
        Veritabani.baslangicUyelerVeritabaniOlustur();
        Veritabani.oduncKitaplarVeritabaniOlustur();
        Veritabani.UyeTalepleriVeritabaniOlustur();
        Helper.anaMenu();
    }
}
