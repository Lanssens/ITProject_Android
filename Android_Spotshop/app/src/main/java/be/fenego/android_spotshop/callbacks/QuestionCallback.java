package be.fenego.android_spotshop.callbacks;

import java.util.List;

import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Question;
import be.fenego.android_spotshop.models.QuestionWrapper;

/**
 * Created by Thijs on 6/01/2017.
 */

public interface QuestionCallback {
    void onSuccessQuestion(List<Question> questions);
    void onError();
}
