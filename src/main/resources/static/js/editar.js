$(function() {
	$('.caralho').on('click', function(event){
		 event.preventDefault();
		
		var btReceber = $(event.currentTarget);
		var urlReceber = btReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		var response.done(function(e){
			
			var codigoMoto = btReceber.data('codigo');
			$('[data-role=' + codigoMoto + ']').html('<span class= " btn btn-success">Recebido</span>')
			btReceber.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro ao Vender a moto.');
		});
	});
});