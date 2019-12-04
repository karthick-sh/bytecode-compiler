package src.parser;

import src.argobj.*;

public class SParser implements Parser{
    public ArgObj parse(String[] args){
        SArgObj arg_obj = new SArgObj(args[1]);
        return arg_obj;
    }
}