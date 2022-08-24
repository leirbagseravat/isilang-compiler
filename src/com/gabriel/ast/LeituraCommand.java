package com.gabriel.ast;

import com.gabriel.datastructure.Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class LeituraCommand extends Command{

    private String id;

    private Variable var;

    public LeituraCommand(String id, Variable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {
        return id + " = _key." + (var.getType() == Variable.NUMBER ? "nextDouble();" : "nextLine();");
    }

    @Override
    public ArrayList<String> getUsedSymbols() {
        return new ArrayList<>(Arrays.asList(id));
    }

    @Override
    public String toString() {
        return "LeituraCommand{" +
                "id='" + id + '\'' +
                '}';
    }
}
