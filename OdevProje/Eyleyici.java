public class Eyleyici implements IEyleyici {

    private final boolean KAPALI=false;
    private final boolean ACIK=true;

    private boolean sogutucuDurum=KAPALI;

    private static Eyleyici eyleyici=null;

    public static Eyleyici getEyleyici() {
        if(eyleyici==null)
            eyleyici=new Eyleyici();
        return eyleyici;
    }
    @Override
    public void sogutucuAc() {
        System.out.println("Sogutcu Aciliyor...");
        sogutucuDurum=ACIK;
        //observer


    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu Kapatiliyor....");
        sogutucuDurum=KAPALI;
        //observer

    }

    @Override
    public boolean getSogutucudurum() {
        return sogutucuDurum;
    }



}
