<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OOI‘m tired
  Date: 2020/12/31
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>

<div>
    <!--------------------- 简历照片修改------------------------->
    <form action="/FlowerManageSystem/FlowerPicServlet" method="post"
          enctype="multipart/form-data" onsubmit="return validate();">
        <input type="hidden" name="id" value="${param.id}">
        <div class="table_style" style="margin-left: 0px;">
            <div class="uploade">
                <div align="center">
                    <c:if test="${param.imgPath == null}">
                        <img src="/FlowerManageSystem/static/img/pic_default.png" width="150" height="150">
                    </c:if>
                    <c:if test="${param.imgPath != null}">
                        <img src="${param.imgPath}" width="150" height="150">
                    </c:if>
                    <p>&nbsp;</p>
                    <input style="margin-left: 100px" name="imgPath" id="imgPath" type="file" value="上传照片">
                </div>
            </div>
            <div class="clear"></div>
            <div class="he"></div>
            <div align="center">
                <input style="margin-top: 15px" name="submit" type="submit" class="save1" value="保存">
                <input style="margin-top: 15px" name="reset" type="reset" class="cancel2" value="取消">
            </div>
        </div>
    </form>
    <!--------------------- 简历照片修改 结束---------------------->
</div>

</body>
</html>
