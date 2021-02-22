package com.upgrad.quora.service.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "answer")
@NamedQueries({
        @NamedQuery(name = "getAnswerById", query = "select a from AnswerEntity a where a.uuid = :uuid"),
        @NamedQuery(name = "getAnswerByQuestionId", query = "select a from AnswerEntity a where a.question.uuid = :questionId")
})
public class AnswerEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "uuid")
    @Size(max = 200)
    @NotNull
    private String uuid;

    @Column(name = "ans")
    @Size(max = 255)
    @NotNull
    private String ans;

    @Column(name = "date")
    @NotNull
    private ZonedDateTime date;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_id")
    @NotNull
    private Question question;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }


    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
