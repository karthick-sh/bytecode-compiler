package src.statement;

import src.parser.*;
import src.main.*;

public class SubStmt extends Stmt {
    private Parser parser;

    public SubStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = 104;

        Main.writeBytecodes(bytes);
    }
}