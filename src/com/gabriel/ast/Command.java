package com.gabriel.ast;

import java.util.ArrayList;

public abstract class Command {
    public abstract String generateJavaCode();

    public abstract ArrayList<String> getUsedSymbols();
}
