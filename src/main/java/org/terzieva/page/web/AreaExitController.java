package org.terzieva.page.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terzieva.page.domain.AreaExit;

@RequestMapping("/areaexits")
@Controller
@RooWebScaffold(path = "areaexits", formBackingObject = AreaExit.class)
public class AreaExitController {
}
