package br.unisinos.parthenos.injector.injector.pojoui.panel;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.CreationModel;
import br.unisinos.parthenos.injector.injector.pojoui.CreationInjector;
import br.unisinos.parthenos.pojoui.annotation.Panel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

@Name("create-panel")
@Language("pojo-ui")
@Model(CreationModel.class)
@Target(CompilationUnit.class)
@Getter
public class PanelCreationInjector extends CreationInjector<CreationModel> {
  public PanelCreationInjector(CreationModel model) {
    super(model, Panel.class);
  }

  @Override
  public NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return ClassWithAnnotations.forName(this.getModel().getClassName(), parsedSource);
  }
}
