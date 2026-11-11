# Java Socket HTTP Web Sunucusu (Port: 1989)

Bu proje, herhangi bir üçüncü parti kütüphane veya harici web çatısı (framework) kullanılmadan, yalnızca **Standart Java SE (`java.net` ve `java.io`)** kütüphaneleri ve **SOLID** yazılım tasarım prensipleri kullanılarak geliştirilmiş çok iş parçacıklı (multi-threaded) bir HTTP/1.1 Web Sunucusudur.

## Proje Özellikleri

* **Sıfır Bağımlılık (Zero-Dependency):** Harici hiçbir kütüphane kullanılmadan saf Java Socket API ile geliştirilmiştir.
* **Port Yapılandırması:** Sunucu `1989` numaralı TCP portundan gelen bağlantıları dinler.
* **Multi-Threading Desteği:** Her istemci bağlantısı ayrı bir iş parçacığında (`Thread`) ele alınarak eşzamanlı (concurrent) istek yönetimi sağlanır.
* **SOLID Mimarisi:** Sorumluluklar `IcerikSaglayici`, `OgrenciBilgiSaglayici`, `HttpYanitOlusturucu`, `IstekYoneticisi` ve `WebSunucuUygulamasi` sınıfları arasında SOLID ilkelerine uygun olarak ayrıştırılmıştır.
* **Biçimlendirilmiş HTML Çıktısı:** Tarayıcıdan bağlanıldığında UTF-8 karakter kodlamasıyla `<h1>` boyutunda Ad Soyad, `<h2>` boyutunda Öğrenci Numarası ve özel CSS ile biçimlendirilmiş kısa biyografi sayfası sunar.

## Mimari ve Sınıf Yapısı

```text
src/
├── IcerikSaglayici.java         # İçerik üreticiler için soyut arayüz (DIP / OCP)
├── OgrenciBilgiSaglayici.java   # Biçimlendirilmiş HTML ve biyografi üretici sınıf (SRP)
├── HttpYanitOlusturucu.java     # HTTP/1.1 200 OK başlık ve byte[] yanıt paketleyici (SRP)
├── IstekYoneticisi.java         # İstemci soket akışlarını yöneten Runnable sınıfı (SRP / DIP)
└── WebSunucuUygulamasi.java     # 1989 portunu dinleyen ana sunucu (Main) sınıfı
