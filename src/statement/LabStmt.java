package src.statement;

import src.parser.*;
import src.argobj.*;
import src.main.*;

public class LabStmt extends Stmt {
    private Parser parser;

    public LabStmt(){
        parser = new SParser();
    }
    public void genCode(String[] args) {
        ArgObj arg_obj = parser.parse(args);

        Main.symbol_table.put(arg_obj.getString(), Integer.toString(Main.bytecode_offset_counter));
        System.out.println(Main.bytecode_offset_counter);
    }

    public int getCount(){
        return 0;
    }
}