package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EAdultQ;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnamneseAdult extends Anamnese {

    private static Map<EAdultQ, List<Question>> Questions = new HashMap<>();
    Map<Map<EAdultQ, Question> , String> Answers ;
    public AnamneseAdult() {
        super();
    }


    public void setQuestions(Map<EAdultQ, List<Question>> questions) {
        this.Questions = questions;
    }

    public void addQuestion(EAdultQ key, Question question) {
        if (this.Questions == null) {
            this.Questions = new HashMap<>();
        }
        if (!this.Questions.containsKey(key)) {
            this.Questions.put(key, new ArrayList<>());
        }
        this.Questions.get(key).add(question);
    }



    //getter for question
    public Map<EAdultQ, List<Question>> getQuestions() {
        return this.Questions;
    }
    //Getter for a type of question
    public List<Question> getQuestions(EAdultQ key) {
        return this.Questions.get(key);
    }


    public static Map<EAdultQ, List<Question>> getStaticQuestions() {
        return Questions;
    }
    public static void addStaticQuestion(EAdultQ key, Question question) {
        List<Question> questionList = Questions.getOrDefault(key, new ArrayList<>());
        questionList.add(question);
        Questions.put(key, questionList);
    }

    public void calculateScore() {

    }
    public Enum<EAdultQ>[] getQtypes(){
        return EAdultQ.values();
    }

    public static void saveStaticData(String fichier) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fichier))) {
            outputStream.writeObject(Questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void restoreStaticData(String fichier) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fichier))) {
            Questions = (Map<EAdultQ, List<Question>>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}