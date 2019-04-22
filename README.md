# t56Himalaya
see: https://space.bilibili.com/44272436/video

# class 3 集成喜马拉雅的SDK

<img src="./img/testSDKok.jpg" width = "400" height = "150" alt="myFuzhouGarden" align="middle" />

# class 4 0227 添加自定义的Log 输出格式

<img src="./img/logUtilOK.jpg" width = "500" height = "150" align="middle"/>

# lesson 6 done 添加indicator

<img src="./img/L6OK.jpg" width = "400" height = "250" align="middle"/>

# lesson 7 indicator 和 viewpager 的联动

增加indicator 的tab click 触发viewpager的跳转能力


# lesson8+9 增加一个search icon

<img src="./img/L8Ok.jpg" width = "400" height = "250" align="middle"/>

# lesson 10 get data done!!

```
03-13 22:47:35.132 6749-6749/com.example.paul.t56himalaya D/[com.example.paul.t56himalaya]RecommendFragment: got! size --- >20
```


# L11 获取数据到recyclerView OK了

<img src="./img/L11RecyclerViewOK.jpeg" width = "400" height = "400" align="middle"/>


# L12 UI 优化： 实现 圆角和间隙

- [x] 优化了封面图：

把背景蓝色图去掉了，用fitxy 以至于不显示之

普通矩形-》 圆角矩形, by: `RoundRectImage.java`

- [x] 优化了rv 的 间隙

增加recyclerView的间隙  by:

 `recyclerView.addItemDecoration()`

用到一个UI  dip2px 的工具类:

`UIUtil.dip2px(view.getContext(), 10);`

item 卡片也有圆角，by 添加一个`shape_album_item_bg.xml`

上下左右都有间隙，最终效果如图


<img src="./img/L12OK.jpeg" width = "200" height = "300" align="middle"/>
