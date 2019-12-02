package teamkenko.english_smart.ThanhTich;

import java.util.ArrayList;

import teamkenko.english_smart.Your_Words.Word;

public class User {
    private String ID;
    private String name;
    private String school;
    private String star;
    private String words;
    private String score;
    private String photo;
    public User()
    {

    }
    public User(String ID, String name, String school, String star, String words, String score, String photo) {
        this.ID = ID;
        this.name = name;
        this.school = school;
        this.star = star;
        this.words = words;
        this.score = score;
        this.photo = photo;
    }

    public String getID() {
        return ID;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
