/**权限管理*/

$(function(){
    if(window.location.pathname!="/ssh/login.jsp"){
        if(sessionStorage.getItem("user")==null||sessionStorage.getItem("user")==""||sessionStorage.getItem("user")==undefined){
            window.location.href="/ssh/login.jsp";
        }
        $("#accountName").html(JSON.parse(sessionStorage.getItem("user")).name);
    }
});

/**退出登录*/
function logOut(){
    sessionStorage.removeItem("user");
    window.location.href="/ssh/login.jsp"
}

/**表单验证*/
function validate(obj,number){
    var count = number;
    $(obj).css("border-color","red");
    function CountDown() {
        if (count%2 ==0){
            $(obj).css("border-color","red");
        }else{
            $(obj).css("border-color","#aaa");
        }
        if (count == 0) {
            clearInterval(countdown);
            $(obj).css("border-color","#aaa");
            return;
        }
        count--;
    }
    var countdown = setInterval(CountDown, 500);
}
$(document).ready(function(){
    $("tr").click(function(){
        $("tr").each(function(){
            $(this).removeClass("click");
        });
        $(this).addClass("click");
    })
});

/**获取url参数值*/
function getParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}




/**移动弹出框*/
function move(obj,title){
    title.bind("mousedown",function(event){
        var offset_x = $(obj)[0].offsetLeft;//x坐标
        var offset_y = $(obj)[0].offsetTop;//y坐标
        var mouse_x = event.pageX;
        var mouse_y = event.pageY;

        $(document).bind("mousemove",function(ev){
            var _x = ev.pageX - mouse_x;
            var _y = ev.pageY - mouse_y;
            var now_x = (offset_x + _x ) + "px";
            var now_y = (offset_y + _y ) + "px";
            obj.css({
                top:now_y,
                left:now_x
            });
        });
    });

    /* 当鼠标左键松开，接触事件绑定 */
    $(document).bind("mouseup",function(){
        $(this).unbind("mousemove");
    });
}

/**信息弹出框*/
function msgMode(msg){
    var html='<div class="confirm">'+
        ' <div class="move-confirm">'+
        ' <div class="confirm-title">提示</div>'+
        '  <div class="confirm-content">'+
        msg+
        '  </div>'+
        '<div class="confirm-operate">'+
        ' <a class="btn btn-success" href="javascript:;" onclick="confirmNo()"><i class="icon-font">&#xe609;</i> 确定</a>'+
        '</div>'+
        '</div>'+
        ' </div>';
    $("body").append(html);
    move($("div.move-confirm"),$("div.confirm-title"));
}

/**提示弹出框*/
function confirmMode(msg,id,status){
    var html='<div class="confirm">'+
    ' <div class="move-confirm">'+
    ' <div class="confirm-title">提示</div>'+
    '  <div class="confirm-content">'+
        msg+
    '  </div>'+
    '<div class="confirm-operate">'+
    ' <a class="btn btn-success" href="javascript:;" onclick="confirmYes('+id+','+status+')"><i class="icon-font">&#xe609;</i> 确定</a>'+
    '<a class="btn btn-danger" href="javascript:;" onclick="confirmNo()"><i class="icon-font">&#xe62a;</i> 取消</a>'+
    '</div>'+
    '</div>'+
    ' </div>';
    $("body").append(html);
    move($("div.move-confirm"),$("div.confirm-title"));
}

function confirmNo(){
    $(".confirm").remove();
}





