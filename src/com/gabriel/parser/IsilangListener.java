// Generated from Isilang.g4 by ANTLR 4.7.1
package com.gabriel.parser;

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsilangParser}.
 */
public interface IsilangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsilangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsilangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsilangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsilangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsilangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsilangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsilangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsilangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsilangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsilangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsilangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsilangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsilangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsilangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsilangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsilangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsilangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsilangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsilangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepeticao(IsilangParser.CmdrepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepeticao(IsilangParser.CmdrepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(IsilangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(IsilangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsilangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsilangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsilangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsilangParser.TermoContext ctx);
}