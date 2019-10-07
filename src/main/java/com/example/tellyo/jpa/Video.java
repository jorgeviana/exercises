package com.example.tellyo.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "video")
public class Video implements java.io.Serializable {
    private long id;
    private String name;
    private Date createdOn;
    private Set<DailyStatistics> dailyStatistics;
    private Boolean userHasAccess;

    private Video() {
    }

    public Video(String name, Date createdOn, Set<DailyStatistics> dailyStatistics, Boolean userHasAccess) {
        this.name = name;
        this.createdOn = createdOn;
        this.dailyStatistics = dailyStatistics;
        this.userHasAccess = userHasAccess;
    }

    // Getters

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
        return createdOn;
    }

    @Transient
    public Boolean isUserHasAccess() {
        return userHasAccess;
    }


    // TODO complete annotations
    @OneToMany(
            fetch = FetchType.LAZY  // by default!
            , mappedBy = "relatedVideo"
            , cascade = CascadeType.ALL
    )
    public Set<DailyStatistics> getDailyStatistics() {
        return dailyStatistics;
    }


    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setUserHasAccess(Boolean userHasAccess) {
        this.userHasAccess = userHasAccess;
    }

    public void setDailyStatistics(Set<DailyStatistics> dailyStatistics) {
        this.dailyStatistics = dailyStatistics;
    }
}
