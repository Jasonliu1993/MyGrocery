package com.grocery.controllers;

import com.grocery.configuration.CustomProperty;
import com.grocery.services.AdminService;
import com.grocery.services.MessageBoardService;
import com.grocery.services.PhotographyService;
import com.grocery.services.TechService;
import com.grocery.utilities.PackingInfo;
import com.grocery.utilities.PaginationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Jason on 10/10/2017.
 */

@Controller
public class CoreController {

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private PhotographyService photographyService;

    @Autowired
    private MessageBoardService messageBoardService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private TechService techService;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        return "index";
    }

    @GetMapping("/photography/{pageNum}")
    public String photography(ModelMap modelMap, @PathVariable("pageNum") Integer pageNum) {

        /**
         * 摄影综述页数据
         */
        modelMap.addAttribute("PhotographyDetail", PackingInfo.changeData2Message(photographyService.getPhotographyDetailBypaging(pageNum, Integer.valueOf(customProperty.getPhotographyDetailPageSize()))));

        /**
         * 分页导航显示
         */
        modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                pageNum.toString(),
                customProperty.getPaginationDisplayNum(),
                "/photography",
                String.valueOf(photographyService.getPhotographyDetailCount()),
                customProperty.getPhotographyDetailPageSize())));
        return "/photography/photography_index";
    }

    @GetMapping("/messageBoard/{pageNum}")
    public String messageBoard(ModelMap modelMap, @PathVariable("pageNum") Integer pageNum) {

        /**
         * 留言板数据分页
         */

        modelMap.addAttribute("MessageBoards",PackingInfo.changeData2Message( messageBoardService.getMessageBoardByPaging(pageNum,Integer.valueOf(customProperty.getMessageBoardPageSize()))));

        /**
         * 分页导航显示
         */
        modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                pageNum.toString(),
                customProperty.getPaginationDisplayNum(),
                "/messageBoard",
                String.valueOf(messageBoardService.getMessageBoardCount()),
                customProperty.getMessageBoardPageSize())));

        return "/message-board/message_board_index";
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap) {

        modelMap.addAttribute("AdminMenus",PackingInfo.changeData2Message(adminService.getAdminMenu()));
        modelMap.addAttribute("CurrentType","tech");
        modelMap.addAttribute("TechSharingPagings",PackingInfo.changeData2Message(techService.getTechSharingByPaging(1,Integer.valueOf(customProperty.getAdminPageSize()))));

        modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                "1",
                customProperty.getPaginationDisplayNum(),
                "",
                String.valueOf(techService.getTechSharingCount()),
                customProperty.getAdminPageSize())));

        return "/admin/admin_index";
    }

}
