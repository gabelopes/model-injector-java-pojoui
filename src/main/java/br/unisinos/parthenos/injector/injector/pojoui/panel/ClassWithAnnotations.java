package br.unisinos.parthenos.injector.injector.pojoui.panel;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

public class ClassWithAnnotations {
  public static NodeWithAnnotations<?> forName(String name, CompilationUnit parsedSource) {
    return parsedSource.getClassByName(name).orElse(null);
  }
}
