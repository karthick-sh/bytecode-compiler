package src.statement;

import src.parser.*;
import src.main.*;

public class CmpeStmt extends Stmt {
    private Parser parser;

    public CmpeStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = (byte) 132;

        Main.writeBytecodes(bytes);
    }
}