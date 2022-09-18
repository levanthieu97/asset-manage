$(function(){
	$('.edit').click(function(){
		let id = $(this).val();
		let name = $('#'+id).find('.c2_name').text();
		let cate1 = $('#'+id).find('.c1_class').val();
		let c2Use = $('#'+id).find('.c2_use').val();

		$('#id').val(id);
		$('#cate1_select').val(cate1);
		$('#name_value').val(name);
		$('#c2_use').val(c2Use);
		$('#delete').prop('disabled',false);
		$('#edit_type').val("update");

	});
});


$(function(){
	$('#clear').click(function(){

		$('#id').val("");
		$('#name_value').val("");
		$('#delete').prop('disabled',true);
		$('#cate1_select').val("default")
		$('#edit_type').val("insert");

	});
});


$(function(){
	$('#insert_update').click(function(){
		let id= $('#id').val();
		let name = "";
		let cate1 = $('#cate1_select').val();
		let cate1Name = $('#cate1_select option:selected').text();
		let c2Use = $('#c2_use').val();
		let editType = $('#edit_type').val();
		let editTypeVal = "";
		let text1 = "";

		if(cate1 == "default"){
			alert("※分類1を選択してください。");
			return false;
		}

		if(editType == "update"){
			editTypeVal = "更新";
			name = $('#'+id).find('.c2_name').text();
			text1 ="「"+ id+":";

			if(c2Use == 1){
				alert("※【分類2："+name+"】は使用しているため更新できません。");
				return false;
			}

		}else{
			editTypeVal = "登録";
			name = $('#name_value').val();
			text1 = "【分類1："+cate1Name+"】で【";
		}

		if(name == ""){
			alert("※名前を入力してください。");
			return false;
		}

		if(window.confirm(text1+name+"】の"+editTypeVal+"を行ってよろしいですか？")){

		}else{

			return false;
		}

	});
});


$(function(){
	$("#delete").click(function(){
		let c2Use = $('#c2_use').val();
		let id= $('#id').val();
		let name = $('#'+id).find('.c2_name').text();

		if(c2Use == 1){
			alert("※【分類2："+name+"】は使用しているため削除できません。");
			return false;
		}

		$('#edit_type').val('delete');
		if(window.confirm("【"+id+":"+name+"】の削除を行ってよろしいですか？")){

		}else{
			$('#edit_type').val("update");
			return false;
		}

	});
});