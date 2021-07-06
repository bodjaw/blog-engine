package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "global_settings")
@Data
public class GlobalSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "code")
    private String settingSystemName;
    @Column(name = "name")
    private String settingName;
    @Column(name = "value")
    private String settingValue;
}
