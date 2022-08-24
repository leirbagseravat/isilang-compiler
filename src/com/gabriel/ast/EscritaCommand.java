package com.gabriel.ast;

import java.util.ArrayList;
import java.util.Arrays;

public class EscritaCommand extends Command{

    private String id;

    public EscritaCommand(String id) {
        this.id = id;
    }

    @Override
    public String generateJavaCode() {
        return "System.out.println("+id+");";
    }

    @Override
    public ArrayList<String> getUsedSymbols() {
        return new ArrayList<>(Arrays.asList(id));
    }

    @Override
    public String toString() {
        return "EscritaCommand{" +
                "id='" + id + '\'' +
                '}';
    }


}
