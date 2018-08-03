var add_jiaoan = {
    addInfoData : {}
};
var addJiaoanField={
    validateFields: {
        // name: {
        //     validators: {
        //         notEmpty: {
        //             message: '菜单名称不能为空'
        //         }
        //     }
        // },
        bq: {
            validators: {
                notEmpty: {
                    message: '标签不能为空'
                }
            }
        },
        jams: {
            validators: {
                notEmpty: {
                    message: '教案描述不能为空'
                }
            }
        }
    }
}
add_jiaoan.collectData = function() {
    this
        .set('introduction')
        .set('tag')
        .parentset('title')
        .parentset('author')
        .parentset('id_input_md')
        .parentset('id_input_html')
    ;
}

add_jiaoan.clearData = function() {
    this.addInfoData = {};
}
add_jiaoan.vaild=function(){
    $('#jiaoan2').data("bootstrapValidator").resetForm();
    $('#jiaoan2').bootstrapValidator('validate');
    return $("#jiaoan2").data('bootstrapValidator').isValid();
}

add_jiaoan.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.vaild()){
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/jiaoan/submitjiaoan", function(data){
        Feng.success("添加成功!");
        add_jiaoan.close();
    },function(data){
        layer.msg("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.addInfoData);
    ajax.start();
}

add_jiaoan.set = function(key, val) {
    this.addInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}
add_jiaoan.parentset = function(key, val) {
    this.addInfoData[key] = (typeof val == "undefined") ? parent.$("#" + key).val() : val;
    return this;
}
add_jiaoan.close = function () {
    parent.layer.close(window.parent.Jiaoan.layerIndex);
};
$(function () {
Feng.initValidator("jiaoan2",addJiaoanField.validateFields);
})