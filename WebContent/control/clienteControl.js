var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	var url = 'http://localhost:8080/SistemaEcommerce/rs/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar clientes '+mensagemErro);
		});   
	}
	
	$scope.salvarTelefone = function() {
		$scope.cliente.telefones.push($scope.telefone);
		$scope.telefone = {};		
	}
	
	$scope.novo = function(){
		$scope.cliente = {};
		$scope.cliente.telefones = [];
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	if ($scope.cliente.codigo == undefined || $scope.cliente.codigo == '') {    		
			$http.post(url,$scope.cliente).success(function(clienteRetornado) {
				$scope.clientes.push(clienteRetornado);
				$scope.novo();
				$scope.mensagens.push('Cliente salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente atualizado com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.codigo == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = url+'/'+$scope.cliente.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir cliente: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});