//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/20
//  Course: cs-2400-02 
//
//  Description:
//      An object that contains a String and a value alongside it.
//
public class Name {
    private String name;
    private int value;
    public Name(String name, int value){
        this.name = name;
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
    
}
