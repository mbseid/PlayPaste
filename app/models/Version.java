package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:42 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
@Entity
public class Version extends Model {

    public String number;

    public Version(String number){
        this.number = number;
    }
}
