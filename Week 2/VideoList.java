import java.util.*;

public class VideoList implements VisualMaterial{
    private int count=0;
    private int max;
    private List<Video> videoList;

    public VideoList(){
        this.max=MAX_CONTENT;
        videoList = new ArrayList<>(max);
    }

    public VideoList(int max){
        this.max = max;
        videoList = new ArrayList<>(max);
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public boolean addVideo(Video video){
        boolean flag = false;
        if(!videoList.contains(video)){
            videoList.add(video);
            this.count++;
            flag=true;
        }
        return flag;
    }

    public int search(Video video){
        int ans = -1;
        int i=0;
        for(Video v: videoList){
            if(v.getCode().equals(video.getCode())){
                ans=i;
                break;
            }
            i++;
        }
        return ans;
    }

    public boolean removeVideo(Video video){
        boolean flag=false;
        int i=0;
        Video lastVideo = videoList.get(videoList.size()-1);
        for(Video v: videoList){
            if(v!=null && v.getCode().equals(video.getCode())){
                v.display();
                videoList.set(i,lastVideo);
                videoList.set(videoList.size()-1, null);
                (this.count)--;
                flag = true;
            }
            i++;
        }
        return flag;
    }

    public void displayList(){
        for (Video v: videoList) {
            if(v!=null)
                v.display();
        }
    }

    public String copyrightNotice() {
        return "Copyright 2021";
    }

    public int length() {
        return 150;
    }
}
