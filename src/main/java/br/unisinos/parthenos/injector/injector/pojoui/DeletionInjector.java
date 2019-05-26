package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.exception.AnnotationNotFoundException;
import br.unisinos.parthenos.injector.injector.model.pojoui.ClassModel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.AnnotationExpr;
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

  private boolean removeAnnotation(NodeWithAnnotations<?> nodeWithAnnotations) {
    final AnnotationExpr annotation = nodeWithAnnotations.getAnnotationByClass(this.getAnnotationClass()).orElse(null);

    if (annotation == null) {
      throw new AnnotationNotFoundException(this.getAnnotationClass());
    }

    return nodeWithAnnotations.getAnnotations().remove(annotation);
  }

  @Override
  protected boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit compilationUnit) {
    return removeAnnotation(nodeWithAnnotations);
  }
}
