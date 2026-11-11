import java.nio.charset.StandardCharsets;

public class HttpYanitOlusturucu {

    public byte[] http200YanitiOlustur(String htmlGovde) {
        byte[] govdeByteDizisi = htmlGovde.getBytes(StandardCharsets.UTF_8);

        String httpBasliklari = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "Content-Length: " + govdeByteDizisi.length + "\r\n"
                + "Connection: close\r\n"
                + "\r\n";

        byte[] baslikByteDizisi = httpBasliklari.getBytes(StandardCharsets.UTF_8);
        byte[] tamYanit = new byte[baslikByteDizisi.length + govdeByteDizisi.length];

        System.arraycopy(baslikByteDizisi, 0, tamYanit, 0, baslikByteDizisi.length);
        System.arraycopy(govdeByteDizisi, 0, tamYanit, baslikByteDizisi.length, govdeByteDizisi.length);

        return tamYanit;
    }
}