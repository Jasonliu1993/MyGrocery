package com.grocery.controllers;

import com.grocery.configuration.CustomProperty;
import com.grocery.serviceImpl.*;
import com.grocery.services.AdminService;
import com.grocery.services.MessageBoardService;
import com.grocery.services.PhotographyService;
import com.grocery.services.SharingService;
import com.grocery.utilities.PackingInfo;
import com.grocery.utilities.PaginationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    private TechSharingServiceImpl techSharingService;

    @Autowired
    private SoftwareSharingServiceImpl softwareSharingService;

    @Autowired
    private NewsSharingServiceImpl newsSharingService;

    @Autowired
    private FoodSharingServiceImpl foodSharingService;

    @Autowired
    private ArticleSharingServiceImpl articleSharingService;

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
                true,
                String.valueOf(photographyService.getPhotographyDetailCount()),
                customProperty.getPhotographyDetailPageSize())));
        return "/photography/photography_index";
    }

    @GetMapping("/messageBoard/{pageNum}")
    public String messageBoard(ModelMap modelMap, @PathVariable("pageNum") Integer pageNum) {

        /**
         * 留言板数据分页
         */

        modelMap.addAttribute("MessageBoards", PackingInfo.changeData2Message(messageBoardService.getMessageBoardByPaging(pageNum, Integer.valueOf(customProperty.getMessageBoardPageSize()))));

        /**
         * 分页导航显示
         */
        modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                pageNum.toString(),
                customProperty.getPaginationDisplayNum(),
                "/messageBoard",
                true,
                String.valueOf(messageBoardService.getMessageBoardCount()),
                customProperty.getMessageBoardPageSize())));

        return "/message-board/message_board_index";
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap, @RequestParam("type") String type, @RequestParam("pageIndex") Integer pageIndex) {

        modelMap.addAttribute("AdminMenus", PackingInfo.changeData2Message(adminService.getAdminMenu()));
        modelMap.addAttribute("CurrentType", type);

        switch (type) {

            case "article":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(articleSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        "1",
                        customProperty.getPaginationDisplayNum(),
                        "/admin?type=article&pageIndex=",
                        false,
                        String.valueOf(articleSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "software":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(softwareSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        "1",
                        customProperty.getPaginationDisplayNum(),
                        "/admin?type=software&pageIndex=",
                        false,
                        String.valueOf(softwareSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "photography":



                break;
            case "news":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(newsSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        "1",
                        customProperty.getPaginationDisplayNum(),
                        "/admin?type=news&pageIndex=",
                        false,
                        String.valueOf(newsSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "food":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(foodSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        "1",
                        customProperty.getPaginationDisplayNum(),
                        "/admin?type=food&pageIndex=",
                        false,
                        String.valueOf(foodSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            default:
                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(techSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        "1",
                        customProperty.getPaginationDisplayNum(),
                        "/admin?type=tech&pageIndex=",
                        false,
                        String.valueOf(techSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));
                break;

        }

        if ("photography".equals(type)){
            return "/admin/admin_index";
        }
        return "/admin/admin_index";
    }

}
