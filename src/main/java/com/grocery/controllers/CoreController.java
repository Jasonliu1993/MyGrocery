package com.grocery.controllers;

import com.grocery.properties.CustomProperty;
import com.grocery.services.ImageService;
import com.grocery.services.IndexService;
import com.grocery.services.MessageBoardService;
import com.grocery.services.PhotographyService;
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

}
