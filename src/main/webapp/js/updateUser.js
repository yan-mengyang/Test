$(function () {
    BookManager.initResource();
});
var BookManager = {};

BookManager.initResource = function () {
    $.ajax({
        url: "/DepartmentListServlet",
        type: "post",
        dataType: "json",
        success: function (result) {
            for (var i = 0; i < result.length; i++) {

                var opt = $("<option value='" + result[i].id + "'>" + result[i].departmentname + "</option>");
                $("#department").append(opt);
            }
            $("#department").val(department);
        }
    });
};

