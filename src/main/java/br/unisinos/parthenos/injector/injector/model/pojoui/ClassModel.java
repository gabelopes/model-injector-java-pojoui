package br.unisinos.parthenos.injector.injector.model.pojoui;

import br.unisinos.parthenos.injector.injector.model.Model;
import com.jsoniter.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassModel implements Model {
  @JsonProperty(value = "class", required = true)
  private String className;
}
