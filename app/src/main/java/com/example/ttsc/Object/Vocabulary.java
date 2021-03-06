package com.example.ttsc.Object;

public class Vocabulary {
    int vocabularyID;
    int topicID;
    int vocabularyImage;
    String english;
    String vietnamese;
    String sound;

    public Vocabulary(int vocabularyID, int topicID, int vocabularyImage, String english, String vietnamese, String sound) {
        this.vocabularyID = vocabularyID;
        this.topicID = topicID;
        this.vocabularyImage = vocabularyImage;
        this.english = english;
        this.vietnamese = vietnamese;
        this.sound = sound;
    }

    public int getVocabularyID() {
        return vocabularyID;
    }

    public void setVocabularyID(int vocabularyID) {
        this.vocabularyID = vocabularyID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getVocabularyImage() {
        return vocabularyImage;
    }

    public void setVocabularyImage(int vocabularyImage) {
        this.vocabularyImage = vocabularyImage;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
