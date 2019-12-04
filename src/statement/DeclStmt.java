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

        Main.symbol_table.put(arg_obj.getString(), Integer.toString(Main.offset_counter++));
    }
}