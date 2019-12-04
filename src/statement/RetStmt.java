package src.statement;

import src.parser.*;
import src.main.*;

public class RetStmt extends Stmt {
    private Parser parser;

    public RetStmt(){
        parser = new NullParser();
    }
    public void genCode(String[] args) {
        parser.parse(args);

        byte[] bytes = new byte[7];

        bytes[0] = 70;
        for (int i = 1; i <= 4; i++) {
            bytes[i] = (byte)(0 >>> ((i-1) * 8));
        }
        bytes[5] = (byte) 77;
        bytes[6] = (byte) 48;

        Main.writeBytecodes(bytes);
    }

    public int getCount(){
        return 7;
    }
}