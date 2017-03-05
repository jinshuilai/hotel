<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
[#escape x as x?html]
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,initial-scale=1.0,user-scalable=no" />
<title>${message("common.error500.title")}</title>
</head>
<body>
	<div class="error">
		<ul>
			<li>
				<img src="/resources/common/images/500_error_icon.png" />
			</li>
			<li class="bnone">
				<div style="overflow:hidden;"><img src="/resources/common/images/error_title.png" class="fleft" /></div>
				<div class="pd">${message("common.error500.description")}</div>
				<a href="javascript:history.back();">${message("common.error500.return")}</a>
			</li>
		</ul>
	</div>
</body>
[/#escape]
</html>
