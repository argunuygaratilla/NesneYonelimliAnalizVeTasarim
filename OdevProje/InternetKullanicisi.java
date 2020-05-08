public class InternetKullanicisi implements IInternetKullanicisi {

    private static InternetKullanicisi internetKullanicisi=null;
    IAgArayuzu agArayuzu= AgArayuzu.getAgArayuzu();

    private int okunanDeger=0;
    public static InternetKullanicisi getInternetKullanicisi() {
        if(internetKullanicisi==null)
            internetKullanicisi=new InternetKullanicisi();
        return internetKullanicisi;
    }

    public int getOkunanDeger() {
        return okunanDeger;
    }

    @Override
    public void agSogutucuAc() {
        agArayuzu.sogutucuyuAc();
    }

    @Override
    public void agSogutucuKapat() {
    agArayuzu.sogutucuyuKapat();
    }

    @Override
    public int agSicaklikAl() {
        return agArayuzu.sicaklikGonder();


    }


}
