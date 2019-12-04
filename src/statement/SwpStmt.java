package src.statement;

import src.parser.*;
import src.main.*;

public class SwpStmt extends Stmt {
    private Parser parser;

    public SwpStmt(){
        parser = new NullParser();
    }

    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[1];

        bytes[0] = 94;

        Main.writeBytecodes(bytes);
    }

    public int getCount(){
        return 1;
    }
}