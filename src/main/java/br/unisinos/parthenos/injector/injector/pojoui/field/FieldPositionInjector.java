package br.unisinos.parthenos.injector.injector.pojoui.field;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.field.FieldPositionModel;
import br.unisinos.parthenos.injector.injector.pojoui.PositionInjector;
import br.unisinos.parthenos.pojoui.annotation.Field;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

@Name("set-field-position")
@Language("pojo-ui")
@Model(FieldPositionModel.class)
@Target(CompilationUnit.class)
public class FieldPositionInjector extends PositionInjector<FieldPositionModel> {
  public FieldPositionInjector(FieldPositionModel model) {
    super(model, Field.class);
  }

  @Override
  protected NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return FieldWithAnnotations.forName(this.getModel().getAttributeName(), this.getModel().getClassName(), parsedSource);
  }
}
