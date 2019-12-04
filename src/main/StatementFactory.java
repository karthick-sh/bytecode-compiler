package src.main;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;
import src.statement.*;

public class StatementFactory {
    private static Map<String, Stmt> statements = new HashMap<String, Stmt>();
    // private static String[] stmt_classes = {
    //     "src.statement.DeclStmt", "src.statement.LabStmt", "src.statement.PrintiStmt", "src.statement.PrintvStmt", 
    //     "src.statement.JmpStmt", "src.statement.JmpcStmt", "src.statement.CmpeStmt", "src.statement.CmpltStmt", "src.statement.CmpgtStmt",
    //     "src.statement.PushiStmt", "src.statement.PopmStmt", "src.statement.PopvStmt", "src.statement.PeekStmt", 
    //     "src.statement.PokeStmt", "src.statement.SwpStmt", "src.statement.AddStmt", "src.statement.SubStmt", "src.statement.MulStmt", 
    //     "src.statement.DivStmt"
    // };
    // private static String[] stmts = {
    //     "decl", "lab", "printi", "printv", "jmp", "jmpc",
    //     "cmpe", "cmplt", "cmpgt", "pushi", "pushv", "popm", "popv", "peek", "poke", "swp",
    //     "add", "sub", "mul", "div"
    // };

    private static String[] stmt_classes = {
        "src.statement.PrintiStmt", "src.statement.DeclStmt", "src.statement.PrintiStmt", "src.statement.PrintvStmt", "src.statement.PopvStmt",
        "src.statement.PushiStmt", "src.statement.PushvStmt", "src.statement.RetStmt", "src.statement.SubrStmt", "src.statement.AddStmt",
        "src.statement.SubStmt", "src.statement.MulStmt", "src.statement.DivStmt", "src.statement.SwpStmt", "src.statement.CmpeStmt",
        "src.statement.CmpgtStmt", "src.statement.CmpltStmt", "src.statement.PopmStmt", "src.statement.JmpStmt", "src.statement.JmpcStmt",
        "src.statement.LabStmt", "src.statement.PeekStmt", "src.statement.PokeStmt"
    };

    private static String[] stmts = {
        "printi", "decl", "printi", "printv", "popv", "pushi", "pushv", "ret", "subr", "add", "sub", "mul", "div", "swp",
        "cmpe", "cmpgt", "cmplt", "popm", "jmp", "jmpc", "lab", "peek", "poke"
    };

    public static void initializeStatements() {
        for (int i = 0; i < stmt_classes.length; i++) {
            Class<?> class_name = null;
            Constructor<?> constructor = null;
            Stmt stmt = null;
            try {
                class_name = Class.forName(stmt_classes[i]);
            } catch (ClassNotFoundException e) {
                System.out.println("Error: Class not found for " + stmt_classes[i]);
                e.printStackTrace();
            }
            try {
                constructor = class_name.getConstructor();
            } catch (NoSuchMethodException e) {
                System.out.println("Error: Constructor not found for " + stmt_classes[i]);
                e.printStackTrace();
            }
            try {
                stmt = (Stmt) constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                System.out.println("Error: Not able to make a new instance for " + stmt_classes[i]);
                e.printStackTrace();
            }

            statements.put(stmts[i], stmt);
        } 
    }
    public static Stmt getStatement(String stmt){
        Stmt stmt_object = statements.get(stmt);

        if(stmt_object == null){
            System.out.println("Error: Unable to get statement for " + stmt);
        }
        return stmt_object;
    }
}