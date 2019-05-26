package br.unisinos.parthenos.injector.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnnotationAlreadyExistsException extends AbortedException {
  private Class<?> annotationClass;

  @Override
  public String getMessage() {
    return "Annotation '" + this.getAnnotationClass().getName() + "' is already present in specified class";
  }
}
