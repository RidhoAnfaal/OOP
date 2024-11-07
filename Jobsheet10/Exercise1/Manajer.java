package Jobsheet10.Exercise1;

public class Manajer extends Pegawai {
    private int tunjangan;

    public Manajer() {

    }

    public Manajer(String nama, int gaji, int tunjangan) {
        super(nama, gaji);
        this.tunjangan = tunjangan;
    }

    @Override
    public int getGaji() {
        return super.getGaji();
    }

    public int getTunjangan() {
        return tunjangan;
    }
}