import java.util.ArrayList;

public class Kurs {
    private String kursAdi;
    private ArrayList<Ders> kursdakiDersler;
    private ArrayList<Egitmen> kursEgitmenleri;
    private ArrayList<Ogrenci> kursOgrencileri;
    //ders sayisi en az 5 ve toplam icerik en az 60 dakika olmali
    private boolean yayinda;

    public Kurs(String kursAdi, Egitmen basEgitmen) {
        this.kursAdi = kursAdi;
        this.kursdakiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>();
        this.kursOgrencileri = new ArrayList<>();
        kursEgitmenleri.add(basEgitmen);
        this.yayinda = false;
    }

    public void kursaEgitmenEkle(Egitmen yeniEgitmen) {
        if (!kursEgitmenleri.contains(yeniEgitmen)){
            kursEgitmenleri.add(yeniEgitmen);
        }else {
            System.out.println(yeniEgitmen.getIsim()+" zaten kursta tanimli bir egitmendir");
        }
    }

    public void kursdanEgitmenSil(Egitmen silinecekEgitmen) {
        kursEgitmenleri.remove(silinecekEgitmen);
    }

    public void kursaDersEkle(Ders eklenecekDers) {
        kursdakiDersler.add(eklenecekDers);
    }

    public int kurstakiDersSayisi() {
        return kursdakiDersler.size();
    }

    private int kurstakiToplamDerslerinDakikaSuresi() {
        double toplamSure = 0;
        for (Ders ders : kursdakiDersler) {
            toplamSure = toplamSure + ders.getDakika();
        }
        return (int) toplamSure;
    }

    private boolean kursYayindaKontrol() {
        if (kursdakiDersler.size() >= 5 && kurstakiToplamDerslerinDakikaSuresi() > 60) {
            yayinda = true;
            return true;
        } else return false;
    }

    public void kursaOgrenciEkle(Ogrenci kursOgrencisi) {
        if (kursYayindaKontrol()) {
            kursOgrencileri.add(kursOgrencisi);
        }
    }
}
