package br.unisinos.parthenos.injector.injector.pojoui.field;

import br.unisinos.parthenos.injector.annotation.Language;
import br.unisinos.parthenos.injector.annotation.Model;
import br.unisinos.parthenos.injector.annotation.Name;
import br.unisinos.parthenos.injector.annotation.Target;
import br.unisinos.parthenos.injector.injector.model.pojoui.field.FieldVisibilityModel;
import br.unisinos.parthenos.injector.injector.pojoui.VisibilityInjector;
import br.unisinos.parthenos.pojoui.annotation.Field;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;

@Name("set-field-visibility")
@Language("pojo-ui")
@Model(FieldVisibilityModel.class)
@Target(CompilationUnit.class)
public class FieldVisibilityInjector extends VisibilityInjector<FieldVisibilityModel> {
  public FieldVisibilityInjector(FieldVisibilityModel model) {
    super(model, Field.class);
  }

  @Override
  protected NodeWithAnnotations<?> getNode(CompilationUnit parsedSource) {
    return FieldWithAnnotations.forName(this.getModel().getAttributeName(), this.getModel().getClassName(), parsedSource);
  }
}
