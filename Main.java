import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Main {


  public static void main(String[] args) throws Exception {
    Gold gold = new Gold();
    Currency currency = new Currency();
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
    Double btc = getBTC(arrprice);
    Double eth = getETH(arrprice);
    Double ltc = getLTC(arrprice);
    Double gld = gold.getgoldUSD();
    System.out.println("gold price = " + gld);
    // while ((inputLine = br.readLine()) != null) {
    //   System.out.println(inputLine);
    // }
    br.close();

    System.out.println("how much btc can you get for an ounce? " + gld/btc );
    System.out.println("how much eth can you get for an ounce? " + gld/eth );
    System.out.println("how much ltc can you get for an ounce? " + gld/ltc );

  }

  public static double[] convert(String[] a) {
    double[] converted = new double[3];
    converted[0] = Double.parseDouble(a[1]);
    converted[1] = Double.parseDouble(a[3]);
    converted[2] = Double.parseDouble(a[5]);
    return converted;
  }

  public static double getBTC(String[] a) {
    Double btc = convert(a)[0];
    return btc;
  }

  public static double getETH(String[] a) {
    Double eth = convert(a)[1];
    return eth;
  }
  
  public static double getLTC(String[] a) {
    Double ltc = convert(a)[2];
    return ltc;
  }
}
