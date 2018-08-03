var testEditor;
var Jiaoan = {
    layerIndex: -1
};
var JiaoanField={
    validateFields: {
        // name: {
        //     validators: {
        //         notEmpty: {
        //             message: '菜单名称不能为空'
        //         }
        //     }
        // },
        jiaoan_title: {
            validators: {
                notEmpty: {
                    message: '教案标题不能为空'
                }
            }
        },
        jiaoan_author: {
            validators: {
                notEmpty: {
                    message: '教案作者不能为空'
                }
            }
        }
    }
}
$(function () {
    Feng.initValidator("jiaoan1",JiaoanField.validateFields)
    testEditor = editormd("test-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "../static/editor/lib/",
        saveHTMLToTextarea: true
    });

    /*
     // or
     testEditor = editormd({
     id      : "test-editormd",
     width   : "90%",
     height  : 640,
     path    : "../lib/"
     });
     */

    $("#jiaoan_submit").bind("click", function () {
        if (!Jiaoan.validate()) {
            return;
        }
        Jiaoan.openAddDept();
        /* markdown 格式文本 */
        $("#id_input_md").val(testEditor.getMarkdown());
        /* html 格式内容 */
        $("#id_input_html").val($(".markdown-body").prop('outerHTML'));
        /* 展示文章描述填写的模态框 */
        // Jiaoan.submit();
    });

});
Jiaoan.openAddDept = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/jiaoan/add_jiaoan'
    });
    this.layerIndex=index;
};
Jiaoan.validate = function () {
    $('#jiaoan1').data("bootstrapValidator").resetForm();
    $('#jiaoan1').bootstrapValidator('validate');
    return $("#jiaoan1").data('bootstrapValidator').isValid();
}
Jiaoan.submit=function submitBlogAddForm() {
    // 提交表单

    var form = document.forms[0];
    $.ajax({
        url: "/jiaoan/",
        type: "POST",
        data: form.serialize(),
        success: function (data) {
            parent.layer.msg("新增成功", {
                icon: 1
            });
        },
        error: function (data) {
            parent.layer.msg("新增成功", {
                icon: 1
            });
        }


    })

}
    Jiaoan.set = function(key, val) {
        this.addInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
        return this;
    }

