package site.perfume.springboot.errors;

public class PerfumeJaExiste extends RuntimeException {

    private String mensagemp;

    public PerfumeJaExiste() {
        this.mensagemp = "Este perfume ja existe";
    }

    public String getMensagemp() {
        return mensagemp;
    }

    public void setMensagemp(String mensagemp) {
        this.mensagemp = mensagemp;
    }
}
