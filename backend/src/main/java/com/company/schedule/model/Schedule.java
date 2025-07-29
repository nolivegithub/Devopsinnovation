package com.company.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "scheduleevents")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime", nullable = false)
    private Date starttime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", nullable = false)
    private Date endtime;
    private String subject;
    private String location;
    private String description;
    private Boolean isallday;
    private String starttimezone;
    private String endtimezone;
    private String recurrencerule;
    private Integer recurrenceid;
    private String recurrenceexception;
    private Integer followingid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
