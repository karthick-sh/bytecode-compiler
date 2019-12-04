package src.statement;

import src.parser.*;
import src.main.*;

public class MulStmt extends Stmt {
    private Parser parser;

    public MulStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = 108;

        Main.writeBytecodes(bytes);
    }

    public int getCount(){
        return 1;
    }
}