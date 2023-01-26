package articles.controllers;

import articles.models.Article;
import articles.models.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/myarticle")
    public String getMyArticle(Model model) {
        Author author = new Author(1, "Damien", "DARRAS");
        Article art = new Article(1, "damdamdeo", "content", author);
        model.addAttribute("myarticle",art); // Ajout au modèle
        return "article"; //Envoi vers la vue
    }
}