嗨！我是宙斯和迈亚之子—— ```Mercury```~（中文名```墨丘利```），可以帮助你做时间的朋友！同时变得更高、更快、更强！
# 下面是我的能力，请查收~~
我可是旅游、信件、贸易、偷窃、诡计、语言、写作、外交、体育、格斗和畜牧业之神，也是众神的信差，将死者的灵魂带进冥界的引路人。我是宙斯和迈亚之子。我的造型是一个无须的健壮英俊青年。我的代表物是双蛇杖，带翅膀的拖鞋和旅游者的帽子。

# 听说你想减肥？
减肥是刚需，是无尽的需求和市场！所以减肥相关需求分析和设计是重中之重！
怎么快乐的减肥？当然是运动啦！
如果防止心血来潮抽搐式运动？当然还是得靠computer啦！让我来帮助你吧

# 我是怎么记忆的呢？
通过txt文本记录Todo计划，todoList.txt -> 记录已经完成的项目情况  
每行文本代表一条记录，通过“|”符号分割每项任务的完成情况，借助idea的多行文本选择工具，方便对数据结构的任意变更。  
tmd越进行需求调研，越发现这个项目不是一个txt就能记录的了！！！---2021年8月28日23点42分  
感觉json不错，可视化，易操作，找到合适的api就可以---23点57分  
好吧，有一点要提前声明下，我的记忆目标并不是为了要更准确，而是希望通过我的记忆，能够帮助你改变和提升自己，那就可以了！--00点35分  
任何数据可以通过手工便捷修改，易读，性能不是要首先要考虑的，其他比如可视化等需求可以考虑通过其他软件辅助分析展示，比如Excel，或者其他功能可以通过其他脚本语言辅助实现，本程序保证计划跟得上变化就好了。  

经过Json序列化和反序列化的开源框架选型，最终选定了Jackson这款组件。

关于训练计划，可以存储在config文件夹中。

# 说吧，需要我干点啥？
- [ ] 训练计划制定：告诉我训练计划，我就会记下来，如果要定制计划内每个动作的个数就跟我说，我支持sin波动曲线、2^10指数直达云霄曲线、脉冲函数曲线、双曲线、椭圆过山车曲线、锯齿曲线什么鬼┏┛墓┗┓...(((m -__-)m
- [ ] 实际训练情况统计：告诉我你哪天完成了哪些计划，或者完成了哪些原子动作，我拿小本本🖊记下来哈
- [ ] 你不一定是同一个人对吧？我以为我隔着屏幕就判断不了你的DNA……不过加入你主动告诉我你是谁的时候，我会记住的啦~
- [ ] 休息模式：固定/随机。听说你还想随机选一天休息？什么？一周随机休息七天？？？？滚滚滚(ノ｀Д)ノ
- [ ] 健身盲盒模式：才练几天就腻了？太没毅力了吧……啊？你说我太无趣整天就这几个动作？……那好吧，我只能祭出我的上古大杀器——健身盲盒了，每天来点刺激有合理又有趣，简单容易操作又有点点小挑战的训练动作……

## 用户切换——你以为你换了个DNA我就不认识你了？
```
tell me, who are you?;)
--eagle
hi, eagle! nice to see you again, have a good time today!
```

## 国际化——没事的时候你要把握住自己呀！不是吧，不是吧，我还要会中文？
```
--  
what can i do 4 you?  
--  
you have noting 2 do?
--lang ch  
可以了！我现在好无聊呀，想干点坏事！  
-- 
亲爱的，你来啦  
-- 
你想干嘛？  
--lang en  
ok! I am so boring, want 2 do some bad thing!  
```

## 开始训练计划——我靠，玩真的…你还真能开始一个训练计划？
```
ok, what can i do 4 you?:)  
--start burpee100  
ok, how long?  
--10day  
ok, it'll end at 2021年8月29日.when you want to start?  
--today  
awesome!  
```

# 脑容量就这么点大该存点啥？别用关系表存好吧，我可不想记对应关系
- 项目
  - id --方便在其他文件中扩展管理该项目。
  - 开始日期 --从什么时候开始不重要，重要的是开始一件事，那就做好一件事。
  - 时间类型 --day、week，可以按照第几天或者星期几来写针对当天的训练目标进行备注。
  - 训练动作 --你实际做过哪些，你喜欢的，都可以加进来。
- 训练动作
  - 英文缩写
  - 英文全名
  - 中文名称
  - parent动作
  - 动作要领/说明
- 人 --每个人要记住自己的编号哦，我可不记忆任何个人隐私数据！

# 先坚持三个月世界无敌的波比跳？
看完几篇波比跳的训练计划帖子，发现锻炼不仅是每天做几个波比跳，定个数量，每天做多少个，总共做几周，个数怎么按照时间增长这么简单。

比如横向来说，不同的人身体素值不一样，需要的计划也不一样。  
再如纵向来说，给你安排的这一周每天做5个，估计你做两天你就要吐槽这个计划太无聊不适合你，为啥不再整点具体的计划，比如做几个休息几分钟什么的，或者说周一波比跳体力耗尽，周二能不能休息下，周三再整点深蹲俯卧撑什么的缓缓口味。再或者，这个计划真无聊，要不换一个练练吧。  

总的来说，机器要有人性，得懂得人心。

好吧，其实并不只有你一个跳，所以呢，每个人都有一个自己的id，如果你同时开始了多个项目，要能够按照你的id查找当天所有的目标。  
每一项原子目标都要支持输入完成情况。  
综上所述，我支持对计划的管理和记录计划完成情况。

### 休息：你总不能天天练吧？

休息模式：随机

随机休息模式：周|月

随机休息周模式：1--每周随机选1天休息

随机休息月模式：10--每个月随机休息10天

休息模式：固定

固定休息模式：周|月|天

固定休息周模式：1|3|5 --每周一、周三、周五休息

固定休息月模式：10|20 --每月固定10号和20号这两天休息

固定休息天模式：3|2 --三天打鱼两天晒网

## burpee 100
每做一组就休息

项目周期：day

- Burpee x20
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10
- Burpee x10

## 1 Week Challenge push-up and ab roller 
项目周期：day

休息模式：随机|week|2

- push-up x10
- ab roller x10

## 30 Day Challenge Burpees Ascending 465

Start with 1 burpe, add 1 more each day for a total of 30days! 465 total burpees!

项目周期：day x30

- burpee x1
- burpee x2
- burpee x3
- burpee x4
- burpee x5
- burpee x6
- burpee x7
- burpee x8
- burpee x9
- burpee x10
- burpee x11
- burpee x12
- burpee x13
- burpee x14
- burpee x15
- burpee x16
- burpee x17
- burpee x18
- burpee x19
- burpee x20
- burpee x21
- burpee x22
- burpee x23
- burpee x24
- burpee x25
- burpee x26
- burpee x27
- burpee x28
- burpee x29
- burpee x30

## 30 Day Challenge Burpees 862

862 total burpees!

- burpee x2
- burpee x4
- burpee x6
- burpee x10
- burpee x2
- burpee x14
- burpee x16
- burpee x18
- burpee x20
- burpee x2
- burpee x24
- burpee x26
- burpee x30
- burpee x34
- burpee x2
- burpee x40
- burpee x44
- burpee x46
- burpee x48
- burpee x2
- burpee x50
- burpee x52
- burpee x54
- burpee x56
- burpee x2
- burpee x60
- burpee x62
- burpee x64
- burpee x2
- burpee x70

## 梯子计划ladder workout

60 Second rest in between each set!

- burpee x10, push up x10, squat x10
- burpee x9, push up x9, squat x9
- burpee x8, push up x8, squat x8
- burpee x7, push up x7, squat x7
- burpee x6, push up x6, squat x6
- burpee x5, push up x5, squat x5
- burpee x4, push up x4, squat x4
- burpee x3, push up x3, squat x3
- burpee x2, push up x2, squat x2
- burpee x1, push up x1, squat x1

## cardio workout combined with some strength training

Start off with 10 burpees, 25 push ups, 10 squats and 50 jumping jacks.

Rest 1 minute and repeat a further 4 times, doing a **total of 5 sets**.

set x5

- burpee x10
- push up x25
- squat x10
- jumping jack x50


# 想要变得更强？俯卧撑来满足你！

# 想要变得智慧？那就跑步吧！

