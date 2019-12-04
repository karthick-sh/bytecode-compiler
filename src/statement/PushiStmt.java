package src.statement;

import src.parser.*;
import src.argobj.*;
import src.main.*;

public class PushiStmt extends Stmt {
    private Parser parser;

    public PushiStmt(){
        parser = new IParser();
    }
    public void genCode(String[] args) {
        ArgObj arg_obj = parser.parse(args);

        byte[] bytes = new byte[5];

        bytes[0] = 70;
        for (int i = 1; i <= 4; i++) {
            bytes[i] = (byte)(arg_obj.getInt() >>> ((i-1) * 8));
        }
        Main.writeBytecodes(bytes);
    }
}