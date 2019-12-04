package src.parser;

import src.argobj.*;

public class IParser implements Parser{
    public ArgObj parse(String[] args){
        IArgObj arg_obj = new IArgObj(Integer.parseInt(args[1]));
        return arg_obj;
    }
}