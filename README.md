# CustomScrollView
## 简介
本项目演示两个ScrollView解决滑动冲突的一种方法，当内部ScrollView拉到Head或bottom时激活外部ScrollView的滑动事件。
**具体方法**：采用内部中断法，利用requestDisallowInterceptTouchEvent控制外部GroupView的mGroupFlags，从而反向控制外部GroupView 是否接管Touch事件。
