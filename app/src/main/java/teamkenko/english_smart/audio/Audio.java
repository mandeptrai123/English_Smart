package teamkenko.english_smart.audio;

public class Audio {
    public static  String hostlocal="http://u987173009.hostingerapp.com/sever/audio/";
    public static String type =".mp3";
    public String getAudio(String name)
    {
        return hostlocal+name+type;
    }
}
