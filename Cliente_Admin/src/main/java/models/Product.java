package models;

public class Product {
    
    private int code;
    private String name;
    private long initValue;
    private State state;

    public Product(){

    }

    public Product(Integer code, String name, long initValue, State state){
        super();
        this.code = code;
        this.name = name;
        this.initValue = initValue;
        this.state = state;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public String getName (){
        return name;
    }
    //Integer code, String name, long initValue, State state, long currentBid
    public void setName(String name){
        this.name = name;
    }

    public long getinitValue(){
        return initValue;
    }

    public void setinitValue(long initValue){
        this.initValue = initValue;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state =state;
    }

    

}
