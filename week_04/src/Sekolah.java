public class Sekolah {
    public static void main(String[] args) {
        Guru guruku = null;

        Mapel mapel = new Mapel("Pemograman java", "Nugraha");
        JamMengajar jml_jam = new JamMengajar(24, "Nugraha");
        guruku = mapel;
        guruku.infGuru();

        guruku = jml_jam;
        guruku.infGuru();
    }
}
