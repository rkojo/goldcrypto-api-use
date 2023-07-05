
public class Main {

  public static void main(String[] args) throws Exception {
    
    Double btc = Crypto.getBTC();
    Double eth = Crypto.getETH();
    Double ltc = Crypto.getLTC();
    Double gld = Gold.getgoldUSD();
    System.out.println("gold price = " + gld);
    // while ((inputLine = br.readLine()) != null) {
    //   System.out.println(inputLine);
    // }


    System.out.println("how much btc can you get for an ounce? " + gld/btc );
    System.out.println("how much eth can you get for an ounce? " + gld/eth );
    System.out.println("how much ltc can you get for an ounce? " + gld/ltc );

  }


}
