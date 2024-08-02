import java.util.ArrayList;

public class Ogrenci extends Kisi {

    private ArrayList<Kurs> katildigiKurslar;

    public Ogrenci(String isim, String tanitimYazisi, String kullaniciAdi) {
        super(isim, tanitimYazisi, kullaniciAdi);
        katildigiKurslar = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() + "Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }
}
