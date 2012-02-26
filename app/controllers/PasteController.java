package controllers;

import models.Language;
import models.Paste;
import models.Version;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:29 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
public class PasteController extends Application {

    public static void create(){
        renderArgs.put("languages", Language.findAll());
        renderArgs.put("versions", Version.findAll());
        render();
    }


    public static void explore(){

    }

    public static void post(String text, long language, long version){
        Language lang = Language.findById(language);
        Version ver = Version.findById(version);
        Paste paste = new Paste(text, lang, ver);
        paste.save();
        view(paste.id);

    }
    public static void view(long id){
        Paste paste = Paste.findById(id);
        renderArgs.put("language", (paste.language == null? "plain": paste.language.name.toLowerCase()));
        renderArgs.put("paste", paste);
        render();
    }
    public static void delete(long id){

    }
}
