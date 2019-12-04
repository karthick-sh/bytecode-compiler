package src.argobj;

public class SIArgObj extends ArgObj{
    public SIArgObj(String arg1, String arg2){
        try{
            i = Integer.parseInt(arg1);
            str = arg2;
        } catch(NumberFormatException e){
            i = Integer.parseInt(arg2);
            str = arg1;
        }
        


    }
}