import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSunucuUygulamasi {

    private static final int PORT = 1989;

    public static void main(String[] args) {
        IcerikSaglayici icerikSaglayici = new OgrenciBilgiSaglayici();
        HttpYanitOlusturucu yanitOlusturucu = new HttpYanitOlusturucu();

        try (ServerSocket sunucuSoketi = new ServerSocket(PORT)) {
            System.out.println("==================================================");
            System.out.println("Web Sunucusu başlatıldı. Port dinleniyor: " + PORT);
            System.out.println("Tarayıcıdan erişim: http://localhost:" + PORT);
            System.out.println("==================================================");

            while (true) {
                Socket istemciSoketi = sunucuSoketi.accept();
                IstekYoneticisi istekYoneticisi = new IstekYoneticisi(istemciSoketi, icerikSaglayici, yanitOlusturucu);
                Thread islemParcasi = new Thread(istekYoneticisi);
                islemParcasi.start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatılırken veya çalışırken kritik hata: " + e.getMessage());
        }
    }
}