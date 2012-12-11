package org.terzieva.page.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terzieva.page.domain.Area;

@RequestMapping("/areas")
@Controller
@RooWebScaffold(path = "areas", formBackingObject = Area.class)
public class AreaController {
}
