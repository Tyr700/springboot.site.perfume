package site.perfume.springboot.errors;

public class ConsultorNaoEncontrado extends RuntimeException {

    private String avisoc;

    public ConsultorNaoEncontrado () {
        this.avisoc = "Este Consultor não foi Encontrado";
    }

    public String getAvisoc() {
        return avisoc;
    }

    public void setAvisoc(String avisoc) {
        this.avisoc = avisoc;
    }
}
