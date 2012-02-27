package jobs;

import models.Language;
import models.Version;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:48 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 *
 * I want to init the static content in the DB from Play.
 * On application start, we will get the number of items in the database
 * and if the count doesn't match the expected count, insert in the data.
 *
 */
@OnApplicationStart
public class ApplicationStart extends Job {
    public void doJob(){
       initLangauges();
       initVersions();
    }

    /**
     *
     */
    private void initLangauges(){
        //We need to have a single point of configuration. If we add another item to list, everything will be accounted for
        String[] languages = {"Java", "Scala", "HTML", "JavaScript", "CSS", "SCSS", "plain"};
        long count = Language.count();

        if(count == languages.length){
          return;
        }
        for(String s : languages){
            new Language(s).save();
        }


    }

    private void initVersions(){
        String[] versions = {"1.2.4","1.2.3","1.2.2","1.2","1.1.1","1.1","1.0.3.2","1.0.2.1","1.0.1","1.0"};
        long count = Version.count();

        if(count == versions.length){
            return;
        }

        for(String s : versions){
            new Version(s).save();
        }
    }
}
