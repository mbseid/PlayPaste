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
        //Get the count of the amount of languages in the current data set
        long count = Language.count();

        if(count == 2){
          return;
        }

        new Language("Java").save();
        new Language("Scala").save();
    }

    private void initVersions(){
        long count = Version.count();

        if(count == 1){
            return;
        }

        new Version("1.2.4").save();
    }
}
