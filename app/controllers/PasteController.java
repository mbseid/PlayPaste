package controllers;

import models.Language;
import models.Paste;
import models.Version;
import play.mvc.Controller;

import java.util.List;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 2:29 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
public class PasteController extends Controller {

    public static void create(){
        renderArgs.put("languages", Language.findAll());
        renderArgs.put("versions", Version.findAll());
        render();
    }


    public static void explore(){
        List<Paste> pastes = Paste.find("order by timestamp desc").from(1).fetch(20);
        renderArgs.put("recentPastes", pastes);
        renderArgs.put("languages", Language.findAll());
        renderArgs.put("pastes", Paste.findAll());
       render();
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
        paste.incrementViewCount();
        renderArgs.put("language", (paste.language == null ? "plain" : paste.language.name.toLowerCase()));
        renderArgs.put("paste", paste);
        renderArgs.put("timestamp", paste.getTimestampString());
        render();
    }
    public static void delete(long id){

    }
}
