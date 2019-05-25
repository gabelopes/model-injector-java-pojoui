package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.Model;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.util.Objects;

@Getter
public abstract class AnnotationMemberInjector<M extends Model> extends AnnotationInjector<M> {
  private Class<? extends Annotation> annotationClass;

  public AnnotationMemberInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model);
    this.annotationClass = annotationClass;
  }

  protected abstract MemberValuePair getMember();

  private void addMember(NormalAnnotationExpr annotation) {
    final MemberValuePair member = this.getMember();

    annotation.addPair(member.getNameAsString(), member.getValue());
  }

  private NormalAnnotationExpr createNormalAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, AnnotationExpr annotation) {
    if (annotation.isNormalAnnotationExpr()) {
      return (NormalAnnotationExpr) annotation;
    }

    annotation.remove();

    return nodeWithAnnotations.addAndGetAnnotation(this.getAnnotationClass());
  }

  private void removeMember(NormalAnnotationExpr normalAnnotation) {
    normalAnnotation
      .getPairs()
      .removeIf(member -> Objects.equals(member.getNameAsString(), this.getMember().getNameAsString()));
  }

  @Override
  public boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit parsedSource) {
    final AnnotationExpr annotation = nodeWithAnnotations.getAnnotationByClass(this.getAnnotationClass()).orElse(null);

    if (annotation == null) { return false; }

    final NormalAnnotationExpr normalAnnotation = this.createNormalAnnotation(nodeWithAnnotations, annotation);

    this.removeMember(normalAnnotation);
    this.addMember(normalAnnotation);

    return true;
  }
}
