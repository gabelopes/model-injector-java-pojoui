package br.unisinos.parthenos.injector.enumeration;

import br.unisinos.parthenos.injector.pool.SourceLanguage;

public enum PojoUISourceLanguage implements SourceLanguage {
  POJO_UI(".java");

  String[] extensions;

  PojoUISourceLanguage(String... extensions) {
    this.extensions = extensions;
  }

  @Override
  public String getName() {
    return this.name().replace("_", "-").toLowerCase();
  }

  public String[] getExtensions() {
    return this.extensions;
  }
}
