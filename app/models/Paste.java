package models;

import helpers.DateUtils;
import play.db.jpa.Model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

    @Lob
    public String text;

    @ManyToOne
    public Language language;

    @ManyToOne
    public Version version;

    @Temporal(TemporalType.TIMESTAMP)
    public Date timestamp;

    public int viewCount;


    public Paste(String text, Language lang, Version version){
        this.text = text;
        this.language = lang;
        this.version = version;
        timestamp = new Date();
        viewCount = 0;
    }
    public String getTimestampString(){
        SimpleDateFormat sdf = DateUtils.getFormatter();
        return new String(sdf.format(timestamp));
    }

    public void incrementViewCount(){
        this.viewCount++;
        this.save();
    }
}
