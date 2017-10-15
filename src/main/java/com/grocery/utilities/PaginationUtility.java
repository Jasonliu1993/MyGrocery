package com.grocery.utilities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jason on 14/10/2017.
 */
public class PaginationUtility {
    /**
     * 当前页
     */
    private String currentPage;

    /**
     * 底下分页显示多少页
     */
    private String barLength;

    /**
     * 请求URL主路径
     */
    private String path;

    /**
     * 数据总行数
     */
    private String dataRowCount;

    /**
     * 每页显示的数量
     */
    private String pageDisplaySize;

    /**
     * 总页数
     */
    private String totalPage;

    public PaginationUtility(String currentPage, String barLength, String path, String dataRowCount, String pageDisplaySize) {
        this.currentPage = currentPage;
        this.barLength = barLength;
        this.path = path + "/";
        this.dataRowCount = dataRowCount;
        this.pageDisplaySize = pageDisplaySize;
        setTotalPage(dataRowCount, pageDisplaySize);
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setTotalPage(String dataRowCount, String pageDisplaySize) {
        if ((Integer.valueOf(dataRowCount) % Integer.valueOf(pageDisplaySize)) == 0)
            this.totalPage = String.valueOf(Integer.valueOf(dataRowCount) / Integer.valueOf(pageDisplaySize));
        else
            this.totalPage = String.valueOf(Integer.valueOf(dataRowCount) / Integer.valueOf(pageDisplaySize) + 1);
    }

    public String getTotalPage() {
        return totalPage;
    }

    public String getPath() {
        return path;
    }

    public String getBarLength() {
        return barLength;
    }

    public String getPreButton() {

        /**
         * 添加前一页按钮内容
         * 如果当前页是第一页，则前一页会显示MIN，但是在前台会判断，如果是MIN的话会不显示前一页按钮
         */
        return currentPage.equals("1") ? "MIN" : String.valueOf(Integer.valueOf(currentPage) - 1);
    }

    public String getPostButton() {
        /**
         * 添加后一页按钮内容
         * 如果当前页是最后一个，那后一页的按钮还是后指向最大页加一，但是在前台页面会判断是否显示
         */
        return currentPage.equals(totalPage) ? "MAX" : String.valueOf(Integer.valueOf(currentPage) + 1);
    }

    /**
     * 返回导航条的每个链接
     *
     * @return
     */
    public List<String> getBarList() {

        List<String> barList = new LinkedList<String>();

        /**
         * 添加中间也按钮内容
         */

        if (Integer.valueOf(totalPage) > Integer.valueOf(barLength)) {

            int temp = 0; //初始化偏移量
            int mod = Integer.valueOf(barLength) / 2;

            /**
             * 如果总页数大于导航显示数(奇数)
             */
            if ((Integer.valueOf(barLength) % 2) != 0) {

                //获取偏移量
                if (Integer.valueOf(currentPage) - mod <= 0) {
                    temp = 1 - (Integer.valueOf(currentPage) - mod);
                } else {
                    if (Integer.valueOf(totalPage) - (Integer.valueOf(currentPage) + mod) <= 0) {
                        temp = Integer.valueOf(totalPage) - (Integer.valueOf(currentPage) + mod);
                    }
                }

                //给导航条中间赋值
                for (int k = Integer.valueOf(currentPage) - mod; k <= (Integer.valueOf(currentPage) + mod); k++) {
                    barList.add(String.valueOf(k + temp));

                }
            } else {
                /**
                 * 如果总页数大于导航显示数(偶数)
                 */

                //获取偏移量
                if (Integer.valueOf(currentPage) - mod <= 0) {
                    temp = 1 - (Integer.valueOf(currentPage) - mod);
                } else {
                    if (Integer.valueOf(totalPage) - (Integer.valueOf(currentPage) + mod - 1) <= 0) {
                        temp = Integer.valueOf(totalPage) - (Integer.valueOf(currentPage) + mod - 1);
                    }
                }

                //给导航条中间赋值
                for (int k = (Integer.valueOf(currentPage) - mod); k < ((Integer.valueOf(currentPage) - mod) + Integer.valueOf(barLength)); k++) {
                    barList.add(String.valueOf(k + temp));
                }
            }
        } else {
            /**
             * 如果总页数小于等于导航显示数
             */
            for (int i = 1; i <= Integer.valueOf(totalPage); i++)
                barList.add(String.valueOf(i));
        }

        return barList;
    }
}
