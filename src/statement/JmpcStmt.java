package src.statement;

import src.parser.*;
import src.argobj.*;
import src.main.*;

public class JmpcStmt extends Stmt {
    private Parser parser;

    public JmpcStmt(){
        parser = new SParser();
    }
    public void genCode(String[] args) {
        ArgObj arg_obj = parser.parse(args);

        int address = Integer.parseInt(Main.symbol_table.get(arg_obj.getString()));
        byte[] bytes = new byte[6];

        bytes[0] = 70;
        for (int i = 1; i <= 4; i++) {
            bytes[i] = (byte)(address >>> ((i-1) * 8));
        }
        bytes[5] = (byte) 40;

        Main.writeBytecodes(bytes);
    }

    public int getCount(){
        return 6;
    }
}