<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>确认发货</title>
    <link type="text/css" rel="stylesheet" href="/FlowerManageSystem/static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" style=" margin-right:60px;  height: 200px; width: 200px; border-radius: 50%" alt="" src="/FlowerManageSystem/static/img/花店logo.jpg" >
    <span class="wel_word" style="margin-top: 60px">确认发货</span>
    <%@ include file="/pages/common/manage_common.jsp"%>
</div>

<div id="main">
    <form action="/FlowerManageSystem/OrderManageServlet?method=sendOut" method="post">
        <input type="hidden" name="id" value="${requestScope.order.orderId}" />
        <table>
            <tr>
                <td><svg t="1609554607634" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13013" width="30" height="30"><path d="M690.910763 515.643993c11.360745 0 18.934235 7.573489 18.934235 22.720468 0 11.360745-7.573489 18.934235-18.934235 22.720468L690.910763 515.643993 690.910763 515.643993zM690.910763 905.678174l117.388571 0c11.360745 0 22.720468-11.360745 22.720468-22.720468l0-3.787256L831.019801 371.748722l0 0c0-7.573489-3.787256-15.146978-7.573489-18.933211L690.910763 205.131961l0 68.161403 68.161403 75.734892-68.161403 0 0 45.440935 94.668103 0 0 465.769073-94.668103 0L690.910763 905.678174 690.910763 905.678174zM690.910763 716.340945l0-45.440935c11.360745 0 18.934235 11.359722 18.934235 22.720468C709.844997 704.981223 702.271508 716.340945 690.910763 716.340945zM509.148046 515.643993l181.76374 0 0 0 0 45.440935 0 0L509.148046 561.084928 509.148046 515.643993 509.148046 515.643993zM690.910763 205.131961l0 68.161403-68.161403-79.521125 0 155.256016 68.161403 0 0 45.440935L600.029916 394.46919l0 0c-11.359722 0-22.720468-11.359722-22.720468-22.720468L577.309448 159.691025l-68.161403 0L509.148046 114.25009l90.88187 0 0 0 0 0 0 0 0 0c7.573489 0 11.360745 3.786233 15.146978 7.573489L690.910763 205.131961 690.910763 205.131961zM690.910763 670.901033l0 45.440935 0 0L509.148046 716.341968l0-45.440935L690.910763 670.901033 690.910763 670.901033 690.910763 670.901033zM690.910763 860.237239l0 45.440935L509.148046 905.678174l0-45.440935L690.910763 860.237239zM331.171562 561.084928c-11.359722 0-22.720468-11.359722-22.720468-22.720468 0-15.146978 11.359722-22.720468 22.720468-22.720468l177.976484 0 0 45.440935L331.171562 561.084928 331.171562 561.084928zM509.148046 114.25009 213.781968 114.25009c-11.359722 0-22.720468 11.359722-22.720468 22.720468l0 745.987149c0 11.360745 11.359722 22.720468 22.720468 22.720468l0 0 295.365054 0 0-45.440935L236.502435 860.237239 236.502435 159.691025l272.644587 0L509.147022 114.25009 509.148046 114.25009zM509.148046 670.901033l0 45.440935L331.171562 716.341968c-11.359722 0-22.720468-11.360745-22.720468-22.720468 0-11.360745 11.359722-22.720468 22.720468-22.720468L509.148046 670.901033z" p-id="13014" fill="#FCD1D1"></path></svg></td>
                <td><svg t="1609554669081" class="icon" viewBox="0 0 1084 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14587" width="30" height="30"><path d="M679.96791406 629.91443867h96.25668487v96.25668399h-96.25668487zM491.78609667 629.91443867h96.25668399v96.25668399h-96.25668398zM303.60427842 629.91443867h96.25668398v96.25668399h-96.25668398zM679.96791406 427.77540107h96.25668487v96.25668487h-96.25668487zM491.78609667 427.77540107h96.25668399v96.25668487h-96.25668398zM303.60427842 427.77540107h96.25668398v96.25668487h-96.25668398z" fill="#FCD1D1" p-id="14588"></path><path d="M821.94652373 105.79679141h-48.12834199V62h-96.25668398v43.79679141h-89.5187171V62h-96.25668399v43.79679141H398.8983957V62H302.64171084v43.79679141H254.51336885a192.51336885 192.51336885 0 0 0-192.51336885 192.51336885v471.17647089a192.51336885 192.51336885 0 0 0 192.51336885 192.51336885h567.43315488a192.51336885 192.51336885 0 0 0 192.51336973-192.51336885V298.31016026a192.51336885 192.51336885 0 0 0-192.51336973-192.51336885z m96.25668486 663.68983974a96.25668487 96.25668487 0 0 1-96.25668486 96.25668398H254.51336885a96.25668487 96.25668487 0 0 1-96.25668398-96.25668398V298.31016026 293.01604297h759.46523994v5.29411729z" fill="#FCD1D1" p-id="14589"></path></svg></td>
                <td><svg t="1609555033243" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="16496" width="30" height="30"><path d="M256.4 806.2v-60.9c28.7-10.1 93-35.5 125.1-50.7 6.8-3.4 11.8-5.1 16.9-8.5l3.4-1.7c8.5-5.1 18.6-8.5 25.4-11.8-1.7 5.1-5.1 10.1-8.5 15.2-10.1 13.5-23.7 25.4-33.8 30.4-11.8 5.1-16.9 16.9-13.5 30.4 3.4 11.8 13.5 20.3 25.4 20.3h164s59.2-11.8 101.4-57.5c30.4-33.8 74.4-86.2 91.3-108.2v-1.7-1.7s1.7-1.7 5.1-3.4c1.7 0 3.4-1.7 8.5 1.7s6.8 6.8-6.8 42.3c-1.7 3.4-3.4 8.5-5.1 11.8-5.1 13.5-25.4 45.7-59.2 77.8-27.1 27.1-72.7 62.6-130.2 74.4l-309.4 1.8zM794.1 556c-20.3-13.5-42.3-13.5-60.9-5.1-11.8 6.8-20.3 15.2-22 18.6 0 0-54.1 67.6-89.6 106.5-25.4 27.1-62.6 38.9-71 40.6h-87.9c18.6-27.1 25.4-54.1 15.2-72.7-6.8-15.2-16.9-20.3-25.4-23.7-23.7-8.5-47.3 3.4-77.8 20.3-5.1 3.4-10.1 5.1-16.9 8.5-5.1 1.7-8.5 5.1-15.2 6.8 6.8-10.1 5.1-25.4-3.4-33.8-44-45.7-69.3-104.8-69.3-167.4 0-131.9 106.5-238.4 238.4-238.4s238.4 106.5 238.4 238.4c0 15.2 11.8 27.1 27.1 27.1s27.1-11.8 27.1-27.1c0-38.9-8.5-77.8-23.7-113.3s-35.5-65.9-62.6-93c-27.1-27.1-57.5-47.3-93-62.6-35.5-15.2-74.4-23.7-113.3-23.7s-77.8 8.5-113.3 23.7-65.9 35.5-93 62.6c-27.1 27.1-47.3 57.5-62.6 93-15.2 35.5-23.7 74.4-23.7 113.3s8.5 77.8 22 113.3c15.2 35.5 35.5 65.9 62.6 93 3.4 3.4 8.5 6.8 13.5 6.8-38.9 15.2-82.9 32.1-94.7 35.5-10.1 3.4-16.9 13.5-16.9 25.4v106.5c0 15.2 11.8 27.1 27.1 27.1h343.3c71-15.2 125.1-57.5 158.9-89.6 37.2-35.5 62.6-76.1 71-96.4 0-1.7 1.7-5.1 3.4-6.8l1.7-5.1c6.8-15.2 13.5-32.1 13.5-49 3.5-34-11.8-50.9-27-59.3z" p-id="16497" fill="#FCD1D1"></path><path d="M613.2 430.8c11.8 0 22-10.1 22-22 0-11.8-10.1-22-22-22H576l45.7-45.7c8.5-8.5 8.5-23.7 0-32.1-8.5-8.5-23.7-8.5-32.1 0l-72.7 72.7-72.7-72.7c-8.5-8.5-23.7-8.5-32.1 0s-8.5 23.7 0 32.1l45.7 45.7h-37.2c-11.8 0-22 10.1-22 22 0 11.8 10.1 22 22 22h72.7v27.1h-72.7c-11.8 0-22 10.1-22 22s10.1 22 22 22h72.7v93c0 11.8 10.1 22 22 22 11.8 0 22-10.1 22-22v-93H610c11.8 0 22-10.1 22-22s-10.1-22-22-22h-72.7v-27.1h75.9z" p-id="16498" fill="#FCD1D1"></path></svg></td>
                <td><svg t="1609555080924" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="17984" width="30" height="30"><path d="M638.9 109.6H54.8c-31 0-54.8 27.1-54.8 62.5V589c0 35.4 23.7 62.5 54.8 62.5h584.1c31 0 54.8-27.1 54.8-62.5V172.1c-0.1-35.4-23.8-62.5-54.8-62.5zM487.4 397.3L366.9 503.6c-11 10.4-29.2 0-29.2-16.7v-37.5c0-12.5-7.3-20.8-18.3-20.8H219c-9.1 0-18.3-8.3-18.3-20.8v-62.5c0-12.5 7.3-20.8 18.3-20.8h100.4c11 0 18.3-8.3 18.3-20.8v-29.2c0-16.7 16.4-27.1 29.2-16.7l120.5 106.3c9.1 8.1 9.1 24.8 0 33.2zM949.2 786.6c-1.8-5.5-3.7-12.8-5.5-20.1-11-31-36.5-54.8-69.4-65.7-21.9-7.3-45.6-7.3-67.5 0-31 11-56.6 34.7-69.4 65.7-1.8 5.5-3.7 12.8-3.7 20.1-1.8 5.5-1.8 12.8-1.8 18.3v1.8c0 60.2 49.3 107.7 109.5 107.7s107.7-47.5 109.5-107.7v-1.8c0.1-5.5 0.1-12.8-1.7-18.3z m-62.1 21.9c-1.8 23.7-21.9 43.8-45.6 43.8-23.7 0-43.8-20.1-45.6-43.8 0-7.3 1.8-14.6 3.7-20.1 3.6-7.3 11-14.6 18.3-20.1 7.3-5.5 14.6-7.3 23.7-7.3s16.4 3.6 23.7 7.3c7.3 3.7 14.6 11 18.3 20.1 1.8 5.5 3.6 11 3.6 18.3v1.8z" p-id="17985" fill="#FCD1D1"></path><path d="M346.8 700.8c-7.3-5.5-14.6-11-23.7-16.4h399.7c3.7 0 5.5-1.8 9.1-3.6V679h1.8c1.8-1.8 3.7-5.5 3.7-9.1V326.7c3.6-3.7 9.1-7.3 16.4-7.3h167.9c5.5 0 9.1 1.8 12.8 3.6 3.7 1.8 84 65.7 84 186.2v144.2c0 5.5 0 11 3.7 16.4 1.8 3.6 1.8 5.5 1.8 9.1v107.7c0 11-9.1 20.1-20.1 20.1h-23.7v-1.8c0-5.5 0-12.8-1.8-18.3 0-7.3-1.8-14.6-3.6-20.1-7.3-25.6-21.9-47.5-42-65.7-9.1-9.1-21.9-16.4-32.9-20.1-18.3-7.3-36.5-12.8-56.6-12.8-9.1 0-18.3 1.8-27.4 3.6-9.1 1.8-20.1 5.5-27.4 9.1-12.8 5.5-23.7 12.8-32.9 20.1h1.8-1.8c-20.1 16.4-34.7 40.2-42 65.7-1.8 7.3-3.6 14.6-3.6 20.1 0 5.5-1.8 12.8-1.8 18.3v1.8h-314v-1.8c0-5.5 0-12.8-1.8-18.3-1.8-7.3-1.8-14.6-3.6-20.1-7.3-25.4-21.9-49.1-42-65.6z m427.1-217.2h178.9c11 0 20.1-11 18.3-21.9-11-47.5-36.5-80.3-51.1-94.9-3.7-3.7-7.3-5.5-12.8-5.5h-115c-11 0-18.3 7.3-18.3 18.2v104.1z m-620.6 283c12.8-31 38.3-54.8 69.4-65.7 21.9-7.3 45.6-7.3 67.5 0 31 11 56.6 34.7 69.4 65.7 1.8 7.3 3.6 14.6 5.5 20.1 1.8 5.5 1.8 12.8 1.8 18.3v1.8c-1.8 60.2-49.3 107.7-109.5 107.7S147.9 867 147.9 806.8V805c0-5.5 0-12.8 1.8-18.3 0-7.4 1.8-14.7 3.6-20.1z m58.4 41.9c1.8 23.7 21.9 43.8 45.6 43.8 23.7 0 43.8-20.1 45.6-43.8v-1.8c0-7.3-1.8-12.8-3.6-18.3-3.7-9.1-11-16.4-18.3-20.1-7.3-3.6-14.6-7.3-23.7-7.3s-16.4 1.8-23.7 7.3c-7.3 5.5-14.6 12.8-18.3 20.1-1.7 5.5-3.6 12.8-3.6 20.1-1.8-1.8 0-1.8 0 0z m-9.1-129.6c-1.8 0-1.8 0 0 0-5.5 1.8-7.3 3.6-11 5.5-9.1 5.5-16.4 11-23.7 16.4-20.1 16.4-34.7 40.2-42 65.7-1.8 7.3-3.6 14.6-3.6 20.1 0 5.5-1.8 12.8-1.8 18.3v1.8H74.8c-11 0-20.1-9.1-20.1-20.1v-89.4c0-11 7.3-18.3 18.3-18.3h129.6z m0 0" p-id="17986" fill="#FCD1D1"></path></svg></td>
                <td style="width: 0px"></td>
                <td><svg t="1609555130481" class="icon" viewBox="0 0 1035 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="19153" width="30" height="30"><path d="M769.146051 330.352948l-325.589433 283.121246L330.30812 495.507008c-14.156062-18.87475-42.468187-18.87475-61.342936 0-18.87475 14.156062-18.87475 42.468187 0 61.342936l141.560622 150.997998c9.437375 9.437375 18.87475 14.156062 33.030812 14.156062 9.437375 0 18.87475-4.718687 28.312125-9.437374l353.901557-306.714683c18.87475-14.156062 18.87475-42.468187 4.718688-61.342937s-42.468187-28.312125-61.342937-14.156062z" p-id="19154" fill="#FCD1D1"></path><path d="M1014.517798 420.008009a37.749499 37.749499 0 0 0-51.905562-28.312125c-23.593437 4.718687-37.749499 28.312125-28.312125 51.905562 9.437375 37.749499 0 122.685873 0 122.685873-14.156062 113.248498-70.780311 212.340934-160.435372 278.402559-89.655061 70.780311-198.184872 99.092436-311.433371 84.936373-113.248498-14.156062-212.340934-70.780311-283.121246-160.435372S80.217686 571.006007 94.373749 457.757508C108.529811 344.50901 165.15406 245.416574 254.809121 179.35495 344.464182 108.574638 452.993993 80.262514 566.242492 94.418576c84.936374 9.437375 165.15406 47.186874 226.496996 99.092436 18.87475 14.156062 42.468187 14.156062 61.342937-4.718687 14.156062-18.87475 14.156062-42.468187-4.718687-61.342937C773.864739 61.387764 679.49099 18.919577 575.679867 4.763515 438.837931-14.111235 306.714683 23.638265 198.184872 108.574638 89.655061 198.2297 18.87475 320.915573 4.718687 453.038821c-14.156062 132.123248 18.87475 268.965184 103.811124 372.776307 84.936374 108.529811 202.90356 174.591435 339.745495 188.747497 132.123248 14.156062 235.934372-4.718687 377.494994-103.811123 108.529811-84.936374 174.591435-202.90356 193.466185-335.026808-4.718687 4.718687 9.437375-99.092436-4.718687-155.716685z" p-id="19155" fill="#FCD1D1"></path></svg></td>
            </tr>
            <tr>
                <td><input readonly name="orderId" type="text" value="${requestScope.order.orderId}"/></td>
                <td><input readonly name="createTime" type="text" value="${requestScope.order.createTime}"/></td>
                <td><input name="price" type="text" value="${requestScope.order.price}"/></td>
                <c:if test="${requestScope.order.status == 0}">
                    <td>
                        <input readonly type="text" value="未发货"/>
                        <input type="hidden" name="status" value="${requestScope.order.status}">
                    </td>
                </c:if>
                <td style="width: 0px"><input type="hidden" name="userId" value="${requestScope.order.userId}"/></td>
                <td><input type="submit" value="发货"/></td>
            </tr>
        </table>
    </form>


</div>

<%@ include file="/pages/common/foot.jsp"%>

</body>
</html>