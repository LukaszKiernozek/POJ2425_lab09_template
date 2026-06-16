package main.java.com.example.model;

public class DictionaryValue {
    private int id;
    private int intKey;
    private String stringKey;
    private String name;
    private String value;

    public DictionaryValue(){

    }

    public DictionaryValue(int id, intKey, String stringKey, String name, String value){
        this.id = id;
        this.intKey = intKey;
        this.stringKey = stringKey;
        this.name = name;
        this.value = value;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getIntKey() {return intKey;}
    public void setIntKey(int intKey){this.intKey = intKey;}
    public String getStringKey(){return stringKey;}
    public void setStringKey(String stringKey){this.stringKey = stringKey;}
    public String getValue(){return value;}
    public void setValue(String value){this.value = value;}
    public String getEnumName(){return enumName;}
    public void setEnumName(String enumName){this.enumName = enumName;}

    @Override
    public String toString() {
        return "DictionaryValue{" +
                "id=" + id +
                ", intKey=" + intKey +
                ", stringKey='" + stringKey + '\'' +
                ", value='" + value + '\'' +
                ", enumName='" + enumName + '\'' +
                '}';
}
