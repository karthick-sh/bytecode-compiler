import java.io.*;

public class Main {
    public static void main(String [] args){
        if(args.length != 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }

        String input_file = args[0];

        StatementFactory.initializeStatements();

        // The following lines are adapted from Professor Midkiff's Notes
        // available at https://engineering.purdue.edu/~smidkiff/ece30862/slides/CompilerHintsB.pdf
        BufferedReader file_reader = null;
        try {
            file_reader = new BufferedReader(new FileReader(input_file));
            String line = file_reader.readLine();
            while (line != null) {
                parseLine(line);
                line = file_reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static void parseLine(String line){
        // The following lines are adapted from Professor Midkiff's Notes
        // available at https://engineering.purdue.edu/~smidkiff/ece30862/slides/CompilerHintsB.pdf
        line = line.trim( );
        line = line.replaceAll(",", " , ");
        line = line.replaceAll("\\s+", " ");
        String[ ] tokens = line.split("\\s");
        String token = tokens[0];

        //Grab opcode
        if (token != null) {
            if (token.matches("decl|lab|subr|ret|retr|printi|printr|printv|jmp|jmpc|cmpe|cmplt|cmpgt|call|callr|pushi|pushr|pushv|popm|popv|peek|poke|swp|add|sub|mul|div")) {
                Stmt stmt = StatementFactory.getStatement(token);
                // stmt.genCode(tokens);
                System.out.println(token);
            } 
            else {
                System.out.println("Unknown stmt: "+token);
            }
        }
    }
}