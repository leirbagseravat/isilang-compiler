package com.gabriel.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SymbolTable {

    private HashMap<String, Symbol> map;

    public SymbolTable() {
        map = new HashMap<String, Symbol>();
    }

    public void add(Symbol symbol) {
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbol) {
        return map.get(symbol) != null;
    }

    public Symbol get(String symbol) {
        return map.get(symbol);
    }

    public ArrayList<Symbol> getAllSymbols() {
        ArrayList<Symbol> lista = new ArrayList<>();
        for (Symbol s : map.values()) {
            lista.add(s);
        }
        return lista;
    }
}
