package teamkenko.english_smart.Your_Words;

public class Word {
    private String voca;
    private String main;
    private String pronun;
    private String sound;
    private String question;
    public Word()
    {

    }

    public Word(String voca, String main, String pronun, String sound, String question) {
        this.voca = voca;
        this.main = main;
        this.pronun = pronun;
        this.sound  = sound;
        this.question = question;
    }

    public String getVoca() {
        return voca;
    }

    public void setVoca(String voca) {
        this.voca = voca;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPronun() {
        return pronun;
    }

    public void setPronun(String pronun) {
        this.pronun = pronun;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
