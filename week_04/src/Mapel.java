public class Mapel extends Guru{
    protected String nama_mapel;

    public Mapel (String nama_mapel, String nama_guru){
        super(nama_guru);
        this.nama_mapel = nama_mapel;
    }

    public void infGuru(){
        System.out.println("Nama guru :"+ super.nama_guru);
        System.out.println("Mengajar mata pelajaran :"+ this.nama_mapel);
    }
}