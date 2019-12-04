package src.parser;

import src.argobj.*;

public class SIParser implements Parser{
    public ArgObj parse(String[] args){
        SIArgObj arg_obj = new SIArgObj(args[1], args[2]);
        return arg_obj;
    }
}