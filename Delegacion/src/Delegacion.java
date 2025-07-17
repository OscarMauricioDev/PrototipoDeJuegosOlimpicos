class Delegacion implements Medallero {

    private String pais;
    private int numeroDeportistas;
    private int medallasOro;
    private int medallasPlata;
    private int medallasBronce;
    private int aniosExactos;

    public Delegacion(String pais, int numeroDeportistas, int medallasOro, int medallasPlata, int medallasBronce, int aniosExactos) {
        this.pais = pais;
        this.numeroDeportistas = numeroDeportistas;
        this.medallasOro = medallasOro;
        this.medallasPlata = medallasPlata;
        this.medallasBronce = medallasBronce;
        this.aniosExactos = aniosExactos;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int getNumeroDeportistas() {
        return numeroDeportistas;
    }

    @Override
    public void setNumeroDeportistas(int numeroDeportistas) {
        this.numeroDeportistas = numeroDeportistas;
    }

    @Override
    public int getMedallasOro() {
        return medallasOro;
    }

    @Override
    public void setMedallasOro(int medallasOro) {
        this.medallasOro = medallasOro;
    }

    @Override
    public int getMedallasPlata() {
        return medallasPlata;
    }

    @Override
    public void setMedallasPlata(int medallasPlata) {
        this.medallasPlata = medallasPlata;
    }

    @Override
    public int getMedallasBronce() {
        return medallasBronce;
    }

    @Override
    public void setMedallasBronce(int medallasBronce) {
        this.medallasBronce = medallasBronce;
    }

    @Override
    public int getAniosExactos() {
        return aniosExactos;
    }

    @Override
    public void setAniosExactos(int aniosExactos) {
        this.aniosExactos = aniosExactos;
    }

    @Override
    public int calcularTotalMedallas() {
        return medallasOro + medallasPlata + medallasBronce;
    }

    @Override
    public void mostrarDelegacion() {
        System.out.println("País: " + pais);
        System.out.println("Número de Deportistas: " + numeroDeportistas);
        System.out.println("Medallas de Oro: " + medallasOro);
        System.out.println("Medallas de Plata: " + medallasPlata);
        System.out.println("Medallas de Bronce: " + medallasBronce);
        System.out.println("Años Exactos: " + aniosExactos);
        System.out.println("Total de Medallas: " + calcularTotalMedallas());

    }
    
}
