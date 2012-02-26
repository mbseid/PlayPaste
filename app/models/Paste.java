package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    public Language language;

    @ManyToOne
    public Version version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


    public Paste(String text, Language lang, Version version){
        this.text = text;
        this.language = lang;
        this.version = version;
        timestamp = new Date();
    }
}
