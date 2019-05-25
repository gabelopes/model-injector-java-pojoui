package br.unisinos.parthenos.injector.injector.pojoui.field;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

public class FieldWithAnnotations {
  private static ClassOrInterfaceDeclaration getClassDeclaration(String name, CompilationUnit parsedSource) {
    return parsedSource.getClassByName(name).orElse(null);
  }

  public static NodeWithAnnotations<?> forName(String name, String className, CompilationUnit parsedSource) {
    final ClassOrInterfaceDeclaration classDeclaration = FieldWithAnnotations.getClassDeclaration(className, parsedSource);
    return classDeclaration.getFieldByName(name).orElse(null);
  }
}
