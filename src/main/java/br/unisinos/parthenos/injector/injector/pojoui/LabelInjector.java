package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.pojoui.LabelModel;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.StringLiteralExpr;

import java.lang.annotation.Annotation;

public abstract class LabelInjector<M extends LabelModel> extends AnnotationMemberInjector<M> {
  private static final String LABEL = "label";

  public LabelInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model, annotationClass);
  }

  private StringLiteralExpr getLabelExpression() {
    return new StringLiteralExpr(this.getModel().getLabel());
  }

  @Override
  protected MemberValuePair getMember() {
    return new MemberValuePair(LABEL, this.getLabelExpression());
  }
}
