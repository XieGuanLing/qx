momo
=====
******************************

索引

	*[获取注册验证码](#获取注册验证码)
	*[注册](#注册)
	*[登录](#登录)
	*[更改头像](#更改头像)
	*[更改昵称](#更改昵称)
	*[退出](#退出)
	*[单向加关注](#单向加关注)
	*[好友动态列表接口](#好友动态列表接口)
	*[发布私信](#发布私信)
	*[私信列表接口](#私信列表接口)
	*[私信详情](#私信详情)
		
	*[发表博客](#发表博客)
	*[对某篇博客表态称赞](#对某篇博客表态称赞)
	*[撰写对某篇博客评论](#撰写对某篇博客评论)
	*[某篇博客的评论列表](#某篇博客的评论列表)
	*[查看自己的全部博客](#查看自己的全部博客)
	*[查看自己某篇博客的具体内容](#查看自己某篇博客的具体内容)
	*[删除自己的某篇博客](#删除自己的某篇博客)
	*[查看某个关注人的全部博客](#查看某个关注人的全部博客)
	*[查看整个站点的博客](#查看整个站点的博客)
	

	*[新建并加入群组](#新建并加入群组)
	*[加入群组](#加入群组)
	*[群组列表](#群组列表)
	*[发表新话题](#发表新话题)
	*[某个话题的评论列表](#某个话题的评论列表)
	*[某个群组下的话题列表](#某个群组下的话题列表)
	*[某个群组下的成员列表](#某个群组下的成员列表)
	*[对某个话题表态称赞](#对某个话题表态称赞)
	*[对某个话题发表看法](#对某个话题发表看法)

接口说明
--------

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


<h2>退出</h2>
域名/capi/cp.php?ac=common&op=logout&m_auth=7c44hpLskh17xPRklyu

#### 请求参数
	* 操作类型（固定搭配） -- ac:common , op:logout
	* API密钥 -- m_auth, 每次调用接口，需要提供此key以验证用户

#### 返回参数
	* 错误码 -- code, 0:代表成功， 1:代表失败
	* 错误类型 -- action, login_success:代表登录成功
	* 错误信息 -- msg, 详细参见附录

#### 样例
	{
  	  "code": 0,
	    "data": [],
	    "msg": "你已经安全退出了\\1",
	    "action": "security_exit"
	}
	
[↑返回顶部](#betit)
