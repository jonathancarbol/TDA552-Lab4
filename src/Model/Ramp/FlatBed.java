package Model.Ramp;

public class FlatBed extends Ramp{

    private int flatBedAngle;


    public FlatBed() {
        this.flatBedAngle = 0;
    }

    public int getFlatBedAngle() {
        return flatBedAngle;
    }

    public void setFlatBedAngle(int angle, double currentSpeed){
        if(angle >= 0 && angle <= 70) {
            if (currentSpeed == 0) {
                flatBedAngle = angle;
                if(flatBedAngle == 0) {
                    this.setRampUp(true);
                }else{
                    this.setRampUp(false);
                }
            }
        }
    }
}
