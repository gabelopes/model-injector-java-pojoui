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
public class CreationModel extends ClassModel {
  @JsonProperty
  private String label;

  @JsonProperty
  private boolean visible = true;

  @JsonProperty
  private int position;
}
