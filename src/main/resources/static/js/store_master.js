$(function() {
    $('#tenpo_code').on('input', function(e) {
        let value = $(e.currentTarget).val();
        value = value
            .replace(/[０-９]/g, function(s) {
                return String.fromCharCode(s.charCodeAt(0) - 65248);
            })
            .replace(/[^0-9]/g, '');
      	$(e.currentTarget).val(value);
    });
});

$(function(){
	$(".edit").click(function(){
		let tenpoCode = $(this).val();
		let name = $('#'+tenpoCode).find('.name').text();

		$('#tenpo_code').val(tenpoCode);
		$('#name_value').val(name);
		$('#delete').prop('disabled',false);


	});
});


$(function(){
	$("#clear").click(function(){

		$('#tenpo_code').val('');
		$('#name_value').val('');
		$('#delete').prop('disabled',true);

	});
});

function tenpoCodeCheck(){
	let tenpoCode = $('#tenpo_code').val();
	let tenpoName = $('#'+tenpoCode).find('.name').text();

	return tenpoName;

	/*if(tenpoName != ''){
		alert(tenpoCode+"："+tenpoName+"-店舗コードチェック！！");
	}else{
		alert("ないよ店舗コードチェック！！");
	}*/
}


$(function(){
	$("#insert_update").click(function(){
		let tenpoCode= $('#tenpo_code').val();
		let tenpoName = $('#name_value').val();
		let nextId = $('#next_id').val();
		let editType = "";
		let editTypeVal = "";

		if(tenpoCode == ""){
			alert("※店舗コードを入力してください。");
			return false;
		}

		if(tenpoName == ""){
			alert("※名前を入力してください。");
			return false;
		}

		let tenpoCheck = tenpoCodeCheck();

		if(tenpoCheck != ""){
			editType="update";
			editTypeVal = "更新";
		}else{
			editType='insert';
			editTypeVal = "登録";
			tenpoCheck = tenpoName;
		}

		$('#edit_type').val(editType);
		if(window.confirm(tenpoCode+":"+tenpoCheck+"の"+editTypeVal+"を行ってよろしいですか？")){

		}else{
			$('#edit_type').val("");
			return false;
		}

	});
});


$(function(){
	$("#delete").click(function(){
		let tenpoCode= $('#tenpo_code').val();
		let tenpoName = $('#name_value').val();

		let tenpoCheck = tenpoCodeCheck();

		if(tenpoCheck == ""){
			alert(tenpoCode+":"+tenpoName+"は存在しないため削除できません。");
			return false;
		}


		$('#edit_type').val('delete');
		if(window.confirm("【"+tenpoCode+":"+tenpoCheck+"】の削除を行ってよろしいですか？")){

		}else{
			$('#edit_type').val("");
			return false;
		}

	});
});