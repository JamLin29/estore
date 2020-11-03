var shopcarId;

$(function(){
	$('.carousel').carousel({

		interval: 3000

	})
	$('.collapse').first().removeClass('on');
	$('.collapse').first().addClass('in');
	
	$('.body .menu ul li').click(function(){
		$('.collapse').removeClass('in');
		var text=$(this).attr('herf');
		$(text).addClass('in');
	});
	$('.booknum').on('click',function(event){
		if($(event.target).is($('.add'))) {
			updateNum(shopcarId, $(this), true);
		} else if($(event.target).is($('.sub'))) {
			updateNum(shopcarId, $(this), false)
		}
	});
	$('.viewbook .book-message #box dd').click(function(){
		$('.viewbook .book-message #box dd').removeClass('active');
		$(this).addClass('active');
	});
	$('#typeMenu').collapse('hide')
	
})

function updateNum(id, th, add) {
	var num = parseInt(th.find('.value').text());
	if(num <= 1 && !add) {
		alert("不能再减啦~");
		return;
	}
	
	$.ajax({
		url: "ajax/update",
		type: "POST",
		data: {
			method: "updateShopCarBook",
			id: id,
			num: add ? num + 1 : num - 1
		},
		success: function(data, state) {
			if(data == "YES") {
				if(add) {
					var value=th.find('.value');
					var price = eval(th.prev('.price').text());
					value.text(num+1);
					th.next('.price_sum').text(price * (num + 1));
					var sum = eval($('#price-num').text());
					$('#price-num').text(sum + price);
					// console.log('+了');
				} else {
					var value=th.find('.value');
					var price = eval(th.prev('.price').text());
					value.text(num-1);
					th.next('.price_sum').text(price * (num - 1));
					var sum = eval($('#price-num').text());
					$('#price-num').text(sum - price);
					// console.log('减了');
				}
			}
		},
		error: function(data) {
			// $("form div:last-child").html('<font color="red">服务器出错</font>')
		}
	})
}

function giveAId(id) {
	shopcarId = id;
}
