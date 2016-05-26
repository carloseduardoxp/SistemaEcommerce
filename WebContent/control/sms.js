var smsModule = angular.module('smsModule', []);

smsModule.controller("smsController", 
		function($scope,$http) {
	url = 'http://localhost:8080/SistemaEcommerce'+
			'/rs/sms';
	
	urlCliente = 'http://localhost:8080/SistemaEcommerce'+
	'/rs/cliente';
	
	$scope.pesquisarClientes = function() {
		$http.get(urlCliente).success(function (clientes) {
			$scope.clientes = clientes;
		}).error(function (erro) {
			alert(erro);
		});
	};
		
	$scope.pesquisar = function() {
		$http.get(url).success(function (smss) {
			$scope.smss = smss;
		}).error(function (erro) {
			alert(erro);
		});
	};	
	
	$scope.novo = function() {
		$scope.sms = "";	
		$scope.clienteSelecionado = "";
		$scope.telefones = [];
		$scope.desabilitaSalvar = false;
	};
	
	$scope.seleciona = function(sms) {
		$scope.sms = sms;
		$scope.desabilitaSalvar = true;
		$scope.telefones = [];
		$scope.telefones.push($scope.sms.telefone);
		for (posicao in $scope.clientes) {
			cliente = $scope.clientes[posicao];
			for (posicao1 in cliente.telefones) {
				telefone = cliente.telefones[posicao1];
				if (telefone.numero == $scope.sms.telefone.numero) {
					$scope.clienteSelecionado = cliente;
				}				
			}			
		}		
	};
	
	$scope.alteraTelefones = function() {
		$scope.telefones = $scope.clienteSelecionado.telefones;		
	};
	
	$scope.selecionaTelefone = function(telefone) {
		$scope.sms.telefone = telefone;
	};
		
	$scope.salvar = function() {
		$http.post(url,$scope.sms)
		.success(function (sms) {
		$scope.smss.push(sms);
		$scope.novo();
		}).error(function (erro) {
			alert(erro);
		});	
	};
	
	$scope.pesquisar();
	$scope.pesquisarClientes();
			
		
	});