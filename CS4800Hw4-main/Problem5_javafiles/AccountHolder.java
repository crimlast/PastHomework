import java.util.Random;

public class AccountHolder {
  private int ID;
  private String address;
  
  public AccountHolder(int ID, String address){
    this.ID = ID;
    this.address = address;
  }
  public int getNextID(){
    Random ran = new Random();
    return ran.nextInt(0,1000000);
  }
  
}
