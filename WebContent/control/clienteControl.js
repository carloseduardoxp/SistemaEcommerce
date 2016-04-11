var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaEcommerce/rs/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.cliente = {};
	}

    $scope.salvar = function() {
		if ($scope.cliente.codigo == '') {
			$http.post(url,$scope.cliente).success(function(cliente) {
				$scope.clientes.push($scope.cliente);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
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
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
});