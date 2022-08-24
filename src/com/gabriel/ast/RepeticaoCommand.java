package com.gabriel.ast;

import com.gabriel.datastructure.Variable;
import com.gabriel.exceptions.SemanticException;

import java.util.ArrayList;
import java.util.Arrays;

public class RepeticaoCommand extends Command{

    private String condition;

    private ArrayList<Command> listaWhile;

    private Variable leftID;

    private Variable rightID;

    public RepeticaoCommand(String condition, ArrayList<Command> listaWhile, Variable leftID, Variable rightID) {
        this.condition = condition;
        this.listaWhile = listaWhile;
        this.rightID = rightID;
        this.leftID = leftID;
        verifyTypes();
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("while (" + condition + ") {\n");
        for (Command c : listaWhile) {
            str.append("            "+c.generateJavaCode()+" \n");
        }
        str.append("        }");

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
