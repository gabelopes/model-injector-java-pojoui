package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.pojoui.PositionModel;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MemberValuePair;

import java.lang.annotation.Annotation;

public abstract class PositionInjector<M extends PositionModel> extends AnnotationMemberInjector<M> {
  private static final String POSITION = "position";

  public PositionInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model, annotationClass);
  }

  private IntegerLiteralExpr getPositionExpression() {
    return new IntegerLiteralExpr(this.getModel().getPosition());
  }

  @Override
  protected MemberValuePair getMember() {
    return new MemberValuePair(POSITION, this.getPositionExpression());
  }
}
