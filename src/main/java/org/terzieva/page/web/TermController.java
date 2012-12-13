package org.terzieva.page.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terzieva.page.domain.Term;

@RequestMapping("/terms")
@Controller
@RooWebScaffold(path = "terms", formBackingObject = Term.class)
public class TermController {
}
