public interface Medallero {

    String getPais();
    void setPais(String pais);
    int getNumeroDeportistas();
    void setNumeroDeportistas(int numeroDeportistas);
    int getMedallasOro();
    void setMedallasOro(int medallasOro);
    int getMedallasPlata();
    void setMedallasPlata(int medallasPlata);
    int getMedallasBronce();
    void setMedallasBronce(int medallasBronce);
    int getAniosExactos();
    void setAniosExactos(int aniosExactos);
    int calcularTotalMedallas();
    void mostrarDelegacion();
    
}
