package br.unisinos.parthenos.injector.injector.pojoui;

import br.unisinos.parthenos.injector.exception.AnnotationAlreadyExistsException;
import br.unisinos.parthenos.injector.injector.model.pojoui.CreationModel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.google.common.base.Strings;
import lombok.Getter;

import java.lang.annotation.Annotation;

@Getter
public abstract class CreationInjector<M extends CreationModel> extends AnnotationInjector<M> {
  private static final String LABEL = "label";
  private static final String POSITION = "position";
  private static final String VISIBLE = "visible";

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

  private void createMembers(NormalAnnotationExpr normalAnnotation) {
    final CreationModel creationModel = this.getModel();

    if (creationModel.getLabel() != null) {
      normalAnnotation.addPair(LABEL, this.getLabelExpression());
    }

    if (creationModel.getPosition() != 0) {
      normalAnnotation.addPair(POSITION, this.getPositionExpression());
    }

    if (!creationModel.isVisible()) {
      normalAnnotation.addPair(VISIBLE, this.getVisibilityExpression());
    }
  }

  private boolean areMembersDefault() {
    final CreationModel creationModel = this.getModel();

    return Strings.isNullOrEmpty(creationModel.getLabel())
        && creationModel.isVisible()
        && creationModel.getPosition() == 0;
  }

  private boolean createAnnotation(NodeWithAnnotations<?> nodeWithAnnotations) {
    if (this.areMembersDefault()) {
      nodeWithAnnotations.addMarkerAnnotation(this.getAnnotationClass());
    } else {
      final NormalAnnotationExpr normalAnnotation = nodeWithAnnotations.addAndGetAnnotation(this.getAnnotationClass());
      this.createMembers(normalAnnotation);
    }

    return true;
  }

  @Override
  protected boolean injectAnnotation(NodeWithAnnotations<?> nodeWithAnnotations, CompilationUnit compilationUnit) {
    if (nodeWithAnnotations.isAnnotationPresent(this.getAnnotationClass())) {
      throw new AnnotationAlreadyExistsException(this.getAnnotationClass());
    }

    return this.createAnnotation(nodeWithAnnotations);
  }
}
