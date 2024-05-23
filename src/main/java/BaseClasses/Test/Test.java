package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test implements Q_E, Serializable {
    private static List<QCM> QCMQuestions;
    private static List<QCU> QCUQuestions;
    private static List<QLibres> QLIBREQuestions;
    private static List<Exercice> ExercicesQuestions;
    private static String testName;
    private static String conclusion;

    public static List<Exercice> getExercicesQuestions() {
        return ExercicesQuestions;
    }

    public static List<QCM> getQCMQuestions() {
        return QCMQuestions;
    }

    public static List<QCU> getQCUQuestions() {
        return QCUQuestions;
    }

    public static List<QLibres> getQLIBREQuestions() {
        return QLIBREQuestions;
    }

    public static void setExercicesQuestions(List<Exercice> exercicesQuestions) {
        ExercicesQuestions = exercicesQuestions;
    }

    public static void setQCMQuestions(List<QCM> QCMQuestions) {
        Test.QCMQuestions = QCMQuestions;
    }

    public static void setQCUQuestions(List<QCU> QCUQuestions) {
        Test.QCUQuestions = QCUQuestions;
    }

    public static void setQLIBREQuestions(List<QLibres> QLIBREQuestions) {
        Test.QLIBREQuestions = QLIBREQuestions;
    }

    // Constructor
    public Test(String testName) {
        Test.testName = testName;
    }

    // Setters and getters
    public void setTestName(String testName) {
        Test.testName = testName;
    }

    public void setConclusion(String conclusion) {
        Test.conclusion = conclusion;
    }

    public String getTestName() {
        return testName;
    }

    public String getConclusion() {
        return conclusion;
    }

    @Override
    public void setQuestions() {
        // Implementation here
    }

    public String getAnswers() {
        return "";
    }

    @Override
    public void calculateScore() {
        // Implementation here
    }

    // Save static data to a file
    public static void saveStaticData(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(QCMQuestions);
            oos.writeObject(QCUQuestions);
            oos.writeObject(QLIBREQuestions);
            oos.writeObject(ExercicesQuestions);
            oos.writeObject(testName);
            oos.writeObject(conclusion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Restore static data from a file
    public static void restoreStaticData(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            QCMQuestions = (List<QCM>) ois.readObject();
            QCUQuestions = (List<QCU>) ois.readObject();
            QLIBREQuestions = (List<QLibres>) ois.readObject();
            ExercicesQuestions = (List<Exercice>) ois.readObject();
            testName = (String) ois.readObject();
            conclusion = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Methods to add questions
    public static void addQCMQuestion(QCM question) {
        if (QCMQuestions == null) {
            QCMQuestions = new ArrayList<>();
        }
        QCMQuestions.add(question);
    }

    public static void addQCUQuestion(QCU question) {
        if (QCUQuestions == null) {
            QCUQuestions = new ArrayList<>();
        }
        QCUQuestions.add(question);
    }

    public static void addQLIBREQuestion(QLibres question) {
        if (QLIBREQuestions == null) {
            QLIBREQuestions = new ArrayList<>();
        }
        QLIBREQuestions.add(question);
    }

    public static void addExerciceQuestion(Exercice question) {
        if (ExercicesQuestions == null) {
            ExercicesQuestions = new ArrayList<>();
        }
        ExercicesQuestions.add(question);
    }
}
