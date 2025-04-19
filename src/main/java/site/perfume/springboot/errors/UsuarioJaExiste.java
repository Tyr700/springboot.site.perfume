package site.perfume.springboot.errors;

public class UsuarioJaExiste extends RuntimeException {
    private String mensagem;


    public UsuarioJaExiste() {
        this.mensagem = "Usuário já existe";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
