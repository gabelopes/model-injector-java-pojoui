package br.unisinos.parthenos.injector.injector.pojoui.field;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.field.FieldCreationModel;
import br.unisinos.parthenos.injector.injector.pojoui.CreationInjector;
import br.unisinos.parthenos.pojoui.annotation.Field;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

@Name("create-field")
@Language("pojo-ui")
@Model(FieldCreationModel.class)
@Target(CompilationUnit.class)
@Getter
public class FieldCreationInjector extends CreationInjector<FieldCreationModel> {
  public FieldCreationInjector(FieldCreationModel model) {
    super(model, Field.class);
  }

  @Override
  protected NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return FieldWithAnnotations.forName(this.getModel().getAttributeName(), this.getModel().getClassName(), parsedSource);
  }
}
