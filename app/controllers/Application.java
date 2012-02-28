package controllers;

import models.Language;
import models.Paste;
import models.Version;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void about(){
        renderArgs.put("totalPasteCount", Paste.count());
        renderArgs.put("languages", Language.findAll());
        renderArgs.put("versions", Version.findAll());
        render();
    }

}