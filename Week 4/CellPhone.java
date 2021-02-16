import java.io.*;

public class CellPhone extends Phone implements Serializable {
    private float load;
    private float talkTime;
    private float ratePerMinute;
    private float ratePerText;

    public CellPhone(){}

    public CellPhone(String name, String brand, float load, float talkTime, float ratePerMinute, float ratePerText) {
        super(name, brand);
        this.load = load;
        this.talkTime = talkTime;
        this.ratePerMinute = ratePerMinute;
        this.ratePerText = ratePerText;
    }

    public CellPhone(String name, String brand, float talkTime, float ratePerMinute, float ratePerText) {
        this(name,brand,300,talkTime,ratePerMinute,ratePerText);
    }

    public float getLoad() {
        return load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    public float getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(float talkTime) {
        this.talkTime = talkTime;
    }


    public float getRatePerMinute() {
        return ratePerMinute;
    }

    public void setRatePerMinute(float ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    public float getRatePerText() {
        return ratePerText;
    }

    public void setRatePerText(float ratePerText) {
        this.ratePerText = ratePerText;
    }

    public float callCost(float duration){
        return duration*getRatePerMinute();
    }

    public boolean call(float duration) {
        float cost = callCost(duration);
        if(duration<=getTalkTime() && this.load>=cost){
            this.load-=cost;
            this.talkTime-=duration;
            return true;
        }
        return false;
    }

    public boolean isLowBat(){
        return getTalkTime() == 0;
    }

    public boolean text(){
        if(load>=getRatePerText()){
            this.load-=getRatePerText();
            this.talkTime-=0.05f;
            return true;
        } else
            return false;
    }

    public String toString() {
        return "\nPhone name: " + getName() + "\nPhone Brand: " + getBrand()
                + "\nLoad: " + getLoad() + "\nTalk Time: " + getTalkTime()
                + "\nRate per minute: " + getRatePerMinute()
                + "\nRate per Text: " + getRatePerText() + "\n";
    }
}
