import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Gold {
  //api source = https://api.nbp.pl/en.html#info
  private double  gold() throws IOException {
  URL url = new URL("http://api.nbp.pl/api/cenyzlota/last/1");
    HttpURLConnection test = (HttpURLConnection)url.openConnection();
    InputStreamReader isr = new InputStreamReader(test.getInputStream());
    BufferedReader br = new BufferedReader(isr);
    String inputLine= br.readLine();
    String price = inputLine.replaceAll("[{}\"\":]","");
    String[] arrprice = price.split("cena|]");
    String db = arrprice[arrprice.length-1];
    //source indicates price is per gram
    double a = Double.parseDouble(db);
    System.out.println("price per gram in zloty = " + db);
    a = a * 31.1; //weight of troy ounce
    System.out.println("price per ounce in zloty = " + a);

    return a;
  }

  public double getgold() throws IOException {
    return gold();
  }

  public double getgoldUSD() throws IOException {
    Currency c = new Currency();
    Double price = gold();
    return price / c.getcurrency();
  }
}
