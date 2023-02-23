package com.theatreproject.models;

import com.theatreproject.controllers.ActorControllerImpl;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "PLAYS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Play.findAll", query = "SELECT p FROM Play p")
        , @NamedQuery(name = "Play.findOne", query = "SELECT p FROM Play p WHERE p.playid = :playid")
})
public class Play {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PLAYID")
    private BigInteger playid;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "WRITER")
    private String writer;
    @Basic
    @Column(name = "DIRECTOR")
    private String director;
    @Basic
    @Column(name = "GENRE")
    private String genre;
    @OneToMany
    @JoinColumn
    private List<ActorPlay> actorPlays;
    @OneToMany
    @JoinColumn
    private List<Show> shows;

    public BigInteger getPlayid() {
        return playid;
    }

    public void setPlayid(BigInteger playid) {
        this.playid = playid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<ActorPlay> getActorPlays() {
        return actorPlays;
    }

    public void setActorPlays(List<ActorPlay> actorPlays) {
        this.actorPlays = actorPlays;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getActorsString() {
        List<Actor> actors = ActorControllerImpl.getInstance().index(playid);

        return actors.stream().map((actor -> actor.getActorname()))
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Play that = (Play) o;

        if (playid != null ? !playid.equals(that.playid) : that.playid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (writer != null ? !writer.equals(that.writer) : that.writer != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playid != null ? playid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
