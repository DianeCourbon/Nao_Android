package adapter;

/**
 * Created by Cyci on 05/11/2017.
 */

public class Motor_Object {
    //moteur = etat boolean + position (angle radian, double) + température (°C, double)

    private int NumeroMoteur;
    private Boolean etatRobot;
    private Double positionMoteur;
    private Double temperatureMoteur;

    public Motor_Object(int NumeroMoteur, Boolean etatRobot, Double positionMoteur, Double temperatureMoteur) {
        this.NumeroMoteur = NumeroMoteur;
        this.etatRobot = etatRobot;
        this.positionMoteur = positionMoteur;
        this.temperatureMoteur = temperatureMoteur;
    }

    public int getNumeroMoteur() {
        return NumeroMoteur;
    }

    public void setNumeroMoteur(int numeroMoteur) {
        NumeroMoteur = numeroMoteur;
    }

    public Boolean getEtatRobot() {
        return etatRobot;
    }

    public void setEtatRobot(Boolean etatRobot) {
        this.etatRobot = etatRobot;
    }

    public Double getPositionMoteur() {
        return positionMoteur;
    }

    public void setPositionMoteur(Double positionMoteur) {
        this.positionMoteur = positionMoteur;
    }

    public Double getTemperatureMoteur() {
        return temperatureMoteur;
    }

    public void setTemperatureMoteur(Double temperatureMoteur) {
        this.temperatureMoteur = temperatureMoteur;
    }
}
