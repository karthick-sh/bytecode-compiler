package src.statement;

import src.parser.*;
import src.main.*;

public class CmpltStmt extends Stmt {
    private Parser parser;

    public CmpltStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = (byte) 136;

        Main.writeBytecodes(bytes);
    }
}