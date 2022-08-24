package com.gabriel.ast;

import com.gabriel.datastructure.Symbol;
import com.gabriel.datastructure.Variable;
import com.gabriel.exceptions.SemanticException;

import java.util.ArrayList;

public class AtribuicaoCommand extends Command{
    private String id;
    private String expr;

    private Variable leftID;

    private ArrayList<Variable> rightIDs;

    public AtribuicaoCommand(String id, String expr, Variable leftID, ArrayList<Variable> rightIDs) {
        this.id = id;
        this.expr = expr;
        this.leftID = leftID;
        this.rightIDs = rightIDs;
        verifyTypes();
    }

    @Override
    public String generateJavaCode() {
        return id + " = " + expr+";";
    }

    @Override
    public ArrayList<String> getUsedSymbols() {
        ArrayList<String> list = new ArrayList<>();
        rightIDs.add(leftID);

        for (Variable r : rightIDs) {
            list.add(r.getName());
        }
        return list;
    }

    @Override
    public String toString() {
        return "AtribuicaoCommand{" +
                "id='" + id + '\'' +
                ", expr='" + expr + '\'' +
                '}';
    }

    private void verifyTypes(){
        for (Variable lv : rightIDs) {
            if (leftID.getType() != lv.getType()) {
                throw new SemanticException("Mismatched variables type: "+leftID.getName() + ", "+ lv.getName());
            }
        }
    }
}
