package br.unisinos.parthenos.injector.injector.model.pojoui;

import com.jsoniter.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisibilityModel extends ClassModel {
  @JsonProperty(required = true)
  private boolean visible;
}
