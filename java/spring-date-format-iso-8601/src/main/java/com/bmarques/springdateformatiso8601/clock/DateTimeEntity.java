package com.bmarques.springdateformatiso8601.clock;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.*;
import java.util.Date;

@Data
@Entity
@Table(name = "date_time_tbl")
public class DateTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_str")
    private String dateStr;

    @Column(name = "date_time")
    private Date date;

    @Column(name = "local_date")
    private LocalDate localDate;

    @Column(name = "local_time")
    private LocalTime localTime;

    @Column(name = "local_datetime_dt")
    private LocalDateTime localDateTime;

    @Column(name = "local_datetime_ts")
    private LocalDateTime localDateTimeTs;

    @Column(name = "offset_datetime")
    private OffsetDateTime offsetDateTime;

    @Column(name = "zoned_datetime")
    private ZonedDateTime zonedDateTime;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
}