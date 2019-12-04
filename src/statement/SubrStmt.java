package src.statement;

import src.parser.*;
import src.main.*;

public class SubrStmt extends Stmt {
    private Parser parser;

    public SubrStmt(){
        parser = new NullParser();
    }
    public void genCode(String[] args) {

        byte[] bytes = new byte[17];

        bytes[0] = 70;
        bytes[1] = 16;
        bytes[2] = 0;
        bytes[3] = 0;
        bytes[4] = 0;
        bytes[5] = 70;
        bytes[6] = 17;
        bytes[7] = 0;
        bytes[8] = 0;
        bytes[9] = 0;
        bytes[10] = 70;
        bytes[11] = 1;
        bytes[12] = 0;
        bytes[13] = 0;
        bytes[14] = 0;
        bytes[15] = 44;
        bytes[16] = 0;


        Main.writeBytecodes(bytes);
    }
    

    public int getCount(){
        return 17;
    }
}