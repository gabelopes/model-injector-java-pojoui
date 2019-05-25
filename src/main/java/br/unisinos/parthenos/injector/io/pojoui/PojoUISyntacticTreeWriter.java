package br.unisinos.parthenos.injector.io.pojoui;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.io.java.JavaSyntacticTreeWriter;
import com.github.javaparser.ast.CompilationUnit;

@Language("pojo-ui")
@Target(CompilationUnit.class)
public class PojoUISyntacticTreeWriter extends JavaSyntacticTreeWriter {
}
