/**
 * Created by Jason on 17/10/2017.
 */

var userNameFlag = 'N';
var emailFlag = 'N';

function checkUserNameIsNotNull() {
    var userName = $("#userName").val();
    if (userName == null || userName == undefined || userName == '') {
        return false;
    } else
        return true;
}

function checkEmailIsNotNull() {
    var email = $("#activeEmail").val();
    if (email == null || email == undefined || email == '') {
        return false;
    }
    return true;
}

function checkPasswordIsNotNull() {
    var password = $("#password4Register").val();
    if (password == null || password == undefined || password == '') {
        return false;
    }
    return true;
}

function authInfo(object, content) {
    $.ajax({
        url: '/authentication/registerCheck',
        type: "POST",//请求方式：get或post
        scriptCharset: 'utf-8',
        dataType: "json",//数据返回类型：xml、json、script
        cache: false,
        data: {
            'object': object,
            'content': content,
        },//自定义提交的数据
        success: function (json) {
            if (json !== null || json !== undefined || json !== '') {
                /*判断程序内部返回是否有错*/
                if (json.code == 100) {
                    $("#unknowError").text('');
                    if (json.data.object == 'UserName') {
                        if (json.data.errorFlag == 'N') {
                            $("#errorMessageUser").text(json.data.errorMessage);
                            $("#doRegister").addClass("disabled");
                            $("#doRegister").unbind("click");
                            userNameFlag = 'N';
                        }
                        else {
                            $("#errorMessageUser").text('');
                            userNameFlag = 'Y';
                            /*<![CDATA[*/
                            if (userNameFlag == 'Y' && emailFlag == 'Y' && checkUserNameIsNotNull() && checkEmailIsNotNull() && checkPasswordIsNotNull()) {
                                $("#doRegister").removeClass("disabled");
                                $("#doRegister").bind("click", function () {
                                    var currentURL = window.location.href;
                                    $("#currentURL4Register").val(currentURL);
                                    $("#registerForm").submit();
                                })
                            } else {
                                $("#doRegister").addClass("disabled");
                                $("#doRegister").unbind("click");
                            }
                            /*]]>*/
                        }

                    } else if (json.data.object == 'Email') {
                        if (json.data.errorFlag == 'N') {
                            $("#errorMessageEmail").text(json.data.errorMessage);
                            $("#doRegister").addClass("disabled");
                            $("#doRegister").unbind("click");
                            emailFlag = 'N';
                        }
                        else {
                            $("#errorMessageEmail").text('');
                            emailFlag = 'Y';
                            /*<![CDATA[*/
                            if (userNameFlag == 'Y' && emailFlag == 'Y' && checkUserNameIsNotNull() && checkEmailIsNotNull() && checkPasswordIsNotNull()) {
                                $("#doRegister").removeClass("disabled");
                                $("#doRegister").bind("click", function () {
                                    var currentURL = window.location.href;
                                    $("#currentURL4Register").val(currentURL);
                                    $("#registerForm").submit();
                                })
                            } else {
                                $("#doRegister").addClass("disabled");
                                $("#doRegister").unbind("click");
                            }
                            /*]]>*/
                        }
                    } else {
                        if (json.data.errorFlag == 'N')
                            $("#unknowError").text(json.data.errorMessage);
                        else
                            $("#unknowError").text('');
                    }
                } else {
                    $("#unknowError").text(json.message);
                }
            }
        },
        error: function (json) {
            $("#unknowError").text("Request Error!")
        }
    })
}

$("#userName").on("blur", function () {
    if (checkUserNameIsNotNull()) {
        authInfo("UserName", $("#userName").val());
    } else {
        $("#errorMessageUser").text("用户名不能为空");
        $("#doRegister").addClass("disabled");
        $("#doRegister").unbind("click");
    }
})
$("#activeEmail").on("blur", function () {
    if (checkEmailIsNotNull()) {
        authInfo("Email", $("#activeEmail").val());
    } else {
        $("#errorMessageEmail").text("邮箱不能为空");
        $("#doRegister").addClass("disabled");
        $("#doRegister").unbind("click");
    }
})

$("#password4Register").on("blur", function () {
    if (checkPasswordIsNotNull()) {
        /*<![CDATA[*/
        if (userNameFlag == 'Y' && emailFlag == 'Y' && checkUserNameIsNotNull() && checkEmailIsNotNull() && checkPasswordIsNotNull()) {
            $("#errorPassword").text('');
            $("#doRegister").removeClass("disabled");
            $("#doRegister").bind("click", function () {
                var currentURL = window.location.href;
                $("#currentURL4Register").val(currentURL);
                $("#registerForm").submit();
            })
        }
        /*]]>*/
    } else {
        $("#errorPassword").text("密码不能为空");
        $("#doRegister").addClass("disabled");
        $("#doRegister").unbind("click");
    }
})