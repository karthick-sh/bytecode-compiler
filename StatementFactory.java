import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

public class StatementFactory {
    private static Map<String, Stmt> statements = new HashMap<String, Stmt>();
    private static String[] stmt_classes = {
        "DeclStmt", "LabStmt", "SubrStmt", "RetStmt", "RetrStmt", "PrintiStmt",
        "PrintrStmt", "PrintvStmt", "JmpStmt", "JmpcStmt", "CmpeStmt", "CmpltStmt", "CmpgtStmt", "CallStmt",
        "CallrStmt", "PushiStmt", "PushrStmt", "PushvStmt", "PopmStmt", "PopvStmt", "PeekStmt", "PokeStmt",
        "SwpStmt", "AddStmt", "SubStmt", "MulStmt", "DivStmt"
    };
    private static String[] stmts = {
        "decl", "lab", "subr", "ret", "retr", "printi", "printr", "printv", "jmp", "jmpc",
        "cmpe", "cmplt", "cmpgt", "call", "callr", "pushi", "pushr", "pushv", "popm", "popv", "peek", "poke", "swp",
        "add", "sub", "mul", "div"
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
                constructor = class_name.getConstructor(Stmt.class);
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