package com.littlejava;

import com.littlejava.model.News;
import com.littlejava.model.NewsFactory;
import com.littlejava.model.NewsWithRelated;
import com.littlejava.view.NewsListViewer;

import java.util.ArrayList;

public class Main {

    // 本地存储新闻内容，如何在终端显示

    // 1. 抽象出 对象
    // 2. 设计 对象应该具有的属性，状态和行为
    // 3. 思考 对象之间交互
    // 4. 开始写代码

    public static void main(String[] args) throws Exception {
        String resource_path = Main.class.getClassLoader().getResource("news").getPath();

        NewsFactory newsReader = new NewsFactory(resource_path);
        ArrayList<News> newsList = newsReader.fetch();

        NewsWithRelated newsWithRelated = new NewsWithRelated("腾讯与 WWF 达成战略合作 以数字科技助力建设「美丽中国」", "品途商业评论（ID：pintu360）4 月 19 日，微信宣布将在前期对小游戏开发者提供扶持，小游戏开发者可获取更高收益 ... 具体扶持政策为，微信 2018 年内，每款小游戏每月安卓内购流水在 50 万元以下（包含 50 万元）部");
        newsWithRelated.addRelated("4.20", "腾讯 COO 任宇昕：明年 100 亿投入到企鹅号内容生态");

        newsList.add(newsWithRelated);

        NewsListViewer viewer = new NewsListViewer(newsList);
        viewer.display();
    }
}

