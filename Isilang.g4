grammar Isilang;

@header {
    import com.gabriel.datastructure.Symbol;
    import com.gabriel.datastructure.Variable;
    import com.gabriel.datastructure.SymbolTable;
    import com.gabriel.exceptions.SemanticException;
    import com.gabriel.ast.Program;
    import com.gabriel.ast.Command;
    import com.gabriel.ast.LeituraCommand;
    import com.gabriel.ast.EscritaCommand;
    import com.gabriel.ast.AtribuicaoCommand;
    import com.gabriel.ast.DecisaoCommand;
    import com.gabriel.ast.RepeticaoCommand;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members {
    private int _tipo;
    private String _varName;
    private String _varValue;
    private SymbolTable table = new SymbolTable();
    private Symbol symbol;
    private Program program = new Program();
    private ArrayList<Command> curThread;
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    private String _readID;
    private String _writeID;
    private String _exprID;
    private String _exprContent;
    private String _exprDecision;
    private String _whileDecision;

    private ArrayList<Command> listaTrue;
    private ArrayList<Command> listaFalse;
    private ArrayList<Command> listaWhile;

    private ArrayList<Variable> listaSymbolAttr = new ArrayList<Variable>();
    private String leftID;
    private String rigthID;

    public void verificaID(String id) {
    if (!table.exists(id))
        throw new SemanticException("Symbol "+ id + " not declared");
    }
    public void exibeComandos() {
        for (Command c : program.getComandos()) {
            System.out.println(c);
        }
    }
    public void generateCode() {
        program.generateTarget();
    }
 }



prog       : 'programa' decl bloco 'fimprog;'
            {
                program.setVartable(table);
                program.setComandos(stack.pop());
              };


decl       : (declaravar)+;

declaravar : tipo ID {
                    _varName = _input.LT(-1).getText();
                    _varValue = null;
                    symbol = new Variable(_varName, _tipo, _varValue);
                    if(!table.exists(_varName)) {
                         table.add(symbol);
                    } else {
                        throw new SemanticException("Symbol "+_varName+" already declared");
                    }
                    } (VIR ID {
                                                  _varName = _input.LT(-1).getText();
                                                  _varValue = null;
                                                  symbol = new Variable(_varName, _tipo, _varValue);
                                                  if(!table.exists(_varName)) {
                                                       table.add(symbol);
                                                  } else {
                                                      throw new SemanticException("Symbol "+_varName+" already declared");
                                                  }
                                                }
                                               )* SC;

tipo       : 'numero' { _tipo = Variable.NUMBER; }
           | 'texto' { _tipo = Variable.TEXT; };

bloco      : { curThread = new ArrayList<Command>();
               stack.push(curThread);
}               (cmd)+;

cmd        :
            cmdleitura  |
            cmdescrita  |
            cmdattrib   |
            cmdselecao  |
            cmdrepeticao;

cmdleitura : 'leia' AP ID {
                            verificaID(_input.LT(-1).getText());
                            _readID = _input.LT(-1).getText();
                            }
                            FP SC {
                            Variable var = (Variable) table.get(_readID);
                            LeituraCommand cmd = new LeituraCommand(_readID, var);
                            stack.peek().add(cmd);
                            };

cmdescrita : 'escreva' AP ( ID {
                                verificaID(_input.LT(-1).getText());
                                _writeID = _input.LT(-1).getText();
                                }
                            | STRING {  _writeID = _input.LT(-1).getText(); }
                            | NUMBER {  _writeID = _input.LT(-1).getText(); }
                            )
                            FP
                            SC
                            {
                                EscritaCommand cmd = new EscritaCommand(_writeID);
                                stack.peek().add(cmd);
                                                        };

cmdattrib  : ID {
                verificaID(_input.LT(-1).getText());
                _exprID = _input.LT(-1).getText();
                leftID = _input.LT(-1).getText();
                } ATTR { _exprContent = ""; }
                expr
                SC {
                    AtribuicaoCommand cmd = new AtribuicaoCommand(_exprID, _exprContent, (Variable) table.get(leftID), listaSymbolAttr);
                    stack.peek().add(cmd);
                };

cmdrepeticao : 'enquanto' AP (ID {
                                verificaID(_input.LT(-1).getText());
                                leftID = _input.LT(-1).getText();
}                           | NUMBER) { _whileDecision = _input.LT(-1).getText(); }
                             OPREL { _whileDecision += _input.LT(-1).getText(); }
                             (ID {
                                  verificaID(_input.LT(-1).getText());
                                  rigthID = _input.LT(-1).getText();
                             } | NUMBER) { _whileDecision += _input.LT(-1).getText();
                                            }
                             FP
                             ACH {
                                curThread = new ArrayList<Command>();
                                stack.push(curThread);
                                }
                             (cmd)+
                             FCH {
                                  listaWhile = stack.pop();
                                  RepeticaoCommand cmd = new RepeticaoCommand(_whileDecision, listaWhile,(Variable) table.get(leftID), (Variable) table.get(rigthID));
                                  stack.peek().add(cmd);
                                };

cmdselecao : 'se' AP
                    ID {
                            verificaID(_input.LT(-1).getText());
                            _exprDecision = _input.LT(-1).getText();
                            leftID = _exprDecision;
                    }
                    OPREL { _exprDecision += _input.LT(-1).getText();}
                    (ID {
                         verificaID(_input.LT(-1).getText());
                         rigthID = _input.LT(-1).getText();
                     }| NUMBER) { _exprDecision += _input.LT(-1).getText();
                                    }
                    FP
                    ACH { curThread = new ArrayList<Command>();
                          stack.push(curThread);  }
                    (cmd)+
                    FCH {
                        listaTrue = stack.pop();
                    }
                    ('senao' ACH
                                { curThread = new ArrayList<Command>();
                                  stack.push(curThread);  }
                                (cmd+) FCH {
                                       listaFalse = stack.pop();

                                } )? {
                                    DecisaoCommand cmd = new DecisaoCommand(_exprDecision, listaTrue, listaFalse, (Variable) table.get(leftID), (Variable) table.get(rigthID));
                                    stack.peek().add(cmd);
                                };

expr        : termo ( OP { _exprContent += _input.LT(-1).getText(); } termo )*;

termo       : ID { verificaID(_input.LT(-1).getText());
                    _exprContent += _input.LT(-1).getText();
                    listaSymbolAttr.add((Variable) table.get(_input.LT(-1).getText()));
                } | NUMBER {
                    _exprContent += _input.LT(-1).getText();
                } | STRING ;

AP          : '(';
FP          : ')';
SC          : ';';
OP          : '+' | '-' | '*' | '/';
ATTR        : '=';
VIR         : ',';
ACH         : '{';
FCH         : '}';
OPREL       : '>' | '<' | '>=' | '<=' | '==' | '!=';
ID          : [a-z] ([a-z] | [A-Z] | [0-9])*;
NUMBER      : [0-9]+ ('.' [0-9]+)?;
STRING      : '"' .*? '"';
WS          : (' ' | '\t' | '\n' | '\r') -> skip;