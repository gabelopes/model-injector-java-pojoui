package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.exception.AnnotationNotFoundException;
import br.unisinos.parthenos.injector.injector.model.Model;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.Objects;

@Getter
public abstract class AnnotationMemberInjector<M extends Model> extends AnnotationInjector<M> {
  private Class<? extends Annotation> annotationClass;

  public AnnotationMemberInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model);
    this.annotationClass = annotationClass;
  }

  protected abstract MemberValuePair getMember();

  private void createMember(NormalAnnotationExpr annotation) {
    final MemberValuePair member = this.getMember();

    annotation.addPair(member.getNameAsString(), member.getValue());
  }

  private boolean existsMember(MemberValuePair member) {
    return Objects.equals(member.getNameAsString(), this.getMember().getNameAsString());
  }

  private void removeMember(NormalAnnotationExpr normalAnnotation) {
    normalAnnotation
      .getPairs()
      .removeIf(this::existsMember);
  }

  private NormalAnnotationExpr createNormalAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, AnnotationExpr annotation) {
    if (annotation.isNormalAnnotationExpr()) {
      return (NormalAnnotationExpr) annotation;
    }

    nodeWithAnnotations.getAnnotations().remove(annotation);

    return nodeWithAnnotations.addAndGetAnnotation(this.getAnnotationClass());
  }

  @Override
  public boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit parsedSource) {
    final AnnotationExpr annotation = nodeWithAnnotations.getAnnotationByClass(this.getAnnotationClass()).orElse(null);

    if (annotation == null) {
      throw new AnnotationNotFoundException(this.getAnnotationClass());
    }

    final NormalAnnotationExpr normalAnnotation = this.createNormalAnnotation(nodeWithAnnotations, annotation);

    this.removeMember(normalAnnotation);
    this.createMember(normalAnnotation);

    nodeWithAnnotations.getAnnotations().sort(Comparator.comparing(NodeWithName::getNameAsString));

    return true;
  }
}
