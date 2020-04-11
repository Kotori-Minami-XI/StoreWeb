package com.Kotori.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @Class: DaoAdmin
 * @Brief: DAO for admins
 * @Paras: aid, adminName, pwd
 *
 */
@Setter @Getter @ToString
public class Admin {
    Integer aid;
    String adminName;
    String pwd;
}

