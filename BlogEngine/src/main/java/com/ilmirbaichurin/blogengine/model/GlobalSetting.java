package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "global_settings")
@Data
public class GlobalSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer settingId;
    @Column(name = "code", nullable = false)
    private String settingSystemName;
    @Column(name = "name", nullable = false)
    private String settingName;
    @Column(name = "value", nullable = false)
    private String settingValue;
}
