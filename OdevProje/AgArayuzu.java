public class AgArayuzu implements IAgArayuzu {

    private static AgArayuzu agArayuzu=null;
    MerkeziBirim merkeziBirim=MerkeziBirim.getMerkeziBirim();


    public static AgArayuzu getAgArayuzu() {
        if(agArayuzu==null)
            agArayuzu=new AgArayuzu();
        return agArayuzu;
    }

    @Override
    public int sicaklikGonder() {
        return merkeziBirim.merkeziSicaklikGonder();

    }

    @Override
    public void sogutucuyuAc() {
        merkeziBirim.merkeziSogutucuAc();

        //Observeble
    }

    @Override
    public void sogutucuyuKapat() {
        merkeziBirim.merkeziSogutucuKapat();
    }
}
