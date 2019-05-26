package br.unisinos.parthenos.injector.injector.model.pojoui.field;

import br.unisinos.parthenos.injector.injector.model.pojoui.CreationModel;
import com.jsoniter.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldCreationModel extends CreationModel {
  @JsonProperty(value = "attribute", required = true)
  private String attributeName;
}
