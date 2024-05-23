package BaseClasses.Test;

import Enums.EAdultQ;
import Enums.EKidQ;
import Interfaces.Q_E;

import java.io.Serializable;

public class Question implements Q_E, Serializable {
    protected String enonce;
	protected float score;
	protected EAdultQ type1 ;
	protected EKidQ type2 ;

	//constructor
	public String getType() {
		if (type1 != null) {
			return type1.toString();
		} else if (type2 != null) {
			return type2.toString();
		}
		return "";
	}

	public EAdultQ getType1() {
		return type1;
	}

	public EKidQ getType2() {
		return type2;
	}

	public void setType1(EAdultQ type1) {
		this.type1 = type1;
	}

	public void setType2(EKidQ type2) {
		this.type2 = type2;
	}

	@Override
    public void setQuestions() {
        
    }
	@Override
	public String getAnswers() {
		return "";
	}
    @Override
    public void calculateScore() {

    }

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
