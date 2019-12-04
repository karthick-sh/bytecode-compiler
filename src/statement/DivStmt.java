package src.statement;

import src.parser.*;
import src.main.*;

public class DivStmt extends Stmt {
    private Parser parser;

    public DivStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = 112;

        Main.writeBytecodes(bytes);
    }
}