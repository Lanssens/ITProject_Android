package be.fenego.android_spotshop.callbacks;

import java.util.List;

import be.fenego.android_spotshop.models.Question;

/**
 * Created by Thijs on 6/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public interface QuestionCallback {
    void onSuccessQuestion(List<Question> questions);
    void onError();
}
