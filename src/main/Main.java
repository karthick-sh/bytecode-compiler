package src.main;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import src.statement.*;

public class Main {
    private static FileOutputStream output_stream;

    public static Map<String,String> symbol_table = new HashMap<String, String>();
    public static int offset_counter = 0;
    public static int bytecode_offset_counter = 0;
    
    public static void main(String [] args){
        if(args.length != 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }

        String input_file = args[0];
        String output_file_name = input_file.replaceAll(".txt", ".smp");

        output_stream = null;
        try{
            output_stream = new FileOutputStream(output_file_name);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        StatementFactory.initializeStatements();

        // The following lines are adapted from Professor Midkiff's Notes
        // available at https://engineering.purdue.edu/~smidkiff/ece30862/slides/CompilerHintsB.pdf
        BufferedReader file_reader = null;
        try {
            file_reader = new BufferedReader(new FileReader(input_file));
            String line = file_reader.readLine();
            while (line != null) {
                countLine(line);
                line = file_reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 

        file_reader = null;
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

        if(output_stream != null){
            try{
                output_stream.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }

    public static void writeBytecodes(byte[] bytes){
        // StringBuilder sb = new StringBuilder();
        // for (byte b : bytes) {
        //     sb.append(String.format("%02X ", b));
        // }
        // System.out.println(sb.toString());
        try {
            output_stream.write(bytes);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void countLine(String line){
        line = line.trim( );
        line = line.replaceAll(",", " , ");
        line = line.replaceAll("\\s+", " ");
        String[ ] tokens = line.split("\\s");
        String token = tokens[0];

        if (token != null) {
            if (token.matches("subr|ret|decl|printi|printv|jmp|jmpc|cmpe|cmplt|cmpgt|pushi|pushv|popm|popv|peek|poke|swp|add|sub|mul|div")) {
                Stmt stmt = StatementFactory.getStatement(token);
                Main.bytecode_offset_counter += stmt.getCount();
            } 
            else if(token.matches("lab")){
                Stmt stmt = StatementFactory.getStatement(token);
                stmt.genCode(tokens);
            }
            else if(!token.matches("//|/|retr|call|callr|lab|")){
                System.out.println("Unknown stmt: "+token);
            }
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
            if (token.matches("subr|ret|decl|printi|printv|jmp|jmpc|cmpe|cmplt|cmpgt|pushi|pushv|popm|popv|peek|poke|swp|add|sub|mul|div")) {
                Stmt stmt = StatementFactory.getStatement(token);
                stmt.genCode(tokens);
                // System.out.println(token);
            } 
            else if(!token.matches("//|/|retr|call|callr|lab|")){
                System.out.println("Unknown stmt: "+token);
            }
        }
    }
}