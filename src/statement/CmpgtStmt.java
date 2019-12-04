package src.statement;

import src.parser.*;
import src.main.*;

public class CmpgtStmt extends Stmt {
    private Parser parser;

    public CmpgtStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = (byte) 140;

        Main.writeBytecodes(bytes);
    }
}