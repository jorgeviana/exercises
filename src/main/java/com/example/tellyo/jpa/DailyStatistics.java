package com.example.tellyo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "dailyStatistics")
public class DailyStatistics implements java.io.Serializable {
    private long id;
    private Date snapshotTime;
    private long views;
    private long comments;
    private Video relatedVideo;

    private DailyStatistics() {
    }

    public DailyStatistics(Date snapshotTime, long views, long comments, Video relatedVideo) {
        this.snapshotTime = snapshotTime;
        this.views = views;
        this.comments = comments;
        this.relatedVideo = relatedVideo;
    }

    // Getters

    @Id
    @Column(name = "stats_id", unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "snapshot_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSnapshotTime() {
        return snapshotTime;
    }

    @Column(name = "views", nullable = false)
    public long getViews() {
        return views;
    }

    @Column(name = "comments", nullable = false)
    public long getComments() {
        return comments;
    }


    // TODO complete annotations
    @ManyToOne
    @JoinColumn(name = "video_id")
    public Video getRelatedVideo() {return relatedVideo;}


    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setSnapshotTime(Date snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public void setRelatedVideo(Video relatedVideo) {
        this.relatedVideo = relatedVideo;
    }
}
