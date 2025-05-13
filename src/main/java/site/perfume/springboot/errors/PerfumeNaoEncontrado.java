package site.perfume.springboot.errors;

public class PerfumeNaoEncontrado extends RuntimeException {

    private String avisop;

    public PerfumeNaoEncontrado(String avisop) {
        this.avisop = "Este Perfume não foi encontrado";
    }

    public String getAvisop() {
        return avisop;
    }

    public void setAvisop(String avisop) {
        this.avisop = avisop;
    }
}
