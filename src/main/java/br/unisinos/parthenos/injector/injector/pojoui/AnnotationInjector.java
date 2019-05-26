package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.enumeration.Status;
import br.unisinos.parthenos.injector.injector.Injector;
import br.unisinos.parthenos.injector.injector.model.Model;
import br.unisinos.parthenos.injector.result.InjectResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

import java.io.File;

public abstract class AnnotationInjector<M extends Model> extends Injector<CompilationUnit, M> {
  public AnnotationInjector(M model) {
    super(model);
  }

  protected abstract NodeWithAnnotations<?> getNode(CompilationUnit parsedSource);
  protected abstract boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit parsedSource);

  @Override
  public InjectResult<CompilationUnit> inject(CompilationUnit parsedSource, File sourceFile) {
    final boolean injected = this.injectAnnotation(this.getNode(parsedSource), parsedSource);

    if (injected) {
      return new InjectResult<>(Status.SUCCESS, parsedSource, sourceFile);
    }

    return new InjectResult<>(Status.UNKNOWN);
  }
}
