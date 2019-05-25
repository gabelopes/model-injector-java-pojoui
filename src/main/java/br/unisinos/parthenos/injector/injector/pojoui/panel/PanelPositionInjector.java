package br.unisinos.parthenos.injector.injector.pojoui.panel;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.CreationModel;
import br.unisinos.parthenos.injector.injector.model.pojoui.PositionModel;
import br.unisinos.parthenos.injector.injector.pojoui.AnnotationMemberInjector;
import br.unisinos.parthenos.injector.injector.pojoui.PositionInjector;
import br.unisinos.parthenos.pojoui.annotation.Panel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

import java.lang.annotation.Annotation;

@Name("set-panel-position")
@Language("pojo-ui")
@Model(PositionModel.class)
@Target(CompilationUnit.class)
public class PanelPositionInjector extends PositionInjector<PositionModel> {
  public PanelPositionInjector(PositionModel model) {
    super(model, Panel.class);
  }

  @Override
  public NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return ClassWithAnnotations.forName(this.getModel().getClassName(), parsedSource);
  }
}
