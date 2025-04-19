package site.perfume.springboot.errors;

public class ConsultorJaExiste extends RuntimeException {

    private String mensagemc;

    public ConsultorJaExiste() {
        this.mensagemc = "Este Consultor já existe";
    }

    public String getMensagemc() {
        return mensagemc;
    }

    public void setMensagemc(String mensagemc) {
        this.mensagemc = mensagemc;
    }
}
