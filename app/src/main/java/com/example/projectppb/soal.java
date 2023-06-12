package com.example.projectppb;

public class soal {

    public String pertanyaan[] = {
            "Apa yang dimaksud dengan sistem operasi pada komputer?",
            "Apa fungsi utama dari RAM (Random Access Memory)?",
            "Apa yang dimaksud dengan virus komputer?",
            "Apa fungsi dari hard disk pada komputer?",
            "Apa yang dimaksud dengan GPU (Graphics Processing Unit)?",

            "Apa kepanjangan dari CPU?",
            "Apa yang dimaksud dengan firewall pada komputer?",
            "Apa yang dimaksud dengan URL (Uniform Resource Locator)?",
            "Apa yang dimaksud dengan browser web?",
            "Apa fungsi dari mouse pada komputer?",
    };

    private String pilihanJawaban[][] = {
            {"Perangkat lunak yang mengatur komponen perangkat keras komputer.","Alat keras yang menjalankan perintah pada komputer.","Perangkat keras yang digunakan untuk memproses data pada komputer.","Program yang digunakan untuk merancang tampilan grafis komputer."},
            {"Menyimpan data dan program yang sedang digunakan saat ini.","Mengontrol semua operasi input dan output pada komputer.","Melakukan pemrosesan dan perhitungan matematika kompleks.","Menyimpan data dan program dalam jangka panjang."},
            {"Perangkat keras tambahan yang meningkatkan kinerja komputer.","Program yang menginfeksi sistem komputer dan merusak atau mencuri data.","Algoritma matematika yang digunakan untuk mengenkripsi data.","Perangkat lunak yang mempercepat kecepatan transfer data pada jaringan."},
            {"Menyimpan data dan program dalam jangka panjang.","Mempercepat kecepatan transfer data pada jaringan.","Melakukan pemrosesan dan perhitungan matematika kompleks.","Mengatur komponen perangkat keras komputer."},
            {"Alat keras yang menjalankan perintah pada komputer.","Perangkat keras tambahan yang meningkatkan kinerja komputer.","Perangkat lunak yang mengatur komponen perangkat keras komputer.","Komponen yang menghasilkan dan mengendalikan tampilan grafis pada komputer."},

            {"Central Processing Unit","Computer Processing Unit","Core Processing Unit","Control Processing Unit"},
            {"Program yang mengamankan data dan mencegah akses yang tidak sah.","Perangkat keras yang digunakan untuk menghubungkan komputer ke jaringan.","Perangkat lunak yang mengatur komponen perangkat keras komputer.","Alat untuk mengkompresi data dan mengurangi ukuran file."},
            {"Alamat unik yang digunakan untuk mengidentifikasi alamat IP komputer.","Perangkat lunak yang digunakan untuk menjelajahi internet.","Bahasa pemrograman yang digunakan untuk membuat halaman web.","Alamat web yang digunakan untuk mengakses halaman atau sumber daya di internet."},
            {"Program yang digunakan untuk membuat halaman web.","Alat keras yang digunakan untuk menghubungkan komputer ke jaringan.","Program yang digunakan untuk menjelajahi internet.","Alamat unik yang digunakan untuk mengidentifikasi alamat IP komputer."},
            {"Mengatur komponen perangkat keras komputer.","Mempercepat kecepatan transfer data pada jaringan.","Melakukan pemrosesan dan perhitungan matematika kompleks.","Memudahkan pengguna dalam memasukkan input dan mengontrol kursor pada layar."},
    };

    private String jawabanBenar[] = {
            "Perangkat lunak yang mengatur komponen perangkat keras komputer.",
            "Menyimpan data dan program yang sedang digunakan saat ini.",
            "Program yang menginfeksi sistem komputer dan merusak atau mencuri data.",
            "Menyimpan data dan program dalam jangka panjang.",
            "Komponen yang menghasilkan dan mengendalikan tampilan grafis pada komputer.",

            "Central Processing Unit",
            "Program yang mengamankan data dan mencegah akses yang tidak sah.",
            "Alamat web yang digunakan untuk mengakses halaman atau sumber daya di internet.",
            "Program yang digunakan untuk menjelajahi internet.",
            "Memudahkan pengguna dalam memasukkan input dan mengontrol kursor pada layar.",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }
    public String getPilihanJawaban4(int x){
        String jawaban4 = pilihanJawaban[x][3];
        return jawaban4;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
