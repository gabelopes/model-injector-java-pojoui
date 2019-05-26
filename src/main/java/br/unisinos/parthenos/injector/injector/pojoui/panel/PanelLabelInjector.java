package br.unisinos.parthenos.injector.injector.pojoui.panel;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.LabelModel;
import br.unisinos.parthenos.injector.injector.pojoui.LabelInjector;
import br.unisinos.parthenos.pojoui.annotation.Panel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

@Name("set-panel-label")
@Language("pojo-ui")
@Model(LabelModel.class)
@Target(CompilationUnit.class)
public class PanelLabelInjector extends LabelInjector<LabelModel> {
  public PanelLabelInjector(LabelModel model) {
    super(model, Panel.class);
  }

  @Override
  public NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return ClassWithAnnotations.forName(this.getModel().getClassName(), parsedSource);
  }
}
