import java.util.*;

public class TestVideoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Artist artist = new Artist();
        CommedyVideo newVideo;
        VideoList videoList = new VideoList();
        boolean flag = true;
        int ans = 0;
        int index = 0;

        do{
            menu();
            ans = sc.nextInt();
            switch (ans){
                case 1:         newVideo = addComVideo();
                                if(videoList.addVideo(newVideo))
                                    System.out.println("Video added successfully");
                                else
                                    System.out.println("Video was not added");
                                break;
                case 2:
                                System.out.println("What video do you want to delete?: ");
                                newVideo = findVideo();
                                if(videoList.removeVideo(newVideo)){
                                    System.out.println("Video deleted successfully");
                                } else
                                    System.out.println("Video was not deleted");
                                break;
                case 3:
                                System.out.println("What video do you want to search?: ");
                                newVideo = findVideo();
                                index =videoList.search(newVideo);
                                if(index!=-1)
                                    System.out.println("It is on num. " + index + ".");
                                else
                                    System.out.println("Video was not found");
                                break;
                case 4:         if(videoList.getCount()==0)
                                    System.out.println("There are no videos added");
                                else
                                    videoList.displayList();
                                break;
                case 5:         flag=false;
                                break;
                default:
                                System.out.println("You have entered the wrong choice");
            }

        }while (flag);
    }

    public static void menu(){
        System.out.println("MENU");
        System.out.println("[1] Add a Video");
        System.out.println("[2] Delete a Video");
        System.out.println("[3] Find a Video");
        System.out.println("[4] Display Book List");
        System.out.println("[5] Exit");
        System.out.print("Please enter your choice: ");
    }

    public static CommedyVideo addComVideo(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Artist's Name: ");
        String firstName = sc.next();
        char middleInitial = sc.next().charAt(0);
        String lastName = sc.nextLine();
        Artist artist = new Artist();
        CommedyVideo comVideo = new CommedyVideo();

        artist.setFirstName(firstName);
        artist.setMiddleInitial(middleInitial);
        artist.setLastName(lastName);
        comVideo.setArtist(artist);

        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        comVideo.setCode(code);

        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        comVideo.setTitle(title);

        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        comVideo.setCategory(category);

        System.out.print("Enter Length: ");
        int length = sc.nextInt();
        comVideo.setLength(length);

        return comVideo;
    }

    public static CommedyVideo findVideo(){
        Scanner sc = new Scanner(System.in);
        CommedyVideo comVideo = new CommedyVideo();
        String code="";
        System.out.print("Enter video's code: ");
        code = sc.nextLine();
        comVideo.setCode(code);

        return comVideo;
    }
}
