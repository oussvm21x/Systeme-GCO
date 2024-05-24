package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test implements Q_E, Serializable {
    private List<QCM> QCMQuestions;
    private List<QCU> QCUQuestions;
    private List<QLibres> QLIBREQuestions;
    private List<Exercice> ExercicesQuestions;
    private String testName;
    private String conclusion;

    public Test(String testName) {
        this.testName = testName;
        this.QCMQuestions = new ArrayList<>();
        this.QCUQuestions = new ArrayList<>();
        this.QLIBREQuestions = new ArrayList<>();
        this.ExercicesQuestions = new ArrayList<>();
    }

    // Getters and setters
    public List<Exercice> getExercicesQuestions() {
        return ExercicesQuestions;
    }

    public List<QCM> getQCMQuestions() {
        return QCMQuestions;
    }

    public List<QCU> getQCUQuestions() {
        return QCUQuestions;
    }

    public List<QLibres> getQLIBREQuestions() {
        return QLIBREQuestions;
    }

    public void setExercicesQuestions(List<Exercice> exercicesQuestions) {
        ExercicesQuestions = exercicesQuestions;
    }

    public void setQCMQuestions(List<QCM> QCMQuestions) {
        this.QCMQuestions = QCMQuestions;
    }

    public void setQCUQuestions(List<QCU> QCUQuestions) {
        this.QCUQuestions = QCUQuestions;
    }

    public void setQLIBREQuestions(List<QLibres> QLIBREQuestions) {
        this.QLIBREQuestions = QLIBREQuestions;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
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
    public static void saveStaticData(Test test, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Restore static data from a file
    public static Test restoreStaticData(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Test) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Methods to add questions
    public void addQCMQuestion(QCM question) {
        if (QCMQuestions == null) {
            QCMQuestions = new ArrayList<>();
        }
        QCMQuestions.add(question);
    }

    public void addQCUQuestion(QCU question) {
        if (QCUQuestions == null) {
            QCUQuestions = new ArrayList<>();
        }
        QCUQuestions.add(question);
    }

    public void addQLIBREQuestion(QLibres question) {
        if (QLIBREQuestions == null) {
            QLIBREQuestions = new ArrayList<>();
        }
        QLIBREQuestions.add(question);
    }

    public void addExerciceQuestion(Exercice question) {
        if (ExercicesQuestions == null) {
            ExercicesQuestions = new ArrayList<>();
        }
        ExercicesQuestions.add(question);
    }
}
