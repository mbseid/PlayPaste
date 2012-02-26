package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:42 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
@Entity
public class Language extends Model {
    
    public String name;

    @OneToMany(mappedBy = "language")
    public List<Paste> pastes;


    public Language(String name){
        this.name = name;
    }
}
