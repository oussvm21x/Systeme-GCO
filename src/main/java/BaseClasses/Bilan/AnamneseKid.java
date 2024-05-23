package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EAdultQ;
import Enums.EKidQ;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnamneseKid extends Anamnese {
    private static Map<EKidQ, List<Question>> Questions = new HashMap<>();
    Map<Map<EKidQ, Question>, String> Answers;

    public AnamneseKid() {
        super();
    }

    public void setQuestions(Map<EKidQ, List<Question>> questions) {
        this.Questions = questions;
    }

    public void addQuestion(EKidQ key, Question question) {
        if (!this.Questions.containsKey(key)) {
            this.Questions.put(key, new ArrayList<>());
        }
        this.Questions.get(key).add(question);
    }

    public Map<EKidQ, List<Question>> getQuestions() {
        return this.Questions;
    }

    // Getter for a type of question
    public List<Question> getQuestions(EKidQ key) {
        return this.Questions.get(key);
    }

    public Map<Map<EKidQ, Question>, String> getAnswers() {
        return this.Answers;
    }

    public void addAnswer(Map<EKidQ, Question> key, String answer) {
        this.Answers.put(key, answer);
    }

    public void calculateScore() {
        // Implement your score calculation logic here
    }

    // This is the correct implementation of getStaticQuestions()
    public static Map<EKidQ, List<Question>> getStaticQuestions() {
        return Questions;
    }

    // This is the correct implementation of addStaticQuestion()
    public static void addStaticQuestion(EKidQ key, Question question) {
        List<Question> questionList = Questions.getOrDefault(key, new ArrayList<>());
        questionList.add(question);
        Questions.put(key, questionList);
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
            Questions = (Map<EKidQ, List<Question>>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
