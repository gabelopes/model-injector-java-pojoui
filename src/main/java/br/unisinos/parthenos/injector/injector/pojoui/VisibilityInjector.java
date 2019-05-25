package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.pojoui.VisibilityModel;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.MemberValuePair;

import java.lang.annotation.Annotation;

public abstract class VisibilityInjector<M extends VisibilityModel> extends AnnotationMemberInjector<M> {
  private static final String VISIBLE = "visible";

  public VisibilityInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model, annotationClass);
  }

  private BooleanLiteralExpr getVisibilityExpression() {
    return new BooleanLiteralExpr(this.getModel().isVisible());
  }

  @Override
  protected MemberValuePair getMember() {
    return new MemberValuePair(VISIBLE, this.getVisibilityExpression());
  }
}
