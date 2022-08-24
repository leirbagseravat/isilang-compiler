package com.gabriel.ast;

import com.gabriel.datastructure.Symbol;
import com.gabriel.datastructure.SymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Program {
    private SymbolTable vartable;
    private ArrayList<Command> comandos;
    private String programName;

    public void generateTarget() {
        HashSet<String> allUsedSymbols = new HashSet<>();
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner; \n");
        str.append("public class MainClass { \n");
        str.append("    public static void main(String args[]){ \n");
        str.append("        Scanner _key = new Scanner(System.in);\n");
        for (Symbol s :  vartable.getAllSymbols()) {
            str.append("        "+s.generateJavaCode() + " \n");
        }

        for (Command c : comandos) {
            str.append("        "+c.generateJavaCode() + " \n");
            allUsedSymbols.addAll(c.getUsedSymbols());
        }
        str.append("    }\n");
        str.append("}");

        for (Symbol s :  vartable.getAllSymbols()) {
            if(!allUsedSymbols.contains(s.getName())) {
                System.out.println("WARNING: unused variable -> "+s.getName());
            }
        }

        try {
            FileWriter fw = new FileWriter("MainClass.java");
            fw.write(str.toString());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public SymbolTable getVartable() {
        return vartable;
    }

    public void setVartable(SymbolTable vartable) {
        this.vartable = vartable;
    }

    public ArrayList<Command> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<Command> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
