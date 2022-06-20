public class IndividualHolder extends AccountHolder implements Util{
  private String name;
  private String SSN;

  public IndividualHolder(int ID, String address, String name, String SSN){
    super(ID, address);
    this.name = name;
    this.SSN = SSN;
  }

  public String getName(){
    return name;
  }

  public String getSSN(){
    return SSN;
  }

  public void setName(String n){
    name = SSN;
  }

  public void setSSN(String s){
    SSN = s;
  }

  @Override
  public void convertNameUpperCase(String name) {
    this.name = name.toUpperCase();
    
  }
  
}
