momo
=====
******************************

索引
----
* 下行接口
	*	[好友动态列表接口](#好友动态列表接口)
	*	[通知列表接口](#通知列表接口)
	*	[私信列表接口](#私信列表接口)
	*	[私信详情](#私信详情)
	*	[好友排行榜接口](#好友排行榜接口)
	*	[我的个人信息](#我的个人信息)
	*   	[系统未读信息计数器](#系统未读信息计数器)
	*	[用户登陆状态](#用户登陆状态)
	*	[好友申请列表](#好友申请列表)

* 上行接口
	*	[获取注册验证码](#获取注册验证码)
	*	[注册](#注册)
	*	[登录](#登录)
	*	[上传图片](#上传图片)
	*	[撰写评论](#撰写评论)
	*	[发布私信](#发布私信)
	*	[更改头像](#更改头像)
	*	[更改昵称](#更改昵称)
	*	[退出](#退出)
	*	[单向加关注](#单向加关注)
	*	
	*	[发表博客](#发表博客)
	*	[查看自己的全部博客](#查看自己的全部博客)
	*       [查看自己某篇博客的具体内容](#查看自己某篇博客的具体内容)
	*       [删除自己的某篇博客](#删除自己的某篇博客)
	*	[查看某个关注人的全部博客](#查看某个关注人的全部博客)
	*	[查看整个站点的博客](#查看整个站点的博客)

接口说明
--------

<h2>查看自己的全部博客</h2>
域名/capi/space.php?do=blog&view=me&auth=6284SqqRXsIhxZ2IUCMkFUcRADW8fsyHyTYimRgF1w

#### 请求参数
	* 当前用户id -- uid

#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败

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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
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



<h2>好友动态列表接口</h2>
域名/capi/space.php?do=feed&uid=1&page=0&perpage=10&view=friend&dateline=1343793316&queryop=down&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	* 当前用户id -- uid
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 查询参数 -- view, 值为we代表好友动态列表
	* API密钥 -- m_auth, 由登录后返回
	* 时间点 -- dateline
	* 查询方式 -- queryop, 取值可以是up, down
		* up 代表上拉，取比dateline新的动态
		* down 代表到底，取紧接着dateline之后的动态
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[feeds]，feed列表， 条目字段如下
			* title_template -- feed的标题
			* body_template -- feed的内容
			* dateline -- feed的时间
			* uid -- 发布feed的用户id
			* username -- 发布feed用户
			* body_data -- feed的内容，当前仅有打赌、表态、评论、加为好友				
			* icon -- feed类型
				* quiz -- 打赌
				* do -- 心情
				* pic -- 图片
				* profile -- 更新资料
				* click -- 表太空
				* comment -- 评论
				* friend -- 成为好友

		* data[count], 返回列表条目数, 便用遍历
#### 样例




[↑返回顶部](#momo)

<h2>全站动态列表接口</h2>
域名/capi/space.php?do=feed&page=0&perpage=10&view=quiz&queryop=down&dateline=13234834
#### 请求参数
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 查询参数 -- view, 值为quiz代表全站打赌动态列表
	* 时间点 -- dateline
	* 查询方式 -- queryop, 取值可以是up, down
		* up 代表上拉，取比dateline新的动态
		* down 代表到底，取紧接着dateline之后的动态
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[feeds]，feed列表， 条目字段如下
			* title_template -- feed的标题
			* body_template -- feed的内容
			* dateline -- feed的时间
			* uid -- 发布feed的用户id
			* username -- 发布feed用户
			* body_data -- feed的内容，当前仅有打赌有意义
			* icon -- feed类型
				* quiz -- 打赌
				* do -- 心情
				* pic -- 图片
				* profile -- 更新资料

		* data[count], 返回列表条目数, 便用遍历
#### 样例
	




[↑返回顶部](#momo)

<h2>通知列表接口</h2>
域名/capi/space.php?do=notice&page=0&prepage=2&uid=1&type=quizinvalid&dateline=324234&queryop=up&m_auth=55dalDuJy
#### 请求参数
	* 当前用户id -- uid
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 通知类型 -- type
	* API密钥 -- m_auth, 由登录后返回
	* 时间点 -- dateline
	* 查询方式 -- queryop, 取值可以是up, down
		* up 代表上拉，取比dateline新的动态
		* down 代表到底，取紧接着dateline之后的动态
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[notices]，通知列表， 条目字段如下
			* id -- 通知id
			* uid -- 接收通知的用户
			* type -- 通知类型（取值含义见请求参数）
			* authorid -- 发送通知的用户
			* authorid -- 发送通知的用户
			* note -- 通知的内容
			* isfriend -- 接收和发送方是否好友
			* dateline -- 时间
			* avatar -- 通知头像
		* data[count], 返回列表条目数, 便用遍历
#### 样例
	




[↑返回顶部](#momo)

<h2>私信列表接口</h2>
域名/capi/space.php?do=pm&page=0&prepage=2&uid=1&filter=newpm&dateline=0&queryop=up&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
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
	* 查询方式 -- queryop, 取值可以是up, down
		* up 代表上拉，取比dateline新的动态
		* down 代表到底，取紧接着dateline之后的动态
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
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

<h2>好友排行榜接口</h2> 
域名/capi/space.php?uid=5&do=friend&m_auth=54f8qnt8HxbRz8NWomy0e4k2gKvVvc6oil8qDY9upUERswmzj
#### 请求参数
	* 当前用户id -- uid
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[friends]，好友列表， 条目字段如下(类似于[登录](#登录)返回的空间信息
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
			* spacenote -- 心情
			* lastpost -- 最新提交时间
			* lastlogin -- 最新登录时间
			* attachsize -- 空间大小
			* flag -- 是否被禁
			* newpm -- 是否有新通知
			* avatar -- 个人头像
			* quiznum -- 发布的打赌数
			* voternum -- 参加打赌的次数
			* creditrank -- 金币排行
			* experiencerank -- 经验排行
			
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
		"code": 0,
		"data": {
			"friends": [
				{
					"uid": "5",
					"groupid": "11",
					"credit": "1040",
					"experience": "1004",
					"username": "summit",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "10",
					"viewnum": "20",
					"notenum": "22",
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
					"dateline": "1343726668",
					"updatetime": "1343726701",
					"lastsearch": "0",
					"lastpost": "1343726701",
					"lastlogin": "1344936333",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.115.181",
					"ip": "74125184",
					"mood": "0",
					"quiznum": "0",
					"winnum": "1",
					"lostnum": "0",
					"voternum": "1",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "5",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "1",
					"groupid": "5",
					"credit": "152",
					"experience": "45",
					"username": "admin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "8",
					"viewnum": "7",
					"notenum": "1",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "1",
					"doingnum": "0",
					"blognum": "1",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1343725030",
					"updatetime": "1343873852",
					"lastsearch": "0",
					"lastpost": "1343873852",
					"lastlogin": "1346209918",
					"lastsend": "0",
					"attachsize": "2155640",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "127.0.0.1",
					"ip": "113111119",
					"mood": "0",
					"quiznum": "2",
					"winnum": "0",
					"lostnum": "1",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "1",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "14",
					"groupid": "5",
					"credit": "79",
					"experience": "14",
					"username": "lin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "5",
					"viewnum": "3",
					"notenum": "0",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "2",
					"doingnum": "0",
					"blognum": "0",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1344825403",
					"updatetime": "0",
					"lastsearch": "0",
					"lastpost": "0",
					"lastlogin": "1345707145",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.133.144",
					"ip": "113111117",
					"mood": "0",
					"quiznum": "0",
					"winnum": "0",
					"lostnum": "0",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "0",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)


<h2>我的个人信息</h2>
域名/capi/cp.php?ac=profile&m_auth=65e8JkX8RscU2y2pYZEVdcZrja2YOr2QXuhbPBCHzLAw
#### 请求参数
	* API密钥 -- m_auth, 由登录后返回
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回一个数据
		* data[space], 当前登录用户的信息，具体内容如下
			* 用户id -- uid
			* 性别 -- sex, 男取值0， 女取值1
			* 用户邮箱 -- email
			* 手机 -- mobile
			* qq帐号 -- qq
			* msn帐号 -- msn
			* weibo帐号 -- weibo
			* 隐私数组 -- privacy, 由类型区分0代表全站可见
			* 动态数组 -- feed, 由类型区分
			* 好友数 -- friend
			* 动态好友数 -- feedfriend
			* 金币 -- credit
			* 信用 -- experience
			* 用户名 -- username
			* 实名 -- name
			* 是否实名 -- namestatus, 1是, 0否
			* 心情数 -- doingnum
			* 分享数 -- sharenum
			* 最近活跃时间 -- dateline
			* 最近更新时间 -- updatetime
			* 最近一次搜索时间 -- lastsearch
			* 最近一次发布时间 -- lastpost
			* 最近一次登录时间 -- lastlogin
			* 最近一次发送消息时间 -- lastsend
			* 是否禁用 -- flag
			* 是否有新通知 -- newpm
			* 头像 -- avatar
			* 登录的ip -- ip
			* 附件大小 -- attachsize
			* 好友列表id -- friends

			
#### 样例
	{
		"code": 0,
		"data": {
			"space": {
				"uid": "5",
				"sex": "0",
				"email": "summit_mail@qq.com",
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
				"friend": "7",
				"feedfriend": "7",
				"sendmail": "",
				"magicstar": "0",
				"magicexpire": "0",
				"timeoffset": "",
				"weibo": "",
				"groupid": "11",
				"credit": "2048",
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
				"lastsearch": "0",
				"lastpost": "1344932295",
				"lastlogin": "1345359730",
				"lastsend": "0",
				"attachsize": "0",
				"addsize": "0",
				"addfriend": "0",
				"flag": "0",
				"newpm": "0",
				"avatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/05_avatar_small.jpg",
				"regip": "127.0.0.1",
				"ip": "127000000",
				"mood": "0",
				"quiznum": "10",
				"winnum": "4",
				"lostnum": "1",
				"voternum": "8",
				"self": 1,
				"friends": [
					"7"
				],
				"allnotenum": 0
			}
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)



<h2>搜索好友</h2>
域名/capi/cp.php?ac=friend&op=search&page=0&perpage=1&searchkey=admin&searchsubmit=true&searchmode=1&m_auth=af9cCEMpQ
#### 请求参数
	* 用户id -- uid
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 查询参数 -- searchsubmit必须为true, searchmode必须为1
	* 查询内容 -- searchkey
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[friend]，打赌列表， 条目字段如下
			* 用户id -- uid
			* 用户头像 -- avatar
			* 金币 -- credit
			* 信用 -- experience
			* 用户名 -- username
			* 实名 -- name
			* 是否实名 -- namestatus, 1是, 0否
			* 心情数 -- doingnum
			* 分享数 -- sharenum
			* 最近活跃时间 -- dateline
			* 最近更新时间 -- updatetime
			* 最近一次搜索时间 -- lastsearch
			* 最近一次发布时间 -- lastpost
			* 最近一次登录时间 -- lastlogin
			* 最近一次发送消息时间 -- lastsend
			* 是否禁用 -- flag
			* 是否有新通知 -- newpm
			* 头像 -- avatar
			* 登录的ip -- ip
			* 附件大小 -- attachsize
			* 发布的打赌数 -- quiznum
			* 赢的次数 -- winnum
			* 输的次数 -- lostnum
			* 参与打赌数 -- voternum
			* 是否好友-- isfriend, 0否，1是
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
		"code": 0,
		"data": {
			"friends": [
				{
					"uid": "5",
					"groupid": "11",
					"credit": "1040",
					"experience": "1004",
					"username": "summit",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "10",
					"viewnum": "20",
					"notenum": "22",
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
					"dateline": "1343726668",
					"updatetime": "1343726701",
					"lastsearch": "0",
					"lastpost": "1343726701",
					"lastlogin": "1344936333",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.115.181",
					"ip": "74125184",
					"mood": "0",
					"quiznum": "0",
					"winnum": "1",
					"lostnum": "0",
					"voternum": "1",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "5",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "1",
					"groupid": "5",
					"credit": "152",
					"experience": "45",
					"username": "admin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "8",
					"viewnum": "7",
					"notenum": "1",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "1",
					"doingnum": "0",
					"blognum": "1",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1343725030",
					"updatetime": "1343873852",
					"lastsearch": "0",
					"lastpost": "1343873852",
					"lastlogin": "1346209918",
					"lastsend": "0",
					"attachsize": "2155640",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "127.0.0.1",
					"ip": "113111119",
					"mood": "0",
					"quiznum": "2",
					"winnum": "0",
					"lostnum": "1",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "1",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "14",
					"groupid": "5",
					"credit": "79",
					"experience": "14",
					"username": "lin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "5",
					"viewnum": "3",
					"notenum": "0",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "2",
					"doingnum": "0",
					"blognum": "0",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1344825403",
					"updatetime": "0",
					"lastsearch": "0",
					"lastpost": "0",
					"lastlogin": "1345707145",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.133.144",
					"ip": "113111117",
					"mood": "0",
					"quiznum": "0",
					"winnum": "0",
					"lostnum": "0",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "0",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)




<h2>系统未读信息计数器</h2>

域名/capi/space.php?do=stat&m_auth=e8b7zu%2BuRuir9hvAgj%2BLxbZtCgUKnFTojhHKjm9zc%2ByGzcuj2cUL

#### 请求参数
	* 固定参数 -- do, 必须为stat
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段

	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组,
		* allnotenum: 未读通知数
		* newpn: 新短消息
		* addfriendnum: 好友请求

#### 样例

	{
		"code": 0,
		"data": {
			"allnotenum": 25,
			"newpm": "0",
			"addfriendnum": "0"
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}


[↑返回顶部](#momo)

<h2>用户登陆状态</h2>

域名/capi/space.php?do=isonline&uid=186

#### 请求参数
	* 固定参数 -- do, 必须为isonline
	* uid -- 查询的用户id

#### 返回字段

	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组,
		* isonline: 0代表不在线, 1代表新浪微博在线, 2代表腾讯微博在线


#### 样例

	{
		"code": 0,
		"data": {
			"isonline": "2"
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}


[↑返回顶部](#momo)

<h2>好友申请列表</h2>
域名/capi/cp.php?ac=friend&op=request&page=0&perpage=1&m_auth=8616qvbrwntFdXONEB

#### 请求参数
	* 用户id -- uid
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* 查询参数 -- op必须为request&page
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[friend]，打赌列表， 条目字段如下
			* 用户id -- uid
			* 用户头像 -- avatar
			* 金币 -- credit
			* 信用 -- experience
			* 用户名 -- username
			* 实名 -- name
			* 是否实名 -- namestatus, 1是, 0否
			* 心情数 -- doingnum
			* 分享数 -- sharenum
			* 最近活跃时间 -- dateline
			* 最近更新时间 -- updatetime
			* 最近一次搜索时间 -- lastsearch
			* 最近一次发布时间 -- lastpost
			* 最近一次登录时间 -- lastlogin
			* 最近一次发送消息时间 -- lastsend
			* 是否禁用 -- flag
			* 是否有新通知 -- newpm
			* 头像 -- avatar
			* 登录的ip -- ip
			* 附件大小 -- attachsize
			* 发布的打赌数 -- quiznum
			* 赢的次数 -- winnum
			* 输的次数 -- lostnum
			* 参与打赌数 -- voternum
			* 是否好友-- isfriend, 0否，1是
			* 是否在线 --  isonline, 0不在线, 1新浪微博在线, 2腾讯微博在线
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
		"code": 0,
		"data": {
			"friends": [
				{
					"uid": "1",
					"groupid": "11",
					"credit": "2231",
					"experience": "2293",
					"username": "admin",
					"name": "admin",
					"namestatus": "1",
					"videostatus": "0",
					"domain": "",
					"friendnum": "0",
					"viewnum": "8",
					"notenum": "25",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "0",
					"doingnum": "1",
					"blognum": "3",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "1",
					"dateline": "1352519246",
					"updatetime": "1348716805",
					"lastsearch": "1344408548",
					"lastpost": "1352516403",
					"lastlogin": "1352519695",
					"lastsend": "0",
					"attachsize": "4873023",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://localhost:8080/momo/center/images/noavatar_small.gif",
					"regip": "127.0.0.1",
					"ip": "127000000",
					"mood": "0",
					"quiznum": "32",
					"winnum": "2",
					"lostnum": "1",
					"voternum": "12",
					"friend": "",
					"fuid": "27",
					"fusername": "sina_2236",
					"status": "0",
					"gid": "0",
					"note": "",
					"num": "0",
					"cfriend": "",
					"cfcount": 0,
					"isonline": 0
				}
			],
			"count": 1
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}

[↑返回顶部](#momo)

<h2>我的好友列表</h2> 
域名/capi/space.php?uid=5&do=friend&isinsert=true&m_auth=54f8qnt8HxbRz8NWomy0e4k2gKvVvc6oil8qDY9upUERswmzj
#### 请求参数
	* 当前用户id -- uid
	* API密钥 -- m_auth, 由登录后返回

#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[friends]，好友列表， 条目字段如下(类似于[登录](#登录)返回的空间信息
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
			* spacenote -- 心情
			* lastpost -- 最新提交时间
			* lastlogin -- 最新登录时间
			* attachsize -- 空间大小
			* flag -- 是否被禁
			* newpm -- 是否有新通知
			* avatar -- 个人头像
			* creditrank -- 金币排行
			* experiencerank -- 经验排行
			* online -- 0,代表不在线 , 1代表新浪微博在线, 2代表腾讯微博在线
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
		"code": 0,
		"data": {
			"friends": [
				{
					"uid": "5",
					"groupid": "11",
					"credit": "1040",
					"experience": "1004",
					"username": "summit",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "10",
					"viewnum": "20",
					"notenum": "22",
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
					"dateline": "1343726668",
					"updatetime": "1343726701",
					"lastsearch": "0",
					"lastpost": "1343726701",
					"lastlogin": "1344936333",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.115.181",
					"ip": "74125184",
					"mood": "0",
					"quiznum": "0",
					"winnum": "1",
					"lostnum": "0",
					"voternum": "1",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "5",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "1",
					"groupid": "5",
					"credit": "152",
					"experience": "45",
					"username": "admin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "8",
					"viewnum": "7",
					"notenum": "1",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "1",
					"doingnum": "0",
					"blognum": "1",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1343725030",
					"updatetime": "1343873852",
					"lastsearch": "0",
					"lastpost": "1343873852",
					"lastlogin": "1346209918",
					"lastsend": "0",
					"attachsize": "2155640",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "127.0.0.1",
					"ip": "113111119",
					"mood": "0",
					"quiznum": "2",
					"winnum": "0",
					"lostnum": "1",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "1",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				},
				{
					"uid": "14",
					"groupid": "5",
					"credit": "79",
					"experience": "14",
					"username": "lin",
					"name": "",
					"namestatus": "0",
					"videostatus": "0",
					"domain": "",
					"friendnum": "5",
					"viewnum": "3",
					"notenum": "0",
					"addfriendnum": "0",
					"mtaginvitenum": "0",
					"eventinvitenum": "0",
					"myinvitenum": "0",
					"pokenum": "2",
					"doingnum": "0",
					"blognum": "0",
					"albumnum": "0",
					"threadnum": "0",
					"pollnum": "0",
					"eventnum": "0",
					"sharenum": "0",
					"dateline": "1344825403",
					"updatetime": "0",
					"lastsearch": "0",
					"lastpost": "0",
					"lastlogin": "1345707145",
					"lastsend": "0",
					"attachsize": "0",
					"addsize": "0",
					"addfriend": "0",
					"flag": "0",
					"newpm": "0",
					"avatar": "http://58.215.187.8:8081/center/images/noavatar_small.gif",
					"regip": "113.111.133.144",
					"ip": "113111117",
					"mood": "0",
					"quiznum": "0",
					"winnum": "0",
					"lostnum": "0",
					"voternum": "2",
					"resideprovince": "",
					"residecity": "",
					"note": "",
					"spacenote": "",
					"sex": "0",
					"gid": "0",
					"num": "0",
					"creditrank": "4",
					"experiencerank": "3",
					"p": "",
					"c": "",
					"group": "其他",
					"isfriend": 1
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)

<h2>我的留言</h2>
域名/capi/do.php?ac=ajax&op=getcomment&id=24&idtype=uid&page=0&prepage=1&dateline=234234&queryop=up&m_auth=af9cCEMpQlfFTifZltugadwhG

#### 请求参数
	* 操作类型 -- op, 必须为getcomment
	* 查询评论关联的id -- id, 若为打赌，则为打赌id值，若为空间则为用户id值，若为分享则为分享id值
	* 指示id代表的类型 -- idtype, uid代表空间
	* 第几页 -- page
	* 每页显示数量  -- perpage
	* API密钥 -- m_auth, 由登录后返回
	* 时间点 -- dateline
	* 查询方式 -- queryop, 取值可以是up, down
		* up 代表上拉，取比dateline新的评论
		* down 代表到底，取紧接着dateline之后的评论
#### 返回字段
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[comments],评论列表，具体内容如下
			* 评论id -- cid
			* 评论对象，用户id -- uid
			* 评论对象头像 -- avatar
			* 评论关联的id -- id
			* 评论类型 -- idtype
			* 发表评论的用户id -- authorid
			* 发表评论的用户头像 -- authoravatar
			* 发表评论的用户名 -- author
			* 发表的时间 -- dateline
			* 发表的ip -- ip
			* 评论的内容 -- message
		* data[count], 返回列表条目数, 便用遍历

#### 样例
	{
    "code": 0,
    "data": {
        "comments": [
            {
                "cid": "31",
                "uid": "1",
                "id": "24",
                "idtype": "quizid",
                "authorid": "1",
                "author": "admin",
                "ip": "127.0.0.1",
                "dateline": "1344407149",
                "message": "234234",
                "magicflicker": "0",
                "avatar": "http://localhost:8080/momo/center/data/avatar/000/00/00/01_avatar_small.jpg"
            }
        ],
        "count": 1
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, rest_success:代表成功, rest_fail:代表失败
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* data[seccode_auth] -- 返回的验证码key，在注册时需要传入
		* data[seccode] -- 验证码

#### 样例
	{"code":0,"data":{"seccode_auth":"1a6431MIvgvhZZzUPUmCUML%2FtL4rlXrN2R8nL5G3qvta","seccode":"CQ7T"},
	"msg":"数据获取成功","action":"rest_success"}
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户
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

#### 样例
	{"code":0,"data":{"space":{"uid":"11","sex":"0","email":"test6@momo.cn","newemail":"","emailcheck":"0",
	"mobile":"","qq":"","msn":"","msnrobot":"","msncstatus":"0","videopic":"","birthyear":"0","birthmonth":"0",
	"birthday":"0","blood":"","marry":"0","birthprovince":"","birthcity":"","resideprovince":"","residecity":"",
	"note":"","spacenote":"","authstr":"","theme":"","nocss":"0","menunum":"0","css":"",
	"privacy":{"view":{"index":"0","friend":"0","wall":"0","feed":"0","mtag":"0","event":"0","doing":"0",
	"blog":"0","quiz":"0","album":"0","share":"0","poll":"0"},"feed":{"doing":1,"blog":1,"quiz":1,"joinquiz":1,
	"upload":1,"share":1,"poll":1,"joinpoll":1,"thread":1,"post":1,"mtag":1,"event":1,"join":1,"friend":1,
	"comment":1,"show":1,"credit":1,"spaceopen":1,"invite":1,"task":1,"profile":1,"click":1}},"friend":"",
	"feedfriend":"","sendmail":"","magicstar":"0","magicexpire":"0","timeoffset":"","weibo":"","groupid":"0",
	"credit":"25","experience":"15","username":"test6","name":"","namestatus":"0","videostatus":"0","domain":"",
	"friendnum":"0","viewnum":"0","notenum":"0","addfriendnum":"0","mtaginvitenum":"0","eventinvitenum":"0",
	"myinvitenum":"0","pokenum":"0","doingnum":"0","blognum":"0","albumnum":"0","threadnum":"0","pollnum":"0",
	"eventnum":"0","sharenum":"0","dateline":"1344414070","updatetime":"0","lastsearch":"0","lastpost":"0",
	"lastlogin":"1344414070","lastsend":"0","attachsize":"0","addsize":"0","addfriend":"0","flag":"0","newpm":"0",
	"avatar":"0","regip":"127.0.0.1","ip":"127000000","mood":"0","voternum":"0","self":1,"friends":[],"allnotenum":0},
	"m_auth":"cf7chDvDIcnUVeupGp4utLftIQEP%2B1rP8eGrGWydH3ITmly6DURpvHCvByCJlE0hEus%2F5Ji%2FqVUrfnd3dHn6%2BA"},
	"msg":"注册成功了，进入个人空间","action":"registered"}
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户
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
	* 错误信息 -- msg, 详细参见附录
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 返回操作完成增加的金币和经验
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录

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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回三个数据
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 返回操作完成增加的金币和经验
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
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, request_has_been_sent:代表成功
	* 错误信息 -- msg, 详细参见附录
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
