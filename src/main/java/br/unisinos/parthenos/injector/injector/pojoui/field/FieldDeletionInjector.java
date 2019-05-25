package br.unisinos.parthenos.injector.injector.pojoui.field;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.field.FieldModel;
import br.unisinos.parthenos.injector.injector.pojoui.DeletionInjector;
import br.unisinos.parthenos.pojoui.annotation.Field;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import lombok.Getter;

@Name("remove-field")
@Language("pojo-ui")
@Model(FieldModel.class)
@Target(CompilationUnit.class)
@Getter
public class FieldDeletionInjector extends DeletionInjector<FieldModel> {
  public FieldDeletionInjector(FieldModel model) {
    super(model, Field.class);
  }

  @Override
  protected NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return FieldWithAnnotations.forName(this.getModel().getAttributeName(), this.getModel().getClassName(), parsedSource);
  }
}
