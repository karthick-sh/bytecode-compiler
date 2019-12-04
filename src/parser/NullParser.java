package src.parser;

import src.argobj.*;

public class NullParser implements Parser{
    public ArgObj parse(String[] args){
        NullArgObj arg_obj = new NullArgObj();
        return arg_obj;
    }
}