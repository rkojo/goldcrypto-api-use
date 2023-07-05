import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Currency {
  Double val = 0.0;
  public static double getcurrency() throws IOException {
    URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/USD/last/1");
    HttpURLConnection test = (HttpURLConnection)url.openConnection();
    InputStreamReader isr = new InputStreamReader(test.getInputStream());
    BufferedReader br = new BufferedReader(isr);
    String inputLine= br.readLine();
    String price = inputLine.replaceAll("[{}\"\":]","");
    String[] arrprice = price.split("mid|]");
    double db = Double.parseDouble(arrprice[arrprice.length-1]);
    System.out.println("currency = " +db );
    return db;
    // double a = Double.parseDouble(db);
    // System.out.println(a);
  }
}
