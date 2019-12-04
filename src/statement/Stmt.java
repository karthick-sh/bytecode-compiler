package src.statement;

import src.parser.*;

public class Stmt {
    private Parser parser;

    public Stmt(){}
    public void genCode(String[] args) {
        parser.parse(args);
    }
}