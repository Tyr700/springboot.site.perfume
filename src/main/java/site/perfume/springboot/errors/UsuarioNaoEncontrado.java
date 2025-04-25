package site.perfume.springboot.errors;

public class UsuarioNaoEncontrado extends RuntimeException {

  private String aviso;

  public UsuarioNaoEncontrado () {
    this.aviso = "Usuário não Encontrado";
  }

  public String getAviso() {
    return aviso;
  }

  public void setAviso(String aviso) {
    this.aviso = aviso;
  }
}
