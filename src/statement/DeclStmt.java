package src.statement;

import src.parser.*;
import src.argobj.*;
import src.main.*;

public class DeclStmt extends Stmt {
    private Parser parser;

    public DeclStmt(){
        parser = new SParser();
    }

    public void genCode(String[] args) {
        ArgObj arg_obj = parser.parse(args);

        Main.symbol_table.put(arg_obj.getString(), Integer.toString(Main.offset_counter));
        Main.offset_counter += 1;

        byte[] bytes = new byte[5];

        bytes[0] = 70;
        for (int i = 1; i <= 4; i++) {
            bytes[i] = (byte)(0 >>> ((i-1) * 8));
        }

        Main.writeBytecodes(bytes);
    }

    public int getCount(){
        return 5;
    }
}