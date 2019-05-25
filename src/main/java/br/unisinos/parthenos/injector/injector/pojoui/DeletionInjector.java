package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.pojoui.ClassModel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

import java.lang.annotation.Annotation;

@Getter
public abstract class DeletionInjector<M extends ClassModel> extends AnnotationInjector<M> {
  private Class<? extends Annotation> annotationClass;

  public DeletionInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model);
    this.annotationClass = annotationClass;
  }

  @Override
  protected boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit compilationUnit) {
    nodeWithAnnotations
      .getAnnotationByClass(this.getAnnotationClass())
      .ifPresent(Node::remove);

    return true;
  }
}
