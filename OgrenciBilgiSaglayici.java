public class OgrenciBilgiSaglayici implements IcerikSaglayici {

    private final String adSoyad;
    private final String ogrenciNo;
    private final String biyografi;

    public OgrenciBilgiSaglayici() {
        this.adSoyad = "Mehmet Berke Ünlütürk";
        this.ogrenciNo = "1250505051";
        this.biyografi = "Yazılım geliştirme, yapay zeka destekli web uygulamaları ve veri analitiği "
                + "alanlarına odaklanan bir mühendislik öğrencisiyim. Temel ağ programlama protokolleri, "
                + "nesne yönelimli tasarım ilkeleri (SOLID), Python ekosistemi ve modern web mimarileri "
                + "üzerine çalışmalar yürütmekteyim. Akademik çalışmalarımın yanı sıra algoritmik problem "
                + "çözme ve düşük seviyeli sistem/soket mimarileri ile ilgileniyorum.";
    }

    @Override
    public String htmlIcerikUret() {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"tr\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>" + adSoyad + " - Kişisel Web Sunucusu</title>\n"
                + "</head>\n"
                + "<body style=\"background-color: #f0f4f8; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #2d3748; margin: 0; padding: 40px;\">\n"
                + "    <div style=\"max-width: 700px; margin: 0 auto; background-color: #ffffff; padding: 35px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.08); border-top: 6px solid #2b6cb0;\">\n"
                + "        <h1 style=\"color: #1a365d; font-family: 'Georgia', serif; font-size: 32px; margin-bottom: 5px;\">" + adSoyad + "</h1>\n"
                + "        <h2 style=\"color: #4a5568; font-family: 'Courier New', Courier, monospace; font-size: 22px; margin-top: 0; border-bottom: 2px solid #e2e8f0; padding-bottom: 15px;\">Öğrenci No: " + ogrenciNo + "</h2>\n"
                + "        <h3 style=\"color: #2b6cb0; font-family: 'Verdana', sans-serif; font-size: 18px; margin-top: 25px;\">Kısa Biyografi</h3>\n"
                + "        <p style=\"font-size: 16px; line-height: 1.7; color: #4a5568; text-align: justify; background-color: #edf2f7; padding: 18px; border-left: 4px solid #3182ce; border-radius: 4px;\">\n"
                + "            " + biyografi + "\n"
                + "        </p>\n"
                + "        <div style=\"margin-top: 25px; font-size: 13px; color: #718096; text-align: right; font-style: italic;\">\n"
                + "            Java Standart Socket API (Port: 1989) ile sunulmuştur.\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
    }
}