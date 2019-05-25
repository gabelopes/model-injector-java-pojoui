package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.injector.model.pojoui.CreationModel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

import java.lang.annotation.Annotation;

@Getter
public abstract class CreationInjector<M extends CreationModel> extends AnnotationInjector<M> {
  private static final String LABEL = "label";
  private static final String VISIBLE = "visible";
  private static final String POSITION = "position";

  private Class<? extends Annotation> annotationClass;

  public CreationInjector(M model, Class<? extends Annotation> annotationClass) {
    super(model);
    this.annotationClass = annotationClass;
  }

  private StringLiteralExpr getLabelExpression() {
    return new StringLiteralExpr(this.getModel().getLabel());
  }

  private BooleanLiteralExpr getVisibilityExpression() {
    return new BooleanLiteralExpr(this.getModel().isVisible());
  }

  private IntegerLiteralExpr getPositionExpression() {
    return new IntegerLiteralExpr(this.getModel().getPosition());
  }

  @Override
  protected boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit compilationUnit) {
    if (nodeWithAnnotations.isAnnotationPresent(this.getAnnotationClass())) { return false; }

    final CreationModel creationModel = this.getModel();
    final NormalAnnotationExpr normalAnnotation = nodeWithAnnotations.addAndGetAnnotation(this.getAnnotationClass());

    if (creationModel.getLabel() != null) {
      normalAnnotation.addPair(LABEL, this.getLabelExpression());
    }

    if (!creationModel.isVisible()) {
      normalAnnotation.addPair(VISIBLE, this.getVisibilityExpression());
    }

    if (creationModel.getPosition() != 0) {
      normalAnnotation.addPair(POSITION, this.getPositionExpression());
    }

    return true;
  }
}
