momo
=====
******************************
* 接口
	*	[获取注册验证码](#获取注册验证码)
	*	[注册](#注册)
	*	[登录](#登录)
	*	[退出](#退出)
	*	[检测用户登陆状态](#检测用户登陆状态)  

	*	[附近的用户](#附近的用户)
	*	[单向加关注](#单向加关注)
	*	[我的好友列表](#我的好友列表)
	*   [删除好友](#删除好友)  
	
	*	[修改个人基本资料](#修改个人基本资料)
	*   [增加个人工作情况](#增加个人工作情况)
	*	[删除个人工作情况](#删除个人工作情况)
	*	[增加个人教育情况](#增加个人教育情况)
	*	[删除个人教育情况](#删除个人教育情况)
	*	[修改昵称](#修改昵称)
	*	[添加个人签名](#添加个人签名)
	*	[分类查看个人信息](#分类查看个人信息)
	*   [我的个人信息](#我的个人信息)  

	*   [添加图片](#添加图片)
	*	[上传头像](#上传头像)
	*	[得到某个用户的大中小头像存放目录](#得到某个用户的大中小头像存放目录)  

	*	[好友动态列表](#好友动态列表)
	*	[发布私信](#发布私信)
	*	[私信列表](#私信列表)
	*	[查看新私信](#查看新私信)
	*	[根据消息id查看私信详情](#根据消息id查看私信详情)
	*	[根据消息来源查看私信详情](#根据消息来源查看私信详情)  

	*	[新建博客分类](#新建博客分类)
	*	[删除博客分类](#删除博客分类)
	*	[查看我的全部博客分类](#查看我的全部博客分类)
	*	[发表博客](#发表博客)
	*	[对某篇博客表态称赞](#对某篇博客表态称赞)
	*	[撰写对某篇博客评论](#撰写对某篇博客评论)
	*	[某篇博客的评论列表](#某篇博客的评论列表)
	*	[查看自己的全部博客](#查看自己的全部博客)
	*   [查看自己某篇博客的具体内容](#查看自己某篇博客的具体内容)
	*   [删除自己的某篇博客](#删除自己的某篇博客)
	*   [查看某个被关注人的全部博客](#查看某个被关注人的全部博客)
	*   [查看所有被关注人的全部博客](#查看所有被关注人的全部博客)
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
<h2>删除好友</h2>
域名/capi/cp.php?ac=friend&op=ignore&friendsubmit=true&uid=4&m_auth=79ccF6ut7bTo8gRdHMU

#### 请求参数
	* ac=friend&op=ignore&friendsubmit=true --- 固定搭配
	* uid -- 用户id
	* m_auth --- 授权码	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
			
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>得到某个用户的大中小头像存放目录</h2>
域名/capi/cp.php?ac=avatar&getavatar=true&uid=6&m_auth=403wei

#### 请求参数
	* ac=avatar&getavatar=true --- 固定搭配
	* uid -- 用户id
	* m_auth --- 授权码	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
			
#### 样例
	{
	    "code": 0,
	    "data": {
	        "small": "/data/avatar/000/00/00/06_avatar_small.jpg",
	        "middle": "/data/avatar/000/00/00/06_avatar_middle.jpg",
	        "big": "/data/avatar/000/00/00/06_avatar_big.jpg"
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)



<h2>附近的用户</h2>
域名/capi/space.php?do=near&m_auth=c39aGq%2BSPRshmMH50rcR%2Bjqq%2Fz82zaomqDSuuWG5tw


#### 请求参数
	* do=near --- 固定搭配
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
			* uid --- 用户id
			* username --- 用户名
			* isdoctor --- 是否是医生 0 -- 非医生，1 -- 医生
			* sex -- 性别 0：没有设置	1：男 2：女
			* avatar -- 头像所在目录,加上网址即可下载
			* dateline -- 注册时间
	        * resideprovince -- 居住省份
	        * residecity -- 居住城市
			* distance --- 距离
		
	
#### 样例
	{
	    "code": 0,
	    "data": [
	        {
	            "uid": "8",
	            "username": "test08",
	            "isdoctor": "0",
	            "sex":"0",
	            "dateline": "1385471652",
	            "resideprovince": "",
	            "residecity": "",
	            "avatar": "/data/avatar/noavatar_middle.gif",
	            "distance": 755.9084
	        },
	        {
	            "uid": "9",
	            "username": "test09",
	            "isdoctor": "0",
	            "sex":"0",
	            "dateline": "1386419293",
	            "resideprovince": "",
	            "residecity": "",
	            "avatar": "/data/avatar/000/00/00/09_avatar_middle.jpg",
	            "distance": 1852.6505
	        }
	    ],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}


[↑返回顶部](#momo)

<h2>添加图片</h2>
域名/capi/cp.php?ac=upload&uploadsubmit2=true&albumid=0&m_auth=c39aGq%2BSPRshmMH50rcR%2Bjqq%2Fz82zaomqDSuuWG5tw&attach=


#### 请求参数
	* ac=upload&uploadsubmit2=true&albumid=0  --- 固定搭配
	* attach ---  要上传的文件 post方式提交
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
			* albumid --- 相册id
			* uid --- 上传图片的用户id
			* filename --- 上传的文件名
			* filepath --- 文件存放路径
			* picid --- 上传后保存的id	
			* filepath --- 图片保存目录，加上http://gluchome.duapp.com/attachment/
			* pic --- 上传后的缩略图，加上http://gluchome.duapp.com/
		
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "pic": {
	            "albumid": 0,
	            "uid": 6,
	            "dateline": "1390925663",
	            "filename": "2e7c0708caf4599662d9862b.jpg",
	            "postip": "127.0.0.1",
	            "title": "",
	            "type": "image/jpeg",
	            "size": 41175,
	            "filepath": "201401/28/6_13909256636f3i.jpg",
	            "thumb": 1,
	            "remote": 0,
	            "topicid": 0,
	            "picid": 8,
	            "pic": "attachment/201401/28/6_13909256636f3i.jpg.thumb.jpg"
	        }
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)



<h2>分类查看个人信息</h2>
域名/capi/cp.php?ac=profile&op=work&m_auth=a5bd8ujqRWZeW4f9a3M3cUnY3E%2FJE5a4vbHVJdfQgA


#### 请求参数
	* ac=profile --- 固定搭配
	* m_auth --- 授权码
	* op --- 取为不同的值，得到不同的个人信息
			* work -- 工作情况
			* edu --  教育情况
			* info --  相关信息 (个人签名，兴趣爱好等)

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### op=work 的 样例	
	{
	    "code": 0,
	    "data": [
	        {
	            "infoid": "31",
	            "uid": "6",
	            "type": "work",
	            "subtype": "",
	            "title": "广东丰德",
	            "subtitle": "软件部",
	            "friend": "0",
	            "startyear": "2010",
	            "endyear": "0",
	            "startmonth": "0",
	            "endmonth": "0"	      
	        }
	        
	    ],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
### op = edu 的样例
	{
	    "code": 0,
	    "data": [
	        {
	            "infoid": "33",
	            "uid": "6",
	            "type": "edu",
	            "subtype": "",
	            "title": "广东医学院",
	            "subtitle": "信息工程学院",
	            "friend": "0",
	            "startyear": "2010",
	            "endyear": "0",
	            "startmonth": "0",
	            "endmonth": "0"
	        },
	        {
	            "infoid": "37",
	            "uid": "6",
	            "type": "edu",
	            "subtype": "",
	            "title": "连平中学",
	            "subtitle": "高中",
	            "friend": "0",
	            "startyear": "2007",
	            "endyear": "2010",
	            "startmonth": "9",
	            "endmonth": "7"
	        }
	    ],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
### op = info 时的样例
	{
	    "code": 0,
	    "data": {
	        "motto": {
	            "infoid": "30",
	            "uid": "6",
	            "type": "info",
	            "subtype": "motto",
	            "title": "医者仁心",
	            "subtitle": "",
	            "friend": "0",
	            "startyear": "0",
	            "endyear": "0",
	            "startmonth": "0",
	            "endmonth": "0"
	        }
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
[↑返回顶部](#momo)


<h2>增加个人工作情况</h2>
域名/capi/cp.php?ac=profile&op=work&profilesubmit=true&title=广东医学院&subtitle=信息工程学院&startyear=2010&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile&op=work&profilesubmit=true  --- 固定搭配
	* title ---  公司或机构名
	* subtitle --- 部门名
	* startyear --- 就职的年份
	* startmonth --- 就职的月份
	* endyear --- 离职的年份
	* endmonth --- 离职的月份
    * m_auth --- 授权码
	

#### 返回字段
	*code -- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "个人资料更新成功了",
	    "action": "update_on_successful_individuals"
	}

[↑返回顶部](#momo)


<h2>删除个人工作情况</h2>
域名/capi/cp.php?ac=profile&op=work&subop=delete&profilesubmit=true&infoid=10&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile&op=work&subop=delete&profilesubmit=true  --- 固定搭配
	* infoid ---  教育信息id
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)




<h2>修改昵称</h2>
域名/capi/cp.php?ac=profile&op=name&name=春雨&m_auth=af9cCEMpQlfFTifZltu


#### 请求参数
	* ac=profile&op=name  --- 固定搭配
	* name ---  真实姓名
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)

<h2>添加个人签名</h2>
域名/capi/cp.php?ac=profile&op=info&profilesubmit=true&motto=医者仁心&m_auth=af9cCEMpQlfFTifZltu


#### 请求参数
	* ac=profile&op=info&profilesubmit=true --- 固定搭配
	* motto ---  个人签名
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>增加个人教育情况</h2>
域名/capi/cp.php?ac=profile&op=edu&profilesubmit=true&title=广东医学院&subtitle=信息工程学院
&startyear=2010&startmonth=9&endyear=2014&endmonth=7&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile&op=edu&profilesubmit=true  --- 固定搭配
	* title ---  校名
	* subtitle --- 学院名
	* startyear --- 入学年份
	* startmonth ---  入学月份
	* endyear --- 毕业年份
	* endmonth ---  毕业月份
    * m_auth --- 授权码

	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "个人资料更新成功了",
	    "action": "update_on_successful_individuals"
	}

[↑返回顶部](#momo)


<h2>删除个人教育情况</h2>
域名/capi/cp.php?ac=profile&op=edu&subop=delete&profilesubmit=true&infoid=10&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile&op=edu&subop=delete&profilesubmit=true  --- 固定搭配
	* infoid ---  教育信息id
	* m_auth --- 授权码

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)





<h2>修改个人基本资料</h2>
域名/capi/cp.php?ac=profile&op=base&profilesubmit=true&birthyear=1990&birthmonth=10&birthday=21&birthprovince=广东&birthcity=河源
&resideprovince=广东&residecity=广州&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile&op=base&profilesubmit=true  --- 固定搭配
	* name ---  真实姓名
	* birthyear --- 出生年
	* birthmonth --- 出生月
	* birthday ---  出生日
	* birthporvince --- 出生省
	* birthcity -- 出生市
	* resideprovince --- 现在居住在哪个省
	* residecity --- 现在居住在哪个市
	* blood --- 血型
	* marry --- 是否已婚 
			* 1：单身 
			* 2：非单身
	* sex --- 性别
			* 1：男
			* 2：女

	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "个人资料更新成功了",
	    "action": "update_on_successful_individuals"
	}

[↑返回顶部](#momo)


<h2>我的个人信息</h2>
域名/capi/cp.php?ac=profile&m_auth=4f1bzUvjXrW7MIHumGEpavu4D3Nf5b


#### 请求参数
	* ac=profile  --- 固定搭配
	* m_auth --- 授权码

	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
		*mobile -- 手机号
		*friend -- 朋友的id号，用逗号隔开
		*avatar -- 头像存放目录		
		*grouptitle --  会员级别
		*commentnum -- 所有评论数
		
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "space": {
	            "uid": "5",
	            "sex": "0",
	            "email": "yuyu01@qq.com",
	            "newemail": "",
	            "emailcheck": "0",
	            "mobile": "",
	            "qq": "",
	            "msn": "",
	            "msnrobot": "",
	            "msncstatus": "0",
	            "videopic": "",
	            "birthyear": "1990",
	            "birthmonth": "10",
	            "birthday": "21",
	            "blood": "",
	            "marry": "0",
	            "birthprovince": "广东",
	            "birthcity": "河源",
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
	                    "profile": "0",
	                    "friend": "0",
	                    "wall": "0",
	                    "feed": "0",
	                    "mtag": "0",
	                    "event": "0",
	                    "doing": "0",
	                    "blog": "0",
	                    "album": "0",
	                    "share": "0",
	                    "poll": "0"
	                },
	                "feed": {
	                    "doing": 1,
	                    "blog": 1,
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
	                    "spaceopen": 1,
	                    "credit": 1,
	                    "invite": 1,
	                    "task": 1,
	                    "profile": 1,
	                    "album": 1,
	                    "click": 1
	                }
	            },
	            "friend": "3,4,2",
	            "feedfriend": "3,4,2",
	            "sendmail": "",
	            "magicstar": "0",
	            "magicexpire": "0",
	            "timeoffset": "",
	            "groupid": "5",
	            "credit": "69",
	            "experience": "81",
	            "username": "yuyu_invite01",
	            "name": "",
	            "namestatus": "1",
	            "videostatus": "0",
	            "domain": "",
	            "friendnum": "3",
	            "viewnum": "6",
	            "notenum": "10",
	            "addfriendnum": "1",
	            "mtaginvitenum": "0",
	            "eventinvitenum": "0",
	            "myinvitenum": "0",
	            "pokenum": "0",
	            "doingnum": "0",
	            "blognum": "2",
	            "albumnum": "0",
	            "threadnum": "1",
	            "pollnum": "0",
	            "eventnum": "0",
	            "sharenum": "0",
	            "dateline": "1382948406",
	            "updatetime": "1383031334",
	            "lastsearch": "0",
	            "lastpost": "1383135725",
	            "lastlogin": "1390787719",
	            "lastsend": "0",
	            "attachsize": "0",
	            "addsize": "0",
	            "addfriend": "0",
	            "flag": "0",
	            "newpm": "0",
	            "avatar":"/data/avatar/000/00/00/07_avatar_small.jpg"
	            "regip": "127.0.0.1",
	            "ip": "121008157",
	            "mood": "0",
	            "self": 1,
	            "friends": [
	                "3",
	                "4",
	                "2"
	            ],
	            "allnotenum": 11,
	            "grouptitle": "普通会员",
	            "commentnum": "0",
	        }
	    },
	    "msg": "rest_success",
	    "action": "rest_success"
	}

[↑返回顶部](#momo)


<h2>好友动态列表</h2>
域名/capi/space.php?do=feed&view=friend&page=0&perpage=10&queryop=down&m_auth=55dalDuJytwHteL6s5qlKwHLm


#### 请求参数
	* do=feed&view=friend  --- 固定搭配
	* page --- 第几页
	* perpage --- 每页的数量
	* m_auth ---  登录返回的授权码
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例

[↑返回顶部](#momo)


<h2>查看新私信</h2>
域名/capi/space.php?do=pm&filter=newpm&m_auth=963aFwmLNwzFcR9K%2BOItoVptXdR4C


#### 请求参数
	* do=pm&filter=newpm  --- 固定搭配
	* m_auth ---  登录返回的授权码
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据		
		
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "pms": [
	            {
	                "pmid": "53",
	                "msgfrom": "uid2",
	                "msgfromid": "2",
	                "msgtoid": "4",
	                "new": "0",
	                "subject": "新消息",
	                "dateline": "1390059009",
	                "message": "新消息",
	                "delstatus": "0",
	                "related": "0",
	                "fromappid": "1",
	                "daterange": 2,
	                "touid": "2",
	                "msgfromavatar": "/data/avatar/000/00/00/07_avatar_small.jpg",
	                "msgtoavatar": "/data/avatar/000/00/00/07_avatar_small.jpg",
	                "msgfromisonline": 0,
	                "msgtoisonline": 1
	            }
	        ],
	        "count": 1,
	        "newpm": 1
	    },
	    "msg": "rest_success",
	    "action": "rest_success"
	}
[↑返回顶部](#momo)


<h2>上传头像</h2>
域名/capi/cp.php?ac=avatar&avatarsubmit=true&upfile= &m_auth=2551OHptdlM%2Bbka2dCZNeEUkuS



#### 请求参数
	* ac=blog&classsubmit=true&op=allclass  --- 固定搭配
	* uid --- 我的id
	* upfile --- 文件 (post方式提交)
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回数据
		*small -- 小尺寸的头像所在目录,加上网址即可下载
		*middle -- 中尺寸的头像所在目录,加上网址即可下载
		*big -- 大尺寸的头像所在目录,加上网址即可下载		
		
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "small": "/data/avatar/000/00/00/07_avatar_small.jpg",
	        "middle": "/data/avatar/000/00/00/07_avatar_middle.jpg",
	        "big": "/data/avatar/000/00/00/07_avatar_big.jpg"
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>查看我的全部博客分类</h2>
域名/capi/cp.php?ac=blog&classsubmit=true&op=allclass&uid=6&m_auth=10c9GwYPPQ%2BrByX2PVqkj8FP

#### 请求参数
	* ac=blog&classsubmit=true&op=allclass  --- 固定搭配
	* uid --- 我的id
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回
		*class 
			* classid -- 分类id
			*classname -- 分类名
			*dateline -- 创建时间
		*count -- 计算class数组的长度 
		
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "class": [
	            {
	                "classid": "4",
	                "classname": "test我的新生活",
	                "uid": "6",
	                "dateline": "1384624568"
	            },
	            {
	                "classid": "5",
	                "classname": "美好生活",
	                "uid": "6",
	                "dateline": "1388517650"
	            },
	            {
	                "classid": "6",
	                "classname": "开心",
	                "uid": "6",
	                "dateline": "1388518048"
	            }
	        ],
	        "count": 3
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
[↑返回顶部](#momo)


<h2>删除博客分类</h2>
域名/capi/cp.php?ac=blog&op=delete&classsubmit=true&classid=6&m_auth=10c9GwYPPQ%2BrByX2PVqkj8FPzmNYeBOHK0Z99dOrcQ

#### 请求参数
	* ac=blog&op=delete&classsubmit=true  --- 固定搭配
	* classid --- 删除的博客分类id
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		
	
#### 样例
	{
    "code": 0,
    "data": [],
    "msg": "进行的操作完成了",
    "action": "do_success"
	}
[↑返回顶部](#momo)



<h2>新建博客分类</h2>
域名/capi/cp.php?ac=blog&op=add&classsubmit=true&classname=美好生活&m_auth=10c9GwYPPQ%2BrByX2PVqkj8FPzmNYeBOHK0Z99dOrcQ

#### 请求参数
	* ac=blog&op=add&classsubmit=true  --- 固定搭配
	* classname --- 新建的博客分类名称
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		
	
#### 样例
	{
    "code": 0,
    "data": [],
    "msg": "进行的操作完成了",
    "action": "do_success"
	}
[↑返回顶部](#momo)



<h2>我的好友列表</h2>
域名/capi/space.php?do=friend&m_auth=ab65k4c%2BTeZjDt%2BJIEnN

#### 请求参数
	* do=friend -- 固定搭配 
	* m_auth  -- API密钥, 由登录后返回
#### 返回字段
	*code--  0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, 里面包含friends数组 和 count属性
		 *friends
		 	*uid -- 好友id
		 	*groupid -- 好友所在群组的id
		 	*credit -- 成长值
		 	*experience -- 经验值
		 	*username -- 用户名
		 	*name -- 实名 
		 	*sex -- 性别
		 	*avatar -- 头像url,加上网站地址就是下载地址
		 	*isonline -- 0：不在线 1：在线
		 	*resideprovince -- 居住省份
            *residecity -- 居住城市
            *lastpost -- 最后提交内容的时间
            *lastlogin -- 最后登录的时间

####示例
	{
    "code": 0,
    "data": {
        "friends": [
            {
                "uid": "7",
                "groupid": "6",
                "credit": "130",
                "experience": "120",
                "username": "yongwang",
                "name": "",
                "namestatus": "0",
                "videostatus": "0",
                "domain": "",
                "friendnum": "3",
                "viewnum": "2",
                "notenum": "0",
                "addfriendnum": "0",
                "mtaginvitenum": "0",
                "eventinvitenum": "0",
                "myinvitenum": "0",
                "pokenum": "0",
                "doingnum": "0",
                "blognum": "1",
                "albumnum": "0",
                "threadnum": "0",
                "pollnum": "0",
                "eventnum": "0",
                "sharenum": "0",
                "dateline": "1383550247",
                "updatetime": "1385551734",
                "lastsearch": "0",
                "lastpost": "1385551734",
                "lastlogin": "1386601713",
                "lastsend": "0",
                "attachsize": "0",
                "addsize": "0",
                "addfriend": "0",
                "flag": "0",
                "newpm": "0",
                "avatar":  "/data/avatar/000/00/00/07_avatar_small.jpg",
                "regip": "127.0.0.1",
                "ip": "127000000",
                "mood": "0",
                "resideprovince": "",
                "residecity": "",
                "note": "",
                "spacenote": "",
                "sex": "0",
                "gid": "0",
                "num": "1",
                "creditrank": "5",
                "experiencerank": "5",
                "group": "其他",
                "isfriend": 1,
                "grouptitle": "中级会员",
                "isonline": 0
            },
            {
                "uid": "4",
                "groupid": "5",
                "credit": "106",
                "experience": "96",
                "username": "qiuxia",
                "name": "",
                "namestatus": "0",
                "videostatus": "0",
                "domain": "",
                "friendnum": "3",
                "viewnum": "0",
                "notenum": "2",
                "addfriendnum": "1",
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
                "dateline": "1382944586",
                "updatetime": "1382944667",
                "lastsearch": "0",
                "lastpost": "0",
                "lastlogin": "1386413565",
                "lastsend": "0",
                "attachsize": "0",
                "addsize": "0",
                "addfriend": "0",
                "flag": "0",
                "newpm": "0",
                "avatar": "/data/avatar/000/00/00/04_avatar_small.jpg",,
                "regip": "127.0.0.1",
                "ip": "127000000",
                "mood": "0",
                "resideprovince": "",
                "residecity": "",
                "note": "",
                "spacenote": "",
                "sex": "0",
                "gid": "0",
                "num": "0",
                "creditrank": "7",
                "experiencerank": "7",
                "group": "其他",
                "isfriend": 1,
                "grouptitle": "普通会员",
                "isonline": 0
            }
        ],
        "count": 2
    },
    "msg": "rest_success",
    "action": "rest_success"
}
[↑返回顶部](#momo)


<h2>检测用户登陆状态</h2>
域名/capi/space.php?do=isonline&uid=7

#### 请求参数
	* do=isonline  --- 固定搭配
	* uid --- 要检测的用户id
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		*对象的属性有：
		     *isonline -- 0:代表不在线， 1：代表在线
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "isonline": 0
	    },
	    "msg": "rest_success",
	    "action": "rest_success"
	}
[↑返回顶部](#momo)



<h2>查看某个被关注人的全部博客</h2>
域名/capi/space.php?do=blog&view=we&fusername=yongwang&auth=071eGlvIzPkREWLjgH9g4%2Fnyehu6CEnfTZ2y4uZ6PA

#### 请求参数
	* do=blog&view=we  --- 固定搭配
	* fusername --- 被关注人的用户名
	* auth  --- 当前用户登录时返回的值

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		*对象的属性有：
			* blogid --  博客id
			* uid -- 博客作者id
			* viewnum -- 被浏览数
			* replynum -- 评论回复数
			* subject -- 博客标题
			* classid -- 博客分类id
			* click_1 -- 表态“路过"
	        * click_2 -- 表态"雷人"
	        * click_3 -- 表态"握手"
	        * click_4 -- 表态"鲜花"
	        * click_5  -- 表态"鸡蛋"
	    *count --- 数组中共有多少个对象
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "blogs": [
	            {
	                "blogid": "11",
	                "topicid": "0",
	                "uid": "7",
	                "username": "yongwang",
	                "subject": "new blog",
	                "classid": "0",
	                "viewnum": "0",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1385551734",
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
	        ],
	        "count": 1
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)



<h2>查看所有被关注人的全部博客</h2>
域名/capi/space.php?do=blog&view=we&orderby=dateline&page=0&perpage=20&auth=071eGlvIzPkREWLjgH9g4%2Fnyehu6CEnfTZ2y4uZ6PA

#### 请求参数
	* do=blog&view=we  --- 固定搭配
	* orderby -- 按什么排序，可选值为：
		* dateline -- 时间
		* replynum -- 回复数
		* viewnum -- 浏览数
		* hot -- 热点数
	* page -- 哪一页
	* perpage -- 每页的数量
	* auth  --- 当前用户登录时返回的值

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		*对象的属性有：
			* message --  博客的内容
			* blogid --  博客id
			* uid -- 博客作者id
			* viewnum -- 被浏览数
			* replynum -- 评论回复数
			* subject -- 博客标题
			* classid -- 博客分类id
			* click_1 -- 表态“路过"
	        * click_2 -- 表态"雷人"
	        * click_3 -- 表态"握手"
	        * click_4 -- 表态"鲜花"
	        * click_5  -- 表态"鸡蛋"
	    *count --- 数组中共有多少个对象
	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "blogs": [
	            {
	                "message": "slkldlsld",
	                "blogid": "14",
	                "topicid": "0",
	                "uid": "2",
	                "username": "1396636115",
	                "subject": "afad",
	                "classid": "0",
	                "viewnum": "1",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1386421423",
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
	                "message": "希望今晚能做好。",
	                "blogid": "11",
	                "topicid": "0",
	                "uid": "7",
	                "username": "yongwang",
	                "subject": "new blog",
	                "classid": "0",
	                "viewnum": "0",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1385551734",
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
	                "message": "难道你不相信吗？",
	                "blogid": "10",
	                "topicid": "0",
	                "uid": "2",
	                "username": "",
	                "subject": "真的可以发表了吗",
	                "classid": "1",
	                "viewnum": "1",
	                "replynum": "0",
	                "hot": "1",
	                "dateline": "1384717770",
	                "pic": "",
	                "picflag": "0",
	                "noreply": "0",
	                "friend": "0",
	                "password": "",
	                "click_1": "0",
	                "click_2": "0",
	                "click_3": "0",
	                "click_4": "0",
	                "click_5": "1"
	            },
	            {
	                "message": "希望你好,真心祝福你。",
	                "blogid": "9",
	                "topicid": "0",
	                "uid": "2",
	                "username": "",
	                "subject": "希望你好",
	                "classid": "0",
	                "viewnum": "2",
	                "replynum": "12",
	                "hot": "1",
	                "dateline": "1384716829",
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
	                "message": "世事难料------纪念同年的小伙伴。",
	                "blogid": "5",
	                "topicid": "0",
	                "uid": "2",
	                "username": "",
	                "subject": "世事难料",
	                "classid": "3",
	                "viewnum": "0",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1384621157",
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
	                "message": "今天认识blog模块，写blog的入口cp.php?ac=blog",
	                "blogid": "4",
	                "topicid": "0",
	                "uid": "2",
	                "username": "1396636115",
	                "subject": "今天认识blog模块",
	                "classid": "3",
	                "viewnum": "1",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1384579241",
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
	        ],
	        "count": 6
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>查看整个站点的博客</h2>
域名/capi/space.php?do=blog&view=all&day=10&orderby=dateline&page=0&perpage=20

#### 请求参数
	* do=blog&view=all  --- 固定搭配
	* day -- 距离现在的天数
	* orderby -- 按什么排序，可选值为：
		* dateline -- 时间
		* replynum -- 回复数
		* viewnum -- 浏览数
		* hot -- 热点数
	* page -- 哪一页
	* perpage -- 每页的数量
	* auth  --- 当前用户登录时返回的值

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		*对象的属性有：
			* message  -- 博客内容
			* blogid --  博客id
			* uid -- 博客作者id
			* viewnum -- 被浏览数
			* replynum -- 评论回复数
			* subject -- 博客标题
			* classid -- 博客分类id
			* click_1 -- 表态“路过"
	        * click_2 -- 表态"雷人"
	        * click_3 -- 表态"握手"
	        * click_4 -- 表态"鲜花"
	        * click_5  -- 表态"鸡蛋"
	    *count --- 数组中共有多少个对象

	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "bloga": [
	            {
	                "message": "slkldlsld",
	                "target_ids": "",
	                "magiccolor": "0",
	                "blogid": "14",
	                "topicid": "0",
	                "uid": "2",
	                "username": "1396636115",
	                "subject": "afad",
	                "classid": "0",
	                "viewnum": "1",
	                "replynum": "0",
	                "hot": "0",
	                "dateline": "1386421423",
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
	        "count": 1
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}

[↑返回顶部](#momo)


<h2>某个话题的评论列表</h2>
/capi/do.php?ac=ajax&op=getthreadpost&tid=2&page=0&perpage=5&dateline=1386434227&queryop=up
	*有多种查询方式，可参考[某篇博客的评论列表](#某篇博客的评论列表)


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
#### 有多种查询方式
	*前10条评论----- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9 (默认是取前10条数据)
	*相当于  ---- /capi/do.php?ac=ajax&op=getcomment&idtype=blogid&id=9&page=0&perpage=10
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
			*avatar -- 评论人的头像地址，加上网站地址就可下载
			*message -- 评论的信息
			*dateline -- 评论的时间
		*count --- 评论信息的数量


#### 样例
	{
	    "code": 0,
	    "data": {
	        "comments": [
		         {
	                "avatar": "/data/avatar/000/00/00/06_avatar_small.jpg",
	                "cid": "15",
	                "authorid": "6",
	                "author": "test",
	                "message": "写得很好11",
	                "dateline": "1386471660"
	            },
	            {
	                "avatar": "/data/avatar/000/00/00/06_avatar_small.jpg",
	                "cid": "14",
	                "authorid": "6",
	                "author": "test",
	                "message": "写得很好11",
	                "dateline": "1386471581"
	            }
	        "count": 2
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
	*do=blog&view=me  --- 固定搭配
	*auth  --- 当前用户登录时返回的值

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		*对象的属性有：
			* message --  博客的内容
			* blogid --  博客id
			* uid -- 博客作者id
			* viewnum -- 被浏览数
			* replynum -- 评论回复数
			* subject -- 博客标题
			* classid -- 博客分类id
			* click_1 -- 表态“路过"
	        * click_2 -- 表态"雷人"
	        * click_3 -- 表态"握手"
	        * click_4 -- 表态"鲜花"
	        * click_5  -- 表态"鸡蛋"
	    *connt -- 数组中对象的个数

	
#### 样例
	{
	    "code": 0,
	    "data": {
	        "blogs": [
	            {
	            	 "message":i want to 
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
	            	"message":i want to 
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
		* blogid --  博客id
		* uid -- 博客作者id
		* viewnum -- 被浏览数
		* replynum -- 评论回复数
		* subject -- 博客标题
		* pic -- 图片链接，多个链接用英文逗号隔开，加上http://gluchome.duapp.com/attachment就是下载地址
		* classid -- 博客分类id
		* click_1 -- 表态“路过"
        * click_2 -- 表态"雷人"
        * click_3 -- 表态"握手"
        * click_4 -- 表态"鲜花"
        * click_5  -- 表态"鸡蛋"

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
	            "pic": "201402/21/6_1393000257FMFM.jpg,201402/22/6_1393042190vEER.png,201402/22/6_1393042528z63y.gif",
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




<h2>私信列表</h2>
域名/capi/space.php?do=pm&page=0&prepage=2&filter=newpm&dateline=0&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	* page -- 第几页
	* perpage  --  每页显示数量
	* filter -- 私信类型
		* newpm -- 未读私信
		* privatepm -- 私人消息
		* systempm -- 系统消息
		* announcepm -- 公共消息
		* 空 -- 私人消息
	* m_auth -- API密钥, 由登录后返回
	* dateline -- 时间点

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	* 操作信息 -- msg, 详细参见附录
	* 结果 -- data, json数组, 本操作返回两个数据
		* pms，私信列表， 条目字段如下
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
		* count, 返回列表条目数, 便用遍历
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
					"msgfromavatar": "/data/avatar/000/00/00/01_avatar_small.jpg",
					"msgtoavatar": "/data/avatar/000/00/00/05_avatar_small.jpg"
				}
			],
			"count": 1
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)

<h2>根据消息id查看私信详情</h2>
域名/capi/space.php?do=pm&subop=view&pmid=2&touid=12&daterange=10&page=1&perpage=10&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	*  do=pm&subop=view -- 操作参数 
	*  pmid -- 消息id
	*  daterange -- 检索消息的区间（几天之内的）
	*  page -- 当前页, 默认为1
	*  perpage -- 分页数, 默认为10
	*  m_auth -- API密钥, 由登录后返回

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg--  操作信息 , 详细参见附录
	*data--  结果 , json数组, 本操作返回两个数据
		* pms，私信列表， 条目字段如下
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
		* count, 返回列表条目数, 便用遍历

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
					"msgfromavatar": "/data/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "/data/avatar/000/00/00/01_avatar_small.jpg"
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
					"msgfromavatar": "/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "/avatar/000/00/00/01_avatar_small.jpg"
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
					"msgfromavatar": "/avatar/000/00/00/01_avatar_small.jpg",
					"msgtoavatar": "/avatar/000/00/00/05_avatar_small.jpg"
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)

<h2>根据消息来源查看私信详情</h2>
域名/capi/space.php?do=pm&subop=view&touid=12&daterange=10&page=1&perpage=10&m_auth=55dalDuJytwHteL6s5qlKwHLmhIhpGZ4fZUXHu0
#### 请求参数
	*  do=pm&subop=view -- 操作参数 
	*  touid -- 来自哪个用户
	*  daterange -- 检索消息的区间（几天之内的）
	*  page -- 当前页, 默认为1
	*  perpage -- 分页数, 默认为10
	*  m_auth -- API密钥, 由登录后返回

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg--  操作信息 , 详细参见附录
	*data--  结果 , json数组, 本操作返回两个数据
		* pms，私信列表， 条目字段如下
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
		* count, 返回列表条目数, 便用遍历

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
					"msgfromavatar": "/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "/avatar/000/00/00/01_avatar_small.jpg"
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
					"msgfromavatar": "/avatar/000/00/00/05_avatar_small.jpg",
					"msgtoavatar": "/avatar/000/00/00/01_avatar_small.jpg"
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
					"msgfromavatar": "/avatar/000/00/00/01_avatar_small.jpg",
					"msgtoavatar": "/avatar/000/00/00/05_avatar_small.jpg"
				}
			],
			"count": 3
		},
		"msg": "数据获取成功",
		"action": "rest_success"
	}
[↑返回顶部](#momo)


<h2>退出</h2>
域名/capi/cp.php?ac=common&op=logout&m_auth=7c44hpLskh17xPRklyu

#### 请求参数
	* ac=common   op=logout  --- 固定搭配
	* m_auth --- 登录后返回的授权码
	

#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*data -- 返回对象数组，
		
	
#### 样例
	{
	    "code": 0,
	    "data": [],
	    "msg": "你已经安全退出了\\1",
	    "action": "security_exit"
   }
[↑返回顶部](#momo)

<h2>发表博客</h2>
域名/capi/cp.php?ac=blog&blogid=0&blogsubmit=true&auth=6284SqqRXsIhxZ2IUCMkFUcRADW8fsyHyTYimRgF1w


#### 请求参数
	* ac=blog&blogid=0&blogsubmit=true  -- 固定搭配
	* m_auth -- API密钥, 由登录后返回
	*用post方式提交以下参数
		*subject  --- 博客标题
		*message  --- 博客内容
		*classid=0  --- 默认博客分类 
		*picids -- 上传图片后返回的picid，多个pid有英文逗号隔开

#### 返回字段
	*code--  0:代表成功， 1:代表失败
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
	*code--  0:代表成功， 1:代表失败
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
/capi/do.php?ac=register&registersubmit=true&username=test4&password=123&password2=123&seccode=cQ7T
isdoctor=0&m_auth=1a6431MIvgvhZZzUPUmCUML%2FtL4rlXrN2R8nL5G3qvta

#### 请求参数
	* ac=register&registersubmit=true -- 固配
	* username  --  用户名
	* password  --  用户输入的第一次密码
	* password2  --  用户输入的确认密码 
	* seccode  --  用户输入的验证码
	* isdoctor  -- 是否是医生，0 -- 非医生，1 -- 医生
	* m_auth  --   生成验证码返回的seccode_auth

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
域名/capi/do.php?ac=login&loginsubmit=true&username=summit&password=likeyou&longititude=116.89238&latitude=23.88923&pushid=8392839&channelid=83923892023
#### 请求参数
	* loginsubmit -- 提交类型 ， 必须为true
	* username -- 用户名
	* password -- 密码
	* longititude -- 经度
	* latitude -- 纬度
	* pushid -- 推送id
	* channelid -- 推送通道id
#### 返回字段
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果, json数组
		* space -- 用户空间信息
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
				* avatar -- 头像存放目录,加上网址即可下载

		*newpm --离线消息数组
	       		* pmid --- 消息id
                * msgfrom --- 该消息发送方username
                * msgfromid ---  该消息发送方id
                * msgtoid --- 该消息接收方id
                * new --- 是否属于新消息 1-是 0-否
                * subject --- 主题与内容相同
                * dateline --- 发送的时间
                * delstatus ---
                * related ---
                * fromappid --- 
                * daterange --- 时间范围
                * touid --- 回复该消息时，接收人的id

	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 样例
	{
    "code": 0,
    "data": {
        "space": {
            "uid": "2",
            "groupid": "6",
            "credit": "386",
            "experience": "371",
            "username": "1396636115",
            "name": "uid2",
            "namestatus": "1",
            "videostatus": "0",
            "domain": "",
            "friendnum": "6",
            "viewnum": "10",
            "notenum": "0",
            "addfriendnum": "0",
            "mtaginvitenum": "0",
            "eventinvitenum": "0",
            "myinvitenum": "0",
            "pokenum": "0",
            "doingnum": "2",
            "blognum": "5",
            "albumnum": "0",
            "threadnum": "0",
            "pollnum": "0",
            "eventnum": "0",
            "sharenum": "0",
            "dateline": "1382601338",
            "updatetime": "1386421423",
            "lastsearch": "1384617842",
            "lastpost": "1390363444",
            "lastlogin": "1390401484",
            "lastsend": "0",
            "attachsize": "0",
            "addsize": "0",
            "addfriend": "0",
            "flag": "0",
            "newpm": "0",
            "regip": "127.0.0.1",
            "ip": "163177139",
            "mood": "3",
   			"avatar":"/data/avatar/000/00/00/02_avatar_small.jpg"
        },
       "newpm": [
            {
                "pmid": "65",
                "msgfrom": "1396636115",
                "msgfromid": "2",
                "msgtoid": "4",
                "folder": "inbox",
                "new": "1",
                "subject": "",
                "dateline": "1395578077",
                "message": "你好",
                "delstatus": "0",
                "related": "1",
                "fromappid": "1"
            },
            {
                "pmid": "69",
                "msgfrom": "1396636115",
                "msgfromid": "2",
                "msgtoid": "4",
                "folder": "inbox",
                "new": "1",
                "subject": "",
                "dateline": "1395578205",
                "message": "你会收到吗？",
                "delstatus": "0",
                "related": "1",
                "fromappid": "1"
            },
            {
                "pmid": "68",
                "msgfrom": "test",
                "msgfromid": "6",
                "msgtoid": "4",
                "folder": "inbox",
                "new": "1",
                "subject": "第三条。感谢有你",
                "dateline": "1395578157",
                "message": "第三条。感谢有你",
                "delstatus": "0",
                "related": "1",
                "fromappid": "1"
            }
        ],
        "m_auth": "5d64If2gsVrSs%2BU0nZUJjchI1gKBSA3ZOTVd69s%2FgQ"
    },
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
域名/capi/cp.php?ac=pm&op=send&pmsubmit=true&username=test6&message=你好!summit&m_auth=af9cCEMpQlfFTifZltugadwh

#### 请求参数
	* ac=pm  op=send  pmsubmit=true  -- 固定搭配 
	* username -- 接收方的用户名
	* message  --  私信内容
	* m_auth -- 登录返回的授权码

#### 返回参数
	*code-- 错误码, 0:代表成功， 1:代表失败
	*action --  操作类型
	*msg -- 操作信息, 详细参见附录
	*data -- 结果
		*request_id -- 请求id
		*response_params 对象
			* success_amount -- 发送数量
			* msgids -- 消息id

#### 样例
	{
	    "code": 0,
	    "data": {
	        "request_id": -649934962,
	        "response_params": {
	            "success_amount": 1,
	            "msgids": [
	                "8654230163905675803"
	            ]
	        }
	    },
	    "msg": "进行的操作完成了",
	    "action": "do_success"
	}
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
域名/capi/cp.php?ac=friend&op=add&gid=0&addsubmit=true&uid=4&m_auth=0ff76%2B%2F

#### 请求参数
	* ac=friend&op=add&gid=0&addsubmit=true -- 固定搭配
	* uid -- 加为关注的用户id
	* gid -- 好友组别
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
