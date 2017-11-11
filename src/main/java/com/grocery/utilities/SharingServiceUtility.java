package com.grocery.utilities;

import com.grocery.configuration.CustomProperty;
import com.grocery.serviceImpl.*;
import com.grocery.services.PhotographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * Created by Jason on 11/11/2017.
 */

@Component
public class SharingServiceUtility {

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private TechSharingServiceImpl techSharingService;

    @Autowired
    private SoftwareSharingServiceImpl softwareSharingService;

    @Autowired
    private PhotographyService photographyService;

    @Autowired
    private NewsSharingServiceImpl newsSharingService;

    @Autowired
    private FoodSharingServiceImpl foodSharingService;

    @Autowired
    private ArticleSharingServiceImpl articleSharingService;


    public ModelMap proceedTypeAndPageIndex(ModelMap modelMap, String type, String path, Integer pageIndex) {

        String full = path.replace("{type}",type);
        modelMap.addAttribute("CurrentType", type);

        switch (type) {

            case "article":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(articleSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(articleSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "software":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(softwareSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(softwareSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "photography":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(photographyService.getPhotographyDetailBypaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(photographyService.getPhotographyDetailCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "news":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(newsSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(newsSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            case "food":

                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(foodSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(foodSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));

                break;
            default:
                modelMap.addAttribute("SharingPagings", PackingInfo.changeData2Message(techSharingService.getSharingByPaging(pageIndex, Integer.valueOf(customProperty.getAdminPageSize()))));

                modelMap.addAttribute("Paginations", PackingInfo.changeData2Message(new PaginationUtility(
                        pageIndex.toString(),
                        customProperty.getPaginationDisplayNum(),
                        full,
                        false,
                        String.valueOf(techSharingService.getSharingCount()),
                        customProperty.getAdminPageSize())));
                break;

        }

        return modelMap;
    }

}
