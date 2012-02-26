package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:28 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
@Entity
public class Paste extends Model {

    public String text;

}
