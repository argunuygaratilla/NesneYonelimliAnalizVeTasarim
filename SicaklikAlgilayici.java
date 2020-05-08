import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private final int MAX_SICAKLIK=40;
    private static SicaklikAlgilayici sicaklikAlgilayici=null;
    int sicaklik=0;

    public static SicaklikAlgilayici getSicaklikAlgilayici() {
        if(sicaklikAlgilayici==null)
            sicaklikAlgilayici=new SicaklikAlgilayici();
        return sicaklikAlgilayici;
    }

    private SicaklikAlgilayici()
    {
        Random random = new Random();
        sicaklik=random.nextInt(MAX_SICAKLIK);

    }

    @Override
    public int sicaklikOku() {
        return sicaklik;
    }


}
