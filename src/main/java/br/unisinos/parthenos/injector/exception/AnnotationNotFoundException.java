package br.unisinos.parthenos.injector.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnnotationNotFoundException extends AbortedException {
  private Class<?> annotationClass;

  @Override
  public String getMessage() {
    return "Could not find annotation '" + this.getAnnotationClass().getName() + "' in specified class";
  }
}
