package br.unisinos.parthenos.injector.injector.pojoui.panel;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.ClassModel;
import br.unisinos.parthenos.injector.injector.pojoui.DeletionInjector;
import br.unisinos.parthenos.pojoui.annotation.Panel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

@Name("remove-panel")
@Language("pojo-ui")
@Model(ClassModel.class)
@Target(CompilationUnit.class)
@Getter
public class PanelDeletionInjector extends DeletionInjector<ClassModel> {
  public PanelDeletionInjector(ClassModel model) {
    super(model, Panel.class);
  }

  @Override
  public NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return ClassWithAnnotations.forName(this.getModel().getClassName(), parsedSource);
  }
}
