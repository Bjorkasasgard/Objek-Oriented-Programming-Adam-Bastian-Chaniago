public class JamMengajar extends Guru{
    protected int jml_jam;

    public JamMengajar(int jml_jam, String nama_guru){
        super(nama_guru);
        this.jml_jam = jml_jam;
    }

    public void infGuru(){
        System.out.println("nama Guru :"+ super.nama_guru);
        System.out.println("jumlah jam mengajar :" + this.jml_jam + "Jam");
    }
}