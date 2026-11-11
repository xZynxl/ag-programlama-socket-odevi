import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class IstekYoneticisi implements Runnable {

    private final Socket istemciSoketi;
    private final IcerikSaglayici icerikSaglayici;
    private final HttpYanitOlusturucu yanitOlusturucu;

    public IstekYoneticisi(Socket istemciSoketi, IcerikSaglayici icerikSaglayici, HttpYanitOlusturucu yanitOlusturucu) {
        this.istemciSoketi = istemciSoketi;
        this.icerikSaglayici = icerikSaglayici;
        this.yanitOlusturucu = yanitOlusturucu;
    }

    @Override
    public void run() {
        try (
                BufferedReader okuyucu = new BufferedReader(new InputStreamReader(istemciSoketi.getInputStream(), StandardCharsets.UTF_8));
                OutputStream yazici = istemciSoketi.getOutputStream()
        ) {
            String istekSatiri = okuyucu.readLine();
            if (istekSatiri != null && !istekSatiri.isEmpty()) {
                System.out.println("[İSTEK ALINDI] " + istemciSoketi.getInetAddress() + " -> " + istekSatiri);

                String htmlIcerik = icerikSaglayici.htmlIcerikUret();
                byte[] httpYaniti = yanitOlusturucu.http200YanitiOlustur(htmlIcerik);

                yazici.write(httpYaniti);
                yazici.flush();
            }
        } catch (IOException e) {
            System.err.println("[HATA] İstemci isteği işlenirken hata oluştu: " + e.getMessage());
        } finally {
            try {
                istemciSoketi.close();
            } catch (IOException e) {
                System.err.println("[HATA] Soket kapatılamadı: " + e.getMessage());
            }
        }
    }
}