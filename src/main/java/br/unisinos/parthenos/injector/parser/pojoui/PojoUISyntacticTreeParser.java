package br.unisinos.parthenos.injector.parser.pojoui;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Result;
import br.unisinos.parthenos.injector.parser.java.JavaSyntacticTreeParser;
import com.github.javaparser.ast.CompilationUnit;

@Language("pojo-ui")
@Result(CompilationUnit.class)
public class PojoUISyntacticTreeParser extends JavaSyntacticTreeParser {
}
