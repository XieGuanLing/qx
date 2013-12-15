momo
=====
******************************

* 接口
	*	[获取注册验证码](#获取注册验证码)
	*	[注册](#注册)
	*	[登录](#登录)
	*	[退出](#退出)
	*	[单向加关注](#单向加关注)
	*	[好友动态列表接口](#好友动态列表接口)
	*	[发布私信](#发布私信)
	*	[私信列表接口](#私信列表接口)
	*	[私信详情](#私信详情)
	*	[发表博客](#发表博客)
	*	[对某篇博客表态称赞](#对某篇博客表态称赞)
	*	[撰写对某篇博客评论](#撰写对某篇博客评论)
	*	[某篇博客的评论列表](#某篇博客的评论列表)
	*	[查看自己的全部博客](#查看自己的全部博客)
	*   [查看自己某篇博客的具体内容](#查看自己某篇博客的具体内容)
	*   [删除自己的某篇博客](#删除自己的某篇博客)
	*   [查看某个关注人的全部博客](#查看某个关注人的全部博客)
	*   [查看整个站点的博客](#查看整个站点的博客)
	*	[新建并加入群组](#新建并加入群组)
	*	[群组列表](#群组列表)
	*	[加入群组](#加入群组)
	*	[发表新话题](#发表新话题)
	*	[某个话题的评论列表](#某个话题的评论列表)
	*	[某个群组下的话题列表](#某个群组下的话题列表)
	*   [某个群组下的成员列表](#某个群组下的成员列表)
	*   [对某个话题表态称赞](#对某个话题表态称赞)
	*	[对某个话题发表看法](#对某个话题发表看法)





接口说明
--------
<h2>某个话题的评论列表</h2>
/capi/do.php?ac=ajax&op=getthreadpost&tid=2&page=0&perpage=5&dateline=1386434227&queryop=up
有多种查询方式，可参考[某篇博客的评论列表](#某篇博客的评论列表)


#### 请求参数
	*ac=ajax   op=getthreadpost  ---  固定搭配
	*tid --- 话题id
	*page --- 第几页
	*perpage --- 每页显示数量
	*dateline --- 时间点
	*queryop --- 查询方式, 取值可以是up, down
	    * up 代表上拉，dataline时间点以前的评论
        * down 代表到底，dataline时间点以后的评论

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		*posts数组
			*uid --- 评论人的id
			*username -- 评论人的用户名
			*dataline -- 评论的时间点
			*message -- 评论信息
			*pic --- 图片
		*count --- 评论信息的数量


#### 样例
	{
	    "code": 0,
	    "data": {
	        "posts": [
	            {
	                "uid": "4",
	                "username": "qiuxia",
	                "dateline": "1386414481",
	                "message": "还不显示名字",
	                "pic": ""
	            },
	            {
	                "uid": "4",
	                "username": "qiuxia",
	                "dateline": "1386413596",
	                "message": "还不显示",
	                "pic": ""
	            }
	          
	        ],
	        "count": 2
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)



<h2>某篇博客的评论列表</h2>
有多种查询方式
*前10条评论----- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9 (默认是取前10条数据)
	相当于  ---- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9&page=0&perpage=10
*自定义要查询的数量（如：20条）  ---- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9&page=0&perpage=20
*某个时间点以前的评论 ---- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9&page=0&perpage=1&dateline=1386434227&queryop=up
*某个时间点以后的评论 ---- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9&page=0&perpage=1&dateline=1386434227&queryop=down


#### 请求参数
	*ac=ajax   op=getcomment  idtype=blogid ---  固定搭配
	*id --- 博客id
	*page --- 第几页
	*perpage --- 每页显示数量
	*dateline --- 时间点
	*queryop --- 查询方式, 取值可以是up, down
	    * up 代表上拉，dataline时间点以前的评论
        * down 代表到底，dataline时间点以后的评论

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		*comments数组
			*cid --- 评论信息的id
			*authorid -- 评论人的id
			*author -- 评论人的用户名
			*message -- 评论信息
		*count --- 评论信息的数量


#### 样例
	{
	    "code": 0,
	    "data": {
	        "comments": [
	            {
	                "cid": "9",
	                "authorid": "6",
	                "author": "summit",
	                "message": "写得很好6"
	            },
	            {
	                "cid": "8",
	                "authorid": "6",
	                "author": "summit",
	                "message": "写得很好5"
	            },
	            {
	                "cid": "7",
	                "authorid": "6",
	                "author": "summit",
	                "message": "写得很好4"
	            },
	            {
	                "cid": "6",
	                "authorid": "6",
	                "author": "summit",
	                "message": "写得很好3"
	            }
	        ],
	        "count": 4
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)



<h2>撰写对某篇博客评论</h2>
域名/capi/cp.php?ac=comment&commentsubmit=true&idtype=blogid&message=写得很好&id=9&m_auth=efafX16s6n%2B8WyOhcn
#### 请求参数
	*ac=comment  commentsubmit=true idtype=blogid ---  固定搭配
	*message --- 评论
	*id --- 博客id
	*m_auth --- 登录后返回的授权码


#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>对某篇博客表态称赞</h2>
域名/capi/cp.php?ac=click&op=add&clickid=4&idtype=blogid&id=6&m_auth=69a8srzUGHbLglC%2FJDKPa%2FdTQDcx1%2FJNaXYDdxdUlA
#### 请求参数
	*ac=click&op=add   clickid=4   idtype=blogid ---  固定搭配
		当clickid选择不同的值时，表示不同的态度，clickid可以取下列值
		*1 --- 路过
		*2 --- 雷人
		*3 --- 握手
		*4 --- 鲜花
		*5 --- 鸡蛋
	*id---话题id


#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "参与表态完成了",
	    "action": "click_success"
	}

[↑返回顶部](#momo)


<h2>对某个话题发表看法</h2>
域名capi/cp.php?ac=thread&postsubmit=true&message=还不显示名字&tid=2&m_auth=69a8srzUGHbLglC%2FJDKPa
#### 请求参数
	*ac=thread&postsubmit=true ---  固定搭配
	*message --- 对话题的看法
	*tid---话题id


#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
	
[↑返回顶部](#momo)



<h2>对某个话题表态称赞</h2>
域名/capi/cp.php?ac=click&op=add&clickid=14&idtype=tid&id=1&m_auth=c0d8IRk2sRIH5xdzWMxEy2GuvkXOh%2BLmZWC7Dgzhig
#### 请求参数
	*ac=click&op=add&clickid=14&idtype=tid ---  固定搭配
	*id---话题id


#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "参与表态完成了",
	    "action": "click_success"
	}

[↑返回顶部](#momo)



<h2>加入群组</h2>
域名/capi/space.php?do=mtag&view=member&tagid=2

#### 请求参数
	*do=mtag&view=member ---  固定搭配
	*tagid---群组id


#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组，返回两个数据
	     *memberlist:成员列表
	     		*uid --  用户id
	     		*username -- 用户名
	     *onlineStatus:在线的成员uid数组

#### 样例
	{
	    "code": 0,
	    "data": {
	        "memberlist": [
	            {
	                "uid": "3",
	                "username": "yuyu"
	            },
	            {
	                "uid": "7",
	                "username": "yongwang"
	            },
	            {
	                "uid": "6",
	                "username": ""
	            }
	        ],
	        "onlineStatus": []
	            "7"
	        ]
	    },
	    "msg": "do_sucess",
	    "action": "do_sucess"
	}


[↑返回顶部](#momo)


<h2>某个群组下的话题列表</h2>
域名capi/space.php?do=mtag&tagid=2&view=list

#### 请求参数
	*ac=mtag&op=join&joinsubmit=true---  固定搭配
	*tagid---群组id
	*m_auth---授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组，每个话题的信息：
		        *tid -- 话题id
	            *topicid  -- 
	            *tagid 
	            *eventid
	            *subject -- 话题的主题
	            *magiccolor
	            *magicegg
	            *uid -- 话题发起人的id
	            *username -- 话题发起人的用户名
	            *dateline 
	            *viewnum -- 该话题的浏览数
	            *replynum -- 该话题的回复数
	            *lastpost -- 该话题的最后回复时间
	            *lastauthor -- 最后回复的作者的用户名 
	            *lastauthorid -- 最后回复的作者的id
	            *displayorder 
	            *digest  -- 是否是精品话题
	            *hot -- 是否是热闹话题
	            *click_11 -- 对该话题表态的为“搞笑”的人数
	            *click_12 -- 对该话题表态的为“迷惑”的人数
	            *click_13 -- 对该话题表态的为“雷人”的人数
	            *click_14 -- 对该话题表态的为“鲜花”的人数
	            *click_15 -- 对该话题表态的为“鸡蛋”的人数

#### 样例
	{
	    "code": 0,
	    "data": [
	        {
	            "tid": "5",
	            "topicid": "0",
	            "tagid": "2",
	            "eventid": "0",
	            "subject": "这个test的新话题",
	            "magiccolor": "0",
	            "magicegg": "0",
	            "uid": "6",
	            "username": "",
	            "dateline": "1386168431",
	            "viewnum": "1",
	            "replynum": "1",
	            "lastpost": "1386168679",
	            "lastauthor": "yongwang",
	            "lastauthorid": "7",
	            "displayorder": "0",
	            "digest": "0",
	            "hot": "1",
	            "click_11": "0",
	            "click_12": "1",
	            "click_13": "0",
	            "click_14": "0",
	            "click_15": "0"
	        },
	        {
	            "tid": "1",
	            "topicid": "0",
	            "tagid": "2",
	            "eventid": "0",
	            "subject": "你在哪？",
	            "magiccolor": "0",
	            "magicegg": "0",
	            "uid": "3",
	            "username": "yuyu",
	            "dateline": "1382946000",
	            "viewnum": "2",
	            "replynum": "0",
	            "lastpost": "1382946000",
	            "lastauthor": "yuyu",
	            "lastauthorid": "3",
	            "displayorder": "0",
	            "digest": "0",
	            "hot": "1",
	            "click_11": "0",
	            "click_12": "0",
	            "click_13": "1",
	            "click_14": "0",
	            "click_15": "0"
	        }
	    ],
	    "msg": "do_sucess",
	    "action": "do_sucess"
	}	

[↑返回顶部](#momo)



<h2>发表新话题</h2>
域名/capi/cp.php?ac=thread&threadsubmit=true&tid=0&topicid=0&tagid=2&subject=这个test的新话题&message=你对这个话题有什么看法&m_auth=db5bwgI15VsGtX

#### 请求参数
	*ac=thread&threadsubmit=true&tid=0&topicid=0 ---  固定搭配
	*tagid---群组id
	*subject --- 话题题目
	*message --- 你对这个话题的说明与看法
	*m_auth---授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}


[↑返回顶部](#momo)



<h2>加入群组</h2>
域名/capi/cp.php?ac=mtag&op=join&joinsubmit=true&tagid=2&m_auth=2e37fk%2Bchmhmsq9PW98em27P8b8

#### 请求参数
	*ac=mtag&op=join&joinsubmit=true---  固定搭配
	*tagid---群组id
	*m_auth---授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型

#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "加入成功，您现在是该群组的成员了",
	    "action": "join_success"
	}


[↑返回顶部](#momo)


<h2>新建并加入群组</h2>
域名/capi/cp.php?ac=mtag&textsubmit=true&tagname=extjs群组&joinmode=1&fieldid=1&m_auth=2e37fk%2Bchmhmsq9PW

#### 请求参数
	*ac=mtag&textsubmit=true---  固定搭配
	*tagname---群组名称
	*joinmode---只能取1，说明自身也加入这个群组
	*fieldid ---群组类型id
    		*自由联盟--1 
    		*地区联盟--2 
    		*兴趣联盟--3 

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型

#### 样例
	{
	    "code": 0,
	    "data": [
	       
	    ],
	    "msg": "操作成功了",
	    "action": "rest_success"
	}


[↑返回顶部](#momo)



<h2>群组列表</h2>
域名/capi/capi/space.php?do=mtag&view=hot&orderby=postnum

#### 请求参数
	* view---查看哪些群组，view取me或manage时，要多传递一个m_auth参数。可以取下列某个值：
		*me--我参与的群组  
		*hot--热门群组
		*recommend--推荐群组 
		*manage--我管理的群组


	*orderby---如何排序， 可以下列某个取值：
	     *threadnum--话题发表数 
	     *postnum--提交信息数
	     *membernum--成员数

#### 返回字段
	* code--- 错误码 0:代表成功， 1:代表失败
	* data
	    *   tagid--- 群组id
	    *	tagname--- 群组名
	    *	fieldid--- 群组类型id
	    *	membernum--- 群组中的成员数
	    *	threadnum--- 群组中的话题数
	    *	postnum--- 回复数
	    *	close--- 群组是否已经关闭
	    *	announcement--- 群组口号
	    *	pic--- 群组logo
	    *	closeapply 
	    *	joinperm 
	    *	viewperm 
	    *	threadperm
	    *	postperm 
	    *	recommend--- 推荐数
	    *	moderator 
	    *	title--- 群组类型名称，与fieldid对应
	    		*全部--0 
	    		*自由联盟--1 
	    		*地区联盟--2 
	    		*兴趣联盟--3 
   	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型

	
#### 样例
	{
    "code": 0,
    "data": [
        {
            "tagid": "3",
            "tagname": "感冒讨论组",
            "fieldid": "1",
            "membernum": "2",
            "threadnum": "2",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "1",
            "tagname": "Apps开发",
            "fieldid": "1",
            "membernum": "3",
            "threadnum": "1",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "2",
            "tagname": "故乡情",
            "fieldid": "1",
            "membernum": "1",
            "threadnum": "1",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "4",
            "tagname": "我是优秀程序员",
            "fieldid": "1",
            "membernum": "2",
            "threadnum": "0",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "5",
            "tagname": "群组测试",
            "fieldid": "1",
            "membernum": "1",
            "threadnum": "0",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "6",
            "tagname": "postman群组",
            "fieldid": "1",
            "membernum": "1",
            "threadnum": "0",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        },
        {
            "tagid": "7",
            "tagname": "extjs群组",
            "fieldid": "1",
            "membernum": "1",
            "threadnum": "0",
            "postnum": "0",
            "close": "0",
            "announcement": "",
            "pic": "image/nologo.jpg",
            "closeapply": "0",
            "joinperm": "0",
            "viewperm": "0",
            "threadperm": "0",
            "postperm": "0",
            "recommend": "0",
            "moderator": "",
            "title": "自由联盟"
        }
    ],
    "msg": "do_sucess",
    "action": "do_sucess"
    }
	

[↑返回顶部](#momo)




<h2>查看自己的全部博客</h2>
域名/capi/space.php?do=blog&view=me&auth=6284SqqRXsIhxZ2IUCMkFUcRADW8fsyHyTYimRgF1w

#### 请求参数
	* 当前用户id -- uid

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	* blogid --  博客id
	* subject -- 博客标题
	* classid -- 博客分类
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "blogs": [
	            {
	                "blogid": "12",
	                "topicid": "0",
	                "uid": "8",
	                "username": "",
	                "subject": "我是test08",
	                "classid": "0",
	                "viewnum": "0",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1385554217",
	                "pic": "",
	                "picflag": "0",
	                "noreply": "0",
	                "friend": "0",
	                "password": "",
	                "click_1": "0",
	                "click_2": "0",
	                "click_3": "0",
	                "click_4": "0",
	                "click_5": "0"
	            },
	            {
	                "blogid": "13",
	                "topicid": "0",
	                "uid": "8",
	                "username": "",
	                "subject": "我发表博客了",
	                "classid": "0",
	                "viewnum": "0",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1385557303",
	                "pic": "",
	                "picflag": "0",
	                "noreply": "0",
	                "friend": "0",
	                "password": "",
	                "click_1": "0",
	                "click_2": "0",
	                "click_3": "0",
	                "click_4": "0",
	                "click_5": "0"
	            }
	        ]
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
	

[↑返回顶部](#momo)

<h2>删除自己的某篇博客</h2>
域名/capi/cp.php?ac=blog&blogid=1&op=delete&deletesubmit=true&auth=c847%2FE%2FpaiQ4h7oYd%2F2ppsnHuquqghTBaumzvqnegQ

#### 请求参数
	* 固定搭配-- ac=blog&op=delete&deletesubmit=true
	* blogid -- 所要删除的自己的博客的id

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型

#### 样例
	{
	    "code": 0,
	    "data": [
	       
	    ],
	    "msg": "操作成功了",
	    "action": "rest_success"
	}


[↑返回顶部](#momo)


<h2>查看自己某篇博客的具体内容</h2>
域名/capi/space.php?do=blog&view=me&id=12&auth=6284SqqRXsIhxZ2IUCMkFUcRADW8fsyHyTYimRgF1w

#### 请求参数
	* 固定搭配 do=blog view=me 
	* id -- 要查看的博客的id
	* API密钥 auth -- 登录后返回的值
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data-- 返回的数据
	        blogid: 博客id
            uid: 用户id
            tag: 标记
            message: 博客内容
            postip: 提交的ip
            related: 相关
            relatedtime:
            target_ids:
            hotuser:
            magiccolor: 
            magicpaper: 
            magiccall: 
            topicid:
            username: 
            subject: 博客标题
            classid: 博客分类
            viewnum:
            replynum: 
            hot: 
            dateline: 
            pic: 
            picflag: 
            noreply: 
            friend: 
            password: 
            click_1: 表态“路过"
            click_2: 表态"雷人"
            click_3: 表态"握手"
            click_4: 表态"鲜花"
            click_5: 表态"鸡蛋"

#### 样例
	{
	    "code": 0,
	    "data": {
	        "blog": {
	            "blogid": "12",
	            "uid": "8",
	            "tag": [],
	            "message": "希望你好,真心祝福你。",
	            "postip": "127.0.0.1",
	            "related": [],
	            "relatedtime": "0",
	            "target_ids": "",
	            "hotuser": "",
	            "magiccolor": "0",
	            "magicpaper": "0",
	            "magiccall": "0",
	            "topicid": "0",
	            "username": "",
	            "subject": "我是test08",
	            "classid": "0",
	            "viewnum": "0",
	            "replynum": "0",
	            "hot": "0",
	            "dateline": "1385554217",
	            "pic": "",
	            "picflag": "0",
	            "noreply": "0",
	            "friend": "0",
	            "password": "",
	            "click_1": "0",
	            "click_2": "0",
	            "click_3": "0",
	            "click_4": "0",
	            "click_5": "0"
	        },
	        "topic": [],
	        "clicks": {
	            "1": {
	                "clickid": 1,
	                "name": "路过",
	                "icon": "luguo.gif",
	                "idtype": "blogid",
	                "displayorder": "0",
	                "clicknum": "0",
	                "classid": 3
	            },
	            "2": {
	                "clickid": 2,
	                "name": "雷人",
	                "icon": "leiren.gif",
	                "idtype": "blogid",
	                "displayorder": "0",
	                "clicknum": "0",
	                "classid": 1
	            },
	            "3": {
	                "clickid": 3,
	                "name": "握手",
	                "icon": "woshou.gif",
	                "idtype": "blogid",
	                "displayorder": "0",
	                "clicknum": "0",
	                "classid": 1
	            },
	            "4": {
	                "clickid": 4,
	                "name": "鲜花",
	                "icon": "xianhua.gif",
	                "idtype": "blogid",
	                "displayorder": "0",
	                "clicknum": "0",
	                "classid": 4
	            },
	            "5": {
	                "clickid": 5,
	                "name": "鸡蛋",
	                "icon": "jidan.gif",
	                "idtype": "blogid",
	                "displayorder": "0",
	                "clicknum": "0",
	                "classid": 3
	            }
	        },
	        "clickuserlist": []
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}




[↑返回顶部](#momo)




<h2>私信列表接口</h2>
域名/capi/space.php?do=pm&page=0&prepage=2&uid=1&filter=newpm&dateline=0&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	* 当前用户id -- uid
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 私信类型 -- filter
		* newpm -- 未读私信
		* privatepm -- 私人消息
		* systempm -- 系统消息
		* announcepm -- 公共消息
		* 空 -- 私人消息
	* API密钥 -- m_auth, 由登录后返回
	* 时间点 -- dateline

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	* 操作信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[pms]，私信列表， 条目字段如下
			* pmid -- 私信id
			* msgfrom -- 消息发送人
			* msgfromavatar -- 消息发送人头像
			* msgfromid -- 消息发送人id
			* msgtoid -- 消息接收人id
			* msgtoavatar -- 消息接收人头像
			* authorid -- 发送通知的用户
			* new -- 是否未读
			* subject -- 私信标题
			* message -- 私信内容
			* delstatus -- 删除状态
			* fromappid -- 应用程序ID，可以忽略
			* dateline -- 时间
			* daterange -- 消息相隔的天数，1代表1天内，2代表两天内，3代表3天内
		* data[count], 返回列表条目数, 便用遍历
#### 样例
	{
		"code": 0,
		"data": {
			"pms": [
				{
					"pmid": "7",
					"msgfrom": "admin",
					"msgfromid": "1",
					"msgtoid": "5",
					"new": "0",
					"subject": "你好summit",
					"dateline": "1344324792",
					"message": "你好summit",
					"delstatus": "0",
					"related": "0",
					"fromappid": "1",
					"daterange": 5,
					"touid": "1",
					"msgfromavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/01_avatar_small.jpg",
					"msgtoavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/05_avatar_small.jpg"
				}
			],
			"count": 1
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)

<h2>私信详情</h2>
域名/capi/space.php?do=pm&subop=view&pmid=2&touid=12&daterange=10&page=1&perpage=10&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	* 消息送至的用户id -- touid
	* 检索消息的区间（几天之内的） -- daterange
	* 消息id -- pmid
	* 当前页 -- page, 默认为1
	* 分页数 -- perpage, 默认为10
	* 操作参数 -- subop, 必须为view
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg--  操作信息 , 详细参见附录
	*data--  结果 , json数组, 本操作返回两个数据
		* data[pms]，私信列表， 条目字段如下
			* pmid -- 私信id
			* msgfrom -- 消息发送人
			* msgfromid -- 消息发送人id
			* msgfromavatar -- 消息发送人头像
			* msgtoid -- 消息接收人id
			* msgtoavatar -- 消息接收人头像
			* authorid -- 发送通知的用户
			* new -- 是否未读
			* subject -- 私信标题
			* message -- 私信内容
			* delstatus -- 删除状态
			* fromappid -- 应用程序ID，可以忽略
			* dateline -- 时间
			* daterange -- 消息相隔的天数，1代表1天内，2代表两天内，3代表3天内
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
		"code": 0,
		"data": {
			"pms": [
				{
					"pmid": "6",
					"msgfrom": "summit",
					"msgfromid": "5",
					"msgtoid": "1",
					"folder": "inbox",
					"new": "1",
					"subject": "23423432423",
					"dateline": "1344324163",
					"message": "23423432423",
					"delstatus": "0",
					"related": "1",
					"fromappid": "1",
					"daterange": 5,
					"msgfromavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/01_avatar_small.jpg"
				},
				{
					"pmid": "8",
					"msgfrom": "summit",
					"msgfromid": "5",
					"msgtoid": "1",
					"folder": "inbox",
					"new": "1",
					"subject": "你好吧。admin",
					"dateline": "1344324259",
					"message": "你好吧。admin",
					"delstatus": "0",
					"related": "1",
					"fromappid": "1",
					"daterange": 5,
					"msgfromavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/01_avatar_small.jpg"
				},
				{
					"pmid": "9",
					"msgfrom": "admin",
					"msgfromid": "1",
					"msgtoid": "5",
					"folder": "inbox",
					"new": "0",
					"subject": "你好summit",
					"dateline": "1344324792",
					"message": "你好summit",
					"delstatus": "0",
					"related": "1",
					"fromappid": "1",
					"daterange": 5,
					"msgfromavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/01_avatar_small.jpg",
					"msgtoavatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/05_avatar_small.jpg"
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)




<h2>发表博客</h2>
域名/capi/cp.php?ac=blog&blogid=0&blogsubmit=true&auth=6284SqqRXsIhxZ2IUCMkFUcRADW8fsyHyTYimRgF1w


#### 请求参数
	* 操作类型 -- ac为blog,blogid为0，blogsubmit为true
	* 查询参数 -- 若传入 view=done， 则查询已完成任务
	* API密钥 -- m_auth, 由登录后返回
	*用post方式提交以下参数
		*subject  --- 博客标题
		*message  --- 博客内容
		*classid  --- 博客分类

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

####示例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
[↑返回顶部](#momo)



******************************
<h2>获取注册验证码</h2>
域名/capi/do.php?ac=register&op=seccode
#### 请求参数
	* 操作类型 -- op, 必须为seccode
	
#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组本操作返回两个数据
		* data[seccode_auth] -- 返回的验证码key，在注册时需要传入
		* data[seccode] -- 验证码

#### 样例
	{
		"code":0,
		"data":
		{
			"seccode_auth":"1a6431MIvgvhZZzUPUmCUML%2FtL4rlXrN2R8nL5G3qvta",
			"seccode":"CQ7T"
		},
		"msg":"数据获取成功",
		"action":"rest_success"
	}
[↑返回顶部](#momo)

<h2>注册</h2>
/capi/do.php?ac=register&registersubmit=true&username=test4&password=123&password2=123&seccode=cQ7T&m_auth=1a6431MIvgvhZZzUPUmCUML%2FtL4rlXrN2R8nL5G3qvta
#### 请求参数
	* 操作参数 -- registersubmit, 必须为true
	* 用户名 -- username
	* 用户输入的第一次密码 -- password
	* 用户输入的确认密码 -- password2
	* 用户输入的验证码 -- seccode
	* 生成验证码返回的key -- m_auth

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		* 用户空间信息 -- space
			* groupid -- 所在用户组（级别）
			* credit -- 金币(这里代表注册增加的金币)
			* experience -- 经验(这里代表注册增加的经验)
			* username -- 用户名
			* name -- 实名
			* namestatus -- 是否实名
			* videostatus -- 是否视频认证
			* friendnum -- 好友数
			* viewnum -- 浏览次数
			* notenum -- 通知数
			* addfriendnum -- 关注数
			* doingnum -- 心情数
			* lastpost -- 最新提交时间
			* lastlogin -- 最新登录时间
			* attachsize -- 空间大小
			* flag -- 是否被禁
			* newpm -- 是否有新通知
			* avatar -- 个人头像
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户
	

#### 样例
	{
	    "code": 0,
	    "data": {
	        "space": {
	            "uid": "11",
	            "sex": "0",
	            "email": "test6@momo.cn",
	            "newemail": "",
	            "emailcheck": "0",
	            "mobile": "",
	            "qq": "",
	            "msn": "",
	            "msnrobot": "",
	            "msncstatus": "0",
	            "videopic": "",
	            "birthyear": "0",
	            "birthmonth": "0",
	            "birthday": "0",
	            "blood": "",
	            "marry": "0",
	            "birthprovince": "",
	            "birthcity": "",
	            "resideprovince": "",
	            "residecity": "",
	            "note": "",
	            "spacenote": "",
	            "authstr": "",
	            "theme": "",
	            "nocss": "0",
	            "menunum": "0",
	            "css": "",
	            "privacy": {
	                "view": {
	                    "index": "0",
	                    "friend": "0",
	                    "wall": "0",
	                    "feed": "0",
	                    "mtag": "0",
	                    "event": "0",
	                    "doing": "0",
	                    "blog": "0",
	                    "quiz": "0",
	                    "album": "0",
	                    "share": "0",
	                    "poll": "0"
	                },
	                "feed": {
	                    "doing": 1,
	                    "blog": 1,
	                    "quiz": 1,
	                    "joinquiz": 1,
	                    "upload": 1,
	                    "share": 1,
	                    "poll": 1,
	                    "joinpoll": 1,
	                    "thread": 1,
	                    "post": 1,
	                    "mtag": 1,
	                    "event": 1,
	                    "join": 1,
	                    "friend": 1,
	                    "comment": 1,
	                    "show": 1,
	                    "credit": 1,
	                    "spaceopen": 1,
	                    "invite": 1,
	                    "task": 1,
	                    "profile": 1,
	                    "click": 1
	                }
	            },
	            "friend": "",
	            "feedfriend": "",
	            "sendmail": "",
	            "magicstar": "0",
	            "magicexpire": "0",
	            "timeoffset": "",
	            "weibo": "",
	            "groupid": "0",
	            "credit": "25",
	            "experience": "15",
	            "username": "test6",
	            "name": "",
	            "namestatus": "0",
	            "videostatus": "0",
	            "domain": "",
	            "friendnum": "0",
	            "viewnum": "0",
	            "notenum": "0",
	            "addfriendnum": "0",
	            "mtaginvitenum": "0",
	            "eventinvitenum": "0",
	            "myinvitenum": "0",
	            "pokenum": "0",
	            "doingnum": "0",
	            "blognum": "0",
	            "albumnum": "0",
	            "threadnum": "0",
	            "pollnum": "0",
	            "eventnum": "0",
	            "sharenum": "0",
	            "dateline": "1344414070",
	            "updatetime": "0",
	            "lastsearch": "0",
	            "lastpost": "0",
	            "lastlogin": "1344414070",
	            "lastsend": "0",
	            "attachsize": "0",
	            "addsize": "0",
	            "addfriend": "0",
	            "flag": "0",
	            "newpm": "0",
	            "avatar": "0",
	            "regip": "127.0.0.1",
	            "ip": "127000000",
	            "mood": "0",
	            "voternum": "0",
	            "self": 1,
	            "friends": [],
	            "allnotenum": 0
	        },
	        "m_auth": "cf7chDvDIcnUVeupGp4utLftIQEP%2B1rP8eGrGWydH3ITmly6DURpvHCvByCJlE0hEus%2F5Ji%2FqVUrfnd3dHn6%2BA"
	    },
	    "msg": "注册成功了，进入个人空间",
	    "action": "registered"
	}
[↑返回顶部](#momo)
	
<h2>登录</h2>
域名/capi/do.php?ac=login&username=summit&password=likeyou&loginsubmit=true&longtitude=23°27′30"&latitude=23°27′30"
#### 请求参数
	* 用户名 -- username
	* 密码 -- password
	* 提交类型 -- loginsubmit， 必须为true
	*经度--longtitude
	*纬度--latitude
#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		* 用户空间信息 -- space
		* groupid -- 所在用户组（级别）
		* credit -- 金币
		* experience -- 经验
		* username -- 用户名
		* name -- 实名
		* namestatus -- 是否实名
		* videostatus -- 是否视频认证
		* friendnum -- 好友数
		* viewnum -- 浏览次数
		* notenum -- 通知数
		* addfriendnum -- 关注数
		* doingnum -- 心情数
		* lastpost -- 最新提交时间
		* lastlogin -- 最新登录时间
		* attachsize -- 空间大小
		* flag -- 是否被禁
		* newpm -- 是否有新通知
		* avatar -- 个人头像
		* reward -- 操作增加的金币分和经验
			* credit -- 金币
			* experience -- 经验
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 样例
	{
		"code": {
			"space": {
				"uid": "5",
				"groupid": "11",
				"credit": "2047",
				"experience": "2108",
				"username": "summit",
				"name": "",
				"namestatus": "0",
				"videostatus": "0",
				"domain": "",
				"friendnum": "1",
				"viewnum": "17",
				"notenum": "0",
				"addfriendnum": "0",
				"mtaginvitenum": "0",
				"eventinvitenum": "0",
				"myinvitenum": "0",
				"pokenum": "0",
				"doingnum": "0",
				"blognum": "2",
				"albumnum": "0",
				"threadnum": "0",
				"pollnum": "0",
				"eventnum": "0",
				"sharenum": "0",
				"dateline": "1343789930",
				"updatetime": "1344932295",
				"lastsearch": "1345360391",
				"lastpost": "1344932295",
				"lastlogin": "1345359730",
				"lastsend": "0",
				"attachsize": "0",
				"addsize": "0",
				"addfriend": "0",
				"flag": "0",
				"newpm": "0",
				"avatar": "0",
				"regip": "127.0.0.1",
				"ip": "127000000",
				"mood": "0",
				"reward": {
					"credit": 0,
					"experience": 0
				}
			},
			"m_auth": "b819QOI5fDiDEO7L0DG66A%2FF%2B0bUu3DVzWGp3IQvkHwE%2BWc7p9qfAUwWK7jsI0C4FaXDCSbWNaqeCOlWIRDb"
		},
		"data": [],
		"msg": "登录成功了，现在引导您进入登录前页面 \\1",
		"action": "login_success"
	}
[↑返回顶部](#momo)

<h2>上传图片</h2>
#### 注意:采用POST上传
#### POST样例：
	`<!DOCTYPE HTML>
	<html>
	<head>
	<meta charset="utf-8">
	<title>上传图片</title></head><body>
	<form action="capi/cp.php?ac=upload" method="post" enctype="multipart/form-data">
	<input type="file" name="attach"/><input type="hidden" name="op" value="uploadphoto2" />
	<input type="hidden" name="uid" value="1" />
	<input type="hidden" name="uploadsubmit2"  value="true" />
	<input type="hidden" name="m_auth"  value="af9cCEMpQlfFTifZltugadwhGAXL%2Ba%2BCor8voR9jZyBh60v4xFryq2i" />
	<input type="hidden" name="topicid"  value="0" />
	<input type="hidden" name="ac"  value="upload" />
	<input type="hidden" name="albumid" value="0" />
	<input type="submit"  name="submit"  value="提交"/>
	</form>
	</body>
	</html>`
#### 请求参数
	* 上传文件 -- attach
	* 操作类型(固定搭配) -- op: uploadphoto2, uploadsubmit2:true, topicid:0. albumid:0, ac:upload
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户
	* 上传用户id -- uid
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 操作信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回一个数据
		* data[pic] -- 上传成功的图片内容，具体条目如下:
			* 上传的用户id -- uid
			* 上传的用户名 -- username
			* 上传时间 -- dateline
			* 上传文件名 -- filename
			* 图片标题 -- title, 默认为空
			* 图片类型 -- type
			* 图片大小 -- size
			* 图片服务端文件名 -- filepath
			* 是否生成了缩略图 -- thumb, 1代表生成了，0代表没有
			* 是否放在远端图像服务器 -- remote
			* 图片id -- picid, <em>重要</em>，当发布打赌时需要关联
			* 图片服务端路径 -- pic
#### 样例
	{"code":0,"data":{"pic":{"albumid":0,"uid":"1","username":"test6","dateline":"1344415852","filename":"qq提醒.png","postip":"127.0.0.1","title":"",
	"type":"image\/png","size":165056,"filepath":"1_1344415852h77H.png","thumb":1,"remote":0,"topicid":0,"picid":80,"pic":"attachment\/1_1344415852h77H.png.thumb.jpg"}},
	"msg":"进行的操作完成了","action":"do_success"}
[↑返回顶部](#momo)




<h2>撰写评论</h2>
域名/capi/cp.php?ac=comment&commentsubmit=true&message=i like you -- summit&idtype=quizid&id=55&m_auth=af9cCEMpQlfFT

#### 请求参数
	* 操作类型(固定搭配) -- commentsubmit: true
	* 指示id代表的类型 -- idtype, quizid代表打赌，uid代表空间, sid代表分享
	* 评论关联的id -- id
	* 评论内容 -- message
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 返回参数
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		* credit -- 金币
		* experience -- 经验
#### 样例
	{
		"code": 0,
		"data": {
			"credit": 1,
			"experience": 1
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)

<h2>发布私信</h2>
域名/capi/cp.php?ac=pm&op=send&touid=0&pmid=0&username=test6&message=你好!summit&pmsubmit=true&m_auth=af9cCEMpQlfFTifZltugadwh

#### 请求参数
	* 操作类型(固定搭配) -- op: send, touid: 0, pmid: 0, pmsubmit: true
	* 接收方的用户名 -- username
	* 私信内容 -- message
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 返回参数
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组

#### 样例
	{"code":0,"data":[],"msg":"进行的操作完成了","action":"do_success"}
[↑返回顶部](#momo)

<h2>更改头像</h2>
#### 注意:采用POST上传
#### POST样例：
	`<!DOCTYPE HTML>
	<html>
	<head>
	<meta charset="utf-8">
	<title>上传头像</title></head><body>
	<form action="capi/cp.php?ac=avatar" method="post" enctype="multipart/form-data">
	<input type="file" name="Filedata"/><input type="submit"  name="submit"  value="提交"/>
	<input type="hidden" name="m_auth" value="af9cCEMpQlfFTifZltugadwhGAXL%2Ba%2BCor8voR9jZyBh60v4xFryq2ibMM1tNHXaHYweU%2B8hsBHobKzgHFJs" />
	<input type="hidden" name="ac" value="avatar" />
	<input type="hidden" name="avatarsubmit" id="avatarsubmit" value="true" />
	</form></body>`

#### 请求参数
	* 上传头像 -- Filedata
	* 操作类型(固定搭配) -- ac:avatar, avatarsubmit:true
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户
	
#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组 本操作返回三个数据
		* data[url], 返回头像的链接
			* big -- 大头像URL
			* middle -- 中头像URL
			* small -- 小头像URL
		* data[reward], 返回操作增加的金币和信用
			* credit -- 增加的金币量
			* experience -- 增加的信用
		* date[dateline]: 操作更新的时间

#### 样例
	{"code":0,"data":{"url":{"big":"http:\/\/localhost:8080\/momo\/center\/data\/avatar\/000\/00\/00\/00_avatar_big.jpg","middle":"http:\/\/localhost:8080\/momo\/center\/data\/avatar\/000\/00\/00\/00_avatar_middle.jpg","small":"http:\/\/localhost:8080\/momo\/center\/data\/avatar\/000\/00\/00\/00_avatar_small.jpg"},"msg":"",
	"reward":{"credit":0,"experience":0},"dateline":"1344421976"},"msg":"\u8fdb\u884c\u7684\u64cd\u4f5c\u5b8c\u6210\u4e86","action":"do_success"}
[↑返回顶部](#momo)

<h2>更改昵称</h2>
域名/capi/cp.php?ac=profile&op=name&name=summit&m_auth=af9cCEMpQlfFTifZltu

#### 请求参数
	* 操作类型(固定搭配) -- op: name
	* 昵称 -- name
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 返回参数
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组 返回操作完成增加的金币和经验
		* credit -- 金币
		* experience -- 经验
#### 样例
	{
		"code": 0,
		"data": {
			"credit": 0,
			"experience": 0
		},
		"msg": "进行的操作完成了",
		"action": "do_success"
	}
[↑返回顶部](#momo)

<h2>单向加关注</h2>
域名/capi/cp.php?ac=friend&op=add&uid=4&gid=0&addsubmit=true&m_auth=0ff76%2B%2F

#### 请求参数
	* 操作类型（固定搭配） -- ac:friend , op:add, addsubmit=true
	* 加为关注的用户id -- uid
	* 好友组别 -- gid
	    * 0 -- 其他
	    * 1 -- 通过本站认识
	    * 2 -- 通过活动认识
	    * 3 -- 通过朋友认识
	    * 4 -- 亲人
	    * 5 -- 同事
	    * 6 -- 同学
	    * 7 -- 不认识
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 返回参数
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
#### 样例
	{
	    "code": 0,
	    "data": [
	        "test8"
	    ],
	    "msg": "您和 晓林 成为好友了",
	    "action": "friends_add"
	}
[↑返回顶部](#momo)
