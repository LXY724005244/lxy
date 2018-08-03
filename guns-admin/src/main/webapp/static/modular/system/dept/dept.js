/**
 * 管理初始化
 */
var Dept = {
    id: "DeptTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Dept.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'num', visible: true, align: 'center', valign: 'middle'},
            {title: '父部门id', field: 'pid', visible: true, align: 'center', valign: 'middle'},
            {title: '父级ids', field: 'pids', visible: true, align: 'center', valign: 'middle'},
            {title: '简称', field: 'simplename', visible: true, align: 'center', valign: 'middle'},
            {title: '全称', field: 'fullname', visible: true, align: 'center', valign: 'middle'},
            {title: '提示', field: 'tips', visible: true, align: 'center', valign: 'middle'},
            {title: '版本（乐观锁保留字段）', field: 'version', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Dept.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Dept.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Dept.openAddDept = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dept/dept_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Dept.openDeptDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dept/dept_update/' + Dept.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Dept.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dept/delete", function (data) {
            Feng.success("删除成功!");
            Dept.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("deptId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Dept.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Dept.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Dept.initColumn();
    var table = new BSTable(Dept.id, "/dept/list", defaultColunms);
    table.setPaginationType("client");
    Dept.table = table.init();
});
