/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author urieldiaz
 */
public class SolicitudPreconsulta {
    private int idSexo;
    private int silla;
    private int camilla;
    private int baston;
    private int oxigeno;
    private int estudioPrevio;
    private int biopsiaPrevia;
    private int identificacion;
    private int comprobante;
    private int curp;
    private int referencia;
    private int mastografia;
    private int ultrasonido;

    public SolicitudPreconsulta()
    {
        
    }

    @Override
    public String toString() {
        String str = "SolicitudPreconsulta[idSexo:".concat(String.valueOf(idSexo))
        .concat(",silla:").concat(String.valueOf(silla))
        .concat(",camilla:").concat(String.valueOf(camilla))
        .concat(",baston:").concat(String.valueOf(baston))
        .concat(",oxigeno:").concat(String.valueOf(oxigeno))
        .concat(",estudioPrevio:").concat(String.valueOf(estudioPrevio))
        .concat(",biopsiaPrevia:").concat(String.valueOf(biopsiaPrevia))
        .concat(",identificacion:").concat(String.valueOf(identificacion)
        .concat(",comprobante:").concat(String.valueOf(comprobante))
        .concat(",curp:").concat(String.valueOf(curp))
        .concat(",referencia:").concat(String.valueOf(referencia))
        .concat(",mastografia:").concat(String.valueOf(mastografia))
        .concat(",ultrasonido:").concat(String.valueOf(ultrasonido))
        .concat("]"));
        return str;
    }
    
    
    
    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getSilla() {
        return silla;
    }

    public void setSilla(int silla) {
        this.silla = silla;
    }

    public int getCamilla() {
        return camilla;
    }

    public void setCamilla(int camilla) {
        this.camilla = camilla;
    }

    public int getBaston() {
        return baston;
    }

    public void setBaston(int baston) {
        this.baston = baston;
    }

    public int getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(int oxiegno) {
        this.oxigeno = oxiegno;
    }

    public int getEstudioPrevio() {
        return estudioPrevio;
    }

    public void setEstudioPrevio(int estudioPrevio) {
        this.estudioPrevio = estudioPrevio;
    }

    public int getBiopsiaPrevia() {
        return biopsiaPrevia;
    }

    public void setBiopsiaPrevia(int biopsiaPrevia) {
        this.biopsiaPrevia = biopsiaPrevia;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
        this.comprobante = comprobante;
    }

    public int getCurp() {
        return curp;
    }

    public void setCurp(int curp) {
        this.curp = curp;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getMastografia() {
        return mastografia;
    }

    public void setMastografia(int mastrografia) {
        this.mastografia = mastrografia;
    }

    public int getUltrasonido() {
        return ultrasonido;
    }

    public void setUltrasonido(int ultrasonido) {
        this.ultrasonido = ultrasonido;
    }
    
    
}
