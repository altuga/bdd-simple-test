
package com.kodcu.is;


import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Ozaman;

public class HisseSenediIslemleriSteps {

    private HisseService hisseServisi;
    private HisseSenet hisse;




    @Diyelimki("^hisse senedinin birim eşik satış fiyatı (\\d+)$")
    public void hisseSenedininBirimEşikSatışFiyatı(int esikDeger) throws Throwable {
        hisseServisi = new HisseService();
        hisse = hisseServisi.yeniHisseEkle("STK", esikDeger);
    }

    @Eğerki("^hisse senedi (\\d+) üzerinden işlem görüyorsa$")
    public void hisseSenediÜzerindenIşlemGörüyorsa(int fiyat) throws Throwable {
        hisse.islem(fiyat);
    }

    @Ozaman("^sistem  uyarısı  şöyle olmalıdır OFF$")
    public void sistemUyarısıŞöyleOlmalıdırOFF() throws Throwable {
        org.junit.Assert.assertEquals(hisse.getDurum(), "OFF");
    }

    @Ozaman("^sistem  uyarısı  şöyle olmalıdır ON$")
    public void sistemUyarısıŞöyleOlmalıdırON() throws Throwable {
        org.junit.Assert.assertEquals(hisse.getDurum(), "ON");
    }


}