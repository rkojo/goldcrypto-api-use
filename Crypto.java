import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Crypto {

  static Double btc = null;
  static Double eth = null;
  static Double ltc = null;

  private static String[] crypto() throws IOException {
     URL url = new URL("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin%2Cethereum%2Clitecoin&vs_currencies=usd");
    HttpsURLConnection test = (HttpsURLConnection)url.openConnection();
    InputStreamReader isr = new InputStreamReader(test.getInputStream());
    BufferedReader br = new BufferedReader(isr);
    String inputLine= br.readLine();
    String price = inputLine.replaceAll("[{}\"\":]","");
    String[] arrprice = price.split("usd|,");
    for(int i = 0; i<arrprice.length; i++) {
      System.out.println(arrprice[i]);
    }
    br.close();
    return arrprice;
  }
  
    public static void convert() throws IOException {
    String[] a = crypto();
    btc = Double.parseDouble(a[1]);
    eth = Double.parseDouble(a[3]);
    ltc = Double.parseDouble(a[5]);
  }

  public static double getBTC() throws IOException {
    if(btc == null) {
      convert();
    }
    return btc;
  }

  public static double getETH() throws IOException {
    if(eth == null) {
      convert();
    }
    return eth;
  }
  
  public static double getLTC() throws IOException {
    if(ltc == null) {
      convert();
    }
    return ltc;
  }
}
