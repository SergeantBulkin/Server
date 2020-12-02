package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.quiz.AnswerRepository;
import by.bsuir.Kulinka.interfaces.quiz.CategoryRepository;
import by.bsuir.Kulinka.interfaces.quiz.QuestionRepository;
import by.bsuir.Kulinka.model.Answer;
import by.bsuir.Kulinka.model.Question;
import by.bsuir.Kulinka.model.entity.quiz.AnswerDB;
import by.bsuir.Kulinka.model.entity.quiz.QuestionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CategoryRepository categoryRepository;
    //------------------------------------------------------------------------------------------------------------------
    //Получить вопросы указанной категории
    @GetMapping(path = "/questions/category")
    public List<Question> getQuestionsFromCategory(@RequestParam(name = "category_id") int category_id)
    {
        //Объявить новый список ответов
        List<Question> questions = new ArrayList<>();

        //Получить список вопросов категории
        List<QuestionDB> questionDBS = questionRepository.findAllFromCategory(category_id);

        //Наполнить новый список ответов
        for (QuestionDB questionDB : questionDBS)
        {
            List<Answer> answerList = getAnswersFromQuestion(questionDB);
            Question question = new Question(questionDB.getQuestion_text(), answerList);
            questions.add(question);
        }

        return questions;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Вернуть список ответов указанного вопроса
    private List<Answer> getAnswersFromQuestion(QuestionDB questionDB)
    {
        //Объявить новый список ответов
        List<Answer> answers = new ArrayList<>();

        //Получить список ответов указанного вопроса
        List<AnswerDB> answerDBS = answerRepository.findAllFromQuestion(questionDB.getId());

        //Наполнить список ответов
        for (AnswerDB answerDB : answerDBS)
        {
            Answer answer = new Answer(answerDB.getAnswer_text(), answerDB.getIs_correct());
            answers.add(answer);
        }

        return answers;
    }
    //------------------------------------------------------------------------------------------------------------------
}
