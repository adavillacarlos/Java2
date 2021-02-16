public class CommedyVideo extends Video{
    private String setting;
    private boolean isInYoutube;


    public CommedyVideo(String setting, boolean isInYoutube) {
        this.setting = setting;
        this.isInYoutube = isInYoutube;
    }

    public CommedyVideo(boolean isInYoutube){
        this("CIT University",isInYoutube);
    }

    public CommedyVideo(){
        this("Cebu City", true);
    }



    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public boolean getIsInYoutube() {
        return isInYoutube;
    }

    public void setInYoutube(boolean inYoutube) {
        this.isInYoutube = inYoutube;
    }

    public void display() {
        System.out.println("Code: " + super.getCode() + "\nTitle: " + super.getTitle() + "\nArtist: " + super.getArtist() +
                "\nCategory: " + super.getCategory() + "\nLength: " + super.getLength() + "\nSetting: " + getSetting() + "\nIn Youtube: " + getIsInYoutube() + "\n");
    }

    public boolean equals(Object obj){
        boolean ans = false;
        if(obj instanceof CommedyVideo){
            CommedyVideo c = (CommedyVideo) obj;
            if(this.setting==c.setting && this.getCode()==c.getCode())
                ans = true;

        }
        return ans;
    }

    public String toString(){
        return super.toString() + "\nSetting: " + getSetting() + "\nIn Youtube: " + getIsInYoutube();
    }

}


