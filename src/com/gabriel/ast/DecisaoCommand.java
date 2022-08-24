package com.gabriel.ast;


import com.gabriel.datastructure.Variable;
import com.gabriel.exceptions.SemanticException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DecisaoCommand extends Command {

    private String condition;

    private ArrayList<Command> listaTrue;

    private ArrayList<Command> listaFalse;

    private Variable rightID;

    private Variable leftID;

    public DecisaoCommand(String condition, ArrayList<Command> lt, ArrayList<Command> lf, Variable leftID, Variable rightID) {
        this.condition = condition;
        this.listaTrue = lt;
        this.listaFalse = lf;
        this.rightID = rightID;
        this.leftID = leftID;
        this.verifyTypes();
    }

    @Override
    public String toString() {
        return "DecisaoCommand{" +
                "condition='" + condition + '\'' +
                ", listaTrue=" + listaTrue +
                ", listaFalse=" + listaFalse +
                '}';
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("if (" + condition + ") {\n");
        for (Command c : listaTrue) {
            str.append("            "+c.generateJavaCode()+" \n");
        }
        str.append("        } ");
        if (listaFalse != null && !listaFalse.isEmpty()) {
            str.append("else {\n");
            for (Command c : listaFalse) {
                str.append("        "+c.generateJavaCode()+" \n");
            }
            str.append("        }");
        }
        return str.toString();
    }

    @Override
    public ArrayList<String> getUsedSymbols() {
        return new ArrayList<>(Arrays.asList(leftID.getName(), rightID.getName()));
    }

    private void verifyTypes(){
        if (leftID.getType() != rightID.getType()) {
            throw new SemanticException("Mismatched variables type: "+leftID.getName() + ", "+ rightID.getName());
        }
    }
}
