package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.Injector;
import br.unisinos.parthenos.injector.injector.model.Model;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

public abstract class AnnotationInjector<M extends Model> extends Injector<CompilationUnit, M> {
  public AnnotationInjector(M model) {
    super(model);
  }

  protected abstract NodeWithAnnotations<?> getNode(CompilationUnit parsedSource);
  protected abstract boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit parsedSource);

  @Override
  public boolean inject(CompilationUnit parsedSource) {
    return this.injectAnnotation(this.getNode(parsedSource), parsedSource);
  }
}
