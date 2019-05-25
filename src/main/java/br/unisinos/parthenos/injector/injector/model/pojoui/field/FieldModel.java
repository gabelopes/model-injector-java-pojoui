package br.unisinos.parthenos.injector.injector.model.pojoui.field;

import br.unisinos.parthenos.injector.injector.model.pojoui.ClassModel;
import com.jsoniter.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldModel extends ClassModel {
  @JsonProperty(value = "attribute", required = true)
  private String attributeName;
}
