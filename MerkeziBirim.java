import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class MerkeziBirim {

    private static MerkeziBirim merkeziBirim=null;
    IEyleyici eyleyici= Eyleyici.getEyleyici();
    ISicaklikAlgilayici sicaklikAlgilayici= SicaklikAlgilayici.getSicaklikAlgilayici();
    AkilliCihazPostgreSQL akilliCihazPostgreSQL=AkilliCihazPostgreSQL.getAkilliCihazPostgreSQL();
    static IInternetKullanicisi internetKullanicisi=InternetKullanicisi.getInternetKullanicisi();


    public static MerkeziBirim getMerkeziBirim() {
        if(merkeziBirim==null)
            merkeziBirim=new MerkeziBirim();
        return merkeziBirim;
    }


    public void merkeziSogutucuAc()
    {
        eyleyici.sogutucuAc();
    }
    public void merkeziSogutucuKapat()
    {
        eyleyici.sogutucuKapat();
    }

    public int merkeziSicaklikGonder()
    {
        return sicaklikAlgilayici.sicaklikOku();
    }

    public String merkeziSogutucuDurum()
    {
        boolean durum=eyleyici.getSogutucudurum();
        if(durum)
            return "ACIK";
        else
            return "KAPALI";

    }

    public void kontrol()
    {
        System.out.println("Sıcaklık: "+ merkeziSicaklikGonder());
        System.out.println("Sogutucu Durumu: "+ merkeziSogutucuDurum());

    }
    public static void kapali()
    {
        System.exit(0);
    }

    public void bekleme() throws InterruptedException {
        Thread.sleep(1000);
    }

    public boolean kullaniciKontrol(String a, String b) throws SQLException {
       return akilliCihazPostgreSQL.kullaniciKontrol(a,b);
    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        int secim=0;
        String kullaniciAdi;
        String sifre;



        do {
            System.out.println("Hoş geldiniz...");
            System.out.println("1- Yetkili Girişi");
            System.out.println("2-  Misafir Girişi");
            System.out.println("3- Bekleme Modu");
            System.out.println("4- Kapalı");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Seçim giriniz:");
            secim=scanner.nextInt();



            switch (secim)
            {
                case 1:
                    System.out.println("Kullanıcı adı ve şifre giriniz:");
                    kullaniciAdi=scanner.next();
                    sifre=scanner.next();
                    if(merkeziBirim.kullaniciKontrol(kullaniciAdi,sifre))//kullanıcı doğrulaması varsayılıyor
                    {
                        System.out.println("Hoş geldiniz "+kullaniciAdi);
                        int yetkiliSecimi=0;
                        do {
                            System.out.println("1- Sıcaklık Görüntüle");
                            System.out.println("2- Sogutucu aç");
                            System.out.println("3- sogutucu kapat");
                            System.out.println("4- Kontrol Et");
                            System.out.println("5- Çıkış");
                            yetkiliSecimi=scanner.nextInt();
                            switch (yetkiliSecimi)
                            {
                                case 1:
                                    System.out.println("Sıcaklık değeri: "+ internetKullanicisi.agSicaklikAl());
                                    break;
                                case 2:
                                    internetKullanicisi.agSogutucuAc();
                                    break;
                                case 3:
                                    internetKullanicisi.agSogutucuKapat();
                                    break;
                                case 4:
                                    MerkeziBirim merkeziBirim= MerkeziBirim.getMerkeziBirim();
                                    merkeziBirim.kontrol();
                                    break;
                                case 5:
                                    System.out.println("Güle güle....");

                                    break;

                            }
                        }
                        while (yetkiliSecimi!=5);
                    }
                    else
                        System.out.println("Yanlış giriş");
                    break;
                case 2:
                    System.out.println("Misafir Girişi Başarılı. Sadece Durumları görüntüleyebilirsiniz");
                    MerkeziBirim merkeziBirim=MerkeziBirim.getMerkeziBirim();
                    merkeziBirim.kontrol();
                    break;
                case 3:
                    System.out.println("Bekleme Moduna Alındı. Uyadırmak için Enter Tuşuna basınız...");
                    Scanner ali=new Scanner(System.in);
                    ali.nextLine();

                    break;
                case 4:
                    System.out.println("Çıkılıyor");
                    MerkeziBirim.kapali();

                    break;
                default:
                    System.out.println("Bir daha seçim yapınız");
            }

        }
        while (true);
    }
}
