$(function () {
    var defaultColunms = JiaoAn.initColumn();
    var table = new BSTreeTable(JiaoAn.id, "/jiaoan/list", defaultColunms);
    // table.setExpandColumn(2);
    table.setIdField("id");
    // table.setCodeField("code");
    // table.setParentCodeField("pcode");
    // table.setExpandAll(true);
    table.init();
    JiaoAn.table = table;
})
var JiaoAn = {
    id: "jiaoanTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};
JiaoAn.initColumn=function () {
    var columns=[
        {
            field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '教案标题', field: 'title', align: 'center', valign: 'middle', sortable: true, width: '17%'},
        {title: '介绍', field: 'introduction', align: 'center', valign: 'middle', sortable: true, width: '12%'},
        {title: 'HTML格式教案预览', field: 'htmlMaterial', align: 'center', valign: 'middle', sortable: true},
        {title: '文章内容预览', field: 'mdMaterial', align: 'center', valign: 'middle', sortable: true, width: '15%'},
        {title: '创建时间', field: 'gmtCreate', align: 'center', valign: 'middle', sortable: true},
        {title: '修改时间', field: 'gmtModified', align: 'center', valign: 'middle', sortable: true},
        {title: '作者', field: 'author', align: 'center', valign: 'middle', sortable: true}
        // {title: '状态', field: 'statusName', align: 'center', valign: 'middle', sortable: true}
    ]
    return columns;
}