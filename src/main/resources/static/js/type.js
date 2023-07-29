layui.use(['table', 'form', 'jquery', 'layer'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form;

	var reader_tb=table.render({
		elem: '#type_tb',
		url: '/type/list',
		cols: [
			[{
				field: 'typeId',
				title: '类型编号',
				width: 120,
				fixed: 'left',
				sort: true
			}, {
				field: 'typeName',
				title: '类型名称',
				width: 120
			}, , {
				fixed: 'right',
				title: '操作',
				toolbar: '#barDemo',
				width: 150
			}]
		],
		page: true,
		height: 500
	});

	//监听行工具事件
	table.on('tool(type_tb)', function(obj) {
		var data = obj.data;
		//console.log(obj)
		if (obj.event === 'del') {
			layer.confirm('真的删除行么',{icon:3}, function(index) {
				$.ajax({
					url:'/type/list/'+data.typeId,
					type:'delete',
					dataType:'json',
					success: function (res) {
						if(res.code!=0){
							return layer.msg("删除失败："+res.msg,{icon:2});
						}
						return layer.msg("删除成功",{icon:1,time:1300},function () {
							obj.del();
						});
					}
				})
				layer.close(index);
			});
		}

	});



	/**
	 * 添加
	 */
	$("#add_btn").click(function () {
		let typeName= $("#typeName").val();
		if ( typeName.length==0) {
			return layer.msg("类型名称不能为空！",{icon:2});
		}
		let data={
			typeName:typeName,
		}
		$.ajax({
			url:'/type/list',
			type:'post',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType: 'json',
			success:function (res) {
				if(res.code!=0){
					return layer.msg(res.msg,{icon: 2});
				}
				return layer.msg("添加成功", {icon: 1, time: 1300}, function () {
					$("#typeName").val("");
					reader_tb.reload();
				});
			}
		});
	});

});
