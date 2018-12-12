package Model.Ramp;

public class Ramp implements IRampables{

    private boolean isRampUp;

    public Ramp() {
        this.isRampUp = true;
    }


    public boolean isRampUp() {
        return isRampUp;
    }

    public void setRampUp(boolean rampUp) {
        isRampUp = rampUp;
    }

}
